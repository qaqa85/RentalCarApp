package com.carSharing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRepository implements CRUDRepository<Car>{
	private final File file;
	private List<Car> cars = null;
	
	public CarRepository(String url) {
		file = new File(url);
		initializeCarDataFromFile();
	}
	
	/**
	 * Adds car object if it does not exist in repository
	 * otherwise returns null
	 * 
	 * @param Car entity that will be passed to database
	 * @return Car entity or null
	 */
	@Override
	public Car create(Car entity) {
		cars.add(entity);
		return entity;
	}

	@Override
	public List<Car> readAll() {
		return cars;
	}

	@Override
	public Car update(Car entity) {
		int idx = cars.indexOf(entity);
		if (idx != -1) {
			cars.set(idx, entity);
			return entity;
		}
		return null;
	}

	@Override
	public Car delete(Car entity) {
		if (cars.remove(entity))
			return entity;
		return null;	
	}
	
	public boolean existsById(int id) {
		return cars.stream()
				.anyMatch(car-> car.getId() == id);
	}
	
	public Optional<Car> readById(int id) {
		return cars.stream()
				.filter(car -> car.getId() == id)
				.findAny();
	}
	
	public List<Car> readByAvailable(boolean available) {
		return cars.stream()
				.filter(car -> car.isAvailable() == available)
				.collect(Collectors.toList());
	}
	
	public List<Car> readAllByCategoryType(String categoryType) {
		try {
			return cars.stream()
					.filter(car -> car.getCategoryType() == CategoryType.valueOf(categoryType.toUpperCase()))
					.collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			System.out.println("Wrong category");
		}
		return List.of();
	}

	public List<Car> readAllByCarType(String carType) {
		try {
			return cars.stream()
					.filter(car -> car.getCarType() == CarType.valueOf(carType.toUpperCase()))
					.collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			System.out.println("Wrong type");
		}
		return List.of();
	}
	
	public void saveDataBase() {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(file);
			
			for(Car car: cars) {
				fw.write(car.toFileFormat());
			}
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Reads all {@code Car} elements in a {@code File}. Elements are stored in a {@code LinkedList}
	 */
	private void initializeCarDataFromFile() {
		final int NAME = 0;
		final int CAR_TYPE = 1;
		final int OWNER = 2;
		final int CATEGORY_TYPE = 3;
		final int AVAILABLE = 4;
		final int ID = 5;
		final int DATA = 6;

		Scanner sc = null;

		try {
			sc = new Scanner(file);

			while(sc.hasNextLine()) {
				//TODO make a constructor that can take array as parameter or BuilderPattern
				String paramTab[] = sc.nextLine().split(";");
				Car car = new Car.CarBuilder()
						.withName(paramTab[NAME])
						.withCarType(paramTab[CAR_TYPE])
						.withOwner(paramTab[OWNER])
						.withCategoryType(paramTab[CATEGORY_TYPE])
						.withAvailable(paramTab[AVAILABLE])
						.withId(paramTab[ID])
						.withLocalDate(paramTab[DATA])
						.build();
				
				if(cars == null)
					cars = new LinkedList<>();
				
				cars.add(car);
					
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error cant read the database");
		} finally {
			if(sc != null) {
				sc.close();
			}
		}
	}
}

package com.CarRental.Car;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

class CarService {
	private final CarRepository repository;
	
	public CarService() {
		repository = new CarRepository("src/database.txt");
	}
	
	public List<Car> readAllCars() {
		return repository.readAll();
	}
	
	public List<Car> readCarsByAvailable(boolean available) {
		return repository.readByAvailable(available);
	}
	
	public List<Car> readAllByCategoryType(String categoryType) {
		return repository.readAllByCategoryType(categoryType);
	}
	
	public List<Car> readAllByCarType(String carType) {
		return repository.readAllByCarType(carType);
	}
	
	public boolean toggleByIdIfAvailable(String id, boolean available) {
		try {
			Optional<Car> result = repository.readById(Integer.parseInt(id));
			
			if(result.isPresent()) {
				Car car = result.get();
				
				if(car.isAvailable() == available) {
					//real toggle
					car.setAvailable(!car.isAvailable());
					//save dateOftoggle
					car.setDate(LocalDate.now());
					return true;
				}
			}		
		} catch (NumberFormatException e) {
			System.out.println("Wrong id number");
		}
		return false;
	}

	public boolean addNewCar(String[] paramTab) {
		Car car = new Car.CarBuilder()
				.withId(paramTab[0])
				.withName(paramTab[1])
				.withCarType(paramTab[2])
				.withOwner(paramTab[3])
				.withCategoryType(paramTab[4])
				.withAvailable(true)
				.withLocalDate(LocalDate.now())
				.build();
		
		if (repository.existsById(car.getId())) {
			if (repository.update(car) != null)
				return true;
		}
		else {
			repository.create(car);	
			return true;
		}
		return false;
	}

	public boolean delCarById(String data) {	
		try {
			Optional<Car> car = repository
					.readById(Integer.parseInt(data));
			
			if(car.isEmpty()) {
				return false;
			}

			if(repository.delete(car.get()) != null) {
				return true;
			}
			
		} catch (NumberFormatException e) {
			System.out.println("Wrong id number");
		}
		return false;
	}

	//save DB on close
	public void close() {
		repository.saveDataBase();
	}
}

package com.carSharing;

public class CarController {
	private final CarService service;
	
	public CarController() {
		service = new CarService();
	}
	
	public void printAllCars() {
		service.readAllCars().forEach(System.out::println);
	}
	
	public void printAllAvailableCars() {
		service.readCarsByAvailable(true).forEach(System.out::println);
	}
	
	public void printAllUnavailableCars() {
		service.readCarsByAvailable(false).forEach(System.out::println);
	}
	
	public void printAllByCategoryType(String categoryType) {
		service.readAllByCategoryType(categoryType).forEach(System.out::println);
	}
	
	public void printAllByCarType(String carType) {
		service.readAllByCarType(carType).forEach(System.out::println);
	}
	
	public void setToggleForRent(String id) {
		System.out.println(service.toggleByIdIfAvailable(id, true));
	}
	
	public void setToggleForReturn(String id) {
		System.out.println(service.toggleByIdIfAvailable(id, false));		
	}
	
	public void addNewCar(String ... paramTab) {
		System.out.println(service.addNewCar(paramTab));
	}

	public void delCarById(String data) {
		System.out.println(service.delCarById(data));
	}

	public void close() {
		service.close();
	}

}

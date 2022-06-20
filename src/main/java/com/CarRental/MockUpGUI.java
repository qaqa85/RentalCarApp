package com.CarRental;

import com.CarRental.Car.CarController;

import java.util.Scanner;

public class MockUpGUI {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		CarController carController = new CarController();
		String data;	
		do {
			System.out.println("WYN(Wynajmij), ODD(Oddaj), WW(Wys. wszystkie), WD(Wys. dostepne), WN(Wys. niedostepne), WT(Wys. typ), WT(Pod. typ), WC(Pod. kat),END");
			System.out.println("ADD(add Car), DEL(del Car)\n");
			data = scanner.nextLine().toUpperCase();	
			
			switch (data) {
			case "WYN" :
				data = scanner.nextLine();
				carController.setToggleForRent(data);
				break;
			case "ODD" :
				data = scanner.nextLine();
				carController.setToggleForReturn(data);
				break;
			case "WW" :
				carController.printAllCars();
				break;
			case "WD" :
				carController.printAllAvailableCars();
				break;
			case "WN" :
				carController.printAllUnavailableCars();
				break;
			case "WT" :
				System.out.println("Podaj typ");
				data = scanner.nextLine();
				carController.printAllByCarType(data);
				break;
			case "WC" :
				System.out.println("Podaj kategorie");
				data = scanner.nextLine();
				carController.printAllByCategoryType(data);
				break;
			case "ADD" :
				carController.addNewCar(getCarParametersAsArray());
				break;
			case "DEL" :
				System.out.println("Podaj id");
				data = scanner.nextLine();
				carController.delCarById(data);
				break;
			case "END" :
				carController.close();
				scanner.close();
				System.exit(0);
				break;
			default :
				System.out.println("unknown command");
			}		
		} while (true);
	}
	
	private static String[] getCarParametersAsArray() {	
		String[] paramTab = new String[5];
		
		System.out.println("Podaj id");
		paramTab[0] = scanner.nextLine();
		
		System.out.println("Podaj nazwe");
		paramTab[1] = scanner.nextLine();
		
		System.out.println("Podaj carType");
		paramTab[2] = scanner.nextLine();
		
		System.out.println("Podaj wlasciciela");
		paramTab[3] = scanner.nextLine();
		
		System.out.println("Podaj categoryType");
		paramTab[4] = scanner.nextLine();
		
		return paramTab;
	}
}

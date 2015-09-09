package com.prabhash.java.inheritance;

public class Buick extends Car {
	
	private String carType = "Buick";
	
	@Override
	public String getCarType() {
		return this.carType;
	}
	
	public static void printNumberOfWheels() {
		System.out.println("Buick has 4 wheels too!");
	}

	public static void main(String[] args) {
		
		Car car = new Car();
		Car buick = new Buick();
		
		Buick originalBuick = new Buick();
		
		System.out.println(car.getCarType());
		System.out.println(buick.getCarType());
		System.out.println(originalBuick.getCarType());
		
		System.out.println(car.getEngineType());
		System.out.println(buick.getEngineType());
		System.out.println(originalBuick.getEngineType());
		
		car.printNumberOfWheels();
		buick.printNumberOfWheels();
		originalBuick.printNumberOfWheels();
		
		Car.printNumberOfWheels();
		Buick.printNumberOfWheels();

	}

}

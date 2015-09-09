package com.prabhash.java.inheritance;

/**
 * Super class car
 * 
 * @author prrathore
 *
 */
public class Car {
	
	private String engineType = "Car";
	private String carType = "General";
	
	public String getEngineType() {
		return this.engineType;
	}
	
	public String getCarType() {
		return this.carType;
	}
	
	public static void printNumberOfWheels() {
		System.out.println("Car wheels " + 4);
	}
	

}

package com.prabhash.java.interview.sample;

/**
 * This class will override equals and hashcode methods of Car class.
 * 
 * @author prrathore
 *
 */
public class Car {
	
	private String model;
	private int year;

	public Car() {

	}

	public Car(String model, int year) {
		this.model = model;
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if((obj == null) || (obj.getClass() != getClass())) {
			result = false;
		}

		Car car = (Car) obj;
		if(car.model == this.model && car.year == this.year) {
			result = true;
		}

		return result;
	}


	@Override
	public int hashCode() {
		int hash = 3;
		hash = 7 * hash + this.model.hashCode();
		return hash;
	}

	public static void main(String[] args) {
		Car c1 = new Car("Honda", 2010);
		Car c2 = new Car("Honda", 2010);
		Car c3 = new Car("Ford", 2012);

		System.out.println("Is c1 equals c2: " + c1.equals(c2)); //true
		System.out.println("Is c1 equals c3: " + c1.equals(c3)); //false

		System.out.println("Hashcode of c1: " + c1.hashCode());
		System.out.println("Hashcode of c2: " + c2.hashCode());
		System.out.println("Hashcode of c3: " + c3.hashCode());
	
	}


}
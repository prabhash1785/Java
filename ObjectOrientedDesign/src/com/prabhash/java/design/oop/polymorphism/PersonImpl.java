package com.prabhash.java.design.oop.polymorphism;

public class PersonImpl implements Person {
	
	@Override
	public String getFirstName() {
		return "Foo";
	}
	
	@Override
	public String getFullName() {
		return "Foo Bar";
	}
	
	public String getLastName() {
		return "Bar";
	}
	
	public static void printName(Person person) {
		System.out.println("Name is: " + person.getFullName());
	}
	
	public static void main(String[] args) {
		
		Person p = new PersonImpl();
		
		printName(p);
		
	}
	
}

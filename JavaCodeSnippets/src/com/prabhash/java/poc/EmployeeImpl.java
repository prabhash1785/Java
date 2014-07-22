package com.prabhash.java.poc;

public class EmployeeImpl implements EmployeeInterface {

	public String getEmployeeName() {
		return "Prabhash Rathore";
	}
	
	public int getEmployeeCount() {
		return 100;
	}
	
	public void sayHello() {
		System.out.println("Hello World!!");
	}
	
	public static void main(String[] args) {
		
		EmployeeInterface employee = new EmployeeImpl();
		System.out.println("Name: " + employee.getEmployeeName());
		System.out.println("Count: " + employee.getEmployeeCount());
		//employee.sayHello();   ---> employee is of type interface EmployeeInterface so it can't access sayHello Method.
		
		EmployeeImpl emp2 = new EmployeeImpl();
		System.out.println("Name: " + emp2.getEmployeeName());
		System.out.println("Count: " + emp2.getEmployeeCount());
		emp2.sayHello();

	}

}

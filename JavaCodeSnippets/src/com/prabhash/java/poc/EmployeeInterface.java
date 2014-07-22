package com.prabhash.java.poc;

/*
 * In Java until Java version 7, we can't add new methods in the interface as it will break all the clients implementation for 
 * that interface. So once an interface contract is defined, it can't change.
 */
public interface EmployeeInterface {
	
	public static final int count = 10;
	public static final String name = "Test";
	
	public String getEmployeeName();
	
	public int getEmployeeCount();
	
	
}

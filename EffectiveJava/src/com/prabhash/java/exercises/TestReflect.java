package com.prabhash.java.exercises;

import java.lang.reflect.*;

public class TestReflect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Customer cust = new Customer.Builder("Clark","Kent").state("Kansas").build();
		System.out.println(cust);
		Class c = cust.getClass();
		try {
			Field f = c.getDeclaredField("lastName");
			f.setAccessible(true); //allows you to access private fields and modify them
			f.set(cust, "Batman");
		} catch (NoSuchFieldException nsfe) {
			nsfe.printStackTrace();
		} catch (IllegalAccessException iae) {
			iae.printStackTrace();
		}
		System.out.println(cust);
	}

}
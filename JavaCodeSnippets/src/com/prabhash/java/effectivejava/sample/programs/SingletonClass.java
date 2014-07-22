package com.prabhash.java.effectivejava.sample.programs;

public class SingletonClass {
	
	private static SingletonClass s = null;
	
	private SingletonClass() {
		
	}
	
	public static SingletonClass singleObject() {
		if(s == null) {
			System.out.println("Goignt to create the object...");
			s = new SingletonClass();
		}
		return s;
	}
		
}

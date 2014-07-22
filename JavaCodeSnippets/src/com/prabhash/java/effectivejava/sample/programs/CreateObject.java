package com.prabhash.java.effectivejava.sample.programs;

public class CreateObject {
	
	private static CreateObject createObject = null;
	
	private CreateObject() {
		System.out.println("This is a private constructor..");		
	}

	// this is the static factory method to create Objects of this class
	public static CreateObject factory() {
		createObject = new CreateObject();
		return createObject;
	}
		
}

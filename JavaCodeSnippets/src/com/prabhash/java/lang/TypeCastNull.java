package com.prabhash.java.lang;

public class TypeCastNull {

	public void foo(Long l) {
		System.out.println("Long = " + l);
	}
	
	public void foo(String s) {
		System.out.println("String = " + s);  
	}
	
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}
	
	public static void main(String[] args) {

		// In this case without type casting null parameter, compiler will complain about ambiguity as it cannot distinguish
		// between the two overloaded methods
		new TypeCastNull().foo((Long) null);
		new TypeCastNull().foo((String) null);
		
		// this is fine because compiler knows which method to call explicitly as there is no overloading
		new TypeCastNull().sayHello(null);
		
		// Static methods could be called on a reference type pointing to a null object
		Thread t = null;
		
		try {
			
			System.out.println("Going to sleep!!");
			t.sleep(5000); // Even though t is null, this call will execute static sleep method of thread
			System.out.println("I am up!");
			
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
	}

}

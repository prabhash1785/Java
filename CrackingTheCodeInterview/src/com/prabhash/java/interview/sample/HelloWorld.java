package com.prabhash.java.interview.sample;

/**
 * Sample Hello World Program
 * 
 * @author Prabhash Rathore
 *
 */
public class HelloWorld {
	
	public String sayHello() {
		return "Hello Coding Interview!!";
	}
	
	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorld();
		System.out.println(helloWorld.sayHello());
	}

}

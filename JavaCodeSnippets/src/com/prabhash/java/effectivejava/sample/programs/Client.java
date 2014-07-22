package com.prabhash.java.effectivejava.sample.programs;

public class Client {

	public static void main(String[] args) {
		
//		CreateObject a = null;
//		a =  CreateObject.factory();
//		
//		// Create an instance of class CreateObject class
//		System.out.println("Created object is: " + a);
//		System.out.println("Hash value of this object is: " + a.hashCode());
//		System.out.println("Class for this object is: " + a.getClass());
		
		SingletonClass a = SingletonClass.singleObject();
		System.out.println("Value of object " + a);
		
		SingletonClass b = SingletonClass.singleObject();
		System.out.println("Value of object " + b);
		
	}

}

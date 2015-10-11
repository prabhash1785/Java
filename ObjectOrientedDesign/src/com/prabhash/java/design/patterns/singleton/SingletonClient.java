package com.prabhash.java.design.patterns.singleton;

public class SingletonClient {
	
	private static class Task implements Runnable {
		
		@Override
		public void run() {
			Singleton instance = Singleton.getInstance();
			System.out.println(Thread.currentThread().getName() + " -> Instance value is: " + instance.toString());
		}
		
	}

	public static void main(String[] args) {
		
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		System.out.println("instance1 == instance2 :: " + (instance1 == instance2)); // Both instances should be equal
		System.out.println("Instance1 : " + instance1.toString());
		System.out.println("Instance2 : " + instance2.toString());
		
		// Concurrent access
		// All threads should just have single instance of Singleton Class
		Thread t1 = new Thread(new Task(), "t1");
		Thread t2 = new Thread(new Task(), "t2");
		Thread t3 = new Thread(new Task(), "t3");
		Thread t4 = new Thread(new Task(), "t4");
		Thread t5 = new Thread(new Task(), "t5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}

}

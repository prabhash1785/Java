package com.prabhash.java.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Gargage class, delete me after experimentation.
 * 
 * @author Prabhash Rathore
 *
 */
public class Garbage {
	
	private static final int POOL_SIZE = 100;
	
	/**
	 * My first ExecutorService object
	 * @author Prabhash Rathore
	 *
	 */
	public void createExecutor() {
		
		//Executor e = new ThreadPoolExecutor();
		
		ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE, new MyThreadFactory());
		executor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Sample Raunnable.. hurray!!!");
			}
		});
		
		//executor.
		System.out.println("Is shutdown: " + executor.isShutdown());
	}
	
	//Thread Factory to be passed to Executor Service
	public class MyThreadFactory implements ThreadFactory {
		@Override
		public Thread newThread(Runnable r) {
		     return new Thread(r);
		}
	}
	
	//nested interface in a class
	public static interface Animal {
		public int getValue();
	}
	
	//inner class which implements the nested interface
	public class Dog implements Animal {
		public int getValue() {
			return 10;
		}
		
		public String getType() {
			return "Lab";
		}
	}

	public static void main(String[] args) {
		
		Animal animal = new Garbage().new Dog();		
		System.out.println(animal.getValue());
		
		System.out.println(animal.getClass().getName()); //run time class name
		
		System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
		
		new Garbage().createExecutor();
	}

}


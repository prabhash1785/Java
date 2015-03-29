package com.prabhash.java.concurrency.threads;

import javax.faces.component.UINamingContainer;

/**
 * Program to create Race Condition between two threads in a Critical Section which is not guarded by Synchronized keyword.
 * 
 * @author prrathore
 *
 */
public class SimpleRaceConditionDemo {
	
	private int count = 0;
	
	/**
	 * This method is the Critical Section in the program as it's changing the state of this class without having any synchronization
	 * so this could lead to Race Condition between two threads and the result depends on the order in which thread runs this method.
	 * 
	 * This critical section will lead to Race Condition.
	 * 
	 */
	public void add(int n) {
		this.count += n;
	}

	public static void main(String[] args) throws InterruptedException {
		
		final SimpleRaceConditionDemo obj = new SimpleRaceConditionDemo();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.add(5);
			}
		}, "Thread1") ;
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.add(10);
			}
		}, "Thread2") ;
		
		t1.start();
		t2.start();
		
		// in debug mode, this statement executes before other threads runs runnable tasks because this statement is being run by 
		// main thread which could run in parallel with other threads
		// Based on Thread Race Condition, the output could be -> 0, 10, 15
		Thread.sleep(1000); //make main thread sleep for 1 second before printing final count
		System.out.println("Value of count is: " + obj.count); 

	}

}

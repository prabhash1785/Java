package com.prabhash.java.lambda;

/**
 * Simple example to show how lambda's could be passed to Thread as runnable objects.
 * 
 * @author prrathore
 *
 */
public class RunnableLambda {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(
				() -> {System.out.println(Thread.currentThread().getName() + " ran!!");});
		
		Thread t2 = new Thread(() -> { System.out.println(Thread.currentThread().getName() + " ran!!"); });
		
		t1.start();
		t2.start();
	}

}

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
		
		Thread t5 = new Thread(
				() -> System.out.println(Thread.currentThread().getName() + " ran!!"));
		
		Runnable runnable3 = () -> {
			final int sleepTime = 3000;
			System.out.println("Going to sleep for " + sleepTime + " seconds.");
			try {
				Thread.sleep(sleepTime);
			} catch(InterruptedException iE) {
				iE.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " ran after sleeping!!");
			};
			
		Thread t3 = new Thread(runnable3);
		
		t3.start();
		t1.start();
		t2.start();
		t5.start();
	}

}

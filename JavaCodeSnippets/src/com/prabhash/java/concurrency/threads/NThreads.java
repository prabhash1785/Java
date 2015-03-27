package com.prabhash.java.concurrency.threads;

/**
 * Collection of threads to run some runnable tasks.
 * 
 * @author prrathore
 *
 */
public class NThreads {
	
	public static class MyRunnable implements Runnable {
		
		@Override
		public void run() {
			System.out.println("Printed by Thread -> " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		
		MyRunnable  runnable = new MyRunnable();
		
		for(int i = 0; i < 10; i++) {
			
			new Thread(runnable, "Thread" + (i + 1)).start();
			
		}
		
	}

}

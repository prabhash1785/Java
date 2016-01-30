package com.prabhash.java.effectivejava.sample.programs;

/**
 * Program created to check if multiple threads can show different values for static variable  from two different threads. With
 * my below example, I don't see inconsistent states of static field from different threads.
 * Ref: http://stackoverflow.com/questions/461896/what-is-the-most-frequent-concurrency-issue-youve-encountered-in-java/462714#462714
 * 
 * @author prrathore
 *
 */
public class Dummy {
	
	private static int a = 1;
	
	/**
	 * Example of bad programming. Don't do this, i.e, don't use wait and notify without synchronized block.
	 * 
	 * @throws InterruptedException
	 */
	public static void waiter() throws InterruptedException {
		
		// Example of Bad Programming - this will throw IllegalMonitorStateException
		Dummy.class.wait(); // Dummy mistake wait and notify should be in a synchronized block
		Dummy.class.notify();
	}

	public static void main(String[] args) throws Exception {
		
		int b = Dummy.a;
		System.out.println("From thread, " + Thread.currentThread().getName() + " :: a = " + b);
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				int i = Dummy.a;
				System.out.println("From thread, " + Thread.currentThread().getName() + " :: a = " + i);
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				int j = Dummy.a;
				System.out.println("From thread, " + Thread.currentThread().getName() + " :: a = " + j);
			}
		});
		
		t1.start();
		t2.start();
		
		// waiter();
		
	}

}

package com.prabhash.java.concurrency.threads;

/**
 * Program to create a Deadlock.
 * 
 * @author prrathore
 *
 */
public class DeadLockDemo {
	
	public synchronized void method1() {
		System.out.println(Thread.currentThread().getName() + " => Method 1");
	}
	
	public synchronized void method2() {
		System.out.println(Thread.currentThread().getName() + " => Method 2");
	}

	public static void main(String[] args) {
		
		final DeadLockDemo monitorObj1 = new DeadLockDemo();
		final DeadLockDemo monitorObj2 = new DeadLockDemo();
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				monitorObj1.method1();
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				monitorObj2.method2();;
			}
		});
		
		thread1.start();
		thread2.start();

	}

}

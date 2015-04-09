package com.prabhash.java.concurrency.test;

import com.prabhash.java.concurrency.locks.BasicNonReentrantLock;

/**
 * Test Basic Non Reentrant Lock implementation.
 * 
 * @author prrathore
 *
 */
public class BasicNonReentrantLockTest {
	
private static class Counter {
		
		private int counter = 0;
		final BasicNonReentrantLock lock = new BasicNonReentrantLock();
		
		public void increment() throws InterruptedException {
			
			lock.lock();
			try {
				counter++;
				System.out.println(Thread.currentThread().getName() + " updated counter to: " + counter);
			} finally {
				lock.unLock();
			}
			
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		final Counter counter = new Counter();
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					counter.increment();
				} catch(InterruptedException i) {
					i.printStackTrace();
				}
			}
		}, "Thread1");
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					counter.increment();
				} catch(InterruptedException i) {
					i.printStackTrace();
				}
			}
		}, "Thread2");

		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					counter.increment();
				} catch(InterruptedException i) {
					i.printStackTrace();
				}
			}
		}, "Thread3");
		
		thread1.start();
		thread2.start();
		thread3.start();


	}

}

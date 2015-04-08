package com.prabhash.java.concurrency.locks;

/**
 * Basic Non Reentrant Lock. 
 * 
 * With Non-Reentrant Lock, if a threads holds the monitor object on one synchronized block then it can't
 * enter other synchronized blocks with the same monitor object without releasing the lock and then acquiring lock on monitor object again. 
 * 
 * @author prrathore
 *
 */
public class BasicNonReentrantLock {
	
	private boolean isLocked = false;
	
	public synchronized void lock() throws InterruptedException {
		
		System.out.println(Thread.currentThread().getName() + " just entered lock method!!");
		
		while(isLocked) {
			
			System.out.println(Thread.currentThread().getName() + " is parked in while loop waiting for notify signal");
			
			wait();
		}
		
		System.out.println(Thread.currentThread().getName() + " locked the object");
		
		isLocked = true;
		
	}
	
	public synchronized void unLock() {
		
		System.out.println("Object unlocked. This thread will notify other waiting threads: " + Thread.currentThread().getName());
		
		isLocked = false;
		notify();
	}
	
	private static class Counter {
		
		private int counter = 0;
		final BasicNonReentrantLock lock = new BasicNonReentrantLock();
		
		public void increment() throws InterruptedException {
			
			lock.lock();
			counter++;
			System.out.println(Thread.currentThread().getName() + " updated counter to: " + counter);
			lock.unLock();
			
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

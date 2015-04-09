package com.prabhash.java.concurrency.locks;

/**
 * Basic Non Reentrant Lock. 
 * 
 * With Non-Reentrant Lock, if a threads holds the monitor object on one synchronized block then it can't
 * enter other synchronized blocks with the same monitor object without releasing the lock and then acquiring lock on monitor object again. 
 * 
 * Test class is available in package: com.prabhash.java.concurrency.test.BasicNonReentrantLockTest
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
	
	public synchronized void unLock() throws IllegalMonitorStateException {
		
		System.out.println("Object unlocked. This thread will notify other waiting threads: " + Thread.currentThread().getName());
		
		isLocked = false;
		notify();
	}
	
}

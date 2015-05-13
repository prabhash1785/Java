package com.prabhash.java.concurrency.locks;

import java.security.InvalidParameterException;

/**
 * Bounded Counting Semaphore implementation.
 * 
 * @author prrathore
 *
 */
public class SemaphoreImpl {

	private final int capacity; //total number of available permits
	private int acquiredPermit;
	
	public SemaphoreImpl() {
		this(5);
	}
	
	public SemaphoreImpl(int capacity) {
		if(capacity <= 0 || capacity > 10) {
			throw new InvalidParameterException("Invalid value of Semaphore capacity, it has to be between 1 and 10!!");
		}
		
		this.capacity = capacity;
		this.acquiredPermit = 0;
		
	}
	
	/**
	 * This method will acquire a permit from Semaphore if there is an available lock or else it will block for the locks to become available.
	 * 
	 */
	public synchronized void acquire() throws InterruptedException {
		
		//Check if all permits are taken, if yes then block
		while(acquiredPermit == (capacity)) {
			wait();
		}
		
		acquiredPermit++;
		
	}
	
	/**
	 * Release the permit back to Semaphore and notify all the blocking threads.
	 * 
	 */
	public synchronized void release() {
		
		if(acquiredPermit == 0) {
			throw new IllegalStateException("Can not release permits until at least one permit is acquired");
		}
		
		acquiredPermit--;
		notifyAll();
		
	}
	
	/**
	 * Number of permits acquired
	 * 
	 */
	public synchronized int getAcquiredPermitCount() {
		return this.acquiredPermit;
	}
	
	/**
	 * Number of available Permits
	 * 
	 */
	public synchronized int getAvailablePermitCount() {
		return (this.capacity - this.acquiredPermit);
	}

}

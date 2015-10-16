package com.prabhash.java.concurrency.locks;

import java.security.InvalidParameterException;

/**
 * Bounded Counting Semaphore implementation.
 * 
 * A counting semaphore. Conceptually, a semaphore maintains a set of permits. Each acquire() BLOCKS if necessary until a
 * permit is available, and then takes it. Each release() adds a permit, potentially releasing a blocking acquirer. However, 
 * no actual permit objects are used; the Semaphore just keeps a count of the number available and acts accordingly.
 * 
 * Semaphores are often used to restrict the number of threads than can access some (physical or logical) resource.
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
	 * This method will acquire a permit from Semaphore if there is an available lock or else it will BLOCK for the locks to become available.
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

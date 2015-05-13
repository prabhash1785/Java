package com.prabhash.java.concurrency.locks;

import java.security.InvalidParameterException;

/**
 * Semaphore implementation.
 * 
 * @author prrathore
 *
 */
public class SemaphoreImpl {
	
	private final boolean[] semaphore;
	private final int capacity;
	private int currentPosition;
	
	public SemaphoreImpl() {
		this(5);
	}
	
	public SemaphoreImpl(int capacity) {
		if(capacity <= 0 || capacity > 10) {
			throw new InvalidParameterException("Invalid value of Semaphore capacity, it has to be between 1 and 10!!");
		}
		
		this.capacity = capacity;
		this.semaphore = new boolean[capacity];
		this.currentPosition = -1;
		
		//initialize all the permits to false
		for(int i = 0; i < this.capacity; i++) {
			this.semaphore[i] = false;
		}
		
	}
	
	/**
	 * This method will acquire a permit from Semaphore if there is an available lock or else it will block for the locks to become available.
	 * 
	 */
	public synchronized void acquire() throws InterruptedException {
		
		//Check if all permits are taken, if yes then block
		while(currentPosition == (capacity - 1)) {
			wait();
		}
		
		currentPosition = currentPosition + 1;
		semaphore[currentPosition] = true;
		
	}
	
	/**
	 * Release the permit back to Semaphore.
	 * 
	 */
	public synchronized void release() {
		
		
		
	}

}

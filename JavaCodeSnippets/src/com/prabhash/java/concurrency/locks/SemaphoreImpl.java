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
	
	public SemaphoreImpl() {
		this(5);
	}
	
	public SemaphoreImpl(int capacity) {
		if(capacity <= 0 || capacity > 10) {
			throw new InvalidParameterException("Invalid value of Semaphore capacity, it has to be between 1 and 10!!");
		}
		
		this.capacity = capacity;
		this.semaphore = new boolean[capacity];
	}
	
	

}

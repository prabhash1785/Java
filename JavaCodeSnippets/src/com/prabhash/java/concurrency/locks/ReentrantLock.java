package com.prabhash.java.concurrency.locks;

/**
 * Reentrant Lock implementation.
 * 
 * A Renentrant lock allows a Thread to execute other blocks of code with same monitor lock without acquiring the lock again on those
 * blocks.
 * 
 * @author prrathore
 *
 */
public class ReentrantLock {
	
	private boolean isLocked = false;
	private Thread lockedBy = null;
	private int lockCount = 0; //keep track of reentrant locks held by the thread on a monitor object
	
	/**
	 * Lock can be obtained only if
	 * 	 - current object is not locked
	 *   - current object is locked by same thread hence retain the lock and increase the lock count. This makes this lock a Reentrant lock.
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void lock() throws InterruptedException {
		
		Thread callingThread = Thread.currentThread();
		
		while(isLocked && callingThread != lockedBy) {
			wait(); //wait for the object to get unlocked
		}
		
		isLocked = true;
		lockedBy = callingThread;
		lockCount += 1;
		
	}
	
	/**
	 * A object can be unlocked only if:
	 *   - it is locked and locked by same thread which is requesting unlock
	 *   - lock can be completely reset to unlock only if lockCount == 0
	 * 
	 * @throws IllegalMonitorStateException
	 */
	public synchronized void unlock() throws IllegalMonitorStateException {
		
		Thread callingThread = Thread.currentThread();
		
		//if there is no lock on object then you can't send unlock request
		if(!isLocked)
			throw new IllegalMonitorStateException();
		
		//if lock is not owned by current threads then throw an exception 
		if(isLocked && callingThread != lockedBy)
			throw new IllegalMonitorStateException();
		
		lockCount -= 1;
		
		if(lockCount == 0) {
			isLocked = false;
			lockedBy = null;
			notify(); //notify the waiting threads
		}
			
		
	}

}

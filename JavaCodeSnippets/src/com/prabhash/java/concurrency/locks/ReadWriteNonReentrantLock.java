package com.prabhash.java.concurrency.locks;

/**
 * Thread Safe Read Write Non-Reentrant Lock implementation.
 * 
 * Lock policy:
 * - Read Locks are shared.
 * - Write Locks are mutually exclusive.
 * - Thread with write lock request will block if there are active read locks or write lock.
 * - Thread with read lock request will block if there is a write lock or there are blocked write locks waiting for lock.
 * 
 * Write lock request gets higher precedence over read lock to prevent thread starvation in a Read Intensive application.
 * 
 * @author Prabhash Rathore
 *
 */
public class ReadWriteNonReentrantLock {
	private volatile int activeReadLocks = 0;
	private volatile int waitingWriteLocks = 0;
	private volatile boolean isWriteLocked = false;
	
	/**
	 * Acquires shared read lock. If there are threads waiting for write locks or there is an active thread then this lock cannot
	 * be acquired and thread needs to be blocked.
	 * 
	 */
	public synchronized void readLock() {
		while(isWriteLocked || waitingWriteLocks > 0) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		++activeReadLocks;
	}
	
	/**
	 * Release read lock.
	 * 
	 */
	public synchronized void readUnLock() {
		if(activeReadLocks <= 0) {
			throw new IllegalStateException("No read locks acquired so cannot unlock");
		}
		
		--activeReadLocks;
		notifyAll(); // notify all blocked threads then one lock is released
	}
	
	/**
	 * Acquire write lock. Write lock cannot be acquired if there are active read locks or if some thread has already acquired write lock.
	 * 
	 */
	public synchronized void writeLock() {
		++waitingWriteLocks; // when write lock is requested, increment waiting write lock requests
		while(isWriteLocked || activeReadLocks > 0) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		--waitingWriteLocks; // once write lock is acquired, decrement the waitingWriteLocks count
		isWriteLocked = true;
	}
	
	/**
	 * Release write lock.
	 * 
	 */
	public synchronized void writeUnLock() {
		if(!isWriteLocked) {
			throw new IllegalStateException("No active write lock acquired so cannot do unlocking");
		}
		
		isWriteLocked = false;
		notifyAll();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

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
				System.out.println(Thread.currentThread().getName() + " is blocked for read lock!!");
				System.out.println("activeReadLocks = " + activeReadLocks + " :: waitingWriteLocks: " + waitingWriteLocks + 
						" :: isWriteLocked: " + isWriteLocked);
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
		
		System.out.println(Thread.currentThread().getName() + " is going to release read lock!!");
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
				System.out.println(Thread.currentThread().getName() + " is blocked for write lock!!");
				System.out.println("activeReadLocks = " + activeReadLocks + " :: waitingWriteLocks: " + waitingWriteLocks + 
						" :: isWriteLocked: " + isWriteLocked);
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
		
		System.out.println(Thread.currentThread().getName() + " is going to release write lock!!");
		isWriteLocked = false;
		notifyAll();
	}

	public static void main(String[] args) {
		ReadWriteNonReentrantLock lock = new ReadWriteNonReentrantLock();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.readLock();
				try {
					Thread.sleep(5000);
				} catch(InterruptedException e) {
					System.out.println("Thread T1 interrupted!!");
				}
				lock.readUnLock();
			}
		}, "T1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.readLock();
				try {
					Thread.sleep(5000);
				} catch(InterruptedException e) {
					System.out.println("Thread T2 interrupted!!");
				}
				lock.readUnLock();
			}
		}, "T2");
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.writeLock();
				try {
					Thread.sleep(5000);
				} catch(InterruptedException e) {
					System.out.println("Thread T3 interrupted!!");
				}
				lock.writeUnLock();
			}
		}, "T3");
		
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.writeLock();
				try {
					Thread.sleep(5000);
				} catch(InterruptedException e) {
					System.out.println("Thread T4 interrupted!!");
				}
				lock.writeUnLock();
			}
		}, "T4");
		
		Thread t5 = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.readLock();
				try {
					Thread.sleep(5000);
				} catch(InterruptedException e) {
					System.out.println("Thread T5 interrupted!!");
				}
				lock.readUnLock();
			}
		}, "T5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

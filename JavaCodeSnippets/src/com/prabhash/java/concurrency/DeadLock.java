package com.prabhash.java.concurrency;

/*
 * This class will show how to create deadlock between two threads
 * We don't need to put Threads to sleep to create deadlock but using sleep increases the probability of Threads deadlock.
 * Without sleep, one out of ten times, Thread deadlock is attained.
 * To fix the deadlock situation, both runnables needs to obtain lock in the same order on String and Integer objects.
 * Ref: http://javarevisited.blogspot.com/2010/10/what-is-deadlock-in-java-how-to-fix-it.html
 * @author Prabhash Rathore
 * 
 */
public class DeadLock {
	
	static class ThreadOne implements Runnable {
		
		@Override
		public void run() {
			
			synchronized(String.class) {
				System.out.println(Thread.currentThread().getName() + " - Got lock on String.class");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				synchronized(Integer.class) {
					System.out.println(Thread.currentThread().getName() + " - Got lock on Integer.class");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}		
			
		}
	}
	
	static class ThreadTwo implements Runnable {
		
		@Override
		public void run() {
			
			synchronized(Integer.class) {
				System.out.println(Thread.currentThread().getName() + " - Acquired lock on Integer.class object..");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				synchronized (String.class) {
					System.out.println(Thread.currentThread().getName() + " - Acquired lock on String.class object..");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		
		//new Thread(new DeadLock.ThreadOne()).start();
		//new Thread(new DeadLock.ThreadTwo()).start();
		
		new Thread(new ThreadOne(), "ThreadOne").start();
		new Thread(new ThreadTwo(), "ThreadTwo").start();

	}

}

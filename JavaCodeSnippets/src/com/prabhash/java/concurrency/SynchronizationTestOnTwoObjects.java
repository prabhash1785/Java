package com.prabhash.java.concurrency;

/**
 * Sample code to show how locks are obtained by threads on different objects, same object and static methods.
 * @author Prabhash Rathore
 *
 */
public class SynchronizationTestOnTwoObjects {
	
	/**
	 * For non-static methods, when a thread reaches a synchronized method, it acquires a lock on the whole object of that
	 * method and continues to keep the lock until the operation is completed. Other threads who needs lock on same object, 
	 * needs to wait for the lock to be released.
	 * However when two threads need locks on different objects of same class then they are not blocked because every object 
	 * has a lock and hence each thread will be able to obtain a lock on their objects.
	 */
	public synchronized void method1() {
		try {
			Thread.sleep(3000);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	public synchronized void method2() {
		try {
			Thread.sleep(5000);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * For methods which are static and are synchronized, threads acquire lock on their "class level objects" and these "class
	 * objects" are loaded by JVM during loading the classes.
	 */
	public static synchronized void method3() {
		try {
			Thread.sleep(3000);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		final SynchronizationTestOnTwoObjects s = new SynchronizationTestOnTwoObjects();
		final SynchronizationTestOnTwoObjects s2 = new SynchronizationTestOnTwoObjects();
		
		// Inner classes
		Thread t1 = new Thread() {
			public void run() {
				s.method1();
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				s2.method1();
			}
		};
		
		Thread t3 = new Thread() {
			public void run() {
				method3();
			}
		};
				
		t1.start();
		t2.start();
		t3.start();		
		
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		System.out.println(t3.getState());

	}

}

package com.prabhash.java.concurrency.threads;

/**
 * Program to prevent Race Condition between two threads in a Critical Section which is guarded by Synchronized keyword.
 * 
 * @author prrathore
 *
 */
public class NoRaceCondition {
	
	private int count = 0;
	
	/**
	 * This method is the Critical Section in the program as it's changing the state of this class. This method is synchronized to 
	 * prevent Race Condition.
	 * 
	 * This critical section will lead to Race Condition.
	 * 
	 */
	public synchronized void add(int n) {
		this.count += n;
		System.out.println("Value printed by Thread: " + Thread.currentThread().getName() + " ==> " + getVal());
	}
	
	/**
	 * If state of a field can be accessed by multiple threads and writes are performed on state then method accessing state
	 * needs to be synchronized as well.
	 * 
	 * @return int
	 * 
	 */
	public synchronized int getVal() {
		return this.count;
	}

	public static void main(String[] args) {
		
		final NoRaceCondition obj = new NoRaceCondition();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.add(5);
			}
		}, "Thread1") ;
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.add(10);
			}
		}, "Thread2") ;
		
		t1.start();
		t2.start();
		
		System.out.println("Value of count printed by Thread: " + Thread.currentThread().getName() + " ==> " + obj.getVal());
		
	}

}

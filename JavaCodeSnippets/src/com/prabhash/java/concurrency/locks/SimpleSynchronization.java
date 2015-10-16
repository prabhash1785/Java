package com.prabhash.java.concurrency.locks;

public class SimpleSynchronization {
	
	private int count = 0;
	
	public void increment() {
		//critical section, apply a lock using using synchronized block
		synchronized(this) {
			count++;
			System.out.println(Thread.currentThread().getName() + " incremented " + this.toString() + " object count to ==> " + count);
		}
	}

	public static void main(String[] args) {
		
		final SimpleSynchronization obj = new SimpleSynchronization();
		final SimpleSynchronization obj2 = new SimpleSynchronization();
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.increment();
			}
		}, "Thread1");
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.increment();
			}
		}, "Thread2");
		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.increment();
			}
		}, "Thread3");
		
		Thread thread4 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.increment();
			}
		}, "Thread4");
		
		Thread thread5 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.increment();
			}
		}, "Thread5");
		
		Thread thread6 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj2.increment();
			}
		}, "Thread6");
		
		Thread thread7 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj2.increment();
			}
		}, "Thread7");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		thread6.start();
		//thread6.start(); //results in illegalstate exception
		thread7.start();
		
	}
	

}

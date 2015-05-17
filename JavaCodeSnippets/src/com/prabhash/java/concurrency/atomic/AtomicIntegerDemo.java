package com.prabhash.java.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger will provide implicit thread safety and prevent race conditions.
 * 
 * @author prrathore
 *
 */
public class AtomicIntegerDemo {
	
	private final AtomicInteger num;
	
	public AtomicIntegerDemo(int num) {
		this.num = new AtomicInteger(num);
	}
	
	public void increment() {
		
		boolean updated = false;
		
		while(!updated) {
			
			int currentVal = num.get();
			updated = num.compareAndSet(currentVal, currentVal + 1); //Atomically sets the value to the given updated value if the current value == the expected value.
			
		}
		
	}
	
	public int getCount() {
		return this.num.get();
	}

	public static void main(String[] args) {
		
		final AtomicIntegerDemo atomicObject = new AtomicIntegerDemo(10);
		
		Thread t0 = new Thread(new Runnable() {
			@Override
			public void run() {
				atomicObject.increment();
			}
		}, "T0");
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " : " + atomicObject.getCount());
			}
		}, "T1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				atomicObject.increment();
			}
		}, "T2");
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " : " + atomicObject.getCount());
			}
		}, "T3");
		
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " : " + atomicObject.getCount());
			}
		}, "T4");
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}

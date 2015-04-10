package com.prabhash.java.concurrency.test;

import com.prabhash.java.concurrency.locks.ReentrantLock;

public class ReentrantLockTest {
	
	private int counter = 0;
	
	private ReentrantLock lock = new ReentrantLock();
	
	public void increment() throws InterruptedException {
		lock.lock();
		try {
			counter = counter + 1;
			printCounter(); //call this method without getting blocked as lock is an instance of Reentrant Lock
		} finally {
			lock.unlock();
		}
		
	}

	public void printCounter() throws InterruptedException {
		lock.lock();
		System.out.println("Counter: " + counter);
		lock.unlock();
	}

	public static void main(String[] args) {
		
		final ReentrantLockTest obj = new ReentrantLockTest();
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.increment();
				} catch(InterruptedException i) {
					i.printStackTrace();
				}
				
			}
		}, "Thread1");
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.increment();
				} catch(InterruptedException i) {
					i.printStackTrace();
				}
				
			}
		}, "Thread2");
		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.increment();
				} catch(InterruptedException i) {
					i.printStackTrace();
				}
				
			}
		}, "Thread3");
		
		Thread thread4 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.increment();
				} catch(InterruptedException i) {
					i.printStackTrace();
				}
				
			}
		}, "Thread4");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}

}

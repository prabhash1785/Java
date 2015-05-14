package com.prabhash.java.concurrency.locks;

/**
 * Client to test Semaphore implementation.
 * 
 * @author prrathore
 *
 */
public class SemaphoreClient {

	public static void main(String[] args) {
		
		final SemaphoreImpl semaphore = new SemaphoreImpl(2);
		
		System.out.println("Total acquired Permits: " + semaphore.getAcquiredPermitCount());
		System.out.println("Total available Permits: " + semaphore.getAvailablePermitCount());
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + " => Remaining permits: " + semaphore.getAvailablePermitCount());
				} catch(InterruptedException i) {
					i.printStackTrace();
				}
			}
		}, "thread1");
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + " => Remaining permits: " + semaphore.getAvailablePermitCount());
					Thread.sleep(5000);
					semaphore.release(); //blocked thread will take this released permit
				} catch(InterruptedException i) {
					i.printStackTrace();
				}
			}
		}, "thread2");

		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + " => Remaining permits: " + semaphore.getAvailablePermitCount());
				} catch(InterruptedException i) {
					i.printStackTrace();
				}
			}
		}, "thread3");
		
		thread1.start();
		thread2.start();
		thread3.start();


	}

}

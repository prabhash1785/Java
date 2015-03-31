package com.prabhash.java.concurrency.threads;

/**
 * A simple program to depict the Thread Signaling process using Java Wait and Notify constructs.
 * 
 * @author prrathore
 *
 */
public class ThreadSignalingDemo {
	
	private static final ThreadSignalingDemo monitorObject = new ThreadSignalingDemo(); //monitor object
	
	public void waitForSignal() throws InterruptedException {
		synchronized(monitorObject) {
			System.out.println(Thread.currentThread().getName() + " => Going in WAIT state!!");
			monitorObject.wait();
			System.out.println(Thread.currentThread().getName() + " => Going out of WAIT state!!");
		}
	}
	
	public void notifyThread() {
		synchronized(monitorObject) {
			System.out.println(Thread.currentThread().getName() + " => Going to NOTIFY other waiting threads!!");
			monitorObject.notify();
			System.out.println(Thread.currentThread().getName() + " => Notified one of the waiting threads!!");
		}
	}

	public static void main(String[] args) {
		
		Thread thread1 = new Thread("Thread1") {
			@Override
			public void run() {
				try {
					monitorObject.waitForSignal();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				monitorObject.notifyThread();
			}
		}, "Thread2");
		
		thread1.start();
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread2.start();

	}

}

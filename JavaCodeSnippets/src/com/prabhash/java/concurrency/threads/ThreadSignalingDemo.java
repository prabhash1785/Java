package com.prabhash.java.concurrency.threads;

public class ThreadSignalingDemo {
	
	private static final ThreadSignalingDemo monitorObject = new ThreadSignalingDemo(); //monitor object
	
	public void waitForSignal() throws InterruptedException {
		synchronized(monitorObject) {
			monitorObject.wait();
		}
	}
	
	public void notifyThread() {
		synchronized(monitorObject) {
			monitorObject.notify();
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

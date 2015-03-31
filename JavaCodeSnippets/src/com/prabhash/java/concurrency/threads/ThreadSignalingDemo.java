package com.prabhash.java.concurrency.threads;

public class ThreadSignalingDemo {
	
	private final ThreadSignalingDemo monitorObject = new ThreadSignalingDemo(); //monitor object
	
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
					new ThreadSignalingDemo().waitForSignal();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				new ThreadSignalingDemo().notifyThread();
			}
		}, "Thread2");

	}

}

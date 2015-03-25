package com.prabhash.java.concurrency;

public class MutualExclusion {
	
	//mutable primitive instance variable
	private int a = 10;
	
	public int getValue() {
		return a;
	}
	
	public synchronized void setValue(int a) {
		this.a = a;
	}

	public static void main(String[] args) {
		
		MutualExclusion m = new MutualExclusion();
		
		Thread t1 = new Thread("Thread1") {
			public void run() {
				//m.setValue(20);
				System.out.println(Thread.currentThread().getName() + " has value: " + m.getValue());
			}
		};;
		
		Thread t2 = new Thread("Thread2") {
			public void run() {
				m.setValue(40);
				System.out.println(Thread.currentThread().getName() + " has value: " + m.getValue());
			}
		};
		
		t1.start();
		t2.start();
		

	}

}

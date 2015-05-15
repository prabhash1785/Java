package com.prabhash.java.concurrency.locks;

public class VolatileDemo {
	
	private volatile long count = 0;

    /**
     * Only one thread may ever call this method,
     * or it will lead to race conditions.
     */
    public void increment() {
        this.count++;
    }


    /**
     * Many reading threads may call this method
     * @return
     */
    public long getCount() {
        return this.count;
    }

	public static void main(String[] args) {
		
		final VolatileDemo volatileObj = new VolatileDemo();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " : " + volatileObj.getCount());
			}
		}, "T1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				volatileObj.increment();
			}
		}, "T2");
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " : " + volatileObj.getCount());
			}
		}, "T3");
		
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " : " + volatileObj.getCount());
			}
		}, "T4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}

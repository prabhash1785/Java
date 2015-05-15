package com.prabhash.java.concurrency.locks;

/**
 * The below program is thread safe even though we are not using synchronized block or lock to control the critical blocks.
 * 
 * This program uses a Volatile data type to force every read and write from Main Memory which keeps the data state consistent.
 * 
 * For thread safety, in this case only one thread can mutate the state of volatile field but any number of threads can read the values.
 * If more than one thread will try to write to count variable then this would lead to race conditions.
 * 
 * @author prrathore
 *
 */
public class VolatileDemo {
	
	private volatile long count = 0;

    /**
     * Only one thread may should call this method,
     * or it will lead to race conditions.
     */
    public void increment() {
        this.count++;
    }


    /**
     * Many reading threads can call this method
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

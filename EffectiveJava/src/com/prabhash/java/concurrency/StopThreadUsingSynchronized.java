package com.prabhash.java.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThreadUsingSynchronized {
	
	private static boolean stopRequested;
	
    private static synchronized void requestStop() {
        stopRequested = true;
    }
    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
               //Poll on flag value
                while (!stopRequested) {
                    System.out.println("i: " + i);
                	i++;
                }
                System.out.println("Finally stopped with value of i = " + i);
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }

}

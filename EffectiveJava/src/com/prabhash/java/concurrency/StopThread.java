package com.prabhash.java.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested;

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

        TimeUnit.NANOSECONDS.sleep(1); //same as Thread.sleep()
        stopRequested = true;
    }
}
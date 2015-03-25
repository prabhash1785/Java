package com.prabhash.java.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * A thread should never stop other thread using Thread.stop() method. This method is deprecated.
 * Instead let the thread poll on a boolean value which could set set/reset by another thread resulting in stopping other thread.
 * Below program is an example of a Thread polling on boolean value to stop.
 * 
 * This is a flawed program as it doesn't synchronize the access to boolean field resulting in program running longer than expected.
 * 
 * @author prrathore
 *
 */
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

        TimeUnit.SECONDS.sleep(1); //same as Thread.sleep()
        stopRequested = true;
    }
}
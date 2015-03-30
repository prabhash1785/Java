package com.prabhash.java.concurrency.threads;

/**
 * TheadLocal class enables us to create variable which are only visible to the thread which creates it.
 * Thus, even if two threads are executing the same code, and the code has a reference to a ThreadLocal variable, 
 * then the two threads cannot see each other's ThreadLocal variables.
 * 
 * @author prrathore
 *
 */
public class ThreadLocalDemo {

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
               new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadLocal.set( (int) (Math.random() * 100D) );
    
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
    
            System.out.println("Thread Name: " + Thread.currentThread().getName() + " ==> " + threadLocal.get());
        }
    }


    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance, "Thread1");
        Thread thread2 = new Thread(sharedRunnableInstance, "Thread2");

        thread1.start();
        thread2.start();
    }

}
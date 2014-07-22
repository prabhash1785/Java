package com.prabhash.java.concurrency;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class will shows the usage of Wait-Notify methods by making use of Producer-Consumer Design Pattern.
 * 
 * Wait - Causes current Thread to wait until another thread invokes the notify/notifyAll method ofthis object.
 * Notify -  Wakes up a single thread that is waiting on this object's monitor (lock).
 * 
 * @author Prabhash Rathore
 *
 */
public class WaitNotify {
	
	private Queue<Integer> queue; //a buffer queue
	
	public WaitNotify() {
		queue = new LinkedList<Integer>();
	}
	
	public class Producer implements Runnable {
		
		/**
		 * Producer which add elements to the Queue
		 * 
		 */
		public void produce(Integer element) {
			synchronized(queue) {
				queue.offer(element);
				System.out.println(Thread.currentThread().getName() + " : Added element " + queue.peek());
				try {
					queue.notify(); //call notify on the object on which you have the mutex
				} catch(IllegalMonitorStateException e) {
					e.printStackTrace();
				}				
				
			}
			
		}
		
		@Override
		public  void run() {
			System.out.println("Hello " + Thread.currentThread().getName());
			int i = 0;
			while(true) {
				produce(i);
				i++;
				try {
					Thread.sleep(2000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}				
			}
		}
		
	}
	
	public class Consumer implements Runnable {
		
		/**
		 * Consumer which reads elements from Queue
		 * 
		 * Blocking the Queue if no elements in queue
		 * 
		 * @return
		 */
		public void consume() {
			
			if(queue.peek() == null) {				
				synchronized(queue) {
					try {
					queue.wait(); //if queue is empty then block until there are elements in queue, timeout after 5 seconds
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			Integer element = queue.poll();
			System.out.println(Thread.currentThread().getName() + " : Consumed element " + element);			
		}
		
		@Override
		public void run() {
			System.out.println("Hello " + Thread.currentThread().getName());
			while(true) {
				try {
					consume();
					Thread.sleep(2000); //sleep for 2 seconds
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}		
		
	}	
	

	public static void main(String[] args) {
		
		WaitNotify obj = new WaitNotify();
		
		Thread producerThread = new Thread(obj.new Producer(), "First Producer Thread");
		
		Thread consumerThread = new Thread(obj.new Consumer(), "Consumer Thread");
		
		//Thread secondProducer = new Thread(obj.new Producer(), "Second Producer Thread");
		
		//Thread secondConsumerThread = new Thread(obj.new Consumer(), "Second Consumer Thread");
		
		producerThread.start();
		consumerThread.start();	
		
		//secondProducer.start();
		//secondConsumerThread.start();

	}
	
}

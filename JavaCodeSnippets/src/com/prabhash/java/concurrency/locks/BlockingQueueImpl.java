package com.prabhash.java.concurrency.locks;

import java.util.LinkedList;
import java.util.List;

/**
 * Blocking Queue implementation which will block to add element if queue is full or block to remove element if queue is empty.
 * 
 * @author prrathore
 *
 */
public class BlockingQueueImpl {
	
	private List<String> queue = new LinkedList<String>();
	private int limit;
	
	public BlockingQueueImpl() {
		this(10);
	}
	
	public BlockingQueueImpl(int limit) {
		this.limit = limit;
	}
	
	/**
	 * Add element to queue. This will block if queue is full.
	 * 
	 */
	public synchronized void add(String element) throws InterruptedException {
		
		while(queue.size() == limit) {
			wait();
		}
		
		if(queue.size() == 0) {
			notifyAll();
		}
		
		queue.add(element);
		
	}
	
	/**
	 * Remove head of the queue. If queue is empty then this will block.
	 * 
	 */
	public synchronized String remove() throws InterruptedException {
		
		while(queue.size() == 0) {
			wait();
		}
		
		if(queue.size() == limit) {
			notifyAll();
		}
		
		return queue.remove(0);
	}	

}

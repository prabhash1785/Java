package com.prabhash.interview.practice.general;

/**
 * Array based implementation of a Circular Queue.
 * 
 * This is not Thread Safe.
 * 
 * @author prrathore
 *
 */
public class CircularQueue {

	private int[] queue;
	private int head = 0;
	private int tail = 0;
	private int size = 0;
	private int capacity;

	public CircularQueue() {
		this(4);
	}

	public CircularQueue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
	}

	public int peek() {

		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}

		return this.queue[head];

	}

	public int poll() {

		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}

		int element = this.queue[head];
		head = (head + 1) % capacity; // move head towards right or wrap it if reach the end of array

		size  = size - 1;

		return element;

	}

	public boolean offer(int element) {

		if(isFull()) {
			System.out.println("Queue is full");
			return false;
		}

		this.queue[tail] = element;
		tail = (tail + 1) % capacity; // move tail towards right or wrap it if reach the end of array

		size  = size + 1;

		return true;

	}
	
	private boolean isEmpty() {
		if(this.head == this.tail) {
			return true;
		}
		
		return false;
	}
	
	private boolean isFull() {
		
		if(((tail - head) == (capacity - 1)) || (head - tail == 1)) {
			return true;
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		
		CircularQueue queue = new CircularQueue();
		
		queue.peek();
		
		int a = queue.poll();
		System.out.println(a);
		
		queue.offer(10);
		queue.offer(30);
		
		queue.peek();
		
		int b = queue.poll();
		System.out.println(b);
		
		queue.offer(70);
		queue.offer(80);
		queue.offer(90);
		
		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		
		queue.offer(190);
		System.out.println("Polled element: " + queue.peek());
		
		

	}

}

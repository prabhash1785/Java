package com.prabhash.interview.stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Implement Stack using a Queue.
 * 
 * Constraints:
 * - You can only use one queue and we cannot use extra memory other than a temporray variable.
 * - You can only use queue add, remove or size methods
 * - We don't care about time complexity.
 * 
 * @author Prabhash Rathore
 *
 */
public class StackUsingQueue {
	
	private Queue<Integer> queue;
	
	public StackUsingQueue() {
		this.queue = new LinkedList<>();
	}

	/**
	 * Since queue adds elements at the end and also stack ends at the end of data structure so push operation is as simple as
	 * add element to queue.
	 * 
	 * Time Complexity: O(1)
	 * 
	 * @param num
	 */
	public void push(int num) {
		queue.add(num);
	}
	
	/**
	 * Since we have an underlying queue data structure and we can only use add and remove method of this queue and also we cannot use
	 * another queue so the only way to achieve Stack LIFO pop operation is to rotate queue elements (queue.size() - 1) times so that
	 * last elements comes to the front of queue and then remove and return this element.
	 * 
	 * Queue rotation could be achieved by repeatedly calling add and remove.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @return int last element added to underlying queue
	 * @throws NoSuchElementException if underlying queue is empty
	 */
	public int pop() {
		// If queue is empty then throw NoSuchElementException
		if(queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		// Make sure to do add and remove only till size - 1 as this will rotate queue and last element will be in front after
		// (size - 1)th iteration
		for(int i = 0; i < queue.size() - 1; i++) {
			int a = queue.remove();
			queue.add(a);
		}
		
		return queue.remove();
	}
	
	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(4);
		stack.push(8);
		stack.push(12);
		System.out.println("Stack pop: " + stack.pop());
		System.out.println("Stack pop: " + stack.pop());
		System.out.println("Stack pop: " + stack.pop());
	}
}

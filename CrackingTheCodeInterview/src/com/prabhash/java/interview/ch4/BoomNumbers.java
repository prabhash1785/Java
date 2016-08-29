package com.prabhash.java.interview.ch4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Boom numbers are numbers consisting only of digits 2 and 3. Given an integer k (0<k<=10^7) , display the k-th Boom number.
 * 
 * Examples:
 * Input : k = 2
 * Output: 3
 * 
 * Input : k = 3
 * Output: 22
 * 
 * Input : k = 100
 * Output: 322323
 * 
 * Input: k = 1000000
 * Output: 3332322223223222223
 * 
 * @author Prabhash Rathore
 *
 */
public class BoomNumbers {
	
	/**
	 * Boom numbers can be generated using BST traversal of Binary Search Tree. First add two boom numbers to a Queue then in a loop,
	 * pop the head of queue, and add two to this element and increment count. If count == k, print this boom number. Else add 3 to the
	 * popped element from queue and increment count. If count == k, print this number. Else repeat this process until count < k.
	 * 
	 * Time Complexity: O(k)
	 * 
	 * @param k
	 */
	public static void printKthBoomNumber(int k) {
		if(k <= 0) {
			throw new IllegalArgumentException();
		}
		
		if(k == 1) {
			System.out.println("\nBoom number " + k + " = 2");
		} else if(k == 2) {
			System.out.println("\nBoom number " + k + " = 3");
		}
		
		Deque<String> deque = new LinkedList<>();
		deque.addLast("2");
		deque.addLast("3");
		int count = 2;
		
		while(count < k) {
			String boomNum = deque.removeFirst();
			
			String nextBoomNumber = boomNum + "2";
			deque.add(nextBoomNumber);
			++count;
			if(count == k) {
				System.out.println("\nBoom number " + k + " = " + nextBoomNumber);
				return;
			}
			
			nextBoomNumber = boomNum + "3";
			deque.add(nextBoomNumber);
			++count;
			if(count == k) {
				System.out.println("\nBoom number " + k + " = " + nextBoomNumber);
				return;
			}
		}
	}
	
	/**
	 * Use a Stack to store boom number digits. If k is odd then push 2 to Stack and if even then push 3 to Stack. Assign k = (k - 1) / 2.
	 * Repeat until k > 0. Final output can be printed by popping all the elements from Stack and appending them.
	 * 
	 * Time Complexity: O(log k)
	 * 
	 * @param k
	 */
	public static void printKthBoomNumberUsingStack(int k) {
		
		if(k <= 0) {
			throw new IllegalArgumentException();
		}
		
		int count = k;
		// Use deque as a Stack
		Deque<String> deque = new LinkedList<>();
		do {
			if(k % 2 != 0) {
				deque.addFirst("2"); // equivalent of of Stack push
			} else {
				deque.addFirst("3"); // equivalent of of Stack push
			}
			
			k = (k - 1) / 2;
		} while(k != 0);
		
		System.out.print("\nBoom number " +  count + " = ");
		while(!deque.isEmpty()) {
			System.out.print(deque.removeFirst());
		}
	}

	public static void main(String[] args) {
		printKthBoomNumber(100);
		printKthBoomNumber(3);
		printKthBoomNumber(1000000);
		printKthBoomNumber(6);
		
		printKthBoomNumberUsingStack(100);
		printKthBoomNumberUsingStack(3);
		printKthBoomNumberUsingStack(1000000);
		printKthBoomNumberUsingStack(6);
	}

}

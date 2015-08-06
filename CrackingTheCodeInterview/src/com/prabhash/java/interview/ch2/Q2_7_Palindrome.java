package com.prabhash.java.interview.ch2;

import java.util.Stack;

/**
 * Determine if a String represented as Linked List is Palindrome.
 * 
 * @author prrathore
 *
 */
public class Q2_7_Palindrome {
	
	/**
	 * Method 1
	 * 
	 * Put all the nodes of Linked List in Stack and then compare all nodes in Linked List with elements in Stack. If everything is equal then
	 * it's a palindrome.
	 * 
	 * @param args
	 */
	public static boolean isPalindromeUsingStack(LinkedListImpl.Node node) throws Exception {
		
		if(node == null) {
			throw new Exception("Linked List is empty!");
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		LinkedListImpl.Node temp = node;
		
		while(temp != null) {
			stack.push(temp.getData());
			temp = temp.getNext();
		}
		
		LinkedListImpl.Node runner = node;
		
		while(runner != null) {
			
			int stackData = stack.pop();
			int listData = runner.getData();
			
			if(stackData != listData) {
				return false;
			}
			
			runner = runner.getNext();
			
		}
		
		 return true;
		
	}

	public static void main(String[] args) throws Exception {
		
		LinkedListImpl ll = new LinkedListImpl();
		
		ll.addNode(4);
		ll.addNode(8);
		ll.addNode(23);
		ll.addNode(7);
		ll.addNode(23);
		ll.addNode(8);
		ll.addNode(4);
		
		LinkedListImpl.prettyPrintLinkedList(ll.getHead());
		
		boolean isPalindrome = isPalindromeUsingStack(ll.getHead());
		System.out.println("\n\nIs is palindrome: " + isPalindrome);

	}

}

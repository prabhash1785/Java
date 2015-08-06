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
	
	/**
	 * Method 2
	 * 
	 * This is an optimization on first method. We don't have to push all Linked List Nodes in stack. We can push half of the nodes in Linked
	 * List to stack and then compare nodes in stack with the remainign node in Linked List. If they are equal, it is a Linked List else not.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static boolean isPalindromeUsingStackOptimized(LinkedListImpl.Node node) {
		
		if(node == null) {
			throw new NullPointerException("Linked List is null");
		}
		
		
		
		return true;
	}
	
	/**
	 * Find middle node of a Linked List
	 * 
	 * @param node
	 * @return
	 */
	private static int findMiddleOfLinkedList(LinkedListImpl.Node node) {
		
		int middle = 1;
		
		LinkedListImpl.Node fast = node;
		LinkedListImpl.Node slow = node;
		
		while(fast != null && fast.getNext() != null) {
			middle++;
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		System.out.println("\n\nMiddle node is at position " + middle + " and value is: " + slow.getData());
		
		return middle;
		
	}

	public static void main(String[] args) throws Exception {
		
		LinkedListImpl ll = new LinkedListImpl();
		
		ll.addNode(4);
		ll.addNode(8);
		ll.addNode(23);
		ll.addNode(7);
		ll.addNode(7);
		ll.addNode(23);
		ll.addNode(8);
		ll.addNode(4);
		
		LinkedListImpl.prettyPrintLinkedList(ll.getHead());
		
		boolean isPalindrome = isPalindromeUsingStack(ll.getHead());
		System.out.println("\n\nIs is palindrome: " + isPalindrome);
		
		findMiddleOfLinkedList(ll.getHead());

	}

}

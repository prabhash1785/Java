package com.prabhash.interview.practice.linkedlist;

import java.util.Stack;

/**
 * Interweave a Singly Linked List.
 * 
 * For eg, input: 2 -> 8 -> 1 -> 7 -> 15
 * Output: 2 -> 15 -> 8 -> 7 -> 1
 * 
 * @author prrathore
 *
 */
public class InterweaveLinkedList {
	
	/**
	 * Method 1:
	 * Store all the nodes in a Stack so that we can access nodes starting end of the Linked List for interweaving.
	 * After that mutate Linked List pointers by pointing first node in Linked List to top node in Stack. Repeat this
	 * process until node from Linked List != popped node from Stack.
	 * 
	 *  Time Complexity: O(n)
	 *  Space Complexity: O(n)
	 *  
	 *  This can be optimized for Space by just storing half of Linked List nodes in Stack. 
	 * 
	 * @param head
	 * @return head
	 */
	public static Node interweaveUsingStack(Node head) {
		
		if(head == null) {
			return null;
		}
		
		final Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		
		Node first = head;
		Node last = stack.pop();
		
		while(first != null && last != null && first != last) {
			
			Node temp = first.next;
			first.next = last;
			last.next = temp; // Make sure to point last to second node stored in temp
			
			first = temp;
			last = stack.pop();
			last.next = null; // MUST reset last pointer to NULL to prevent infinite loops and corrupting Linked List pointers
		}
		
		return head;
	}
	
	public static Node interweaveUsingStackOptimizedForSpace(Node head) {
		
		if(head == null) {
			return null;
		}
		
		Node fast = head;
		Node slow = head;
		
		// determine the middle of Linked List
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		// Space optimized, we are just storing half (second half) of Nodes in Stack
		final Stack<Node> stack = new Stack<>();
		while(slow != null) {
			stack.push(slow);
			slow = slow.next;
		}
		
		Node first = head;
		Node last = stack.pop();
		
		while(first != null && last != null && first != last) {
			
			Node temp = first.next;
			first.next = last;
			last.next = temp; // Make sure to point last to second node stored in temp
			
			first = temp;
			last = stack.pop();
			last.next = null; // MUST reset last pointer to NULL to prevent infinite loops and corrupting Linked List pointers
		}
		
		return head;
	}
	
	private static void printLinkedList(Node head) {
		
		if(head == null) {
			return;
		}
		
		System.out.print(head.data + " -> " );
		printLinkedList(head.next);	
	}
	
	public static class Node {
		
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		
		Node head = new Node(4);
		head.next = new Node(2);
		head.next.next = new Node(10);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(7);
		head.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next = new Node(19);
		
		System.out.println("Original Linked List:");
		printLinkedList(head);
		
		head = interweaveUsingStack(head);
		System.out.println("\nInterweaved LinkedList:");
		printLinkedList(head);
		
		head = interweaveUsingStackOptimizedForSpace(head);
		System.out.println("\nInterweaved LinkedList using Space Optimized Algorithm:");
		printLinkedList(head);
	}
}

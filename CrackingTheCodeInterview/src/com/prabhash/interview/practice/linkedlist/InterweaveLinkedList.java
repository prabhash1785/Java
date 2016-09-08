package com.prabhash.interview.practice.linkedlist;

import java.util.Stack;

/**
 * Interweave a Singly Linked List.
 * 
 * For eg, input: 2 -> 8 -> 1 -> 7 -> 15
 * Output: 2 -> 15 -> 8 -> 7 -> 1
 * 
 * @author Prabhash Rathore
 *
 */
public class InterweaveLinkedList {
	
	/**
	 * Method 1:
	 * Store all the nodes in a Stack so that we can access nodes starting end of the Linked List for interweaving.
	 * After that mutate Linked List pointers by pointing first node in Linked List to top node in Stack. Repeat this
	 * process until node from Linked List != popped node from Stack and for even number of nodes, make sure first.next
	 * != node popped from stack.
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
		
		// For even number of nodes, make sure to stop when first.next becomes equal to last
		while(first != null && last != null && first != last && first.next != last) {
			
			Node temp = first.next;
			
			first.next = last;
			last.next = temp; // Make sure to point last to second node stored in temp
			
			first = temp;
			
			last = stack.pop();
			last.next = null; // MUST reset last pointer to NULL to prevent infinite loops and corrupting Linked List pointers
		}
		
		return head;
	}
	
	/**
	 * Method 2:
	 * Interweave a singly Linked List with Space optimization. In this case, we are just storing half of the Linked List nodes in
	 * Stack as compared to Method 1 where we stored all the nodes
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param head
	 * @return head
	 */
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
		
		// For even number of nodes, make sure to stop when first.next becomes equal to last
		while(first != null && last != null && first != last && first.next != last) {
			
			Node temp = first.next;
			
			first.next = last;
			last.next = temp; // Make sure to point last to second node stored in temp
			
			first = temp;
			last = stack.pop();
			last.next = null; // MUST reset last pointer to NULL to prevent infinite loops and corrupting Linked List pointers
		}
		
		return head;
	}
	
	/**
	 * Method 3:
	 * This method further optimizes interweaving Linked List by not using a Stack. It uses constant amount of space.
	 * 
	 * This method first finds the mid point in the Linked List and then it reverses the Linked List from mid point to end. Once 
	 * second half of Linked List is reversed then it interweaves the Linked List by following same steps as previous methods.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param head
	 * @return
	 */
	public static Node interweaveLLUsingConstantSpace(Node head) {
		
		if(head == null) {
			throw new IllegalArgumentException("Linked List is null");
		}
		
		Node fast = head;
		Node slow = head;
		
		// find the mid point node of Linked List
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		// reverse Linked List from mid point to end
		Node end = reverseLinkedList(slow);
		Node first = head;
		
		// For even number of nodes, make sure to stop when first.next becomes equal to last
		while(first != null && end != null && first != end && first.next != end) {
			
			Node tempFirst = first.next;
			Node tempEnd = end.next;
			
			first.next = end;
			end.next = tempFirst;
			
			first = tempFirst;
			end = tempEnd;
		}
		
		return head;
	}
	
	private static Node reverseLinkedList(Node node) {
		
		if(node == null) {
			throw new IllegalArgumentException();
		}
		
		// If Linked List has just one node then just return the same node without any reversal
		if(node.next == null) {
			return node;
		}
		
		Node prev = node;
		Node current = node.next;
		Node future = null;
		
		if(current != null) {
			future = current.next;
		}
		
		prev.next = null; // reset prev's next pointer to null to prevent cycles
		
		while(future != null) {
			
			current.next = prev;
			prev = current;
			current = future;
			
			future = future.next;
		}
		
		if(current != null) {
			current.next = prev;
		}
		
		return current;
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
		
		// test case 1: odd number of nodes
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
		
		head = interweaveLLUsingConstantSpace(head);
		System.out.println("\nInterweaved Linked List using constant space:");
		printLinkedList(head);
		
		// test case 2: even number of nodes
		Node evenLinkedList = new Node(5);
		evenLinkedList.next = new Node(10);
		evenLinkedList.next.next = new Node(15);
		evenLinkedList.next.next.next = new Node(20);
		
		System.out.println("\nOriginal Even Linked List:");
		printLinkedList(evenLinkedList);
		
		evenLinkedList = interweaveUsingStack(evenLinkedList);
		System.out.println("\nInterweaved LinkedList:");
		printLinkedList(evenLinkedList);
		
		evenLinkedList = interweaveUsingStackOptimizedForSpace(evenLinkedList);
		System.out.println("\nInterweaved LinkedList using Space Optimized Algorithm:");
		printLinkedList(evenLinkedList);
		
		evenLinkedList = interweaveLLUsingConstantSpace(evenLinkedList);
		System.out.println("\nInterweaved Linked List using constant space:");
		printLinkedList(evenLinkedList);
	}
}

package com.prabhash.interview.practice.linkedlist;

public class LinkedListImpl {
	
	private static class Node {
		
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	/**
	 * Iteratively reverse a Singly Linked List
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param head
	 * @return Node
	 */
	public static Node reverseLinkedList(Node head) {
		
		if(head == null) {
			return null;
		}
		
		Node prev = null;
		Node current = head;
		Node second = head.next;
		
		while(second != null) {
			
			current.next = prev;
			
			prev = current;
			current = second;
			second = second.next;
		}
		
		current.next = prev;
		
		return current;
		
	}
	
	public static void printLinkedList(Node head) {
		
		if(head == null) {
			return;
		}
		
		System.out.print(head.data + " -> ");
		
		printLinkedList(head.next);
	}

	public static void main(String[] args) {
		
		Node head = new Node(2);
		head.next = new Node(6);
		head.next.next = new Node(10);
		head.next.next.next = new Node(15);
		
		System.out.println("Original Linked List:"); 
		printLinkedList(head);
		
		Node newHead = reverseLinkedList(head);
		
		System.out.println("\nReversed Linked List:");
		printLinkedList(newHead);
		
	}

}

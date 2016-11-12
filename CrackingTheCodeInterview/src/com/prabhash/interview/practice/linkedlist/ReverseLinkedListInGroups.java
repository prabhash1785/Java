package com.prabhash.interview.practice.linkedlist;

public class ReverseLinkedListInGroups {
	
	/**
	 * Reverse Linked List with the given group size as follows:
	 * 
	 * Original Linked List:
		2 -> 4 -> 8 -> 7 -> 1 -> 9 -> 10 -> 5 -> 20 -> 18 -> 23 -> NULL

	   Reversed Linked List with group size k = 3:
	   8 -> 4 -> 2 -> 9 -> 1 -> 7 -> 20 -> 5 -> 10 -> 23 -> 18 -> NULL
	 * 
	 * @param head
	 * @param groupSize
	 * @return newHead
	 */
	public static Node reverseLinkedListWithGivenGroupSize(Node head, int groupSize) {
		
		if(head == null) {
			return null;
		}
		
		if(groupSize <= 0) {
			throw new IllegalArgumentException();
		}
		
		return reverseLinkedListHelper(head, groupSize);
	}
	
	private static Node reverseLinkedListHelper(Node head, int k) {
		
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list
		 * starting from current. And make rest of the list as next of first
		 * node
		 */
		if (next != null)
			head.next = reverseLinkedListHelper(next, k);

		// prev is now head of input list
		return prev;
	}

	/**
	 * Create a new Singly Linked List from given array.
	 * 
	 * @param values
	 * @return head
	 */
	public static Node createLinkedList(int[] values) {
		
		if(values == null || values.length == 0) {
			return null;
		}
		
		Node head = new Node(values[0]);
		Node pointer = head;
		for(int i = 1; i < values.length; i++) { 
			pointer.next = new Node(values[i]);
			pointer = pointer.next;
		}
		
		return head;
	}
	
	public static void printLinkedList(Node head) {
		if(head == null) {
			System.out.println("NULL");
			return;
		}
		
		System.out.print(head.data + " -> ");
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
		
		int[] a = new int[] {2, 4, 8, 7, 1, 9, 10, 5, 20, 18, 23};
		Node head = createLinkedList(a);
		
		System.out.println("Original Linked List:");
		printLinkedList(head);
		
		Node newHead = reverseLinkedListWithGivenGroupSize(head, 3);
		System.out.println("\nReversed Linked List with group size:");
		printLinkedList(newHead);
	}
}

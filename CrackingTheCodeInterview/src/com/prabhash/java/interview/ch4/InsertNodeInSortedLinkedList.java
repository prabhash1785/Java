package com.prabhash.java.interview.ch4;

/**
 * Insert a node in sorted Linked List maintaining the sorted order.
 * 
 * @author prrathore
 *
 */
public class InsertNodeInSortedLinkedList {
	
	/**
	 * Insert a node into sorted Linked List.
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public static Node insertNode(Node head, int val) {
		
		Node newNode = new Node(val);
		if(head == null) {
			return newNode;
		}

		Node prev = null;
		Node current = head;

		while(current != null) {

			if(val <= current.val) {

				if(prev == null) {
					newNode.next = current;
					return newNode;
				} else {
					prev.next = newNode;
					newNode.next = current;
					return head;
				}
			} else {
				prev = current;
				current = current.next;
			}
		}
		
		// if newNode val is greater than last node then point last node to newNode
		if(val > prev.val) {
			prev.next = newNode;
		}

		return head;
	}
	
	public static void printLinkedList(Node head) {
		
		if(head == null) {
			System.out.println("Empty Linked List");
			return;
		}
		
		while(head != null) {
			System.out.print(head.val + " => ");
			head = head.next;
		}
	}
	
	public static class Node {
		private int val;
		private Node next;
		
		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		
		Node head = insertNode(null, 5);
		head = insertNode(head, 4);
		head = insertNode(head, 14);
		head = insertNode(head, 1);
		head = insertNode(head, 7);
		head = insertNode(head, 20);
		
		System.out.println("Sorted Linked List:");
		printLinkedList(head);
	}

}

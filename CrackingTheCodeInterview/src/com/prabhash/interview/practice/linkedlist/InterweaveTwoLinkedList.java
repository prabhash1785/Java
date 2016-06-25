package com.prabhash.interview.practice.linkedlist;

/**
 * Interweave two singly Linked List.
 * 
 * @author Prabhash Rathore
 *
 */
public class InterweaveTwoLinkedList {
	
	/**
	 * Interweave two singly Linked List.
	 * 
	 * @param node1
	 * @param node2
	 * @return head
	 */
	public static Node interweaveTwoSinglyLinkedList(Node node1, Node node2) {
		
		if(node1 == null) {
			return node2;
		}
		
		if(node2 == null) {
			return node1;
		}
		
		Node head = node1;
		
		while(node1.next != null && node2.next != null) {
			Node temp1 = node1.next;
			Node temp2 = node2.next;
			
			node1.next = node2;
			node2.next = temp1;
			
			node1 = temp1;
			node2 = temp2;
		}
		
		if(node1.next == null) {
			node1.next = node2;
		}
		
		if(node2.next == null) {
			Node temp = node1.next;
			node1.next = node2;
			node2.next = temp;
		}
		
		return head;
	}
	
	/**
	 * Recursively print a Linked List
	 * 
	 * @param head
	 */
	public static void printLinkedList(Node head) {
		if(head == null) {
			System.out.print("NULL");
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
		
		Node list1 = new Node(4);
		list1.next = new Node(6);
		list1.next.next = new Node(8);
		list1.next.next.next = new Node(12);
		list1.next.next.next.next = new Node(14);
		
		System.out.println("First Linked List:");
		printLinkedList(list1);
		
		Node list2 = new Node(3);
		list2.next = new Node(5);
		list2.next.next = new Node(9);
		
		System.out.println("\nSecond Linked List:");
		printLinkedList(list2);
		
		Node head = interweaveTwoSinglyLinkedList(list1, list2);
		System.out.println("\nInterweaved Linked List:");
		printLinkedList(head);
	}
}

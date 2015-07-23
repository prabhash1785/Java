package com.prabhash.java.interview.ch2;

/**
 * Implementation of a simple Singly Linked List
 * 
 * @author prrathore
 *
 */
public class LinkedListImpl {
	
	private Node head;
	
	public LinkedListImpl(Node head) {
		this.head = head;
	}
	
	/**
	 * Add new node at the end of Linked List.
	 * 
	 * @param data
	 */
	public void addNode(int data) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node tempNode = head;
		
		while(tempNode.next != null) {
			tempNode = tempNode.next;
		}
		
		tempNode.next = newNode;
		
	}
	
	/**
	 * Insert a node after the given afterKey value. If afterKey is not found return false, else return true and update Linked List.
	 * 
	 * @param data
	 * @param afterKey
	 * @return
	 */
	public boolean insertNode(int data, int afterKey) {
		
		if(head == null) {
			throw new NullPointerException("Linked List head is null!");
		}
		
		Node newNode = new Node(data);
		
		Node pointer = head;
		
		while(pointer != null) {
			
			if(pointer.data == afterKey) { //found a node with the same value as afterKey
				
				Node tempNode = pointer.next;
				pointer.next = newNode;
				
				pointer.next.next = tempNode;
				
				return true;
			}
			
			pointer = pointer.next; //traverse through the Linked List
			
		}
		
		return false;
		
	}
	
	public void prettyPrintLinkedList(Node node) {
		
		if(node == null) {
			throw new NullPointerException("LinkedList does not exist!");
		}
		
		while(node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		
	}
	
	
	public static class Node {
		
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
	}

	public static void main(String[] args) {
		
		LinkedListImpl ll = new LinkedListImpl(new Node(10));
		
		ll.addNode(13);
		ll.addNode(1);
		ll.addNode(56);
		ll.addNode(33);
		ll.addNode(22);
		ll.addNode(7);
		ll.addNode(85);
		
		ll.prettyPrintLinkedList(ll.head);
		
		ll.addNode(56);
		ll.addNode(17);
		ll.addNode(100);
		
		System.out.println("\n\nUpdated Linked List with new elements added at the tail::");
		ll.prettyPrintLinkedList(ll.head);
		
		//insert a new node
		boolean inserted = ll.insertNode(66, 7);
		
		if(inserted) {
			System.out.println("\n\nHere is updated Linked List with a new node inserted in the middle::");
			ll.prettyPrintLinkedList(ll.head);
			
		} else {
			System.out.println("\n\nOops! Did not find a matching key in ordre to insert a new key after that node!!");
		}

		
	}

}

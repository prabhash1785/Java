package com.prabhash.java.interview.ch2;

/**
 * Implementation of a simple Singly Linked List
 * 
 * @author prrathore
 *
 */
public class LinkedListImpl {
	
	private Node head;
	
	public LinkedListImpl() {
		this(null);
	}
	
	public LinkedListImpl(Node head) {
		this.head = head;
	}
	
	/**
	 * Getters and setters for head
	 */
	public Node getHead() {
		return this.head;
	}
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	/**
	 * Generate a Linked List with random numbers
	 * 
	 */
	public void generateLinkedList() {
		
		this.addNode(13);
		this.addNode(1);
		this.addNode(56);
		this.addNode(13);
		this.addNode(33);
		this.addNode(22);
		this.addNode(22);
		this.addNode(7);
		this.addNode(85);
		this.addNode(100);
		this.addNode(56);
		this.addNode(17);
		this.addNode(100);
		
		System.out.println("\nHere is a generated LinkedList:\n");
		this.prettyPrintLinkedList(this.head);
			
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
	
	/**
	 * Find if data is available in Linked List.
	 * 
	 * @param data
	 * @return boolean
	 */
	public boolean isAvailable(int data) {
		
		Node node = this.head;
		
		while(node != null) {
			
			if(node.data == data) {
				return true;
			}
			
			node = node.next;
			
		}
		
		return false;
		
	}
	
	/**
	 * Delete a node with given data from Linked List.
	 * 
	 * @param node head of the Linked List
	 * @param data data key to be deleted
	 * 
	 * @return boolean
	 */
	public boolean deleteNode(Node node, int data) {
		
		if(node == null) {
			throw new NullPointerException("Linked List is null!");
		}
		
		Node prev = node; // keep track of previous nodes a
		
		while(node != null) {
			
			if(node.data == data) {
				
				prev.next = node.next;
				node = null;
				
				return true;
			}
			
			prev = node;
			node = node.next;
			
		}
		
		return false;
		
	}
	
	/**
	 * Reverse a Linked List
	 */
	public Node reverseLinkedList(Node node) {
		
		Node prev = null; //keep track of prev set of nodes
		Node current = node; //keep track of current node for operation
		Node rem = node.next; //keep track of next set of nodes
		
		while(rem != null) {
			
			current.next = prev;
			
			prev = current;
			current = rem;
			rem = rem.next;
			
		}
		
		current.next = prev; //Make sure last node points to the prev linked list chain
		
		this.head = current; //update head reference to first node in reversed linked list
		
		return current;
		
	}
	
	
	/**
	 * Print Singly Linked List in pretty format.
	 * 
	 * @param node
	 */
	public static void prettyPrintLinkedList(Node node) {
		
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

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
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
		
		boolean isdeleted = ll.deleteNode(ll.head, 56);
		
		if(isdeleted) {
			System.out.println("\n\nLL after deletion:: ");
			ll.prettyPrintLinkedList(ll.head);
		} else {
			System.out.println("\n\nGiven key is not found in Linked List for deletion.");
		}
		
		System.out.println("\n\nHere is Reverse Linked List: ");
		Node newHead = ll.reverseLinkedList(ll.head);
		ll.prettyPrintLinkedList(newHead);
		
		int input = 221;
		System.out.println("\n\nIs " + input + " available in Linked List: " + ll.isAvailable(input));
				
	}

}

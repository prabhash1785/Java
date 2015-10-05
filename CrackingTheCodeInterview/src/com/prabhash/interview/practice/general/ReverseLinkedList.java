package com.prabhash.interview.practice.general;

import com.prabhash.java.interview.ch2.LinkedListImpl;
import com.prabhash.java.interview.ch2.LinkedListImpl.Node;

public class ReverseLinkedList {
	
	public static Node reverseLL(Node node) { // a
		
		if(node == null) {
			return null;
		}

		Node prev = null;
		Node current = node; // a
		Node next = current.getNext(); // a

		while(next != null) { // a b c
			current.setNext(prev); // null <- a <- b <- c
			prev = current; // a b c
			current = next; // a b c
			next = next.getNext(); //b c null

		}
		
		current.setNext(prev);

		return current;

	}

	public static void main(String[] args) {
		
		LinkedListImpl ll = new LinkedListImpl();
		ll.addNode(2);
		ll.addNode(4);
		ll.addNode(6);
		
		Node head = ll.getHead();
		
		Node reversedHead = reverseLL(head);
		System.out.println("Reversed Linked List head is:");
		while(reversedHead != null) {
			System.out.print(reversedHead.getData() + " -> ");
			reversedHead = reversedHead.getNext();
		}

	}

}

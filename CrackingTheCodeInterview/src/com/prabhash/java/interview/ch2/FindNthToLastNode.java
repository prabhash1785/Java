package com.prabhash.java.interview.ch2;

/**
 * Find Nth to last node in a Linked List.
 * 
 * @author prrathore
 *
 */
public class FindNthToLastNode {

	public static void main(String[] args) {
		
		LinkedListImpl ll = new LinkedListImpl();
		
		ll.generateLinkedList();
		
		LinkedListImpl.Node head = ll.getHead();
		
		ll.prettyPrintLinkedList(head);

	}

}

package com.prabhash.java.interview.ch2;

/**
 * Determine loop in Linked List. If there is a loop then determine the start of loop.
 * 
 * @author prrathore
 *
 */
public class Q2_6_DetermineLoopinLinkedList {
	
	/**
	 * Determine if Linked List has a loop.
	 * 
	 * Have two pointers - one fast and slow. Move fast twice as fast as slow. If there is a loop then they should collide else they will
	 * not collide.
	 * 
	 * @param node
	 * @return
	 */
	public static boolean hasLoop(LinkedListImpl.Node node) {
		
		boolean hasLoop = false;
		
		LinkedListImpl.Node fast = node;
		LinkedListImpl.Node slow = node;
		
		while(fast != null && fast.getNext() != null) {
			
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			// collision occurred
			if(slow == fast) {
				hasLoop = true; 
				break;
			}
			
		}
		
		return hasLoop;
		
	}

	public static void main(String[] args) {
		
		LinkedListImpl ll = new LinkedListImpl();
		
		ll.addNode(1);
		ll.addNode(2);
		ll.addNode(3);
		ll.addNode(4);
		ll.addNode(5);
		ll.addNode(6);
		ll.addNode(7);
		ll.addNode(8);
		ll.addNode(9);
		ll.addNode(10);
		ll.addNode(11);
		ll.addNode(12);
		ll.addNode(12);
	
		LinkedListImpl.Node head = ll.getHead();
		
		//create a loop in Linked List by finding the reference of kth node and then setting last node next to kth node.
		LinkedListImpl.Node fourth = head;
		for(int i = 0; i < 4; i++) {
			fourth = fourth.getNext();
		}
		
		LinkedListImpl.Node last = head;
		while(last.getNext() != null) {
			last = last.getNext();
		}
		
		//set last node next reference to fourth node to create a loop
		last.setNext(fourth);
	
		//LinkedListImpl.prettyPrintLinkedList(head); // Works only for Linked List without loop.
		
		boolean hasLoop = hasLoop(head);
		System.out.println("\n\nLinked List has loop: " + hasLoop);

	}

}

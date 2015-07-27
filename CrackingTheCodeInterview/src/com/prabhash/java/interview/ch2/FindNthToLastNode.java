package com.prabhash.java.interview.ch2;

/**
 * Find Nth to last node in a Linked List.
 * 
 * @author prrathore
 *
 */
public class FindNthToLastNode {
	
	/**
	 * Using two pointers with a difference of k nodes between them, find the required node once the faster node hits the last node.
	 * 
	 * @param node
	 * @param k
	 * @return data
	 */
	public static int findKthToLast(LinkedListImpl.Node node, int k) {
		
		if(node == null) {
			throw new NullPointerException("Linked List is null");
		}
		
		LinkedListImpl.Node prev = node;
		
		int counter = 0; //counter to keep track of ditance between prev and next nodes
		
		while(node != null) {
			
			if(counter < k) {
				counter++;
			} else {
				prev = prev.getNext();
			}
			
			node = node.getNext();
			
		}
		
		if(counter < k) {
			System.out.println("There are not enough nodes in Linked List to find kth to last node.");
			return -1;
		}
		
		// boundary condition when prev becomes null at the end of Linked List traversal. 
		if(prev == null) {
			return -1;
		}
		
		int data = prev.getData();
		
		return data;
		
	}

	public static void main(String[] args) {
		
		LinkedListImpl ll = new LinkedListImpl();
		
		ll.generateLinkedList();
		
		LinkedListImpl.Node head = ll.getHead();
		
		ll.prettyPrintLinkedList(head);
		
		int data = findKthToLast(head, 0);
		System.out.println("\n\nKth element from last: " + data);

	}

}

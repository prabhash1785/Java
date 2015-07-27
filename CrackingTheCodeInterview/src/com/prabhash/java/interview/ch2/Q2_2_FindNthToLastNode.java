package com.prabhash.java.interview.ch2;

/**
 * Find Nth to last node in a Linked List.
 * 
 * @author prrathore
 *
 */
public class Q2_2_FindNthToLastNode {
	
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
		
		int counter = 0; //counter to keep track of distance between prev and next nodes
		
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
	
	/**
	 * Method 2
	 * 
	 * In first pass, find the length of Linked List. Then subtract pos = length - k. In second pass, find the node at pos position. This is the target kth position from last node. 
	 * 
	 * @param args
	 */
	public static int findKthNodeIn2Pass(LinkedListImpl.Node node, int k) {
		
		if(node == null) {
			throw new NullPointerException("Empty Linked List");
		}
		
		int output = -1; //final value to be returned as output for kth node
		
		int length = 0;
		LinkedListImpl.Node second = node; //second node which will run second time to find kth node
		
		// find the length of Linked List in first pass
		while(node != null) {
			length++;
			node = node.getNext();
		}
		
		int kthPos = length - k;
		
		if(kthPos < 0) { // boundary condition check
			return output;
		}
		
		int i = 0;
		while(i < kthPos && second != null) {
			second = second.getNext();
			i++;
		}
		
		if(second == null) {
			return output;
		}
			
		output = second.getData();
		
		return output;	
		
	}
	

	public static void main(String[] args) {
		
		LinkedListImpl ll = new LinkedListImpl();
		
		ll.generateLinkedList();
		
		LinkedListImpl.Node head = ll.getHead();
		
		int data = findKthToLast(head, 4);
		System.out.println("\n\nKth element from last: " + data);
		
		int data2 = findKthNodeIn2Pass(head, 4);
		System.out.println("Kth node using 2 pass method: " + data2);

	}

}

package com.prabhash.java.interview.ch2;

/**
 * Partition a Linked List around a value of such that nodes less that x comes before nodes greater or equal to x.
 * 
 * @author prrathore
 *
 */
public class Q2_4_PartitionLinkedList {
	
	/**
	 * In order to partition a LinkedList around the value of x where values less than x comes before values greater or equal to x, we will
	 * do following:
	 * - Create two new instances of LinkedList, one to hold smaller nodes and other for larger nodes.
	 * - Traverse through LinkedList and for each node, if they are smaller move that smaller LL and others need to go larger value LL
	 * - Finally link smaller and larger LL and return it.
	 * 
	 *  Time Complexity: O(n)
	 *  Space Complexity: O(n)
	 * 
	 * @param node
	 * @param x
	 * @return newHead
	 */
	public static LinkedListImpl.Node partitionLinkedList(LinkedListImpl.Node node, int x) {
		
		if(node == null) {
			throw new NullPointerException("Linked List is null");
		}
		
		LinkedListImpl smallerValLL = new LinkedListImpl();
		LinkedListImpl biggerValLL = new LinkedListImpl();
		
		while(node != null) {
			
			if(node.getData() < x) {
				smallerValLL.addNode(node.getData());
			} else {
				biggerValLL.addNode(node.getData());
			}
			
			//move Linked List to next node
			node = node.getNext();
			
		}
		
		LinkedListImpl.Node smallerLLTail = smallerValLL.getHead(); //tail of smaller Linked List
		
		//if there were no elements added in smalleValLinkedList then just return the head of biggerValLL
		if(smallerLLTail == null) {
			return biggerValLL.getHead();
		}
		
		// go to the end of smallerLL if there were any nodes copied to it
		while(smallerLLTail.getNext() != null) {
			smallerLLTail = smallerLLTail.getNext();
		}
		
		//link smallerLL and biggerLL
		smallerLLTail.setNext(biggerValLL.getHead());
		
		return smallerValLL.getHead();
	}

	public static void main(String[] args) { // generate a Linked List
		
		LinkedListImpl ll = new LinkedListImpl();
		
		ll.generateLinkedList();
		
		LinkedListImpl.Node newHead = partitionLinkedList(ll.getHead(), 0);
		
		System.out.println("\n\nHere is the partitioned Linked List:");
		ll.prettyPrintLinkedList(newHead);

	}

}

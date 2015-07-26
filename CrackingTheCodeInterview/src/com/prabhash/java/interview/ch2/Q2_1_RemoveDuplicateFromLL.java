package com.prabhash.java.interview.ch2;

import java.util.HashMap;
import java.util.Map;

/**
 * Q 2.1
 * 
 * Remove duplicate from Linked List.
 * 
 * @author prrathore
 *
 */
public class Q2_1_RemoveDuplicateFromLL {
	
	/**
	 *  Remove duplicates from Linked List using a HashMap as a buffer. This buffer will keep track of duplicate elements.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 *  
	 * @param node
	 * @return
	 */
	public static boolean removeDuplicateDataUsingBuffer(LinkedListImpl.Node node) {
		
		if(node == null) {
			System.out.println("Linked List is null, cannot remove duplicates!");
			return false;
		}
		
		Map<Integer, Boolean> map = new HashMap<>(); //Buffer to keep track of duplicates
		
		LinkedListImpl.Node prev = node;
		
		boolean hasDuplicates = false;
		
		while(node != null) {
			
			if(map.containsKey(node.getData())) {
				
				prev.setNext(node.getNext()); //set prev next reference to next.next in order to remove next element as it's a duplicate
				
				hasDuplicates = true;
				
			} else {
				
				map.put(node.getData(), true);
				
				prev = node; // move prev to next node
				
			}
			
			node = node.getNext();
						
		}
		
			
		return hasDuplicates;
		
	}

	public static void main(String[] args) {
		
		final LinkedListImpl ll = new LinkedListImpl();
		
		ll.generateLinkedList(); // generate a Linked List
		
		LinkedListImpl.Node head = ll.getHead(); //get a reference to Linked List head
		
		//Remove duplicate using buffer
		boolean duplicatesFound = removeDuplicateDataUsingBuffer(head);
		if(duplicatesFound) {
			System.out.println("\n\nLinkedList after removing duplicates:");
			ll.prettyPrintLinkedList(head);
		} else {
			System.out.println("\n\nNo duplicates found");
		}
		
	}

}

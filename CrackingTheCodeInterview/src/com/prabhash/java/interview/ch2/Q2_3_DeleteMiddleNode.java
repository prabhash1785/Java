package com.prabhash.java.interview.ch2;

/**
 * Delete the middle node of a Linked List, given you have access to only that node.
 * 
 * @author prrathore
 *
 */
public class Q2_3_DeleteMiddleNode {

	/**
	 * Delete middle node when we have reference to only middle node.
	 * In order to this, simply store the reference of next node in a next object and copy values from next to middle node. This will
	 * delete middle node.
	 * 
	 * If middle node is the last node then we CANNOT delete this node.
	 * 
	 * @param node
	 */
	public static void deleteMiddleNode(LinkedListImpl.Node node) {
		
		if(node == null) {
			throw new NullPointerException("Linked List is null");
		}
		
		LinkedListImpl.Node next = node.getNext();
		
		//overwrite node value and ref with the value and ref in next node. This will delete the desired node
		node.setData(next.getData());
		node.setNext(next.getNext());
		
	}
	
	public static void main(String[] args) {
		
		LinkedListImpl ll = new LinkedListImpl();
		
		ll.generateLinkedList();
		
		LinkedListImpl.Node head = ll.getHead(); // head of Linked List
		
		// find a reference to one of the nodes at position 5 which needs to be deleted
		LinkedListImpl.Node middle = head;
		
		int i = 0;
		
		// randomly move middle pointer to fifth node in Linked List
		while(i < 8 && middle != null) {
			middle = middle.getNext();
			i++;
		}
		
		if(middle == null) {
			System.out.println("\n\nOoops end of Linked List has reached!!");
			return;
		} else {
			System.out.println("\n\nValue of middle node: " + middle.getData());
		}
		
		//delete middle node when we just have reference to middle node
		deleteMiddleNode(middle);
		
		ll.prettyPrintLinkedList(head); // print Linked List after deleting middle node
		

	}

}

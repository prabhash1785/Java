package com.prabhash.java.interview.ch2;

/**
 * Even Odd Merge of a Single Linked List
 * 
 * @author Prabhash Rathore
 *
 */
public class EvenOddMerge {
	
	/**
	 * Method 1:
	 * 
	 * Merge given list in a way that even position nodes come before odd positioned nodes. This is done using extra space where
	 * we will maintain two lists, one for even position nodes and other one for odd position nodes. At the end, merge tail of even
	 * list to head of odd list. Return the head of even list.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param head
	 * @return evenMergedListHead
	 */
	public static Node evenOddMergeWithExtraSpace(Node head) {
		if(head == null) {
			return null;
		}
		
		Node evenMergedListHead = null;
		Node evenCurrent = evenMergedListHead;
		
		Node oddMergedHead = null;
		Node oddCurrent = oddMergedHead;
		
		Node current = head;
		int pos = 0;
		while(current != null) {
			Node n = new Node(current.data);
			if(pos % 2 == 0) {
				if(evenMergedListHead == null) {
					evenMergedListHead = n;
					evenCurrent = n;
				} else {
					evenCurrent.next = n;
					evenCurrent = n;
				}
			} else {
				if(oddMergedHead == null) {
					oddMergedHead = n;
					oddCurrent = n;
				} else {
					oddCurrent.next = n;
					oddCurrent = n;
				}
			}
			pos++;
			current = current.next;
		}
		
		// Connect tail of even list to head of odd list
		if(evenCurrent != null) {
			evenCurrent.next = oddMergedHead;
		}
		
		return evenMergedListHead;
	}
	
	/**
	 * Merge even and odd positioned nodes with constant memory.
	 * 
	 * Maintain two pointers for even and odd tails. For each subsequent node, determine if it is at odd position or even position
	 * and then link it to respective even and odd tails. 
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param list
	 * @return list
	 */
	public static Node mergeEvenAndOddList(Node list) {
		if(list == null) {
			return null;
		}
		
		Node evenTail = list;
		Node oddTail = list.next;
		Node current = oddTail == null ? null : oddTail.next;
		int position = 2; // position to determine order and even order of nodes
		
		while(current != null) {
			Node temp = current.next;
			if(position % 2 == 0) {
				Node oddHead = evenTail.next; // save odd Head in order to safely link even tail and odd head
				evenTail.next = current;
				current.next = oddHead;
				evenTail = current;
			} else {
				oddTail.next = current;
				oddTail = oddTail.next;
				oddTail.next = null; // mark this as NULL in order to prevent circular Linked List behavior
			}
			current = temp;
			position++;
		}
		return list;
	}
	
	public static class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void printList(Node head) {
		while(head != null) {
			System.out.print(head.data + " => ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(0);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(5);
		head.next.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next.next = new Node(9);
		head.next.next.next.next.next.next.next.next.next.next = new Node(10);
		
		System.out.println("Original List:");
		printList(head);
		
		Node mergedHead = evenOddMergeWithExtraSpace(head);
		System.out.println("\nEven Odd Merged list using extra space algorithm:");
		printList(mergedHead);
		
		Node mergedList = mergeEvenAndOddList(head);
		System.out.println("\nEven Odd Merged list using constant space algorithm:");
		printList(mergedList);
	}
}

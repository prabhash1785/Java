package com.prabhash.interview.practice.linkedlist;

/**
 * Reverse a Linked List Pair wise.
 * 
 * For ex, 1 > 2 > 3 > 4 > 5
 * Output: 2 > 1 > 4 > 3 > 5
 * 
 * @author Prabhash Rathore
 *
 */
public class PairWiseReversal {
	
	/**
	 * Reverse Linked List nodes in pairs.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param head
	 * @return head
	 */
	public static Node reverseLinkedListPairWise(Node head) {
		if(head == null) {
			return null;
		}
		
		Node prev = null;
		Node first = head;
		Node second = head.next;
		
		if(second == null) {
			return first;
		}
		
		Node next = second.next;
		
		while(second != null) {
			next = second.next; // save the next pointer
			
			second.next = first;
			if(prev == null) {
				head = second;
			} else {
				prev.next = second;
			}
			
			first.next = next;
			
			// pointer assignments
			prev = first;
			first = first.next;
			if(first == null) {
				break;
			} else {
				second = first.next;
			}
		}
		
		return head;
	}
	
	/**
	 * Reverse Linked List in pair recursively. At each recurse call, reverse a group of Linked List nodes.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param head
	 * @return new head of reversed Linked List
	 */
	public static Node reversePairWiseRecursively(Node head) {
		if(head == null) {
			return head;
		}
		
		Node prev = null;
		Node current = head;
		Node next = null;
		
		int count = 0; // use counter to only reverse 2 Linked List nodes in each recursive call
		while(count < 2 && current != null) {
			next = current.next;
			
			current.next = prev; // mutate Linked List node
			
			// update pointer positions
			prev = current;
			current = next;
			++count;
		}
		
		if(current != null) {
			head.next = reversePairWiseRecursively(current);
		}
		
		return prev;
	}
	
	public static class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}

	private static Node createLinkedList(int[] a) {
		if(a == null || a.length == 0) {
			return null;
		}
		
		Node head = new Node(a[0]);
		Node pointer = head;
		for(int i = 1; i < a.length; i++) {
			pointer.next = new Node(a[i]);
			pointer = pointer.next;
		}
		
		return head;
	}
	
	private static void printLinkedList(Node head) {
		if(head == null) {
			return;
		}
		
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	public static void main(String[] args) {
		Node oddLinkedList = createLinkedList(new int[] {1, 2, 3, 4, 5});
		System.out.println("Original odd Linked List:");
		printLinkedList(oddLinkedList);
		
		Node reversedLinkedList = reverseLinkedListPairWise(oddLinkedList);
		System.out.println("\nHere is reversed odd Linked List:");
		printLinkedList(reversedLinkedList);
		
		// test case for even sized Linked List
		Node evenLinkedList = createLinkedList(new int[] {1, 2, 3, 4, 5, 6});
		System.out.println("\nOriginal even Linked List:");
		printLinkedList(evenLinkedList);
		
		Node reversedEvenLinkedList = reverseLinkedListPairWise(evenLinkedList);
		System.out.println("\nHere is reversed even Linked List:");
		printLinkedList(reversedEvenLinkedList);
		
		// Recursive test case
		Node oddLinkedList2 = createLinkedList(new int[] {1, 2, 3, 4, 5});
		Node reverseLLRecursively = reversePairWiseRecursively(oddLinkedList2);
		System.out.println("\n\nHere is reversed odd Linked List recursively:");
		printLinkedList(reverseLLRecursively);
	}
}

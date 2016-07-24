package com.prabhash.java.interview.ch2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Flatten a multi level linked list
 * 
 * @author prrathore
 *
 */
public class FlattenMultiLevelLinkedList {
	
	/**
	 * Flatten linked list using DFS. Store nodes in a separate Linked List.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param node
	 * @return
	 */
	public static List<Node> flattenLinkedListUsingStack(Node node) {
		if(node == null) {
			throw new NullPointerException();
		}
		
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		
		List<Node> list = new LinkedList<>();
		
		while(!stack.isEmpty()) {
			Node currrent = stack.pop();
			list.add(currrent);
			
			if(currrent.next != null) {
				stack.push(currrent.next);
			}
			
			if(currrent.down != null) {
				stack.push(currrent.down);
			}
		}
		
		return list;
	}
	
	public static void printFlattenedLinkedList(List<Node> list) {
		for(Node node : list) {
			System.out.print(node + " -> ");
		}
	}

	public static class Node {
		private int data;
		private Node next;
		private Node down;
		
		public Node(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
	    head.next = new Node(2);
	    head.next.next = new Node(3);
	    head.next.next.next = new Node(4);
	    head.next.down = new Node(7);
	    head.next.down.down = new Node(9);
	    head.next.down.down.down = new Node(14);
	    head.next.down.down.down.down = new Node(15);
	    head.next.down.down.down.down.next = new Node(23);
	    head.next.down.down.down.down.next.down = new Node(24);
	    head.next.down.next = new Node(8);
	    head.next.down.next.down = new Node(16);
	    head.next.down.next.down.down = new Node(17);
	    head.next.down.next.down.down.next = new Node(18);
	    head.next.down.next.down.down.next.next = new Node(19);
	    head.next.down.next.down.down.next.next.next = new Node(20);
	    head.next.down.next.down.down.next.next.next.down = new Node(21);
	    head.next.down.next.next = new Node(10);
	    head.next.down.next.next.down = new Node(11);
	    head.next.down.next.next.next = new Node(12);
	    
	    List<Node> flattenedList = flattenLinkedListUsingStack(head);
	    System.out.println("Here is the lattened list:");
	    printFlattenedLinkedList(flattenedList);
	}
}

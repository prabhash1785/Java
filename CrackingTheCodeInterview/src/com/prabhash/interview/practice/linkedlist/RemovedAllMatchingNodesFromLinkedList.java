package com.prabhash.interview.practice.linkedlist;

import java.util.Scanner;

/**
 * Remove all matching nodes from Linked List.
 * 
 * @author prrathore
 *
 */
public class RemovedAllMatchingNodesFromLinkedList {

	public static class LinkedListNode {
		int val;
		LinkedListNode next;

		LinkedListNode(int node_value) {
			val = node_value;
			next = null;
		}
	};

	public static LinkedListNode _insert_node_into_singlylinkedlist(
			LinkedListNode head, int val) {
		if (head == null) {
			head = new LinkedListNode(val);
		} else {
			LinkedListNode end = head;
			while (end.next != null) {
				end = end.next;
			}
			LinkedListNode node = new LinkedListNode(val);
			end.next = node;
		}
		return head;
	}

	/**
	 * Remove all the nodes from Linked List with the given value.
	 * 
	 * @param value
	 * @param head
	 * @return head
	 */
	public static LinkedListNode removeAll(int value, LinkedListNode head) {
		
		if(head == null) {
			return null;
		}
		
		LinkedListNode prev = null;
		LinkedListNode current = head;
		
		while(current != null) {
			
			if(current.val == value) {
				if(prev != null) {
					prev.next = current.next;
					current.next = null;
					current = prev.next;
				} else {
					prev = current;
					current = current.next;
					prev.next = null;
					prev = null;
					head = current; // since deleted first node, point head to new current
				}
			} else {
				prev = current;
				current = current.next;
			}
		}

		return head;
	}
	
	public static void printLinkedList(LinkedListNode head) {
		while(head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int _val;
		_val = in.nextInt();

		int _list_size = in.nextInt(), _list_i;
		int _list_item;
		LinkedListNode _list = null;
		for (_list_i = 0; _list_i < _list_size; _list_i++) {
			_list_item = in.nextInt();
			_list = _insert_node_into_singlylinkedlist(_list, _list_item);
		}
		
		System.out.println("Orginal Linked List:");
		printLinkedList(_list);

		_list = removeAll(_val, _list);

		System.out.println("\nModified Linked List after removing nodes:");
		printLinkedList(_list);
		in.close();
	}
}

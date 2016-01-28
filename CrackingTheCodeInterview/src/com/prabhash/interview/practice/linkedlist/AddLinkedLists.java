package com.prabhash.interview.practice.linkedlist;

/**
 * Add two Linked Lists representing numbers with their most significant digits on left and least ones on right.
 * 
 * @author prrathore
 *
 */
public class AddLinkedLists {
	
	public static class Node {
		
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	/**
	 * Find size of Linked List recursively
	 * 
	 * @param x
	 * @return
	 */
	private static int sizeOfLinkedList(Node x) {
		
		if(x == null) {
			return 0;
		}
		
		return sizeOfLinkedList(x.next) + 1;
	}
	
	/**
	 * Pad n zeroes in front of given Linked List
	 * 
	 * @param node
	 * @param n
	 */
	private static Node padZeroes(Node node, int n) {
		
		if(n == 0) {
			return node;
		}
		
		Node zero = new Node(0);
		zero.next = node;
		node = zero;
		
		n = n - 1;
		
		return padZeroes(node, n);
	}

	private static void printLinkedList(Node node) {
		
		if(node == null) {
			return;
		}
		
		System.out.print(node.data + " -> ");
		
		printLinkedList(node.next);
		
	}
	
	private static class SumAndCarry {
		Node sum;
		int carry;
		
		public SumAndCarry() {
			this.sum = null;
			this.carry = 0;
		}
	}
	
	private static SumAndCarry sumHelper(Node p, Node q) {
		
		if(p == null) {
			return null;
		}
		
		SumAndCarry sumAndCarryNode = sumHelper(p.next, q.next);
		
		sumAndCarryNode = sumAndCarryNode == null ? new SumAndCarry() : sumAndCarryNode; // to prevent Null Pointer Exception
		
		int sumData = p.data + q.data + sumAndCarryNode.carry;
		int carryData = 0;
		
		if(sumData > 9) {
			carryData = sumData / 10;
			sumData = sumData % 10;
		}
		
		Node tempSumData = new Node(sumData);
		
		tempSumData.next = sumAndCarryNode.sum;
		
		sumAndCarryNode.sum = tempSumData;
		sumAndCarryNode.carry = carryData;
		
		return sumAndCarryNode;
	}
	
	public static Node add(Node a, Node b) {
		
		if(a == null && b == null) {
			return null;
		}
		
		if(a != null && b == null) {
			return a;
		}
		
		if(a == null && b != null) {
			return b;
		}
		
		int sizeOfNode1 = sizeOfLinkedList(a);
		System.out.println("\nSize of Linked List1: " + sizeOfNode1);
		
		int sizeOfNode2 = sizeOfLinkedList(b);
		System.out.println("\nSize of Linked List2: " + sizeOfNode2);
		
		int diff = Math.abs(sizeOfNode1 - sizeOfNode2);
		
		if(sizeOfNode1 > sizeOfNode2) {
			b = padZeroes(b, diff);
			System.out.println("\nHere is updated second Linked List");
			printLinkedList(b);
		} else {
			a = padZeroes(a, diff);
			System.out.println("\nHere is updated first Linked List");
			printLinkedList(a);
		}
		
		SumAndCarry sumAndCarry = sumHelper(a, b);
		
		return sumAndCarry.sum;
	}
	
	public static void main(String[] args) {
		
		Node node1 = new Node(4);
		node1.next = new Node(3);
		node1.next.next = new Node(7);
		node1.next.next.next = new Node(9);
		
		System.out.println("Linked List1:");
		printLinkedList(node1);
		
		Node node2 = new Node(7);
		node2.next = new Node(8);
		
		System.out.println("\nLinked List2:");
		printLinkedList(node2);
		
		Node sum = add(node1, node2);
		
		System.out.println("\nHere is the sum of above two Linked Lists");
		printLinkedList(sum);
		
	}

}

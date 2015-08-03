package com.prabhash.java.interview.ch2;

import com.prabhash.java.interview.ch2.LinkedListImpl.Node;

/**
 * This program will calculate sum of numbers represented as LinkedList of numbers where each node represents one digit.
 * 
 * @author prrathore
 *
 */
public class Q2_5_SumLinkedListNodes {
	
	/**
	 * Find sum of numbers represented as Linked List where numbers are arranged from ones place to next higher place going left to right.
	 * 
	 * Since numbers are arranged from ones to higher place so it's easier to sum two Linked List starting left node and keep moving right
	 * until you reach last node. For sum of each nodes, we have to keep track of carry and add that to nodes on the next place.
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws Exception
	 */
	public static LinkedListImpl.Node sumOfNodesStartingLeftPosition(LinkedListImpl.Node a, LinkedListImpl.Node b) throws Exception {
		
		if(a == null && b == null) {
			throw new Exception("Cannot calculate sum when both operands are null!");
		}
		
		// if one of the operand is null then just return other operand as sum
		if(a == null) {
			return b;
		}
		
		if(b == null) {
			return a;
		}
		
		LinkedListImpl.Node head = null;
		LinkedListImpl.Node tail = null;
		
		int carry = 0; //keep track of carry generated while adding numbers in each place
		
		while(a != null && b != null) {
			
			int sum = a.getData() + b.getData() + carry;
			
			if(sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			
			LinkedListImpl.Node sumNode = new LinkedListImpl.Node(sum);
			
			if(head == null) {
				head = sumNode;
				tail = head;
			}
			
			tail.setNext(sumNode);
			tail = tail.getNext();
			
			//increment a and b Linked List
			a = a.getNext();
			b = b.getNext();
			
		}
		
		while(a != null) {
			int sum = a.getData() + carry;
			
			if(sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			
			LinkedListImpl.Node sumNode = new LinkedListImpl.Node(sum);
			
			tail.setNext(sumNode);
			
			a = a.getNext();
			tail = tail.getNext();
		}
		
		while(b != null) {
			int sum = b.getData() + carry;

			if(sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}

			LinkedListImpl.Node sumNode = new LinkedListImpl.Node(sum);

			tail.setNext(sumNode);

			b = b.getNext();
			tail = tail.getNext();
		}
		
		// Make sure carry generated from sum of last nodes gets added to the LinkedList sum
		if(carry > 0) {
			tail.setNext(new LinkedListImpl.Node(carry));
		}
		
		return head;
	}
	
	/**
	 * Find sum of numbers represented as Linked List where higher place number is on left and lower on right.
	 * 
	 * Since first node in LinkedList is higher place and we sum from ones place so there are following ways we can get sum of these
	 * Linked List:
	 * - Reverse both Linked List and then calculating sum is straightforward.
	 * - Other way is to pad zeroes in shorter Linked List so that both Linked List are same size and then calculate the sum of these
	 * Linked List.
	 * 
	 * @param args
	 */
	public static LinkedListImpl.Node sumOfNodesFromRightPosition(LinkedListImpl.Node a, LinkedListImpl.Node b) throws Exception {
		
		if(a == null && b == null) {
			throw new Exception("Cannot calculate sum when both operands are null!");
		}
		
		// if one of the operand is null then just return other operand as sum
		if(a == null) {
			return b;
		}
		
		if(b == null) {
			return a;
		}
		
		LinkedListImpl.Node head = null;
		
		int l1 = 0;
		LinkedListImpl.Node temp1 = a;
		
		while(temp1 != null) {
			l1++;
			temp1 = temp1.getNext();
		}
		
		int l2 = 0;
		LinkedListImpl.Node temp2 = b;
		
		while(temp2 != null) {
			l2++;
			temp2 = temp2.getNext();
		}
		
		LinkedListImpl.Node tempHead = null;
		LinkedListImpl.Node tempNext = tempHead;
		
		if(l1 > l2) { //if second number is shorter then pad zeroes to b to make a and b of same length
			
			int diff = l1 - l2;
			
			while(diff > 0) {
				
				LinkedListImpl.Node n = new LinkedListImpl.Node(0);
				
				if(tempHead == null) {
					tempHead = n;
					tempNext = tempHead;
				} else {
					tempNext.setNext(n);
					tempNext = tempNext.getNext();
				}
				
				diff--;
				
			}
			
			tempNext.setNext(b);
			b = tempHead;
			
		} else {
			
			int diff = l2 - l1;
			
			while(diff > 0) {
				
				LinkedListImpl.Node n = new LinkedListImpl.Node(0);
				
				if(tempHead == null) {
					tempHead = n;
					tempNext = tempHead;
				} else {
					tempNext.setNext(n);
					tempNext = tempNext.getNext();
				}
				
				diff--;
				
			}
			
			tempNext.setNext(a);
			a = tempHead;
			
		}
		
		System.out.println("\n\nLinked List a:");
		LinkedListImpl.prettyPrintLinkedList(a);
		
		System.out.println("\n\nLinked List b:");
		LinkedListImpl.prettyPrintLinkedList(b);
		
		//recursively calculate sum of Linked List starting from tail position
		SumAndCarry sumAndCarry = calculateSum(a, b);
		
		//check if sumAndCarry has a higher than 0 carry. If yes then create a node out of carry and append on left of head.
		if(sumAndCarry.carry > 0) {
			
			LinkedListImpl.Node node = new LinkedListImpl.Node(sumAndCarry.carry);
			
			node.setNext(sumAndCarry.sum);
			
			sumAndCarry.sum = node;
			
		}
			
		head = sumAndCarry.sum;
		
		return head;
	}
	
	/**
	 * Recursively calculate sum of Linked List arranged from higher to lower place digits. First reach the end of Linked List and then start adding Linked List nodes from rear
	 * position and pass carry to left nodes. Also keep referencing these sum nodes to one another.
	 * 
	 * @param args
	 */
	private static SumAndCarry calculateSum(LinkedListImpl.Node a, LinkedListImpl.Node b) {
		
		SumAndCarry sumAndCarry = new SumAndCarry();
		
		if(a == null || b == null) {
			return sumAndCarry;
		}
		
		SumAndCarry sumAndCarry2 = calculateSum(a.getNext(), b.getNext());
		
		int sum = a.getData() + b.getData() + sumAndCarry2.carry;
		
		int newCarry = 0;
		
		if(sum > 9) {
			newCarry = sum / 10;
			sum = sum % 10;
		}
		
		SumAndCarry sumAndCarry3 = new SumAndCarry();
		
		sumAndCarry3.carry = newCarry;
		sumAndCarry3.sum = new LinkedListImpl.Node(sum);
		
		sumAndCarry3.sum.setNext(sumAndCarry2.sum);
		
		return sumAndCarry3;
		
	}
	
	/**
	 * Nested class to store carry and sum of nodes.
	 * 
	 * @author prrathore
	 *
	 */
	private static class SumAndCarry {
		private int carry;
		private LinkedListImpl.Node sum;
		
		public SumAndCarry() {
			this(0, null);
		}
		
		public SumAndCarry(int carry, LinkedListImpl.Node sum) {
			this.carry = carry;
			this.sum = sum;
		}
		
	}
	

	public static void main(String[] args) {
		
		LinkedListImpl a = new LinkedListImpl();
		a.addNode(9);
		a.addNode(6);
		a.addNode(9);
		a.addNode(9);
		
		System.out.println("Number a staring from ones place:");
		LinkedListImpl.prettyPrintLinkedList(a.getHead());
		
		LinkedListImpl b = new LinkedListImpl();
		b.addNode(3);
		b.addNode(9);
		
		System.out.println("\n\nNumber b starting from ones place:");
		LinkedListImpl.prettyPrintLinkedList(b.getHead());
		
		LinkedListImpl.Node sum = null;
		
		try {
			sum = sumOfNodesStartingLeftPosition(a.getHead(), b.getHead());
		} catch(Exception e) {
			System.out.println("\n\nSeems like both operands were provided as null!!");
			return;
		}
		
		System.out.println("\n\nSum of Numbers starting with ones place");
		LinkedListImpl.prettyPrintLinkedList(sum);
		
		// Sum of numbers when numbers are arranged from higher to Lower place in Linked List
		LinkedListImpl c = new LinkedListImpl();
		c.addNode(9);
		c.addNode(6);
		c.addNode(9);
		c.addNode(9);
		
		System.out.println("\n\nNumber c staring from ones place:");
		LinkedListImpl.prettyPrintLinkedList(c.getHead());
		
		LinkedListImpl d = new LinkedListImpl();
		d.addNode(3);
		d.addNode(9);
		d.addNode(8);
		
		System.out.println("\n\nNumber d staring from ones place:");
		LinkedListImpl.prettyPrintLinkedList(d.getHead());
		
		LinkedListImpl.Node sum2 = null;
		
		try {
			sum2 = sumOfNodesFromRightPosition(c.getHead(), d.getHead());
		} catch(Exception e) {
			System.out.println("\n\nException occurred while calculating sum!!");
		}
		
		System.out.println("\n\nHere is the sum of Linked List starting from left to right arranged from higher to lower place:");
		LinkedListImpl.prettyPrintLinkedList(sum2);
		
	}

}

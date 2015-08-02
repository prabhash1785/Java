package com.prabhash.java.interview.ch2;

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
		
		if(carry > 0) {
			tail.setNext(new LinkedListImpl.Node(carry));
		}
		
		return head;
	}
	
	/**
	 * Find sum of numbers represented as Linked List where higher place number is on left and lower on right.
	 * 
	 * @param args
	 */
	public static LinkedListImpl.Node sumOfNodesFromRightPosition(LinkedListImpl.Node a, LinkedListImpl.Node b) {
		
		LinkedListImpl.Node head = null;
		LinkedListImpl.Node tail = null;
		
		
		
		return head;
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
		
	}

}

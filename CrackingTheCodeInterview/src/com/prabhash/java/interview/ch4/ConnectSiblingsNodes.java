package com.prabhash.java.interview.ch4;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Connect sibling nodes in a Binary Tree.
 * 
 * @author Prabhash Rathore
 *
 */
public class ConnectSiblingsNodes {
	
	/**
	 * Connect siblings at each level in a Binary Tree using BFS algorithm.
	 * 
	 * @param root
	 */
	public static void connectSiblingsUsingBFS(Node root) {
		if(root == null) {
			System.out.println("Tree root is null");
			return;
		}
		
		Deque<Node> queue = new LinkedList<>();
		Deque<Node> nextLevel = new LinkedList<>();
		queue.addLast(root);
		while(!queue.isEmpty()) {
			Node current = queue.removeFirst();
			if(current.left != null) {
				nextLevel.addLast(current.left);
			}
			
			if(current.right != null) {
				nextLevel.addLast(current.right);
			}
			
			if(queue.isEmpty()) {
				// Using an iterator connect nodes at same level
				Iterator<Node> iterator = nextLevel.iterator();
				Node first = null;
				if(iterator.hasNext()) {
					first = iterator.next();
				}
				while(iterator.hasNext()) {
					Node second = iterator.next();
					first.nextRight = second;
					first = second;
				}
				
				queue = nextLevel;
				nextLevel = new LinkedList<>();
			}
		}
		
	}
	
	public static void printSiblingsAtEachLevel(Node root) {
		if(root == null) {
			return;
		}
		
		Node current = root;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.nextRight;
		}
		System.out.print("\n");
		
		// Assumption: tree is a complete tree and hence it has the leftmost node at each level
		printSiblingsAtEachLevel(root.left);
	}
	
	public static class Node {
		private int data;
		private Node left, right, nextRight;
		
		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(8);
		root.right = new Node(10);
		root.left.left = new Node(12);
		root.left.right = new Node(14);
		root.right.right = new Node(100);
		
		connectSiblingsUsingBFS(root);
		printSiblingsAtEachLevel(root);
	}
}

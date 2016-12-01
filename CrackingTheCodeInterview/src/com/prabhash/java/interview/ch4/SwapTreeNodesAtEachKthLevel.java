package com.prabhash.java.interview.ch4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Swap binary tree nodes at each kth level.
 * 
 * @author Prabhash Rathore
 *
 */
public class SwapTreeNodesAtEachKthLevel {
	
	/**
	 *  Swap left and right child of any node when this node is at level where (k - level <= 1). After swapping nodes, reset level to 0.
	 *  Recurse for both left and right subtrees.
	 *  
	 *  Time Complexity: O(n)
	 * 
	 * @param root
	 * @param k
	 */
	public static void swapNodesAtEachKthLevel(Node root, int k) {
		if(k <= 0) {
			throw new IllegalArgumentException("K cannot be < 1");
		}
		
		if(root == null) {
			throw new NullPointerException();
		}
		
		swapNodesAtEachKthLevelHelper(root, k, 1);
	}
	
	private static void swapNodesAtEachKthLevelHelper(Node root, int k, int level) {
		if(root == null) {
			return;
		}
		
		if(root.left == null && root.right == null) {
			return;
		}
		
		if(k - level <= 1) {
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
			level = 0;
		} else {
			++level;
		}
		
		swapNodesAtEachKthLevelHelper(root.left, k, level);
		swapNodesAtEachKthLevelHelper(root.right, k, level);
	}
	
	public static class Node {
		int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public static void printBFSOfTree(Node root) {
		if(root == null) {
			System.out.println("\nTree is null");
			return;
		}
		
		Deque<Node> queue = new LinkedList<>();
		Deque<Node> nextLevel = new LinkedList<>();
		
		queue.addLast(root); // add root node to queue
		
		while(!queue.isEmpty()) {
			Node node = queue.removeFirst();
			System.out.print(node + " ");
			
			if(node.left != null) {
				nextLevel.addLast(node.left);
			}
			
			if(node.right != null) {
				nextLevel.addLast(node.right);
			}
			
			if(queue.isEmpty()) {
				queue = nextLevel;
				nextLevel = new LinkedList<>();
				
				System.out.print("\n"); // print a new line
			}
		}
	}
	
	public static void main(String[] args) {
		// test case 1
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.left.left = new Node(4);
		
		root1.right = new Node(3);
		root1.right.left = new Node(7);
		root1.right.right = new Node(8);
		
		System.out.println("BFS of original tree:");
		printBFSOfTree(root1);
		
		// swap nodes at each kth level
		swapNodesAtEachKthLevel(root1, 2);
		System.out.println("BFS of tree after swapped nodes:");
		printBFSOfTree(root1);
		
		// test case 2
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		
		root2.right = new Node(3);
		
		System.out.println("BFS of original tree:");
		printBFSOfTree(root2);
		
		// swap nodes at each kth level
		swapNodesAtEachKthLevel(root2, 1);
		System.out.println("BFS of tree after swapped nodes:");
		printBFSOfTree(root2);
	}
}

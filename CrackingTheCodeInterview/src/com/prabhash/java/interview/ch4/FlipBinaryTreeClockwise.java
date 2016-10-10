package com.prabhash.java.interview.ch4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a binary tree, flip the binary tree towards right direction clockwise.
 * In the flip operation, left most node becomes the root of flipped tree and its parent become its right child 
 * and the right sibling become its left child and same should be done for all left most nodes recursively.
 * 
 * @author Prabhash Rathore
 *
 */
public class FlipBinaryTreeClockwise {
	
	/**
	 * Visit all the left most nodes and rotate the tree clockwise.
	 * 
	 * Time Complexity: O(log n)
	 * 
	 * @param root
	 * @return newRoot
	 */
	public static Node flipTreeClockwise(Node root) {
		if(root == null) {
			return null;
		}
		
		Node newRoot = flipTreeClockwise(root.left);
		
		if(root.left == null && root.right == null) {
			return root;
		}
		
		root.left.left = root.right;
		root.left.right = root;
		
		root.left = null;
		root.right = null;
		
		return newRoot;
	}
	
	public static void printBST(Node root) {
		if(root == null) {
			return;
		}
		
		Deque<Node> queue = new LinkedList<>();
		Deque<Node> nextLevel = new LinkedList<>();
		queue.addLast(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.removeFirst();
			System.out.print(node.data + " ");
			if(node.left != null) {
				nextLevel.addLast(node.left);
			}
			
			if(node.right != null) {
				nextLevel.addLast(node.right);
			}
			
			if(queue.isEmpty()) {
				queue = nextLevel;
				nextLevel = new LinkedList<>();
				System.out.print("\n");
			}
		}
	}
	
	public static class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println("BST of original tree:");
		printBST(root);
		
		Node flippedTreeNode = flipTreeClockwise(root);
		System.out.println("BST of flipped tree:");
		printBST(flippedTreeNode);
	}
}

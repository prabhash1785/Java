package com.prabhash.java.interview.ch4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Create a Max Tree from given array.
 * 
 * Max Tree is a kind of Binary Tree where root has the maximum value compared to both it's left and right subtrees.
 * 
 * @author Prabhash Rathore
 *
 */
public class MaxTreeFromArray {

	/**
	 * Create Max Tree from given array.
	 * 
	 * Time Complexity: O(n ^ 2) because of extra linear time spent finding max in each sub-array.
	 * 
	 * @param a
	 * @return tree root
	 */
	public static Node createMaxTree(int[] a) {
		if(a == null) {
			return null;
		}
		
		return createMaxTreeHelper(a, 0, a.length - 1);
	}
	
	private static Node createMaxTreeHelper(int[] a, int start, int end) {
		if(start > end) {
			return null;
		}
		
		int maxIndex = findMaxElement(a, start, end);
		
		Node root = new Node(a[maxIndex]);
		root.left = createMaxTreeHelper(a, start, maxIndex - 1);
		root.right = createMaxTreeHelper(a, maxIndex + 1, end);
		
		return root;
	}
	
	private static int findMaxElement(int[] a, int start, int end) {
		int maxIndex = start;
		for(int i = start + 1; i <= end; i++) {
			if(a[i] > a[maxIndex]) {
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	
	/**
	 * Print Max Tree nodes using BFS algorithm.
	 * 
	 * @param root
	 */
	public static void printMaxTreeUsingBFS(Node root) {
		if(root == null) {
			return;
		}
		
		Deque<Node> currentLevel = new LinkedList<>();
		Deque<Node> nextLevel = new LinkedList<>();
		currentLevel.addLast(root);
		
		while(!currentLevel.isEmpty()) {
			Node current = currentLevel.removeFirst();
			System.out.print(current.data + " ");
			if(current.left != null) {
				nextLevel.addLast(current.left);
			}
			if(current.right != null) {
				nextLevel.addLast(current.right);
			}
			
			if(currentLevel.isEmpty()) {
				currentLevel = nextLevel;
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
		int[] array = new int[] {12, 4, 1, 17, 13, 15, 8, 2};
		
		Node maxTreeRoot = createMaxTree(array);
		System.out.println("Level Order traversal of generated Max Tree");
		printMaxTreeUsingBFS(maxTreeRoot);
	}

}

package com.prabhash.java.interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a number n, find all the possible combination of Binary Trees.
 * 
 * @author Prabhash Rathore
 *
 */
public class CreateAllCombinationOfBinaryTrees {
	
	public static List<Node> getAllBinaryTreeCombinations(int n) {
		if(n <= 0) {
			return null;
		}
		
		List<Node> result = new ArrayList<>();
		int count = 0;
		Node head = null;
		Node tail = head;
		getAllBinaryTreeCombinationsHelper(n, count, head, tail, result);
		
		return result;
	}
	
	private static void getAllBinaryTreeCombinationsHelper(int n, int counter, Node head, Node tail, List<Node> result) {
		if(n == 0) {
			result.add(head);
			return;
		}
		
		for(int left = 0; left < n; left++) {
			int right = n - left - 1;
			
			Node node = new Node(counter);
			if(tail == null) {
				tail = new Node(counter);
				head = tail;
			} else {
				tail.left = node;
			}
			
			getAllBinaryTreeCombinationsHelper(left, counter + 1, head, tail.left, result);
			tail.left = null;
			
			tail.right = node;
			getAllBinaryTreeCombinationsHelper(right, counter + 1, head, tail.right, result);
		}
	}
	
	public static void printTree(Node root) {
		if(root == null) {
			return;
		}
		
		printTree(root.left);
		System.out.print(root.data + " ");
		printTree(root.right);
	}
	
	public static void printAllTrees(List<Node> list) {
		if(list == null || list.size() == 0) {
			System.out.println("\nNo tree available");
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("\nTree Number # " + (i + 1));
			printTree(list.get(i));
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
		int nodeCount = 3;
		List<Node> list = getAllBinaryTreeCombinations(nodeCount);
		System.out.println("Here are all trees:");
		printAllTrees(list);
	}

}

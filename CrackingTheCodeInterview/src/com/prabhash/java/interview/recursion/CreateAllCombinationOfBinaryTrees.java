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
		
		return getAllBinaryTreeCombinationsHelper(n);
	}
		
	private static List<Node> getAllBinaryTreeCombinationsHelper(int n) {
		List<Node> result = new ArrayList<>();
		
		if(n == 0) {
			result.add(null);
		}
		
		for(int left = 0; left < n; left++) {
			int right = n - 1 - left;
			
			List<Node> leftSubTrees = getAllBinaryTreeCombinationsHelper(left);
			
			List<Node> rightSubTrees = getAllBinaryTreeCombinationsHelper(right);
			
			for(int i = 0; i < leftSubTrees.size(); i++) {
			
				for(int j = 0; j < rightSubTrees.size(); j++) {
					Node root = new Node(left);
					root.left = leftSubTrees.get(i);
					root.right = rightSubTrees.get(j);
					
					result.add(root);
				}
				
			}
		}
		
		return result;
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
		int nodeCount = 2;
		List<Node> list = getAllBinaryTreeCombinations(nodeCount);
		System.out.println("Here are all trees:");
		printAllTrees(list);
	}

}

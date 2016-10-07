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
	
	private static final int NODE_VALUE = 0;
	
	/**
	 * In order to generate all possible binary trees, first find all left sub-trees and right sub-trees. Then generate tree combinations
	 * from these left and right subtrees.
	 * 
	 * Time Complexity: [(2n)! / n!(n + 1)!] - This is same as nth Catalan Number
	 * 
	 * @param n
	 * @return List<Node>
	 */
	public static List<Node> getAllBinaryTreeCombinations(int n) {
		if(n <= 0) {
			return null;
		}
		
		return getAllBinaryTreeCombinationsHelper(n);
	}
		
	private static List<Node> getAllBinaryTreeCombinationsHelper(int n) {
		List<Node> result = new ArrayList<>();
		
		if(n == 0) {
			result.add(null); // this is needed in order for the loop to work below
			return result;
		}
		
		for(int left = 0; left < n; left++) {
			int right = n - 1 - left;
			
			List<Node> leftSubTrees = getAllBinaryTreeCombinationsHelper(left);
			
			List<Node> rightSubTrees = getAllBinaryTreeCombinationsHelper(right);
			
			// generate all possible combination of trees from left subtrees and right subtrees
			for(int i = 0; i < leftSubTrees.size(); i++) {
				
				for(int j = 0; j < rightSubTrees.size(); j++) {
					Node root = new Node(NODE_VALUE);
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
		int nodeCount = 3;
		List<Node> list = getAllBinaryTreeCombinations(nodeCount);
		System.out.println("Here are all trees:");
		printAllTrees(list);
	}

}

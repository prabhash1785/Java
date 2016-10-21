package com.prabhash.java.interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate all possible BSTs given number of nodes.
 * 
 * @author Prabhash Rathore
 *
 */
public class GenerateAllBSTsFrom {
	
	/**
	 * Generate all combination of left subtrees and right subtrees. Then generate trees by combining left and right subtrees.
	 * 
	 * @param n
	 * @return List<Node>
	 */
	public static List<Node> getAllBSTs(int n) {
		if(n <= 0) {
			return null;
		}
		
		return getAllBSTsHelper(1, n);
	}
	
	private static List<Node> getAllBSTsHelper(int start, int end) {
		List<Node> list = new ArrayList<>();
		
		if(start > end) {
			list.add(null);
			return list;
		}
		
		for(int i = start; i <= end; i++) {
			List<Node> leftSubTrees = getAllBSTsHelper(start, i - 1);
			List<Node> rightSubTrees = getAllBSTsHelper(i + 1, end);
			
			for(int j = 0; j < leftSubTrees.size(); j++) {
				Node node = new Node(i); // number at ith position is the root
				node.left = leftSubTrees.get(j);
				
				for(int k = 0; k < rightSubTrees.size(); k++) {
					node.right = rightSubTrees.get(k);
					list.add(node);
				}
			}
		}
		
		return list;
	}
	
	public static class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void inOrder(Node node) {
		if(node == null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public static void main(String[] args) {
		int n = 3;
		List<Node> list = getAllBSTs(n);
		
		System.out.println("List of BSTs:");
		for(Node node : list) {
			inOrder(node);
			System.out.print("\n");
		}
	}
}

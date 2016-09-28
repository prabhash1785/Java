package com.prabhash.java.interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate all possible binary trees from the given inorder traversal array.
 * 
 * @author Prabhash Rathore
 *
 */
public class GenerateAllPossibleBinaryTreesFromGivenInOrder {
	
	/**
	 * From inOrder traversal array, for each ith element, left subtree would be from start to (i - 1) and right subtree would
	 * be from (i + 1) to end. Once we have x and y left and right subtrees respective, all combination of binary trees could
	 * be found by combining left and right subtrees would be a multiple of x * y.
	 * 
	 * Time Complexity: [(2n)! / n!(n + 1)!] - This is same as nth Catalan Number
	 * 
	 * @param inOrder
	 * @return
	 */
	public static List<Node> generateAllBinaryTrees(int[] inOrder) {
		if(inOrder == null) {
			return null;
		}
		
		return generateAllBinaryTreesHelper(inOrder, 0, inOrder.length - 1);
	}
	
	private static List<Node> generateAllBinaryTreesHelper(int[] a, int start, int end) {
		List<Node> list = new ArrayList<>();
		
		if(start > end) {
			list.add(null);
			return list;
		}
		
		for(int i = start; i <= end; i++) {
			List<Node> leftSubTrees = generateAllBinaryTreesHelper(a, start, i - 1);
			List<Node> rightSubTrees = generateAllBinaryTreesHelper(a, i + 1, end);
			
			for(int j = 0; j < leftSubTrees.size(); j++) {
				for(int k = 0; k < rightSubTrees.size(); k++) {
					Node root = new Node(a[i]);
					root.left = leftSubTrees.get(j);
					root.right = rightSubTrees.get(k);
					
					list.add(root);
				}
			}
		}
		
		return list;
	}
	
	public static void printPreOrder(Node root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
	
	public static class Node {
		private int data;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		int[] inOrder = new int[] {
			4, 5, 7
		};
		
		List<Node> trees = generateAllBinaryTrees(inOrder);
		System.out.println("Here are preOrder traversal of all trees:");
		for(Node node : trees) {
			printPreOrder(node);
			System.out.print("\n");
		}
	}
}

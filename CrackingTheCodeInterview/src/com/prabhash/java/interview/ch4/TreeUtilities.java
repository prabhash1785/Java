package com.prabhash.java.interview.ch4;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtilities {
	
	/**
	 * Find number of nodes using BFS traversal.
	 * 
	 * @param root
	 * @return
	 */
	public static int findNumberOfNodesIteratively(TreeImpl.Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int numberOfNodes = 0;
		
		Queue<TreeImpl.Node> queue = new LinkedList<TreeImpl.Node>();
		queue.add(root);
		
		while(queue.peek() != null) {
			
			TreeImpl.Node node = queue.poll();
			numberOfNodes++;
			
			if(node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			
			if(node.getRight() != null) {
				queue.add(node.getRight());
			}
				
		}
		
		return numberOfNodes;
		
	}
	
	/**
	 * Method 1: Recursive method to find number of nodes in tree.
	 * 
	 * @param root
	 * @return size
	 */
	public static int findNumberOfNodesinTree(TreeImpl.Node root) {
		
		if(root == null) {
			return 0;
		}
		
		return findNumberOfNodesinTree(root.getLeft()) + findNumberOfNodesinTree(root.getRight()) + 1;
		
	}
	
	/**
	 * Method 2 - Recursively find number of nodes in tree. This method is same as method 1 except it explodes the recursive call in multiple steps.
	 * 
	 * @param root
	 * @return size
	 */
	public static int findNumberOfNodesinTreeMethod2(TreeImpl.Node root) {
		
		if(root == null) {
			return 0;
		}
		
		//return findNumberOfNodesinTree(root.getLeft()) + findNumberOfNodesinTree(root.getRight()) + 1;
		
		int leftNodesCount = findNumberOfNodesinTree(root.getLeft());
		int rightNodesCount = findNumberOfNodesinTree(root.getRight());
		
		return leftNodesCount + rightNodesCount + 1;
		
	}

	public static void main(String[] args) {
		
		TreeImpl tree = new TreeImpl();
		
		try {
			tree.generateTree(new int[] {12, 23, 10, 34, 22, 6, 56, 31});
		} catch(Exception e) {
			System.out.println("\n\nException occurred while creating the tree");
			e.printStackTrace();
		}
		
		TreeImpl.Node root = tree.getRoot();
		
		int numberOfNodesIteratively = findNumberOfNodesIteratively(root);
		System.out.println("Number of nodes iteratively: " + numberOfNodesIteratively);
		
		int numberOfNodes = findNumberOfNodesinTree(root);
		System.out.println("Number of nodes: " + numberOfNodes);
		

	}

}

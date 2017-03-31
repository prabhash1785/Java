package com.prabhash.java.interview.ch4;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all branches of binary tree
 * 
 * @author Prabhash Rathore
 *
 */
public class PrintAllBinaryTreeBranches {
	
	public static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static List<List<Node>> getAllBranches(Node root) {
		if(root == null) {
			return null;
		}

		List<Node> path = new ArrayList<>();
		List<List<Node>> allPaths = new ArrayList<>();

		helper(root, path, allPaths);
		return allPaths;
	}

	private static void helper(Node root, List<Node> path, List<List<Node>> paths) {
		if(root == null) {
			return;
		}

		path.add(root);

		if(root.left == null && root.right == null) {
			paths.add(new ArrayList<>(path));
			path.remove(path.size() - 1); // yes remove this leaf node from path as it's not needed anymore
			return;
		}

		helper(root.left, path, paths);
		helper(root.right, path, paths);

		path.remove(path.size() - 1);
	}

	public static void printAllPaths(List<List<Node>> paths) {
		if(paths == null || paths.size() == 0) {
			System.out.println("No path exists");
			return;
		}

		for(List<Node> path : paths) {
			for(Node node : path) {
				System.out.print(node.data + " ");
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(15);
		root.left.right = new Node(50);

		root.right = new Node(20);
		root.right.left = new Node(25);

		List<List<Node>> paths = getAllBranches(root);
		printAllPaths(paths);
	}
} 
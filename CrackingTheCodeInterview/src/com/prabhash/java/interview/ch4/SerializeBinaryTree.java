package com.prabhash.java.interview.ch4;

/**
 * Serialize a binary tree to a string so that it could be reproduced back into a tree from the serialized string.
 * 
 * @author Prabhash Rathore
 *
 */
public class SerializeBinaryTree {
	
	/**
	 * Serialize a Binary Tree to String.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param root
	 * @return String
	 */
	public static String serializeUsingPreOrder(Node root) {
		if(root == null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		serializeUsingPreOrderHelper(root, sb);
		
		return sb.toString();
	}
	
	private static void serializeUsingPreOrderHelper(Node root, StringBuilder sb) {
		if(root == null) {
			return;
		}
		
		sb.append("(").append(root.data);
		
		if(root.left != null) {
			serializeUsingPreOrderHelper(root.left, sb);
		} else {
			sb.append("(null");
		}
		
		sb.append(",");
		
		if(root.right != null) {
			serializeUsingPreOrderHelper(root.right, sb);
		} else {
			sb.append("null");
		}
		
		sb.append(")");
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
		Node root = new Node(8);
		root.left = new Node(5);
		root.right = new Node(10);
		
		root.left.left = new Node(15);
		root.left.right = new Node(12);
		root.left.right.left = new Node(30);
		
		root.right.right = new Node(19);
		root.right.right.left = new Node(4);
		
		String serializedTree = serializeUsingPreOrder(root);
		System.out.println("Serialized tree: " + serializedTree);
	}

}

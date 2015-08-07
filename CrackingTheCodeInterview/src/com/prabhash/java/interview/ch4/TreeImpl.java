package com.prabhash.java.interview.ch4;

/**
 * Implementation of Tree
 * 
 * @author prrathore
 *
 */
public class TreeImpl {
	
	/**
	 * Nested class which represents single node in a Binary Tree.
	 * 
	 * @author prrathore
	 *
	 */
	public static class Node {
		
		private int key;
		private String data;
		private Node left;
		private Node right;
		
		public Node() {
			this(0, "", null, null);
		}
		
		public Node(int key, String data) {
			this(key, data, null, null);
		}
		
		public Node(int key, String data, Node left, Node right) {
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public String getData() {
			return this.data;
		}
		
		public void setData(String data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

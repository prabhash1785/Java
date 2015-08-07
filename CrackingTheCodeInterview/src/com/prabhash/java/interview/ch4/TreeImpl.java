package com.prabhash.java.interview.ch4;

/**
 * Implementation of Tree
 * 
 * @author prrathore
 *
 */
public class TreeImpl {
	
	private Node root;
	
	public TreeImpl() {
		this(null);
	}
	
	public TreeImpl(Node root) {
		this.root = root;
	}
	
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
		
		@Override
		public String toString() {
			return this.key + " :: " + this.data;
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if(obj == null) {
				return false;
			}
			
			if(this == obj) {
				return true;
			}
			
			if(obj instanceof Node) {
				
				Node n = (Node) obj;
				
				if(this.key == n.key && this.data == n.data) {
					return true;
				}
				
			}
			
			return false;
			
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + key;
			
			return result;
		}
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

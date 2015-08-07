package com.prabhash.java.interview.ch4;

/**
 * Implementation of Binary Search Tree
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
	
	public Node getRoot() {
		return this.root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	/**
	 * Add node to a Binary Search Tree
	 * 
	 * @param node
	 */
	public void addNode(Node node) {
		
		if(node == null) {
			throw new NullPointerException("Cannot add a null node");
		}
		
		if(root == null) {
			root = node;
			return;
		}
		
		Node navigator = root;
		Node backup = root;
		
		while(navigator != null) {
			
			backup = navigator;
			
			if(node.key < navigator.key) {
				
				navigator = navigator.left;
				
				if(navigator == null) {
					navigator = node;
					backup.left = navigator; //link top level tree to left child node
					return;
				}
				
			} else {
				
				navigator = navigator.right;
				
				if(navigator == null) {
					navigator = node;
					backup.right = navigator; //link top level tree to right child node 
					return;
				}
				
			}
			
		}
		
			
	}
	
	/**
	 * Pre-order traversal of tree
	 * 
	 * @param node
	 */
	public void preOrder(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.key + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/**
	 * In-order traversal of a Tree
	 * 
	 * @param node
	 */
	public void inOrder(Node node) {
		
		if(node == null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.key + " ");
		inOrder(node.right);
	
	}
	
	/**
	 * Post-order traversal of tree 
	 * 
	 * @param root
	 */
	public void postOrder(Node root) {
		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.key + " ");
	}
	
	/**
	 * Nested class which represents single node in a Binary Tree
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
		
		public Node(int key) {
			this(key, Integer.toString(key), null, null);
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
		
		TreeImpl tree = new TreeImpl();
		
		tree.addNode(new Node(4));
		tree.addNode(new Node(3));
		tree.addNode(new Node(8));
		tree.addNode(new Node(2));
		tree.addNode(new Node(1));
		tree.addNode(new Node(7));
		tree.addNode(new Node(12));
		
		Node root = tree.getRoot();
		
		System.out.println("Pre-order Traversal:");
		tree.preOrder(root);
		
		System.out.println("\n\nIn-order Traversal:");
		tree.inOrder(root);
		
		System.out.println("\n\nPost-order Travsersal:");
		tree.postOrder(root);
		
	}

}

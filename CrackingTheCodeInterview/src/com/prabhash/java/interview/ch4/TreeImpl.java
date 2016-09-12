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
			
			if(node.key <= navigator.key) {
				
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
	 * Generate a Binary Search Tree from a list of integer data.
	 * 
	 * @param list
	 * @throws Exception
	 */
	public void generateTree(int[] list) throws Exception {
		
		if(list == null) {
			throw new Exception("Cannot generate a tree from empty list");
		}
		
		for(int i : list) {
			addNode(new Node(i));
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
	 * InOrder from right node to left. This will print BST elements in decreasing order.
	 * 
	 * @param node
	 */
	public void inOrderFromRightToLeft(Node node) {
		
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
	
	/**
	 * Iterative way to find a node in a tree.
	 * 
	 * Time Complexity: Average O(log n)
	 * 					Worst O(log n)
	 * 
	 * @param args
	 */
	public boolean findNodeIteratively(int data) throws Exception {
		
		Node node = this.root;
		
		if(node == null) {
			throw new Exception("Tree is nul!!");
		}
		
		while(node != null) {
			
			if(node.key == data) {
				return true;
			}
			
			if(data < node.key) {
				node = node.left;
			} else {
				node = node.right;
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * Find node recursively for Binary Tree.
	 * 
	 * Time Complexity: O(n) as you have to visit all the nodes
	 * 
	 * @param data
	 * @return
	 */
	public boolean findNodeRecursively(int data) throws Exception {
		
		Node node = this.root;
		
		if(root == null) {
			throw new Exception("Tree is empty");
		}
		
		return findNodeRecursivelyHelper(node, data);
		
	}
	
	/**
	 * Private helper method which finds a node recursively for a Binary Tree.
	 * 
	 * @param node
	 * @param data
	 * @return
	 */
	private boolean findNodeRecursivelyHelper(Node node, int data) {
		
		if(node == null) {
			return false;
		}
		
		return (node.key == data) || findNodeRecursivelyHelper(node.left, data) || findNodeRecursivelyHelper(node.right, data);
		
	}
	
	/**
	 * Find a node in Binary Search Tree using Recursion.
	 * 
	 * Time Complexity: O(log n)
	 * Space Complexity: O(log n) because of System Stack used in Recursion
	 * 
	 */
	public boolean findNodeForBST(Node node, int data) {
		
		if(node == null) {
			return false;
		}
		
		if(node.key == data) {
			return true;
		}
		
		if(data < node.key) {
			return findNodeForBST(node.left, data);
		} else {
			return findNodeForBST(node.right, data);
		}
		
	}
	
	/**
	 * Method 1:
	 * Find height of Binary Search Tree by adding 1 to each note starting recursive backtracking.
	 * 
	 * Height of a tree is defined as the longest branch from root to leaf.
	 * 
	 * @param node
	 * @return maxHeight
	 */
	public int getHeight(Node node) {
		
		if(node == null) {
			return 0;
		}
		
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		
		return (Math.max(leftHeight, rightHeight)) + 1;
		
	}
	
	/**
	 * Method 2: Find max height of tree.
	 * 
	 * For each child node, keep adding 1 as you go down the tree branches. At the end, for each node, return the maximum of leftHeight or,
	 * rightHeight.
	 * 
	 * @param node
	 * @return maxHeight
	 */
	public int getHeightMethod2(Node node) {
		
		if(node == null) {
			return 0;
		}
		
		int leftHeight = getHeightMethod2(node.left) + 1;
		int rightHeight = getHeightMethod2(node.right) + 1;
		
		return Math.max(leftHeight, rightHeight);
		
	}
	
	/**
	 * Find out if this tree is balanced.
	 * 
	 * A balanced tree is a tree for which each node's left and right sub trees depth difference cannot be more than 1.
	 * 
	 * To find if a tree is balanced, lets find the depth of left and right sub trees for each node. If left and right sub tree differ
	 * by more than 1 then it's not a balanced tree.
	 * 
	 * @param node
	 * @return
	 */
	public boolean isBalanced(Node node) {
		
		if(node == null) {
			return true;
		}
		
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}
		
		return isBalanced(node.left) && isBalanced(node.right);
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
		
		try {
			tree.generateTree(new int[]{64, 18, 75, 45, 34});
		} catch(Exception e) {
			System.out.println("Can't provide an empty list to generate tree method");
		}
		
		Node root = tree.getRoot();
		
		System.out.println("Pre-order Traversal:");
		tree.preOrder(root);
		
		System.out.println("\n\nIn-order Traversal:");
		tree.inOrder(root);
		
		System.out.println("\n\nPost-order Travsersal:");
		tree.postOrder(root);
		
		TreeImpl tree2 = new TreeImpl();
		
		int[] list = new int[] {12, 5, 4, 8, 76, 13, 56, 44, 17, 30, 99, 86, 23, 2};
		
		
		try {
			tree2.generateTree(list);
		} catch(Exception e) {
			System.out.println("\n\nOops provided an empty list!!");
		}
		
		System.out.println("\n\nInorder traversal of second tree is:");
		tree2.inOrder(tree2.getRoot());
		
		// find data in tree
		int dataToFind = 12;
		boolean isAvailable = false;
		
		try {
			isAvailable = tree.findNodeIteratively(dataToFind);
		} catch(Exception e) {
			System.out.println("\n\nTree is null");
		}
		
		System.out.println("\n\n" + dataToFind + " is present in tree: " + isAvailable);
		
		boolean isAvailableRecursive = false;
		
		try {
			isAvailableRecursive = tree.findNodeRecursively(dataToFind);
		} catch(Exception e) {
			System.out.println("\n\nTree is null!");
		}
		
		System.out.println("\n\n" + dataToFind + " is available in tree: " + isAvailableRecursive);
		
		// find data from BST Recursively
		boolean hasDataInBST = tree.findNodeForBST(root, dataToFind);
		System.out.println(dataToFind + " is present in BST: " + hasDataInBST);
		
		// max height of tree
		int maxHeight = tree.getHeight(tree.root);
		System.out.println("Max Height of tree is: " + maxHeight);
		
		int maxHeight2 = tree.getHeightMethod2(tree.root);
		System.out.println("Max Height of tree is: " + maxHeight2);
		
		// find if tree is balanced
		boolean isBalanced = tree.isBalanced(tree.root);
		System.out.println("Tree is balanced: " + isBalanced);
		
		
	}

}

package com.prabhash.java.interview.ch4;

/**
 * Find closest neighbor in a tree for a given value.
 * 
 * @author prrathore
 *
 */
public class FindClosestNeighborInBST {
	
	private Node root;
	
	/**
	 * Add given node to a Binary Search Tree.
	 * 
	 * @param data
	 */
	public void addNode(int data) {
		
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
			return;
		}
		
		Node currentNode = root;
		Node parent = root;
		
		while(true) {
			parent = currentNode;
			if(data <= currentNode.data) {
				currentNode = currentNode.left;
				if(currentNode == null) {
					parent.left = newNode;
					return;
				}
			} else {
				currentNode = currentNode.right;
				if(currentNode == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	/**
	 * Print inorder traversal.
	 * 
	 * @param root
	 */
	public void printInOrder(Node root) {
		
		if(root != null) {
			printInOrder(root.left);
			System.out.print(root.data + " ");
			printInOrder(root.right);
		}
	}
	
	/**
	 * Find exact match of a node.
	 * 
	 * @param root
	 * @param data
	 * @return boolean
	 */
	public boolean findNode(Node root, int data) {
		if(root == null) {
			return false;
		}
		
		if(root.data == data) {
			return true;
		} else if(data < root.data) {
			return findNode(root.left, data);
		} else {
			return findNode(root.right, data);
		}
	}
	
	/**
	 * Find closest predecessor to a given number.
	 * 
	 * @param root
	 * @param data
	 * @return int
	 */
	public int findClosestNeighborNotHigherThanGivenValue(Node root, int data) {
		return findClosestNeighborNotHigherThanGivenValueHelper(root, data, -1);
	}
	
	public int findClosestNeighborNotHigherThanGivenValueHelper(Node root, int data, int result) {
		if(root == null) {
			return result;
		}
		
		if(root.data == data) {
			return root.data;
		} else if(root.data < data) {
			result = result > root.data ? result : root.data;
			return findClosestNeighborNotHigherThanGivenValueHelper(root.right, data, result);
		} else {
			return findClosestNeighborNotHigherThanGivenValueHelper(root.left, data, result);
		}
	}
	
	public static class Node {
		
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.data);
		}
	}

	public static void main(String[] args) {
		
		FindClosestNeighborInBST tree = new FindClosestNeighborInBST();
		tree.addNode(8);
		tree.addNode(4);
		tree.addNode(15);
		tree.addNode(10);
		tree.addNode(12);
		tree.addNode(2);
		tree.addNode(6);
		
		System.out.println("Inorder of tree:");
		tree.printInOrder(tree.root);
		
		boolean isNodeAvailable = tree.findNode(tree.root, 12);
		System.out.println("\n12 is available: " + isNodeAvailable);
		
		isNodeAvailable = tree.findNode(tree.root, 200);
		System.out.println("\n200 is available: " + isNodeAvailable);
		
		int num = 14;
		int closestPredecessorNeighbor = tree.findClosestNeighborNotHigherThanGivenValue(tree.root, num);
		System.out.println("Closest neight to " + num + " is: " + closestPredecessorNeighbor);
	}
}

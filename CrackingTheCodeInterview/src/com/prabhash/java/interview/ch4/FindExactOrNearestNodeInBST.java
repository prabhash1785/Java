package com.prabhash.java.interview.ch4;

/**
 * Given a BST and a value to be searched, find the exact node if that has same value or else return the node with the nearest value.
 * 
 * For example:
 *                   200
 *          100                400
 *     50        150       300        500
                                  450
                                  
    400 -> node with value 400
    399 -> node with value 400
 * 
 * @author Prabhash Rathore
 *
 */
public class FindExactOrNearestNodeInBST {
	
	private Node root;
	
	/**
	 * Traverse the BST looking for node with given value. If node found with exact value then return that node. Else for nodes not equal
	 * to value, keep track of nodes with closest value to given input value.
	 * 
	 *  Time Complexity: O(logn)
	 * 
	 * @param data
	 * @return Node	Node with exact value if found or node with nearest value
	 */
	public Node findExactOrNearestNode(int data) {
		Node root = this.root;
		if(root == null) {
			return null;
		}
		
		Node result = new Node(0);
		findExactOrNearestNodeHelper(root, data, result);
		
		return result;
	}
	
	private void findExactOrNearestNodeHelper(Node root, int data, Node result) {
		if(root == null) {
			return;
		}
		
		if(root.data == data) {
			result.data = data;
			return;
		} else if(data < root.data) {
			if(Math.abs(root.data - data) < Math.abs(result.data - data)) {
				result.data = root.data;
			}
			findExactOrNearestNodeHelper(root.left, data, result);
		} else {
			if(Math.abs(root.data - data) < Math.abs(result.data - data)) {
				result.data = root.data;
			}
			findExactOrNearestNodeHelper(root.right, data, result);
		}
	}
	
	/**
	 * Add data to BST. 
	 * 
	 * @param data
	 */
	public void addNode(int data) {
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
			return;
		}
		
		Node node = root;
		Node parent = root;
		
		while(true) {
			parent = node;
			if(data <= node.data) {
				node = node.left;
				if(node == null) {
					parent.left = newNode;
					return;
				}
			} else {
				node = node.right;
				if(node == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public void inOrder(Node root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
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
		FindExactOrNearestNodeInBST tree = new FindExactOrNearestNodeInBST();
		tree.addNode(200);
		tree.addNode(100);
		tree.addNode(400);
		tree.addNode(50);
		tree.addNode(150);
		tree.addNode(300);
		tree.addNode(500);
		tree.addNode(450);
		
		System.out.println("Inorder of BST:");
		tree.inOrder(tree.root);
		
		// Nearest node test cases
		System.out.println("\nNearest node: " + tree.findExactOrNearestNode(400).data);
		System.out.println("\nNearest node: " + tree.findExactOrNearestNode(399).data);
	}
}

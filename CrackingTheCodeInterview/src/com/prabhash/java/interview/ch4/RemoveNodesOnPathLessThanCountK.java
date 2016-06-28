package com.prabhash.java.interview.ch4;

/**
 * Remove nodes on root to leaf path whose length is less than some number k.
 * 
 * Ref: http://www.geeksforgeeks.org/remove-nodes-root-leaf-paths-length-k/
 * 
 * @author prrathore
 *
 */
public class RemoveNodesOnPathLessThanCountK {
	
	/**
	 * At each node keep track of path length. For a leaf node, if path length < k then delete that node.
	 * Continue this process recursively for all the nodes. At the end, return the root of modified tree.
	 * 
	 * @param root
	 * @param k
	 * @return root		root of modified tree
	 */
	public static Node deleteNodesOnPathLessThanLengthK(Node root, int k) {
		if(root == null) {
			return null;
		}
		
		int count = 1;
		return nodeDeleterHelper(root, k, count);
	}
	
	private static Node nodeDeleterHelper(Node root, int givenCount, int actualCount) {
		if(root == null) {
			return null;
		}
		
		root.left = nodeDeleterHelper(root.left, givenCount, actualCount + 1);
		root.right = nodeDeleterHelper(root.right, givenCount, actualCount + 1);
		
		if(root.left == null && root.right == null && actualCount < givenCount) {
			return null;
		}
		
		return root;
	}
	
	public static void printInOrder(Node root) {
		if(root == null) {
			return;
		}
		
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
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
		Node treeRoot = new Node(1);
        treeRoot.left = new Node(2);
        treeRoot.right = new Node(3);
        treeRoot.left.left = new Node(4);
        treeRoot.left.right = new Node(5);
        treeRoot.left.left.left = new Node(7);
        treeRoot.right.right = new Node(6);
        treeRoot.right.right.left = new Node(8);
        int k = 4;
        
        System.out.println("Inorder of original tree:");
        printInOrder(treeRoot);
        
        Node modifiedTreeRoot = deleteNodesOnPathLessThanLengthK(treeRoot, k);
        System.out.println("\nInorder of modified tree:");
        printInOrder(modifiedTreeRoot);
	}

}

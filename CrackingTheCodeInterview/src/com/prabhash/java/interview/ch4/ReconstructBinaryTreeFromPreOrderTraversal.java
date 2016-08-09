package com.prabhash.java.interview.ch4;

/**
 * Generate a Binary Tree from given Pre-Order traversal with markers represented as null.
 * 
 * @author Prabhash Rathore
 *
 */
public class ReconstructBinaryTreeFromPreOrderTraversal {
	
	private static int arrayIndex = 0; // IMPORTANT to use arrayIndex as static variable for this program to work correctly
	
	/**
	 * Generate Binary Tree from pre-order traversal of array.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param array
	 * @return root of tree
	 */
	public static Node createBinaryTreeFromPreOrder(String[] array) {
		if(array == null) {
			return null;
		}
		
		arrayIndex = 0;
		return helper(array);
	}
	
	private static Node helper(String[] a) {
		if(arrayIndex == a.length) {
			return null;
		}
		
		if(a[arrayIndex] == null) {
			++arrayIndex; // make sure to increment index when element is NULL
			return null;
		}
		
		Node root = new Node(a[arrayIndex]);
		
		++arrayIndex;
		root.left = helper(a);
		root.right = helper(a);
		
		return root;
	}
	
	public static class Node {
		private String data;
		private Node left;
		private Node right;
		
		public Node(String data) {
			this.data = data;
		}
	}
	
	public static void printTreePreOrder(Node root) {
		if(root == null) {
			//System.out.print("null ");
			return;
		}
		
		System.out.print(root.data + " ");
		printTreePreOrder(root.left);
		printTreePreOrder(root.right);
	}

	public static void main(String[] args) {
		final String[] preOrderArray = new String[] {
				"H", "B", "F", null, null, "E", "A", null, null, null, "C", null, "D", null, "G", "I", null, null, null
		};
		
		Node root = createBinaryTreeFromPreOrder(preOrderArray);
		System.out.println("Preorder traversal of tree:");
		printTreePreOrder(root);
	}
}

package com.prabhash.java.interview.ch4;

/**
 * Check if tree is BST.
 * 
 * @author prrathore
 *
 */
public class Q4_5_CheckBST {
	
	/**
	 * For a tree to be BST, for each node in the tree following condition must satisfy:
	 * 		left sub-tree  <=	root.val  < right sub-tree
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(h) where h is the height of tree which is same as O(log n) if tree is balanced
	 * 
	 * @param root
	 * @return boolean
	 */
	public static boolean isBST(TreeImpl.Node root) {
		
		return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
	}
	
	private static boolean isBSTHelper(TreeImpl.Node root, int min, int max) {
		
		if(root == null) { // base condition
			return true;
		}
		
		if(root.getKey() > max || root.getKey() <= min) {
			return false;
		}
		
		return isBSTHelper(root.getLeft(), min, root.getKey()) && isBSTHelper(root.getRight(), root.getKey(), max);
		
	}
	
	private static void printInOrderTraversal(TreeImpl.Node root) {
		
		if(root != null) {
			printInOrderTraversal(root.getLeft());
			System.out.print(root.getData() + " ");
			printInOrderTraversal(root.getRight());
		}
		
	}

	public static void main(String[] args) {
		
		TreeImpl tree = new TreeImpl(new TreeImpl.Node(8));
		TreeImpl.Node root = tree.getRoot();
		
		root.setLeft(new TreeImpl.Node(4));
		root.getLeft().setRight(new TreeImpl.Node(6));
		
		root.setRight(new TreeImpl.Node(12));
		
		System.out.println("In-order traversal of tree:");
		printInOrderTraversal(root);
		
		boolean isBST = isBST(root);
		System.out.println("\n\nIS BST: " + isBST);

	}

}

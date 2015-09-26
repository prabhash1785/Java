package com.prabhash.java.interview.ch4;

/**
 * Create a min height BST from a sorted list.
 * 
 * @author prrathore
 *
 */
public class Q2_3_CreateMinBSTFromList {
	
	public static TreeImpl.Node createBST(int[] list) {
		return helper(list, 0, list.length - 1); 
	}
	
	/**
	 * Create Min Height BST from a sorted array of numbers.
	 * 
	 * To create min height BST, tree has to be balanced and as complete as possible. In order to this, we can split the array into two
	 * equal halves, mid becomes root, left half becomes left sub tree and right half becomes right sub tree. Recurse this until start > end.
	 * 
	 * @param list
	 * @param start
	 * @param end
	 * @return
	 */
	public static TreeImpl.Node helper(int[] list, int start, int end) {
		
		if(start > end) {
			return null;
		} else {
			
			int mid = (start + end) / 2;
			
			TreeImpl.Node leftSubtree = helper(list, start, mid - 1);
			TreeImpl.Node rightSubTree = helper(list, mid + 1, end);
			
			TreeImpl.Node root = new TreeImpl.Node(list[mid]);
			
			root.setLeft(leftSubtree);
			root.setRight(rightSubTree);
			
			return root;
			
		}
		
	}
	
	/**
	 * Get height of tree.
	 * 
	 * Height of Tree is the longest branch from root to one of it's leaves. So to find height, find the height of left sub tree, find
	 * height of right sub tree and then the height must the max of left and right sub tree height. Recurse for each node in the tree.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param root
	 * @return
	 */
	public static int getHeight(TreeImpl.Node root) {
		
		if(root == null) { // Base condition
			return 0;
		}
		
		int leftTreeHeight = getHeight(root.getLeft()) + 1;
		int rightTreeHeight = getHeight(root.getRight()) + 1;
		
		return Math.max(leftTreeHeight, rightTreeHeight);
		
	}
	
	/**
	 * Program to find if a tree is balanced or not. 
	 * 
	 * Balanced Tree is a tree where for any node in the tree, their left sub-tree height and right sub-tree height cannot differ by more than 1. 
	 * 
	 * @param node
	 * @return
	 */
	public static boolean isBalanced(TreeImpl.Node node) {
		
		int heightDiff = checkBranchHeightDiffForEachNode(node);
		
		if(heightDiff == -1) {
			return false;
		} else {
			return true;
		}
		
	}
	
	/**
	 * Private helper method which checks for height of both left and right sub-trees for each node in the tree. In addition it checks for
	 * for left and right sub-trees height difference to determine if is balanced or not. If height diff is greater than  1, it quits by concluding it's
	 * not a balanced tree. 
	 * 
	 * @param node
	 * @return
	 */
	private static int checkBranchHeightDiffForEachNode(TreeImpl.Node node) {
		
		if(node == null) {
			return 0;
		}
		
		int leftBranchHeight = checkBranchHeightDiffForEachNode(node.getLeft()) + 1;
		
		if(leftBranchHeight == -1) {
			return -1;
		}
		
		int rightBranchHeight = checkBranchHeightDiffForEachNode(node.getRight()) + 1;
		
		if(rightBranchHeight == -1) {
			return -1;
		}
		
		int heightDiff = Math.abs(leftBranchHeight - rightBranchHeight);
		
		if(heightDiff > 1) {
			return -1;
		} else {
			return Math.max(leftBranchHeight, rightBranchHeight);
		}
		
	}
	
	/**
	 * Print in-order traversal of tree
	 * 
	 * @param args
	 */
	public static void inOrder(TreeImpl.Node root) {
		
		if(root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getKey() + " ");
			inOrder(root.getRight());
		}
		
	}

	public static void main(String[] args) {
		
		final int[] list = new int[] {7, 10, 11, 18, 20 , 35};
		
		System.out.println("Original array:");
		for(int i : list) {
			System.out.print(i + " ");
		}
		
		TreeImpl.Node root = createBST(list);
		
		System.out.println("\n\nInorder Traversal of BST: ");
		inOrder(root);
		
		int height = getHeight(root);
		System.out.println("\n\nMin Height of tree: " + height);
		
		boolean isTreeBalanced = isBalanced(root);
		System.out.println("\n\nIs tree balanced: " + isTreeBalanced);
		
	}

}

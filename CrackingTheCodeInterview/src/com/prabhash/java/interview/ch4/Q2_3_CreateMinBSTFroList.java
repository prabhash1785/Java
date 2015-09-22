package com.prabhash.java.interview.ch4;

/**
 * Create a min height BST from a sorted list.
 * 
 * @author prrathore
 *
 */
public class Q2_3_CreateMinBSTFroList {
	
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
		
	}

}

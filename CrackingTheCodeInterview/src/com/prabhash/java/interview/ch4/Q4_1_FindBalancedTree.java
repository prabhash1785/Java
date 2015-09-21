package com.prabhash.java.interview.ch4;

public class Q4_1_FindBalancedTree {
	
	/**
	 * Method 1
	 * 
	 * Prefer Method 2 over method 1 as method 1 is cleaner.
	 * 
	 * @param root
	 * @return
	 */
	private static int getHeight(TreeImpl.Node root) {
		
		if(root == null) {
			return 0;
		}
		
		return getHeightHelper(root, 1); //to get exact height, initiate this with 1 instead of 0
		
	}
	
	private static int getHeightHelper(TreeImpl.Node root, int height) {
		
		if(root == null) {
			return height;
		}
		
		int leftHeight = getHeightHelper(root.getLeft(), height++);
		int rightHeight = getHeightHelper(root.getRight(), height++);
		
		return leftHeight > rightHeight ? leftHeight : rightHeight;
		
	}
	
	/**
	 * Method 2 to get height of tree
	 * 
	 * @param root
	 * @return
	 */
	private static int getHeight2(TreeImpl.Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int leftHeight = getHeight2(root.getLeft());
		int rightHeight = getHeight2(root.getRight());
		
		return Math.max(leftHeight, rightHeight) + 1;
		
	}
	
	/**
	 * Find if a tree is balanced.
	 * 
	 * Time Complexity: O(n logn)
	 * 
	 * @param root
	 * @return
	 */
	private static boolean isBalanced(TreeImpl.Node root) {
		
		if(root == null) {
			return true;
		}
		
		int leftHeight = getHeight2(root.getLeft());
		int rightHeight = getHeight2(root.getRight());
		
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}
		
		return isBalanced(root.getLeft()) && isBalanced(root.getRight()); 
		
	}
	
	/**
	 * Method 2 to find if tree is balanced.
	 * 
	 * This is an optimized method as it will determine tree is balanced at the same while finding the height of tree cutting down the
	 * algorithm time to O(n).
	 * 
	 * Time complexity: O(n)
	 * 
	 * @param args
	 */
	public static boolean isBalanced2(TreeImpl.Node root) {
		
		if(checkHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
		
	}
	
	/**
	 * This helper method finds the height of a node. At the same time, it also checks if tree is balanced by comparing height of left and 
	 * right subtree for each node. If tree is not balanced then it returns -1.
	 * 
	 *  Time Complexity: O(n)
	 *  Space Complexity: O(H) where H is the height of tree
	 * 
	 * @param root
	 * @return
	 */
	private static int checkHeight(TreeImpl.Node root) {
		
		// Base condition
		if(root == null) {
			return 0;
		}
		
		int leftHeight = checkHeight(root.getLeft());
		if(leftHeight == -1) {
			return -1;
		}
		
		int rightHeight = checkHeight(root.getRight());
		if(rightHeight == -1) {
			return -1;
		}
		
		int heightDiff = Math.abs(leftHeight - rightHeight);
		
		if(heightDiff > 1) {
			return -1; // Not balanced
		} else {
			return Math.max(leftHeight, rightHeight) + 1; // return height if balanced
		}
		
	}
	

	public static void main(String[] args) {
		
		TreeImpl tree = new TreeImpl();
		
		try {
			tree.generateTree(new int[]{23, 12, 4, 56, 37, 51});
		} catch(Exception e) {
			System.out.println("Exception occurred while generating the tree" + e);			
		}
		
		int heightOfTree = getHeight(tree.getRoot());
		System.out.println("Height of tree: " + heightOfTree);
		
		System.out.println("Height with method two: " + getHeight2(tree.getRoot()));
		
		boolean isTreeBalanced = isBalanced(tree.getRoot());
		System.out.println("Is tree balanced: " + isTreeBalanced);
		
		boolean isTreeBalanced2 = isBalanced2(tree.getRoot());
		System.out.println("Is tree balanced with method 2: " + isTreeBalanced2);
		

	}

}

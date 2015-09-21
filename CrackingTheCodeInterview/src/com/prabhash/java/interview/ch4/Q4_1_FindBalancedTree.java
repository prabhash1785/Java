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
		

	}

}

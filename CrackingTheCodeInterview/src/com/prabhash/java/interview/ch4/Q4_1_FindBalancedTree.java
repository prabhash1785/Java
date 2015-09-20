package com.prabhash.java.interview.ch4;

public class Q4_1_FindBalancedTree {
	
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

	public static void main(String[] args) {
		
		TreeImpl tree = new TreeImpl();
		
		try {
			tree.generateTree(new int[]{23, 12, 4, 56, 37, 51});
		} catch(Exception e) {
			System.out.println("Exception occurred while generating the tree" + e);			
		}
		
		int heightOfTree = getHeight(tree.getRoot());
		System.out.println("Height of tree: " + heightOfTree);
		

	}

}

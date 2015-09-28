package com.prabhash.java.interview.ch4;

public class PathSumOfTree {
	
	/**
	 * Recursive method to find if a branch in tree has a given sum.
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public static boolean hasPathSumFromRootToLeaf(TreeImpl.Node root, int sum) {
		
		if(root == null) {
			return false;
		}
		
		//check sum == 0 only at leaf nodes
		if(sum == 0 && root.getLeft() == null && root.getRight() == null) {
			return true;
		}
		
		return hasPathSumFromRootToLeaf(root.getLeft(), sum - root.getKey()) || hasPathSumFromRootToLeaf(root.getRight(), sum - root.getKey());
		
	}
	
	
	public static void main(String[] args) {
		
		TreeImpl tree = new TreeImpl();
		
		try {
			tree.generateTree(new int[] {5, 4, 8, 11, 13, 14, 7, 2, 5, 1});
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		boolean hasSum = hasPathSumFromRootToLeaf(tree.getRoot(), 20);
		System.out.println("Does tree have a branch with sum 20: " + hasSum);
		

	}

}

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
		
		int pathSum = 0;
		return hasPathSumFromRootToLeafHelper(root, sum, pathSum);
		
	}
	public static boolean hasPathSumFromRootToLeafHelper(TreeImpl.Node root, int sum, int pathSum) {
		
		if(root == null) {
			return false;
		}
		
		pathSum = pathSum + root.getKey();
		
		//check sum == pathSum at leaf nodes
		if(pathSum == sum && root.getLeft() == null && root.getRight() == null) {
			return true;
		}
		
		return hasPathSumFromRootToLeafHelper(root.getLeft(), sum, pathSum) || hasPathSumFromRootToLeafHelper(root.getRight(), sum, pathSum);

	}
	
	
	
	/**
	 * Using an array to store paths and keep track of current element index
	 * 
	 * @param args
	 */
	public static void printPathsWithSum(TreeImpl.Node root, int sum) {
		
		if(root == null) {
			System.out.println("Root is null!");
			return;
		}
		
		int[] path = new int[20]; //Max 20 nodes are allowed at one time
		int index = 0;
		
		int pathSum = 0;
		
		printPathsWithSumHelper(root, sum, path, index, pathSum);
	}

	private static void printPathsWithSumHelper(TreeImpl.Node root, int sum, int[] path, int index, int pathSum) {
		
		if(root == null) {
			return;
		}
		
		path[index] = root.getKey();
		index = index + 1;
		
		pathSum = pathSum + root.getKey();
		
		if(root.getLeft() == null && root.getRight() == null && pathSum == sum) {
			
			printPaths(path, index);
			
		}
		
		// recurse over all nodes in the tree
		printPathsWithSumHelper(root.getLeft(), sum, path, index, pathSum);
		printPathsWithSumHelper(root.getRight(), sum, path, index, pathSum);
				
	}
	
	private static void printPaths(int[] array, int index) {
		
		for(int i = 0; i < index; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println("\n");
		
	}
	
	public static void main(String[] args) {
		
		TreeImpl tree = new TreeImpl();
		
		try {
			tree.generateTree(new int[] {5, 4, 8, 11, 13, 14, 7, 2, 5, 1});
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		int desiredSum = 51;
		boolean hasSum = hasPathSumFromRootToLeaf(tree.getRoot(), desiredSum);
		System.out.println("Does tree have a branch with sum " + desiredSum + ": " + hasSum);
		
		System.out.println("\n\nHere is the list of branches with path sum " + desiredSum + ": ");
		printPathsWithSum(tree.getRoot(), desiredSum);
		
	}

}

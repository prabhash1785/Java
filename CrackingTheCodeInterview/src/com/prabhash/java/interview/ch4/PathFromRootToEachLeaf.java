package com.prabhash.java.interview.ch4;

/**
 * Get Path from Root to each leaf in a tree.
 * 
 * @author prrathore
 *
 */
public class PathFromRootToEachLeaf {
	
	public static void getPathFromRootToLeaf(TreeImpl.Node root) {
		
		int[] list = new int[20];
		int count = 0;
		getPathRecursively(root, list, count);
		
	}
	
	private static void getPathRecursively(TreeImpl.Node node, int[] list, int index) {
		
		if(node == null) {
			return;
		}
		
		list[index] = node.getKey();
		
		index = index + 1;
		
		getPathRecursively(node.getLeft(), list, index);
		getPathRecursively(node.getRight(), list, index);
		
		// if encountered a leaf, print the list which is the path from root to leaf
		if(node.getLeft() == null && node.getRight() == null) {
			printArray(list, index);
		}
			
	}
	
	private static void printArray(int[] list, int count) {
		
		for(int i = 0; i < count; i++) {
			System.out.print(list[i] + " ");
		}
		
		System.out.println("\n");
	}

	public static void main(String[] args) throws Exception {
		
		TreeImpl tree = new TreeImpl();
		
		tree.generateTree(new int[] {4, 3, 8, 2, 1, 7, 12});
		
		getPathFromRootToLeaf(tree.getRoot());

	}

}

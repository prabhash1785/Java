package com.prabhash.java.interview.ch4;

/**
 * Create a balanced TreeImpl of minimal height from a given sorted list.
 * 
 * @author prrathore
 *
 */
public class CreateBSTFromSortedList {
	
	/**
	 * To create a balanced Binary Search Tree of minimal height, let us divide the array into two equal halves.
	 * Middle element will be root, left part will be left sub tree and right part will be right sub tree. Recurse this process.
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static TreeImpl createTreeImplFromList(int[] list) throws Exception {
		
		if(list == null) {
			throw new Exception("List is null");
		}
		
		TreeImpl tree = new TreeImpl();
		tree.setRoot(createBST(list, 0, list.length - 1));
		
		return tree;
		
	}
	
	/**
	 * Recursive method to generate BST from list.
	 * 
	 * @param list
	 * @param start
	 * @param end
	 * @return
	 */
	private static TreeImpl.Node createBST(int[] list, int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		int mid = (start + end) / 2;
		
		TreeImpl.Node root = new TreeImpl.Node(list[mid]);
		
		root.setLeft(createBST(list, start, mid - 1));
		root.setRight(createBST(list, mid + 1, end));
		
		return root;
		
	}

	public static void main(String[] args) {
		
		int[] inputArray = new int[] {2, 4, 8, 12, 35, 46, 57, 62, 75};
		
		TreeImpl tree = new TreeImpl();
		
		try {
			tree = createTreeImplFromList(inputArray);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n\nCannot create a list from empty array");
		}
		
		tree.inOrder(tree.getRoot());

	}

}

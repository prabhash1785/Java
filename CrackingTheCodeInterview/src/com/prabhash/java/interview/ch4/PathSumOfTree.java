package com.prabhash.java.interview.ch4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	
	/**
	 * Method 1: Recursive
	 * 
	 * Find all the paths in a tree whose sum from root to lead is equal to a given sum.
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> findPathsWithGivenSum(TreeImpl.Node root, int sum) {
		
		if(root == null) {
			return null;
		}
		
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		
		findPathWithSumHelper(root, new ArrayList<Integer>(), sum, output);
		
		return output;
		
	}
	
	private static void findPathWithSumHelper(TreeImpl.Node root, List<Integer> list, int sum, List<List<Integer>> output) {
		
		if(root == null) {
			return;
		}
		
		if(sum == 0 && root.getLeft() == null && root.getRight() == null) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(list);
			output.add(temp);
		}
		
		if(root.getLeft() != null) {
			list.add(root.getKey());
			findPathWithSumHelper(root.getLeft(), list, sum - root.getKey(), output);
			list.remove(list.size() - 1);
		}
		
		if(root.getRight() != null) {
			list.add(root.getKey());
			findPathWithSumHelper(root.getRight(), list, sum - root.getKey(), output);
			list.remove(list.size() - 1);
		}
				
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
		
		List<List<Integer>> list = findPathsWithGivenSum(tree.getRoot(), 20);
		System.out.println("\n\nHere are the paths:\n");
		for(List<Integer> l : list) {
			for(Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.println("\n");
		}
		
	}

}

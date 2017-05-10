package com.prabhash.java.interview.ch4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find kth parent of all leaf nodes in a given Binary tree.
 * 
 * Time Complexity: O(n)
 * 
 * @author Prabhash Rathore
 *
 */
public class FindKthParentsOfAllLEaves {
	
	// Find all the Kth nodes from leaves
	public static Set<Node> findKthNodes(Node root, int k) {
		Set<Node> set = new HashSet<>();
		if(root == null) {
			return set;
		}

		List<Node> branch = new ArrayList<>();
		helper(root, k, branch, set);
		return set;
	}

	private static void helper(Node root, int k, List<Node> branch, Set<Node> set) {
		if(root == null) {
			return;
		}
		
		branch.add(root);

		if(root.left == null && root.right == null) {
			if(branch.size() >= k) {
				Node n = branch.get(branch.size() - k);
				set.add(n);
			}
		}
		
		helper(root.left, k, branch, set);
		helper(root.right, k, branch, set);
		branch.remove(root);
	}
	
	public static class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	static void findKthParentHelper(Node root, int k, int leafCount, ArrayList<Node> parentNodes, ArrayList<Node> trackerList){
	    if(root == null){
	        int kLocation = (trackerList.size() - k);
	        if(kLocation > -1){
	            parentNodes.add(trackerList.get(kLocation));
	        }
	        return;
	    }
	    
	    trackerList.add(root);
	    findKthParentHelper(root.left, k, leafCount+1, parentNodes, trackerList);
	    findKthParentHelper(root.right, k, leafCount+1, parentNodes, trackerList); 
	    trackerList.remove(root);
	}

	static List<Node> findKthParent(Node root, int k) {
	    ArrayList<Node> parentNodes = new ArrayList<Node>();
	    ArrayList<Node> trackerList = new ArrayList<Node>();
	    findKthParentHelper(root, k, 0, parentNodes, trackerList);
	    return parentNodes;
	}

	public static void main(String[] args) {
		final Node root = new Node(20);
		
		root.left = new Node(50);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.left.right.left = new Node(300);
		root.left.right.left.left = new Node(5);
		root.left.right.left.left.right = new Node(15);
		
		root.right = new Node(100);
		root.right.left = new Node(10);
		root.right.left.left = new Node(1);
		
		root.right.right = new Node(1000);
		root.right.right.left = new Node(4);
		root.right.right.right = new Node(12);
		
		final int k = 2;
//		final Set<Node> kthNodes = findKthNodes(root, k);
		final List<Node> kthNodes = findKthParent(root, k);
		System.out.println("Here are all kth nodes:");
		for(Node node : kthNodes) {
			System.out.println(node + " ");
		}
	}
}

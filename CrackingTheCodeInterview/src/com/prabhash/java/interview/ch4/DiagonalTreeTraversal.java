package com.prabhash.java.interview.ch4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Traverse a tree diagonally.
 * 
 * @author prrathore
 *
 */
public class DiagonalTreeTraversal {

	public static void printNodesDiagonally(Node root) {

		if(root == null) {
			return;
		}

		Map<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
		
		getDiagonalMap(root, 0, map);
		printDiagonal(map);
	}

	private static void getDiagonalMap(Node root, int level, Map<Integer, List<Node>> map) {

		if(root == null) {
			return;
		}

		if(map.containsKey(level)) {
			List<Node> list = map.get(level);
			list.add(root); // this should update the list in the Map, no need to explicitly put this list in Map
		} else {
			List<Node> newList = new ArrayList<>();
			newList.add(root);
			map.put(level, newList);
		}

		getDiagonalMap(root.left, level + 1, map);
		getDiagonalMap(root.right, level, map);
	}

	private static void printDiagonal(final Map<Integer, List<Node>> map) {

		if(map == null) {
			System.out.println("Empty tree");
		}

		Set<Integer> set = map.keySet();
		for(Integer i : set) {
			List<Node> list = map.get(i);

			if(list != null && list.size() > 0) {

				for(Node node : list) {
					System.out.print(node.data + " ");
				}
				System.out.println("\n");
			}
		}
	}
	
	public static class Node {

		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);

		root.left.left = new Node(1);
		root.left.right = new Node(6);

		root.right.right = new Node(14);

		root.right.right.left = new Node(13);

		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		printNodesDiagonally(root);
	}
}
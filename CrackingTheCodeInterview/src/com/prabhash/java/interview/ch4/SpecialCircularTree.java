package com.prabhash.java.interview.ch4;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Special Tree which has 3 children each. Two children are left and right nodes but third children could reference any node in the tree
 * which can make it a circular tree or more precisely a Graph.
 * 
 * @author Prabhash Rathore
 *
 */
public class SpecialCircularTree {
	
	public static Node<String> cloneTree(Node<String> root) {
		Map<Node<String>, Node<String>> visitedNodeMap = new HashMap<>();
		return cloneHelper(root, visitedNodeMap);
	}
	
	private static Node<String> cloneHelper(Node<String> root, Map<Node<String>, Node<String>> map) {
		if(root == null) {
			return null;
		}
		
		Node<String> node = null;
		if(map.containsKey(root)) {
			node = map.get(root);
			return node;
		} else {
			node = new Node<>(root.data);
			map.put(root, node);
		}
		
		node.left = cloneHelper(root.left, map);
		node.right = cloneHelper(root.right, map);
		node.random = cloneHelper(root.random, map);
		
		return node;
	}
	
	public static void printInOrder(Node<String> root) {
		if(root == null) {
			return;
		}
		
		Set<Node<String>> vistedNodes = new HashSet<>();
		printInOrderHelper(root, vistedNodes);
	}
	
	private static void printInOrderHelper(Node<String> root, Set<Node<String>> set) {
		if(root == null) {
			return;
		}
		
		set.add(root);
		printInOrderHelper(root.left, set);
		System.out.print(root.data + " ");
		printInOrderHelper(root.right, set);
		if(root.random != null) {
			System.out.print("random: " + root.random.data);
		}
	}
	
	public static void printBFSOfTree(Node<String> root) {
		if(root == null) {
			System.out.println("\nTree is null");
		}
		
		Deque<Node<String>> queue = new LinkedList<>();
		Deque<Node<String>> nextLevel = new LinkedList<>();
		queue.addLast(root);
		while(!queue.isEmpty()) {
			Node<String> node = queue.removeFirst();
			if(node != null) {
				System.out.print(node.data + " ");
			}
			if(node.left != null) {
				nextLevel.addLast(node.left);
			}
			if(node.right != null) {
				nextLevel.addLast(node.right);
			}
			if(node.random != null) {
				System.out.print("Random: " + node.random.data);
			}
			
			if(queue.isEmpty()) {
				queue = nextLevel;
				nextLevel = new LinkedList<>();
				System.out.print("\n");
			}
		}
	}
	
	public static class Node<T> {
		T data;
		private Node left;
		private Node right;
		private Node random;
		
		public Node(T data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
	}

	public static void main(String[] args) {
		Node<String> root = new Node<>("10");
		
		Node<String> randomNode = new Node<>("35");
		randomNode.left = new Node<>("43");
		randomNode.right = new Node<>("86");
		randomNode.random = root;

		root.left = new Node<>("20");
		root.right = new Node<>("30");
		root.random = randomNode;
		
		root.left.right = randomNode;
		
		System.out.println("Original Tree:");
		printInOrder(root);
		
		System.out.println("\nBFS of original tree");
		printBFSOfTree(root);
		
		System.out.println("\nClone Tree:");
		Node<String> clonedTree = cloneTree(root);
		printInOrder(clonedTree);
		
		System.out.println("\nBFS of cloned tree");
		printBFSOfTree(clonedTree);
	}

}

package com.prabhash.java.interview.ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Create Linked Lists from each tree level.
 * 
 * @author prrathore
 *
 */
public class Q4_4_CreateLinkedListFromEachTreeLevel {
	
	/**
	 * Use BFS algorithm to find all the node at each level and create a Linked List of those nodes. Keep adding these Linked List
	 * to a List which will be returned at the end.
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> createLinkedListForEachLevel(TreeImpl.Node root) throws Exception {
		
		if(root == null) {
			throw new Exception("Cannot work with null tree");
		}
		
		List<List<Integer>> list = new ArrayList<List<Integer>>(); 
		
		Queue<TreeImpl.Node> queue = new LinkedList<TreeImpl.Node>(); //store nodes at each level
		queue.add(root);
		
		Queue<TreeImpl.Node> tempQueue = new LinkedList<TreeImpl.Node>(); //temporary queue to store children of current level nodes
		
		List<Integer> levelList = new LinkedList<Integer>(); //stored node data from each level
		
		while(queue.peek() != null) {
			
			TreeImpl.Node n = queue.poll();
			
			levelList.add(n.getKey());
			
			if(n.getLeft() != null) {
				tempQueue.add(n.getLeft());
			}
			
			if(n.getRight() != null) {
				tempQueue.add(n.getRight());
			}
			
			// When queue becomes empty, lets assign tempQueue to queue, add levelList to list and create a new instance of levelList
			if(queue.peek() == null) {
				queue = tempQueue;
				
				tempQueue = new LinkedList<TreeImpl.Node>(); //create new instance so that all previous level nodes could be flushed out
				
				list.add(levelList);
				
				levelList = new LinkedList<Integer>();
							
			}
					
		}
		
		return list;
		
	}

	public static void main(String[] args) throws Exception {
		
		TreeImpl tree = new TreeImpl();
		
		tree.generateTree(new int[] {4, 3, 8, 2, 1, 7, 12});
		
		List<List<Integer>> output = createLinkedListForEachLevel(tree.getRoot());
		
		//print output
		if(output == null) {
			
			System.out.println("\nTree must be null");
			
		} else {
			
			System.out.println("\nLinked Listed from each level of Tree:");
			for(List<Integer> list : output) {
				
				for(Integer i : list) {
					
					System.out.print(i + " - > ");
					
				}
				
				System.out.println("\n");
				
			}
			
		}

	}

}

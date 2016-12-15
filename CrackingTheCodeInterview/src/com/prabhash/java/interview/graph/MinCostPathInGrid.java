package com.prabhash.java.interview.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Given a two dimensional grid, each cell of which contains integer cost which represents a cost to traverse 
 * through that cell, we need to find a path from top left cell to bottom right cell by which total cost incurred is 
 * minimum.
 * 
 * @author Prabhash Rathore
 *
 */
public class MinCostPathInGrid {
	
	/**
	 * Find shortest path using Dijkstra's Algorithm.
	 * 
	 * @param grid
	 * @param start
	 * @param end
	 * @return path
	 */
	public static List<Node> findShortestPath(int[][] grid, Node start, Node end) {
		if(grid == null || start == null || end == null) {
			throw new NullPointerException();
		}
		
		List<Node> path = new ArrayList<>();
		Queue<Node> queue = new PriorityQueue<>((Node node1, Node node2) -> {
			return Integer.compare(node1.distanceFromStart, node2.distanceFromStart);
		});
		
		Set<Node> visitedNodes = new HashSet<>();

		queue.add(start);
		
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			
			visitedNodes.add(node);
			
			if(node.equals(end)) {
				end = node; // make sure to reference end to node object
				break;
			}
			
			List<Node> neighbors = getNeighbors(grid, node);
			for(Node neighbor : neighbors) {
				if(visitedNodes.contains(neighbor)) {
					continue;
				}
				
				neighbor.weight = grid[neighbor.row][neighbor.col]; // get neighbor weight value from grid
				int distanceFromStart = node.distanceFromStart + neighbor.weight;
				if(neighbor.distanceFromStart == 0 || distanceFromStart < neighbor.distanceFromStart) {
					neighbor.distanceFromStart = distanceFromStart;
					neighbor.parent = node;
				}
				
				// add and remove node to get the Priority Queue reshuffled
				if(queue.contains(neighbor)) {
					queue.remove(neighbor);
				}
				
				queue.add(neighbor);
			}
		}
		
		// derive path by backtracking nodes parents
		Node temp = end;
		while(temp != null) {
			path.add(temp);
			temp = temp.parent;
		}

		return path;
	}
	
	private static List<Node> getNeighbors(int[][] grid, Node node) {
		if(grid == null || node == null) {
			return null;
		}
		
		List<Node> neighbors = new ArrayList<>();
		int row = node.row;
		int col = node.col;
		
		Node leftNode = new Node(row, col - 1);
		if(isValidCell(grid, leftNode)) {
			neighbors.add(leftNode);
		}
		
		Node topNode = new Node(row - 1, col);
		if(isValidCell(grid, topNode)) {
			neighbors.add(topNode);
		}
		
		Node rightNode = new Node(row, col + 1);
		if(isValidCell(grid, rightNode)) {
			neighbors.add(rightNode);
		}
		
		Node bottomNode = new Node(row + 1, col);
		if(isValidCell(grid, bottomNode)) {
			neighbors.add(bottomNode);
		}
		
		return neighbors;
	}
	
	private static boolean isValidCell(int[][] grid, Node node) {
		if(grid == null || node == null) {
			return false;
		}
		
		if(node.row < 0 || node.row >= grid.length) {
			return false;
		}
		
		if(node.col < 0 || node.col >= grid[0].length) {
			return false;
		}
		
		return true;
	}
	
	public static class Node {
		private int row, col;
		private int weight;
		private int distanceFromStart;
		private Node parent;
		
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
			this.weight = 0;
			this.distanceFromStart = 0;
			this.parent = null;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj == null) {
				return false;
			}
			
			if(obj.getClass() != this.getClass()) {
				return false;
			}
			
			Node node = (Node) obj;
			if(this.row == node.row && this.col == node.col) {
				return true;
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			int prime = 23;
			int hashCode = 11;
			hashCode = hashCode * prime + Integer.valueOf(this.row).hashCode() +
					Integer.valueOf(this.col).hashCode();
			
			return hashCode;
		}
		
		@Override
		public String toString() {
			return "(" + this.row + ", " + this.col + " => " + this.weight + ")";
		}
	}

	public static void main(String[] args) {
		final int[][] grid = new int[][] {
				{31,  100, 65,  12, 18},
		        {10,  13,  47,  157, 6},
		        {100, 113, 174, 11, 33},
		        {88,  124, 41,  20, 140},
		        {99,  32,  111, 41, 20}
		};
		
		List<Node> shortestPath = findShortestPath(grid, new Node(0, 0), new Node(4, 4));
		System.out.println("Here is the shortest path from start to end nodes:");
		for(Node node : shortestPath) {
			System.out.println(node);
		}
	}
}

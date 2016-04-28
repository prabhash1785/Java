package com.prabhash.interview.practice.matrix;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindIfPathExistsInGrid {
	
	/**
	 * Find if path exists in a grid from start to end coordinate.
	 * 
	 * @param grid
	 * @param start
	 * @param end
	 * @return boolean
	 */
	public static boolean doesPathExist(int[][] grid, Coordinate start, Coordinate end) {
		
		if(grid == null || start == null || end == null) {
			throw new IllegalArgumentException();
		}
		
		if(start.row >= grid.length || start.col >= grid[0].length || end.row >= grid.length || end.col >= grid[0].length) {
			throw new IllegalArgumentException();
		}
		
		if(start.equals(end)) {
			return true;
		}
		
		return pathExistsHelper(grid, start.row, start.col, end);
	}
	
	private static boolean pathExistsHelper(int[][] grid, int startRow, int startCol, Coordinate end) {
		
		if(startRow >= grid.length || startCol >= grid[0].length) {
			return false;
		}
		
		if(!isValidCoordinate(grid, startRow, startCol)) {
			return false;
		}
		
		if(startRow == end.row && startCol == end.col) {
			return true;
		}
			
		return pathExistsHelper(grid, startRow + 1, startCol, end) || pathExistsHelper(grid, startRow, startCol + 1, end);
	}
	
	/**
	 * Find if a path exists in grid. If path exists then return the path.
	 * 
	 * @param grid
	 * @param start
	 * @param end
	 * @return result
	 */
	public static Result findPathIfExists(final int[][] grid, final Coordinate start, final Coordinate end) {
		
		if(grid == null || start == null || end == null) {
			throw new IllegalArgumentException();
		}
		
		if(start.row >= grid.length || start.col >= grid[0].length || end.row >= grid.length || end.col >= grid[0].length) {
			throw new IllegalArgumentException();
		}
		
		if(start.equals(end)) {
			
			Result result = new Result();
			Set<Coordinate> set = new LinkedHashSet<>();
			set.add(start);
			result.path = set;
			result.pathExists = true;
			return result;
		}
		
		return findPathIfExistsHelper(grid, start.row, start.col, end);
	}
	
	private static Result findPathIfExistsHelper(final int[][] grid, final int startRow, final int startCol, final Coordinate end) {
		
		if(startRow >= grid.length || startCol >= grid[0].length) {
			return null;
		}
		
		if(startRow == end.row && startCol == end.col) {
			
			Result result = new Result();
			Set<Coordinate> set = new LinkedHashSet<>();
			set.add(new Coordinate(startRow, startCol));
			result.path = set;
			result.pathExists = true;
			return result;
		}
		
		if(!isValidCoordinate(grid, startRow, startCol)) {
			Result result = new Result();
			result.pathExists = false;
			return result;
		}
		
		Result r1 = findPathIfExistsHelper(grid, startRow + 1, startCol, end);
		if(r1 != null && r1.pathExists) {
			r1.path.add(new Coordinate(startRow, startCol)); // while backtracking add coordinates to path
			return r1;
		}
		
		Result r2 = findPathIfExistsHelper(grid, startRow, startCol + 1, end);
		if(r2 != null && r2.pathExists) {
			r2.path.add(new Coordinate(startRow, startCol)); // while backtracking add coordinates to path
			return r2;
		}
		
		return null;
	}
	
	/**
	 * Find if path exists in grid between two points using BFS Algorithm.
	 * 
	 * @param grid
	 * @param start
	 * @param end
	 * @return boolean
	 */
	public static boolean findIfPathExistsUsingBFS(final int[][] grid, Coordinate start, final Coordinate end) {
		
		if(grid == null || start == null || end == null) {
			throw new IllegalArgumentException();
		}
		
		if(start.equals(end)) {
			return true;
		}
		
		Queue<Coordinate> queue = new LinkedList<>();
		queue.offer(start);
		
		Set<Coordinate> vistedSet = new HashSet<>();
		
		while(queue.peek() != null) {
			
			Coordinate c = queue.poll();
			
			if(c.equals(end)) {
				return true;
			}
			
			if(!vistedSet.contains(c)) {
				
				vistedSet.add(c);
				
				if(isValidCoordinate(grid, c.row, c.col + 1)) {
					queue.offer(new Coordinate(c.row, c.col + 1));
				}
				
				if(isValidCoordinate(grid, c.row + 1, c.col)) {
					queue.offer(new Coordinate(c.row + 1, c.col));
				}
			}
		}
		
		return false;
	}

	private static boolean isValidCoordinate(final int[][]grid, final int row, final int col) {
		
		if(grid == null) {
			throw new IllegalArgumentException();
		}
		
		if(row >= grid.length || col >= grid[0].length) {
			return false;
		}
		
		if(grid[row][col] == 1) {
			return true;
		}
		
		return false;
	}
	
	public static class Coordinate {
		
		private int row;
		private int col;
		
		public Coordinate(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if(obj == null) {
				return false;
			}
			
			if(obj.getClass() != this.getClass()) {
				return false;
			}
			
			Coordinate coordinate = (Coordinate) obj;
			if(this.row == coordinate.row && this.col == coordinate.col) {
				return true;
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			
			final int prime = 23;
			int hashCode = 3;
			
			hashCode = hashCode * prime + Integer.valueOf(row).hashCode();
			hashCode = hashCode * prime + Integer.valueOf(col).hashCode();
			
			return hashCode;
		}
		
		@Override
		public String toString() {
			return "[" + this.row + ", "+ this.col + "]";
		}
	}
	
	public static class Result {
		
		private boolean pathExists;
		private Set<Coordinate> path;
	}

	public static void main(String[] args) {
		
		final int[][] grid = new int[][] {
				{1, 1, 1, 1},
				{0, 1, 1, 0},
				{1, 0, 1, 1}
		};
		
		boolean pathExists = doesPathExist(grid, new Coordinate(0, 0), new Coordinate(grid.length - 1, grid[0].length - 1));
		System.out.println("Path exists between start and end of grid: " + pathExists);
		
		Result result = findPathIfExists(grid, new Coordinate(0, 0), new Coordinate(grid.length - 1, grid[0].length - 1));
		if(result != null && result.pathExists) {
			System.out.println("Path exists and below is the path:");
			Set<Coordinate> set = result.path;
			for(Coordinate coordinate : set) {
				System.out.print(coordinate + " <==> ");
			}
		} else {
			System.out.println("Path does not exist from start to end in grid!");
		}
		
		// test using BFS
		boolean pathExistsUsingBFS = findIfPathExistsUsingBFS(grid, new Coordinate(0, 0), new Coordinate(grid.length - 1, grid[0].length - 1));
		System.out.println("\nPath exists using BFS: " + pathExistsUsingBFS);
	}
}

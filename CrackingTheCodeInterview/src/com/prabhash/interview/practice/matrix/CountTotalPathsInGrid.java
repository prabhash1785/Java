package com.prabhash.interview.practice.matrix;

public class CountTotalPathsInGrid {
	
	/**
	 * Find total number of paths in a grid from top left to bottom right cell when you can only move left or right in the grid.
	 * 
	 * Time Complexity: Exponential
	 * 
	 * @param a
	 * @return
	 */
	public static int findTotalPaths(int[][] a) {
		
		if(a == null) {
			throw new IllegalArgumentException();
		}
		
		return findTotalPathsHelper(a, 0, 0);
	}
	
	private static int findTotalPathsHelper(int[][] matrix, int i, int j) {
		
		if(i >= matrix.length || j > matrix[0].length) {
			return 0;
		}
		
		if(i == matrix.length - 1 && j == matrix[0].length - 1) {
			return 1;
		}
		
		return findTotalPathsHelper(matrix, i, j + 1) + findTotalPathsHelper(matrix, i + 1, j);
	}
	
	/**
	 * Find all the possible paths in a grid from top left to bottom right cell.
	 * 
	 * @param grid
	 */
	public static void printPathsFromStartToEnd(int[][] grid) {
		
		Coordinate[] cells = new Coordinate[grid.length * grid[0].length]; // cells size equal to total cells in grid
		printPathsHelper(grid, 0, 0, cells, 0);
	}
	
	private static void printPathsHelper(int[][] grid, int m, int n, Coordinate[] paths, int cellCount) {
		
		if(m >= grid.length || n >= grid[0].length) {
			return;
		}
		
		paths[cellCount] = new Coordinate(m, n);
		cellCount++;
		
		if(m == grid.length - 1 && n == grid.length - 1) {
			printGridPaths(paths, cellCount);
		}
		
		printPathsHelper(grid, m, n + 1, paths, cellCount);
		printPathsHelper(grid, m + 1, n, paths, cellCount);
	}
	
	private static void printGridPaths(Coordinate[] path, int pathSize) {
		
		for(int i = 0; i < pathSize; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println("\n");
	}
	
	public static class Coordinate {
		
		private int x;
		private int y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	
	public static void main(String[] args) {
		int[][] grid = new int[3][3];
		
		int totalPathCount = findTotalPaths(grid); 
		System.out.println("Total number of paths: " + totalPathCount);	
		
		System.out.println("\nHere are possible paths in grid:");
		printPathsFromStartToEnd(grid);
	}
}

package com.prabhash.interview.practice.matrix;

/**
 * Count total number of islands in a given 2-dimensional grid. A group of connected ones
 * forms an island.
 * 
 * @author Prabhash Rathore
 *
 */
public class CountIslands {
	
	/**
	 * Group of connected ones is considered 1 island.
	 * 
	 * Algorithm:
	 * Go through the two dimensional grid, keeping track of visited cells. If you find a cell with value 1 then increment the
	 * island count by 1. Also mark all the connected cells as visited which are connected to this cell.
	 * 
	 * @param grid
	 * @return
	 */
	public static int findNumberOfIslands(int[][] grid) {
		if(grid == null) {
			return 0;
		}
		
		int islandCount = 0;
		int[][] visitedSet = new int[grid.length][grid[0].length];
		
		for(int i = 0; i < visitedSet.length; i++) {
			for(int j = 0; j < visitedSet[0].length; j++) {
				visitedSet[i][j] = 0;
			}
		}
		
		for(int m = 0; m < grid.length; m++) {
			for(int n = 0; n < grid[0].length; n++) {
				if(grid[m][n] == 1 && visitedSet[m][n] == 0) {
					islandCount++;
					markConnectedCellsAsVisited(grid, visitedSet, m , n);
				}
			}
		}
		
		return islandCount;
	}
	
	/**
	 * Mark all connected neighbors with value 1 as visited.
	 * 
	 * @param grid
	 * @param visitedSet
	 * @param m
	 * @param n
	 */
	private static void markConnectedCellsAsVisited(int[][] grid, int[][] visitedSet, int m , int n) {
		if(grid == null || visitedSet == null) {
			return;
		}
		
		// If out of bounds then return
		if(m < 0 || m >= grid.length || n < 0 || n >= grid[0].length) {
			return;
		}
		
		// Already visited then return
		if(visitedSet[m][n] == 1) {
			return;
		}
		
		// If not 1 then return
		if(grid[m][n] == 0) {
			return;
		}
		
		// mark this cell as visited
		visitedSet[m][n] = 1;
		
		// recursively visit all 8 neighbors
		markConnectedCellsAsVisited(grid, visitedSet, m - 1, n);
		markConnectedCellsAsVisited(grid, visitedSet, m + 1, n);
		markConnectedCellsAsVisited(grid, visitedSet, m, n - 1);
		markConnectedCellsAsVisited(grid, visitedSet, m, n + 1);
		markConnectedCellsAsVisited(grid, visitedSet, m - 1, n - 1);
		markConnectedCellsAsVisited(grid, visitedSet, m + 1, n + 1);
		markConnectedCellsAsVisited(grid, visitedSet, m - 1, n + 1);
		markConnectedCellsAsVisited(grid, visitedSet, m + 1, n - 1);
	}

	public static void main(String[] args) {
		
		int[][] grid = new int[][] {
				{1, 1, 0, 0, 0},
				{0, 1, 0, 0, 1},
				{1, 0, 0, 1, 1},
				{0, 0, 0, 0, 0},
				{1, 0, 1, 0, 1}	
		};
		
		int islandCount = findNumberOfIslands(grid);
		System.out.println("Island count is: " + islandCount);
	}
}

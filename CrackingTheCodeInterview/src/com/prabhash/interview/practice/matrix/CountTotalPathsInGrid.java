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
	
	public static void main(String[] args) {
		int[][] grid = new int[3][3];
		
		int totalPathCount = findTotalPaths(grid); 
		System.out.println("Total number of paths: " + totalPathCount);	
	}
}

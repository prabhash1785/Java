package com.prabhash.interview.practice.matrix;

/**
 * Pacman - Find number of connected dots starting from top left corner in a grid. Dots are considered
 * connected if it has at least one adjacent neighbor with 1 as a value.
 * 
 * @author Prabhash Rathore
 *
 */
public class PacmanFindNumberOfConnectedDots {

	/**
	 * Recursively find the number of connected cells in a grid. Also keep track of visted cells.
	 * Only movement allowed are: either horizontally or vertically not diagonally. 
	 * 
	 * @param a
	 * @return count
	 */
	public static int findNumberOfDotsInLine(final int[][] a) {
		
		int[][] vistedCells = new int[a.length][a[0].length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				vistedCells[i][j] = 0;
			}
		}
		
		int row = 0, col = 0;
		return findNumberOfDotsInLineHelper(a, row, col, vistedCells);
	}
	
	private static int findNumberOfDotsInLineHelper(int[][] a, int i, int j, int[][] vistedCells) {
		
		if(a == null) {
			return -1;
		}
		
		if(i >= a.length) {
			return 0;
		}
		
		if(j >= a[0].length) {
			return 0;
		}
		
		int count = 0;
		vistedCells[i][j] = 1;
		if(a[i][j] == 1) {
			count = 1;
		}
		
		if(i + 1 < a.length && vistedCells[i+1][j] != 1) {
			count += findNumberOfDotsInLineHelper(a, i + 1, j, vistedCells);
		} else if(i - 1 >= 0 && vistedCells[i - 1][j] != 1) {
			count += findNumberOfDotsInLineHelper(a, i - 1, j, vistedCells);
		} else if(j + 1 < a[0].length && vistedCells[i][j + 1] != 1) {
			count += findNumberOfDotsInLineHelper(a, i, j + 1, vistedCells);
		} else if(j - 1 >= 0 && vistedCells[i][j - 1] != 1) {
			count += findNumberOfDotsInLineHelper(a, i, j - 1, vistedCells);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		int[][] grid = new int[][] {
				{1, 1, 1, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 0},
				{0, 1, 1, 1, 0, 1, 0, 0},
				{0, 0, 0, 1, 0, 1, 0, 0},
				{0, 0, 0, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}
		};
		
		int count = findNumberOfDotsInLine(grid);
		System.out.println("Number of connected dots: " + count);
	}

}

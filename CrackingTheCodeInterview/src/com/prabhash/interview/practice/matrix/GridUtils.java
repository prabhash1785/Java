package com.prabhash.interview.practice.matrix;

public class GridUtils {
	
	public static void printGridElementsRecursivelu(int[][] a) {
		
		if(a == null) {
			return;
		}
		
		printGridElementsRecursively(a, 0, 0); 
	}
	
	private static void printGridElementsRecursively(int[][] a, int row, int col) {
		
		if(a == null) {
			return;
		}
		
		if(row >= a.length && col >= a[0].length) {
			return;
		} else if(row < a.length && col >= a[0].length) {
			col = 0;
			row++;
			System.out.println("\n");
		} else if(row >= a.length) {
			return;
		} else {
			System.out.print(a[row][col] + " ");
			col++;
		}
		
		printGridElementsRecursively(a, row, col);
	}
	
	/**
	 * Print Sprial of a Square Matrix
	 * 
	 * @param a
	 */
	public static void printSprialOfMatrix(final int[][] a) {
		
		if(a == null) {
			throw new NullPointerException();
		}
		int layer = 0, i = 0;
		int matrixSize = a.length;
		for(layer = 0; layer <= (matrixSize / 2); layer++) {
			
			for(i = layer; i < (matrixSize - layer - 1); i++) {
				System.out.print(a[layer][i] + " ");
			}
			
			for(i = layer; i < (matrixSize - layer - 1); i++) {
				System.out.print(a[i][matrixSize - layer - 1] + " ");
			}
			
			for(i = (matrixSize - layer - 1); i > layer; i--) {
				System.out.print(a[matrixSize - layer - 1][i] + " ");
			}
			
			for(i = (matrixSize -layer - 1); i > layer; i--) {
				System.out.print(a[i][layer] + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[][] grid = new int[][] {
				{2, 5, 1, 8, 9},
				{5, 23, 12, 3, 90},
				{12, 34, 91, 12, 87}
		};
		System.out.println("Here are grid elements:");
		printGridElementsRecursivelu(grid);
		
		int[][] squareMartix = new int[][] {
				{4, 9, 0, 2},
				{1, 12, 3, 18},
				{8, 6, 11, 20},
				{34, 23, 93, 81}
		};
		System.out.println("\nHere is sprial of matrix:\n");
		printSprialOfMatrix(squareMartix);
	}
}

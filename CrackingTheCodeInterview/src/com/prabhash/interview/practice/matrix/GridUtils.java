package com.prabhash.interview.practice.matrix;

public class GridUtils {
	
	public static void printGridElementsRecursivelu(int[][] a) {
		
		if(a == null) {
			return;
		}
		
		printGridElementsRecursivelu(a, 0, 0); 
	}
	
	private static void printGridElementsRecursivelu(int[][] a, int row, int col) {
		
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
		
		printGridElementsRecursivelu(a, row, col);
	}
	
	public static void main(String[] args) {
		
		int[][] grid = new int[][] {
				{2, 5, 1, 8, 9},
				{5, 23, 12, 3, 90},
				{12, 34, 91, 12, 87}
		};
		System.out.println("Here are grid elements:");
		printGridElementsRecursivelu(grid);
	}
}

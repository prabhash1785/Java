package com.prabhash.interview.practice.matrix;

public class PascalTriangle {
	
	public static void printPascalTriangle(int size) {
		if(size < 0) {
			throw new IllegalArgumentException();
		}
		
		int[][] matrix = new int[size][size];
		
		for(int row = 0; row < size; row++) {
			for(int col = 0; col <= row; col++) {
				if(col == 0) {
					matrix[row][col] = 1;
				} else if(col == row) {
					matrix[row][col] = 1;
				} else {
					int prevRow = row - 1;
					int prevCol1 = col - 1;
					int prevCol2 = col;
					if(prevRow >= 0 && prevCol1 >= 0) {
						matrix[row][col] = matrix[prevRow][prevCol1] + matrix[prevRow][prevCol2];
					}
				}
			}
		}
		
		System.out.println("Here is Pascal Triangle");
		for(int i = 0; i < size; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		printPascalTriangle(5);
	}
}

package com.prabhash.java.interview.ch1;

/**
 * If a row or col has a zero in a MxN matrix then set entire row and col to zero.
 * 
 * @author prrathore
 *
 */
public class Q1_7 {
	
	private static void setRowColToZero(int[][] matrix) {
		
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		
		int[] rowWithZero = new int[rowSize]; //track row index with zeroes
		int[] colWitZero = new int[colSize]; //track col index with zeroes
		
		// initialize row and col tracker arrays to -1
		for(int i = 0; i < rowSize; i++) {
			rowWithZero[i] = -1;
		}
		
		for(int i = 0; i < colSize; i++) {
			colWitZero[i] = -1;
		}
		
		int zeroElementTracker = 0; //index for zero counter arrays
		
		// first lets find row and col wit zeroes
		for(int i = 0; i < rowSize; i++) {
			for(int j = 0; j < colSize; j++) {
				if(matrix[i][j] == 0) {
					rowWithZero[zeroElementTracker] = i;
					colWitZero[zeroElementTracker] = j;
					zeroElementTracker++;
				}
			}
		}
		
		// set corresponding rows and cols to zero based on indexes tracked in row and col arrays
		for(int i = 0; i < zeroElementTracker; i++) {

			// set corresponding cols to zero
			for(int j = 0; j < colSize; j++) {
				matrix[rowWithZero[i]][j] = 0;
			}

			// set corresponding rows to zro
			for(int j = 0; j < rowSize; j++) {
				matrix[j][colWitZero[i]] = 0;
			}

		}

	}
	
	/**
	 * Pretty print a 2-D matrix.
	 * 
	 * @param matrix
	 */
	private static void prettyPrintMatrix(final int[][] matrix) {

		for(int i = 0; i < matrix.length; i++) {

			for(int j = 0; j < matrix[0].length; j++) {

				System.out.print(matrix[i][j] + "  ");

			}

			System.out.println("\n");

		}

	}

	public static void main(String[] args) {
		
		final int[][] input = {{2, 3, 4, 0}, {6, 0, 1, 3}, {8, 4, 7, 4}};
		
		System.out.println("Original Matrix:");
		prettyPrintMatrix(input);
		
		System.out.println("Updated Matrix with row and col as zero:");
		setRowColToZero(input);
		prettyPrintMatrix(input);
		
		
		

	}

}

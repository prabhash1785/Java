package com.prabhash.java.interview.ch1;

/**
 * Rotate a n x n matrix by 90 degree. 
 * 
 * @author prrathore
 *
 */
public class Q1_6 {
	
	/**
	 * Method 1 to rotate matrix by 90 degree.
	 * 
	 * Work in Progress...
	 * 
	 * @param input
	 * @return int[][]
	 */
	public static int[][] rotateMatrix(final int[][] input) {
		
		int rowSize = input[0].length;
		int colSize = input.length;
		
		final int[][] rotatedMatrix = new int[rowSize][colSize];
		
		
		
		return rotatedMatrix;
		
	}
	
	/**
	 * Method 2 to rotate matrix by 90 degree.
	 * 
	 * @param matrix
	 */
	public static void rotateMatrixMethod2(int[][] matrix) {
		
		int n = matrix.length;
		
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}

	private static void prettyPrintMatrix(final int[][] matrix) {
		
		for(int i = 0; i < matrix.length; i++) {
			
			for(int j = 0; j < matrix[0].length; j++) {
				
				System.out.print(matrix[i][j] + "  ");
				
			}
			
			System.out.println("\n");
			
		}
		
	}
	
	public static void main(String[] args) {
		
		final int MATRIX_ORDER = 4;
		
		final int[][] matrix = new int[MATRIX_ORDER][MATRIX_ORDER];
		
		int num = 1;
		
		//create a matrix
		for(int i = 0; i < MATRIX_ORDER; i++) {
			for(int j = 0; j < MATRIX_ORDER; j++) {
				matrix[i][j] = num++;
			}
		}
		
		System.out.println("Matrix before rotation: ");
		prettyPrintMatrix(matrix);
		
		System.out.println("\nMatrix after rotation: ");
		rotateMatrixMethod2(matrix);
		prettyPrintMatrix(matrix);
		
	}

}

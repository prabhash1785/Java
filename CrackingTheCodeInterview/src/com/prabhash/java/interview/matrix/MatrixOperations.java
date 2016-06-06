package com.prabhash.java.interview.matrix;

public class MatrixOperations {
	
	
	public static int[][] createNewSquareMatrix(int x) {
		return createNewMatrix(x, x);
	}
	
	public static int[][] createNewMatrix(int x, int y) {
		
		int[][] matrix = new int[x][y];
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				matrix[i][j] = 0;
			}
		}
		
		return matrix;
	}
	
	/**
	 * Create a simple 3x3 matrix. 
	 * 
	 *  1  2  3  4  

		5  6  7  8  

		9  0  1  2  
	 * 
	 */
	public static void createFirstMatrix() {
		
		int[][] a = new int[3][4];
		int value = 1;
		for(int i = 0; i < 3; i++) {

			for(int j = 0; j < 4; j++) {

				a[i][j] = value;
				value++;

				if(value > 9) {
					value = 0;
				}
			}
		}
		printMatrix(a);
	}
	
	/**
	 * -1  2  3  4  -5  

		1  -2  3  -4  5  

		1  2  3  4  5  

		1  -2  3  -4  5  

		-1  2  3  4  -5 
	 * 
	 */
	public static void createMatrixWithNegativeDiagonals() {
		
		// create matrix having each row going from 1 to 5
		int[][] matrix = new int[5][5];
		for(int i = 0; i < 5; i++) {
			
			int value = 1;
			for(int j = 0; j < 5; j++) {
				matrix[i][j] = value;
				value++;
			}
		}
		
		//Make all the elements in the first diagonal negative
		for(int i = 0; i < 5; i++) {
			matrix[i][i] = (-1) * matrix[i][i];
		}
		
		// Make other diagonal negative
		for(int i = 4, j = 0; i >= 0 && j < 5; i--, j++) {
				matrix[i][j] = (-1) * matrix[i][j];
		}
		
		printMatrix(matrix);
	}
	
	/**
	 * Create a spiral matrix with below pattern:
	 * 
	 *  1 2 3 4 5 

		6 0 0 0 6 

		5 0 0 0 7 

		4 0 0 0 8 

		3 2 1 0 9
	 * 
	 */
	public static void createSpriralMatrixInMoreThanOnePass() {
		
		int[][] a = createNewSquareMatrix(5);
		
		int value = 1;
		//set first row values
		for(int i = 0; i < 4; i++) {
			a[0][i] = value++;
		}
		
		for(int i = 0; i < 4; i++) {
			if(value > 9) {
				value = 0;
			}
			a[i][4] = value++;
		}
		
		for(int i = 4; i > 0; i--) {
			if(value > 9) {
				value = 0;
			}
			a[4][i] = value++;
		}
		
		for(int i = 4; i > 0; i--) {
			if(value > 9) {
				value = 0;
			}
			a[i][0] = value++;
		}
		
		printMatrix(a);
	}
	
	public static void createCircularSpriralMatrix() {
		
		int dimension = 4;
		int[][] a = createNewSquareMatrix(dimension);
		
		int value = 4;
		int layer = 0;
		while(layer < dimension / 2) {
			
			int row = layer, col = layer;
			for(int i = col; i < (dimension - layer - 1); i++) {
				a[row][i] = value;
			}
			
			for(int i = row; i < (dimension - layer - 1); i++) {
				a[i][dimension - layer] = value;
			}
			
			for(int i = dimension - layer; i > col; i--) {
				a[dimension - layer][i] = value;
			}
			
			for(int i = dimension - layer; i > row; i--) {
				a[i][col] = value;
			}
			
			layer++;
			value--;
		}
		
		printMatrix(a);
	}

	/**
	 * Pretty Print the given matrix.
	 * 
	 * @param a
	 */
	public static void printMatrix(int[][] a) {
		
		System.out.println("\n\nHere is the matrix:");
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {

		createFirstMatrix();
		createMatrixWithNegativeDiagonals();
		createSpriralMatrixInMoreThanOnePass();
		createCircularSpriralMatrix();
	}
}

package com.prabhash.interview.practice.matrix;

/**
 * Rotate MxN matrix by 90 degree.
 * 
 * @author Prabhash Rathore
 *
 */
public class RotateMatrix {
	
	/**
	 * Brute Force: Using quadratic extra space, rotate matrix by 90 degree.
	 * This solution simply copies each row of original matrix to column wise starting from end to the new matrix.
	 * 
	 * Time Complexity: O(n ^ 2)
	 * Space Complexity: O(n ^ 2)
	 * 
	 * @param a
	 * @return rotatedMatrix
	 */
	public static int[][] rotateMatrixBy90DegreeUsingExtraSpace(int[][] a) {
		if(a == null) {
			throw new NullPointerException();
		}
		
		int[][] rotatedMatrix = new int[a.length][a[0].length];
		for(int i = 0, col = a.length - 1; i < a.length && col >= 0; i++, col--) {
			for(int j = 0; j < a[0].length; j++) {
				rotatedMatrix[j][col] = a[i][j];
			}
		}
		return rotatedMatrix;
	}
	
	/**
	 * Rotate Matrix by 90 degree using constant space.
	 * 
	 * Time Complexity: O(n ^ 2)
	 * Space Complexity: O(1)
	 * 
	 * @param a
	 * @return a
	 */
	public static int[][] rotateMatrixUsingConstantSpace(int[][] a) {
		if(a == null) {
			throw new NullPointerException();
		}
		
		// Go one layer at a time
		for(int layer = 0; layer < a.length; ++layer) {
			int start = layer, end = a.length - layer - 1;
			
			for(int i = start; i < end; i++) {
				int offset = i - start;
				
				// save top to temp 
				int temp = a[start][i];
				
				// copy left to top
				a[start][i] = a[end - offset][start];
				
				// copy bottom to left
				a[end - offset][start] = a[end][end - offset];
				
				// copy right to bottom
				a[end][end - offset] = a[i][end];
				
				// copy top to right
				a[i][end] = temp;
			}
			
		}
		
		return a;
	}
	
	public static void printMatrix(final int[][]matrix) {
		if(matrix == null) {
			throw new NullPointerException();
		}
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		final int[][] a = new int[][] {
				{2, 5, 8, 10},
				{4, 7, 9, 12},
				{1, 6, 15, 20},
				{50, 60, 5, 200}
		};
		
		System.out.println("Original Matrix:");
		printMatrix(a);
		
		System.out.println("\nRotated Matrix:");
		int[][] rotatedMatrix = rotateMatrixBy90DegreeUsingExtraSpace(a);
		printMatrix(rotatedMatrix);
		
		System.out.println("\nRotated Matrix using constant space:");
		rotatedMatrix = rotateMatrixUsingConstantSpace(a);
		printMatrix(rotatedMatrix);
	}
}

package com.prabhash.java.interview.ch1;

/**
 * Rotate a n x n matrix by 90 degree. 
 * 
 * @author prrathore
 *
 */
public class Q1_6 {

	private static void prettyPrintMatrix(final int[][] matrix) {
		
		for(int i = 0; i < matrix[0].length; i++) {
			
			for(int j = 0; j < matrix.length; j++) {
				
				System.out.print(matrix[i][j] + "  ");
				
			}
			
			System.out.println("\n");
			
		}
		
	}
	
	public static void main(String[] args) {
		
		final int[][] matrix = new int[3][3];
		
		int num = 1;
		
		//create a matrix
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				matrix[i][j] = num++;
			}
		}
		
		System.out.println("Matrix before rotation: ");
		prettyPrintMatrix(matrix);
		
	}

}

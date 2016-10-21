package com.prabhash.interview.practice.matrix;

/**
 * Given a m x n matrix, calculate the perimeter of a square sub-matrix.
 * 
 * @author Prabhash Rathore
 *
 */
public class GetSquarePerimeterInMatrix {
	
	/**
	 * Starting from the given matrix position, go around the sub-square in matrix, adding value along each edge of square.
	 * 
	 * @param m
	 * @param i
	 * @param j
	 * @param squareLength
	 * @return perimeter
	 */
	public static int getPerimiterSum(int[][] m, int i, int j, int squareLength) {
		if(i < 0 || i >= m.length || j < 0 || j >= m[0].length || squareLength <= 1 || squareLength > (m.length - i) 
				|| squareLength > (m[0].length - i)) {
			throw new IllegalArgumentException();
		}
		
		int perimeter = 0;

		// calculate sum along top edge
		int counter = 0;
		while(counter < squareLength - 1) {
			perimeter += m[i][j];
			++j;
			++counter;
		}
		
		// calculate sum along right vertical edge
		counter = 0;
		while(counter < squareLength - 1) {
			perimeter += m[i][j];
			++i;
			++counter;
		}
		
		// calculate sum along bottom horizontal edge
		counter = 0;
		while(counter < squareLength - 1) {
			perimeter += m[i][j];
			--j;
			++counter;
		}
		
		// calculate sum along left vertical edge
		counter = 0;
		while(counter < squareLength - 1) {
			perimeter += m[i][j];
			--i;
			++counter;
		}
		
		return perimeter;
	}
	
	/**
	 * Optimized method to find perimeter for n queries where n <= 10 ^ 6.
	 * 
	 * Since there could be millions of perimeter queries on same matrix so we are pre-processing the matrix and calculating the
	 * cumulative sum of each row and col and then from these matrices, calculating perimeter by simply doing subtractions of
	 * cumulative sum from end and start cells along each edge of pre-processed squares.
	 * 
	 * It's complex and tedious to come up with exact indices from cumulative matrices so it needs a lot of calculation and care
	 * to prevent offset errors. 
	 * 
	 * Time Complexity: O(1)
	 *
	 * @param preProcessedRowMatrix
	 * @param preProcessedColMatrix
	 * @param i
	 * @param j
	 * @param squareLength
	 * @return perimeter
	 */
	public static int getPerimeterSumFromPreprocessedMatrix(int[][] preProcessedRowMatrix, int[][] preProcessedColMatrix,
			int i, int j, int squareLength) {
		
		int perimeter = 0;
		
		int topRowPerimeter = 0;
		if(j == 0) {
			topRowPerimeter = preProcessedRowMatrix[i][j + squareLength - 2];
		} else {
			topRowPerimeter =  preProcessedRowMatrix[i][j + squareLength - 2] - preProcessedRowMatrix[i][j - 1];
		}
		
		int rightColPerimter = 0;
		if(i == 0) {
			rightColPerimter = preProcessedColMatrix[i + squareLength - 2][j + squareLength - 1];
		} else {
			rightColPerimter = preProcessedColMatrix[i + squareLength - 2][j + squareLength - 2] - 
							preProcessedColMatrix[i - 1][j + squareLength - 1];
		}
		
		int bottomRowPerimeter = preProcessedRowMatrix[i + squareLength - 1][j + squareLength - 1] - 
				preProcessedRowMatrix[i + squareLength - 1][j];
		
		int leftColPerimeter = preProcessedColMatrix[i + squareLength - 1][j] - 
				preProcessedColMatrix[i][j];
		
		perimeter = topRowPerimeter + rightColPerimter + bottomRowPerimeter + leftColPerimeter;
		return perimeter;
	}
	
	/**
	 * Pre-process matrix to get cumulative sum along each row.
	 * 
	 * @param m
	 * @return cumulativeRowSumMatrix
	 */
	private static int[][] getMatrixWithCumulativeRowSum(int[][] m) {
		int[][] cumulativeRowSumMatrix = new int[m.length][m[0].length];
		
		// calculate cumulative sum along each row and store that in cumulativeRowSumMatrix
		for(int i = 0; i < m.length; i++) {
			int rowCumulativeSum = 0;
			for(int j = 0; j < m[0].length; j++) {
				rowCumulativeSum += m[i][j];
				cumulativeRowSumMatrix[i][j] = rowCumulativeSum;
			}
		}
		return cumulativeRowSumMatrix;
	}
	
	/**
	 * Pre-process matrix to get cumulative sum along each col.
	 * 
	 * @param m
	 * @return cumulativeColSumMatrix
	 */
	private static int[][] getMatrixWithCumulativeColSum(int[][] m) {
		int[][] cumulativeColSumMatrix = new int[m.length][m[0].length];
		
		// calculate cumulative sum along each col and store that in cumulativeColSumMatrix
		for(int j = 0; j < m[0].length; j++) {
			int colCumulativeSum = 0;
			for(int i = 0; i < m.length; i++) {
				colCumulativeSum += m[i][j];
				cumulativeColSumMatrix[i][j] = colCumulativeSum;
			}
		}
		return cumulativeColSumMatrix;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
				{4, 5, 7, 9, 2, 1},
				{7, 1, 0, 5, 2, 8},
				{8, 1, 2, 9, 7, 3},
				{1, 3, 1, 1, 2, 9},
				{0, 8, 4, 7, 1, 4}
		};
		
		int perimeterSum = getPerimiterSum(matrix, 0, 1, 4);
		System.out.println("Permiter sum of square of length 4 starting at position {0, 1} is: " + perimeterSum);
		
		// Method 2: Pre-process matrix to get cumulative sum along each row and col and then run n O(1) perimeter queries on these
		// pre-processed matrices
		int[][] cumulativeSumAlongRows = getMatrixWithCumulativeRowSum(matrix);
		int[][] cumulativeSumAlongCols = getMatrixWithCumulativeColSum(matrix);
		
		int perimeter = getPerimeterSumFromPreprocessedMatrix(cumulativeSumAlongRows, cumulativeSumAlongCols, 0, 1, 4); 
		System.out.println("Permiter sum of square of length 4 starting at position {0, 1} from pre-processed matrix is: " + perimeter);
	}

}

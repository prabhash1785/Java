package com.prabhash.java.matrix;

/**
 * Print a triangle as below:
 * 
 * 	    	*     

  	  	  * * *   

 		* * * * * 
 * 
 * @author prrathore
 *
 */
public class Triangle {
	
	public static void printTriangle(int row, int col) {
		
		int midCol = col/2;
		
		for(int i = 0; i < row; i++) {
			
			int first = midCol - i;
			int last = midCol + i;
			
			for(int j = 0; j < col; j++) {
				
				if(j < first || j > last) {
					System.out.print("  "); // if colIndex is not between first and last then just print double white space
				} else {
					System.out.print("*" + " ");
				}
				
			}
			
			System.out.println("\n");
			
		}
		
		
	}

	public static void main(String[] args) {
		
		printTriangle(3, 5);

	}

}

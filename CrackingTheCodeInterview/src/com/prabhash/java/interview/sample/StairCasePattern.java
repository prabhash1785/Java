package com.prabhash.java.interview.sample;

/**
 * Programmatically print following staircase pattern given number of steps n.
 * 
 *        	 #
      		##
     	   ###
    	  ####
   		 #####
  		######
 	   #######
	  ########
 * 
 * @author Prabhash Rathore
 *
 */
public class StairCasePattern {

	public static void printStairCase(int n) {

		for (int i = 0; i < n; i++) {
			int j = 0;
			while (j < (n - 1 - i)) {
				System.out.print(" ");
				j++;
			}
			while (j < n) {
				System.out.print("#");
				j++;
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		
		int n = 8;
		printStairCase(n);
	}
}

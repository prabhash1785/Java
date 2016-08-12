package com.prabhash.interview.practice.array;

/**
 * Print all possible sub-arrays for given array.
 * 
 * @author Prabhash Rathore
 *
 */
public class PrintAllSubArrays {
	
	public static void printAllSubArrays(int[] a) {
		if(a == null) {
			throw new NullPointerException();
		}
		
		for(int i = 0; i < a.length; i++) {
			for(int j = i; j < a.length; j++) {
				for(int k = i; k < j; k++) {
					System.out.print(a[k] + " ");
				}
				System.out.print("\n");
			}
		}
	}

	public static void main(String[] args) {
		final int[] a = new int[] {2, 4, 7, 8, 9, 10, 15, 20};
		System.out.println("Here are all sub-arrays of this array:");
		printAllSubArrays(a);
	}
}

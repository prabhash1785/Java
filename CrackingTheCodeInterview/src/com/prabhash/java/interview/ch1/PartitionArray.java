package com.prabhash.java.interview.ch1;

/**
 * Partition an array around a value x such that values less than x are on left and greater or equal values are on right side of x.
 * 
 * @author prrathore
 *
 */
public class PartitionArray {

	/**
	 * Partition is done as follows:
	 * - Create a new array which will store partitioned elements
	 * - Keep two pointers on new array, one starting left and other starting right. Left will store smaller elements and right will store
	 * greater or equal elements
	 * - Keep incrementing or decrementing left right index based on need.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param a
	 * @param x
	 * @return newarray
	 * @throws Exception
	 */
	public static int[] partitionArray(final int[] a, final int x) throws Exception {
		
		if(a == null || a.length == 0) {
			throw new Exception("Empty Array!!");
		}
		
		final int[] newArray = new int[a.length];
		
		// left and right pointers for new Array to store lesser and greater elements
		int leftIndex = 0;
		int rightIndex = a.length - 1;
		
		for(int i = 0; i < a.length; i++) {
			
			if(a[i] < x) {
				newArray[leftIndex] = a[i];
				leftIndex++;
			} else {
				newArray[rightIndex] = a[i];
				rightIndex--;
			}
			
		}
		
		return newArray;
		
	}
	
	private static void printArray(final int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		
		final int[] input = new int[] {7, 1, 12, 4, 20, 6};
		final int x = 5;
		
		System.out.println("Input Array:");
		printArray(input);
		
		int[] partitionedArray = null;
		
		try {
			partitionedArray = partitionArray(input, x);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\nHere is partitioned array:");
		printArray(partitionedArray);
		

	}

}

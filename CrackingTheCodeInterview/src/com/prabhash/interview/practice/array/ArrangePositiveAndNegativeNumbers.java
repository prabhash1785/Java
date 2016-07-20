package com.prabhash.interview.practice.array;

/**
 * Given an array of positive and negative numbers. Arrange the array such that negative numbers come before positive numbers.
 * Make sure relative position of numbers are kept intact. 
 * 
 * @author Prabhash Rathore
 *
 */
public class ArrangePositiveAndNegativeNumbers {

	/**
	 * Pass array two times. In first pass, store all negative numbers in new array and in second pass, store all positive numbers
	 * in new array. This will keep relative positions of array elements in the same order as original array.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param a
	 * @return newArray
	 */
	public static int[] arrangeNumbersUsingExtraSpace(final int[] a) {
		
		if(a == null) {
			throw new NullPointerException("Given array is null");
		}
		
		int[] newArray = new int[a.length];
		
		//first store all negative numbers
		int j = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] < 0) {
				newArray[j] = a[i];
				j++;
			}
		}
		
		// store all positive numbers
		for(int i = 0; i < a.length; i++) {
			if(a[i] >= 0) {
				newArray[j] = a[i];
				j++;
			}
		}
		
		return newArray;
	}
	
	public static void main(String[] args) {
		
		int[] a1 = new int[] {12, 11, -13, -5, 6, -7, 5, -3, -6};
		System.out.println("Original array:");
		for(int i : a1) {
			System.out.print(i + " ");
		}
		
		int[] modifiedArray = arrangeNumbersUsingExtraSpace(a1);
		System.out.println("\nModified array:");
		for(int i : modifiedArray) {
			System.out.print(i + " ");
		}
	}
}

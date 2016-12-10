package com.prabhash.interview.practice.array;

import java.util.Arrays;

/**
 * Perform minimum delete operations to make all elements in an array same.
 * 
 * @author Prabhash Rathore
 *
 */
public class MinDeleteOperationToMakeAllElementsSame {
	
	/**
	 * Sort the array and then find element with max count by passing through the array. Then minimum elemnet to be deleted must
	 * be the difference of array.length - maxElementFrequency.
	 * 
	 * Time Complexity: O(n + n logn) = O(n logn)
	 * Space Complexity: O(1)
	 * 
	 * @param a
	 * @return a.length - maxFrequency
	 */
	public static int minDeleteOperationsUsingSorting(int[] a) {
		if(a == null || a.length == 0) {
			return 0;
		}
		
		Arrays.sort(a);
		
		int elementWithMaxFrequency = Integer.MIN_VALUE;
		int maxFrequency = 0;
		
		for(int i = 0; i < a.length; i++) {
			int currentElement = a[i];
			int currentFrequency = 1;
			
			while(i < (a.length - 1) && a[i] == a[i+1]) {
				currentFrequency++;
				i++;
			}
			
			if(currentFrequency > maxFrequency) {
				maxFrequency = currentFrequency;
				elementWithMaxFrequency = currentElement;
			}
		}
		
		return (a.length - maxFrequency);
	}
	
	/**
	 * Using a sorted map, find the element with max frequency. This can be done in linear time and then min element to be deleted
	 * can be calculated by subtracting maxFrequency from array.length.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param a
	 * @return a.length - maxFrequency
	 */
	public static int findMinElementToBeDeltedUsingExtraMemory() {
		// TODO: Complete this method
		return 0;
	}

	public static void main(String[] args) {
		final int[] a = new int[] {4, 3, 4, 4, 2, 4};
		System.out.println("Min element to be deleted = " + minDeleteOperationsUsingSorting(a));
		
		final int[]b = new int[] {1, 2, 3, 4, 5};
		System.out.println("Min element to be deleted = " + minDeleteOperationsUsingSorting(b));
	}

}

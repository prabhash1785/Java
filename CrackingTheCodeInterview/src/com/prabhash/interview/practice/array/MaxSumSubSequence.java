package com.prabhash.interview.practice.array;

/**
 * Find max sum of contiguous sub-sequence in a given array of positive and
 * negative numbers.
 * 
 * @author Prabhash Rathore
 *
 */
public class MaxSumSubSequence {

	/**
	 * Only finds the max sum in a given sequence of positive and negative numbers.
	 * 
	 * Algo:
	 * - Keep a temporary sum of sub-sequence and a max sum which represents actual max sum.
	 * - If sum < 0, then reset sum = 0 as we don't wanna carry forward with a sub-sequence which sum is < 0
	 * - If sum > maxSum then set maxSum = sum 
	 * 
	 * @param list
	 */
	public static void findMaxSumSubSequence(int[] list) {

		if (list == null || list.length == 0) {
			throw new IllegalArgumentException(
					"Either array is null or there is no element in array");
		}

		int sum = 0;
		int maxSum = 0;

		for (int i = 0; i < list.length; i++) {

			sum = sum + list[i];

			if (sum > maxSum) {
				maxSum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}

		System.out.println("Max sum is: " + maxSum);
		
	}

	/**
	 * In addition to finding maxSum of sequence, find start and end index of that sequence too.
	 * 
	 * Start and End index can be found as follows:
	 * - Keep actual start and end index variables in addition to a temporary start index.
	 * - At the start of loop, if sum == 0 then set tempStartIndex = i
	 * - When sum > maxSum, do following
	 * 		maxSum = sum
	 * 		startIndex = tempStartIndex
	 * 		endIndex = i
	 * 		
	 * @param list
	 */
	public static void findMaxSumSubSequenceWithIndexes(int[] list) {

		if (list == null || list.length == 0) {
			throw new IllegalArgumentException(
					"Either array is null or there is no element in array");
		}

		int sum = 0;
		int maxSum = 0;

		int startIndex = -1;
		int endIndex = -1;

		int tempStartIndex = -1; // used to hold temporarily start index of potential sub-sequences

		for (int i = 0; i < list.length; i++) {

			if (sum == 0) {
				tempStartIndex = i;
			}

			sum = sum + list[i];

			if (sum > maxSum) {
				maxSum = sum;
				startIndex = tempStartIndex;
				endIndex = i;
			} else if (sum < 0) {
				sum = 0;
			}
		}

		System.out.println("Max sum is: " + maxSum);
		System.out.println("Start Index: " + startIndex + " ::: End Index: "
				+ endIndex);

	}

	public static void main(final String[] args) {

		int[] array = new int[] { 5, -9, 6, -2, 3 };

		findMaxSumSubSequence(array);
		findMaxSumSubSequenceWithIndexes(array);

	}

}

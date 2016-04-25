package com.prabhash.interview.practice.array;

/**
 * Find subarray with given sum
 * Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
 * 
 * @author prrathore
 *
 */
public class FindConsecutiveArrayWithGivenSum {
	
	/**
	 * Find consecutive numbers in given array whose sum is equal to given sum.
	 * 
	 * Brute Force: For each number in the array, try to find all the sub-sequence whose sum could be equal to the given sum.
	 * 
	 * Time Complexity: O(n ^ 2)
	 * 
	 * @param a
	 * @param sum
	 */
	public static void findConsecutiveArrayWithGivenSumNonOptimized(final int[] a, final int sum) {
		
		if(a == null) {
			throw new IllegalArgumentException();
		}
		
		int tempSum = 0;
		for(int i = 0; i < a.length - 1; i++) {
			
			tempSum = a[i];
			
			for(int j = i + 1; j < a.length; j++) {
				
				if(tempSum == sum) {
					printArray(a, i, j - 1); // (j - 1) because jth number is not added to tempSum yet
					return;
				}
				
				tempSum += a[j];
			}
		}
		
		System.out.println("Such a sub-sequence does not exist");
	}
	
	/**
	 * Method 2: This is the optimized way to find consecutive numbers using given sum.
	 * 
	 * Maintain a tempSum and start position and keep adding next subsequent number. If tempSum > givenSum then keep subtracting the start 
	 * position number from tempSum, keep moving start to next position and do make sure you compare tempSum to sum everytime you subtract
	 * start position number. If tempSum is equal to sum then return the given numbers. If tempSum is less than given sum then 
	 * keep adding next subsequent numbers.
	 * 
	 * This method does not work if there are negative numbers in the array.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param a
	 * @param givenSum
	 */
	public static void findConsecutiveNumberSumOptimized(final int[] a, final int givenSum) {
		
		if(a == null) {
			throw new IllegalArgumentException();
		}
		
		int tempSum = 0;
		int start = 0;
		for(int i = 0; i < a.length; i++) {
			
			tempSum += a[i];
			
			if(tempSum == givenSum) {
				
				printArray(a, start, i);
				return;
			} else if(tempSum > givenSum) {
				
				// It's possible that tempSum may have become a really large number so keep subtracting numbers starting from start
				// position until it's lower than given sum. Do check when tempSum becomes equal to given sum every time you subtract a 
				// start position number.
				// Each number in this inner loop can be accessed a max of 2 times so it's still linear time complexity not quadratic. 
				while(tempSum > givenSum && start < i) { // move start only upto i
					tempSum = tempSum - a[start];
					start++;
					
					if(tempSum == givenSum) {
						printArray(a, start, i);
						return;
					}
				}
			} 
		}
		
		System.out.println("Such a sub-sequence does not exist");
	}
	
	private static void printArray(final int[] a, int start, int end) {
		
		System.out.println("Found Sum:");
		for(int i = start; i <= end; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println("\n");
	}

	public static void main(String[] args) {
		
		// test case 1
		int[] array = new int[] {5, 7, 3, 12, 19};
		int givenSum = 22;
		
		findConsecutiveArrayWithGivenSumNonOptimized(array, givenSum);
		findConsecutiveNumberSumOptimized(array, givenSum);
		
		// test case 2
		array = new int[] {4, 1, 8, 20, 15, 6, 13};
		givenSum = 49;
		
		findConsecutiveArrayWithGivenSumNonOptimized(array, givenSum);
		findConsecutiveNumberSumOptimized(array, givenSum);
	}
}

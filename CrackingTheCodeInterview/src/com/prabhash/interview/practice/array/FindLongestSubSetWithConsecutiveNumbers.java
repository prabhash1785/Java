package com.prabhash.interview.practice.array;

import java.util.Arrays;

/**
 * Find longest subset with consecutive numbers.
 * 
 * @author Prabhash Rathore
 *
 */
public class FindLongestSubSetWithConsecutiveNumbers {
	
	/**
	 * To find the longest subset with consecutive numbers, first sort the array and then check if consecutive numbers in array
	 * differ by 1, if they do then they are consecutive, increment count by 1
	 * 
	 * Time Complexity: O(nlogn + n) => O(nlogn)
	 * 
	 * @param a
	 * @return maxLength
	 */
	public static int getSizeOfLongestConsecutiveSubset(int[] a) {
		if(a == null) {
			return 0;
		}
		
		int maxLength = 0;
		Arrays.sort(a); // Sort the array. Time Complexity: O(n logn)
		
		for(int i = 1; i < a.length; i++) {
			int count = 1;
			while(i < a.length && (a[i] - a[i - 1]) == 1) {
				++count;
				++i;
			}
			if(count > maxLength) {
				maxLength = count;
			}
		}
		
		return maxLength;
	}

	public static void main(String[] args) {
		int[] a = new int[] {3, -2, 7, 9, 8, 1, 2, 0, -1, 5, 8};
		System.out.println("Largest subset length with consecutive numbers: " + getSizeOfLongestConsecutiveSubset(a));
	}

}

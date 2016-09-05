package com.prabhash.interview.practice.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
	
	/**
	 * Optimized method to find longest subset of consecutive numbers.
	 * 
	 * Store all numbers in a set. While set is not empty, remove one number from set and find all consecutive numbers in set both which are
	 * lower and higher. Make sure to remove numbers once they are found. Keep updating maxCount if you find a subset longer than maxCount.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param a
	 * @return maxCount
	 */
	public static int findLongestSubSetLengthWithConsecutiveNumbersOptimized(int[] a) {
		if(a == null) {
			return 0;
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		
		int maxCount = 0;
		while(!set.isEmpty()) {
			int num = set.iterator().next();
			set.remove(num);
			
			int count = 1;
			int lowerNum = num - 1;
			int higherNum = num  + 1;
			while(set.contains(lowerNum)) {
				++count;
				set.remove(lowerNum);
				--lowerNum;
			}
			
			while(set.contains(higherNum)) {
				++count;
				set.remove(higherNum);
				++higherNum;
			}
			
			if(count > maxCount) {
				maxCount = count;
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		int[] a = new int[] {3, -2, 7, 9, 8, 1, 2, 0, -1, 5, 8};
		System.out.println("Largest subset length with consecutive numbers: " + getSizeOfLongestConsecutiveSubset(a));
		
		System.out.println("Largest subset length: " + findLongestSubSetLengthWithConsecutiveNumbersOptimized(a));
	}

}

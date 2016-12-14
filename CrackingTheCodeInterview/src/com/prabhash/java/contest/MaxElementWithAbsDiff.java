package com.prabhash.java.contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Given an array of integers, find and print the maximum number of integers you
 * can select from the array such that the absolute difference between any two
 * of the chosen integers is <= 1.
 * 
 * For example:
 * Input 1:
 * 6
 * 4 6 5 3 3 1
 * Output: 3
 * 
 * Input 2:
 * 6
 * 1 2 2 3 1 2
 * Output: 5
 * 
 * @author Prabhash Rathore
 *
 */
public class MaxElementWithAbsDiff {

	/**
	 * Metod 1: Non-Optimzed
	 * 
	 * For each number in the array, iterate over all the elements in the array as a nested loop and then find numbers whose
	 * absolute difference is 1. The tricky part is to maintain a Sorted Set where you keep track of lowest and highest elements
	 * because to count any number as a valid number you have to make sure this number's absolute difference is no more than 1
	 * compared to already picked numbers.
	 * 
	 * As a minor optimization, also maintain a visited Set so that we don't repeat operation for the same number as it will result in
	 * same count at the cost of extra iterations.
	 * 
	 * Time Complexity: O(n ^ 2)
	 * 
	 * @param a
	 * @return int
	 */
	public static int maxElementsWithAbsDiffLessThanEqualTo1(int[] a) {
		if (a == null || a.length == 0) {
			return 0;
		}

		int maxCount = 0;
		SortedSet<Integer> sortedSet = null;
		Set<Integer> visitedElements = new HashSet<>();

		for (int i = 0; i < a.length; i++) {
			if (visitedElements.contains(a[i])) {
				continue;
			}

			visitedElements.add(a[i]);
			sortedSet = new TreeSet<>();
			sortedSet.add(a[i]);
			int count = 1;

			for (int j = 0; j < a.length; j++) {
				if (j == i) {
					continue;
				}

				if (sortedSet.size() == 1
						&& Math.abs(a[j] - sortedSet.first()) <= 1) {
					sortedSet.add(a[j]);
					count++;
				} else if ((Math.abs(a[j] - sortedSet.first()) <= 1)
						&& (Math.abs(a[j] - sortedSet.last()) <= 1)) {
					sortedSet.add(a[j]);
					count++;
				}
			}

			if (count > maxCount) {
				maxCount = count;
			}
		}

		return maxCount;
	}
	
	/**
	 * Method 2: Optimized
	 * 
	 * Sort the array and then check if consecutive numbers have absolute difference as 1. If yes then increment count else move on
	 * to the next number.
	 * 
	 * Time Complexity: O(n log n)
	 * 
	 * @param a
	 * @return int
	 */
	public static int maxElementCountWithAbsDiffLessThanEqualTo1Optimized(int[] a) {
		if(a == null || a.length == 0) {
			return 0;
		}
		
		Arrays.sort(a);
		int maxCount = 0;
		
		for(int i = 0; i < a.length; i++) {
			int count = 1;
			int nextIndex = -1;
			
			int j = i + 1;
			while(j < a.length && Math.abs(a[j] - a[i]) <= 1) {
				if(nextIndex == -1 && a[j] != a[i]) {
					nextIndex = j;
				}
				
				++count;
				++j;
			}
			
			if(count > maxCount) {
				maxCount = count;
			}
			
			i = Math.max(i, nextIndex); // let's start from nextIndex now which is the next number
		}
		
		return maxCount;
	}
	
	/**
	 * Method 3: Optimized
	 * Store each number in given array in a SortedMap with it's corresponding frequency. Iterate through map, checking consecutive
	 * numbers if they absolute diff is 1. If trye then update maxCount = their corresponding frequencies. Iterate through through
	 * remaining entries in the map.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param a
	 * @return maxCount
	 */
	public static int findMaxNumbersWithAbsoluteDiff1UsingExtraSpace(int[] a) {
		if(a == null || a.length == 0) {
			return 0;
		}
		
		int maxCount = 1; // at least there will always be 1 numebr with diff <= 1 
		
		//add these array numbers into a Sorted Map with numebr as key and value as frequency
		SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
		for(int i = 0; i < a.length; i++) {
			if(sortedMap.containsKey(a[i])) {
				sortedMap.put(a[i], sortedMap.get(a[i]) + 1);
			} else {
				sortedMap.put(a[i], 1);
			}
		}
		
		while(!sortedMap.isEmpty()) {
			int firstKey = sortedMap.firstKey();
			int firstValue = sortedMap.get(firstKey);
			sortedMap.remove(firstKey, firstValue);
			
			if(!sortedMap.isEmpty()) {
				int secondKey = sortedMap.firstKey();
				int secondValue = sortedMap.get(secondKey);
				
				if(secondKey - firstKey <= 1) {
					maxCount = Math.max(maxCount, secondValue + firstValue);
				}
			} else {
				maxCount = Math.max(maxCount, firstValue);
			}
		}
		
		return maxCount;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		
		in.close();

		int count = maxElementsWithAbsDiffLessThanEqualTo1(a);
		System.out.println("Count = " + count);
		
		int count2 = maxElementCountWithAbsDiffLessThanEqualTo1Optimized(a);
		System.out.println("Count = " + count2);
		
		int count3 = findMaxNumbersWithAbsoluteDiff1UsingExtraSpace(a);
		System.out.println("Count = " + count3);
	}
}

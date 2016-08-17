package com.prabhash.interview.practice.sort;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Merge given two sorted arrays. The resulting array should not have any duplicates.
 * 
 * @author Prabhash Rathore
 *
 */
public class MergeTwoSortedArraysAndRemoveDuplicates {
	
	/**
	 * Merge two sorted arrays and remove any duplicate elements before returning merged array. 
	 * 
	 * Create a new array of size [a.length + b.length]. Compare array a and b elements and add it to array c based on whichever is smaller
	 * first. After merge, run two pointers and remove duplicates by comparing subsequent elements.
	 * 
	 * Time Complexity: O(m + n)
	 * 
	 * @param a
	 * @param b
	 * @return c
	 */
	public static int[] mergeArraysAndRemoveDuplicates(int[] a, int[] b) {
		if(a == null || b == null) {
			throw new NullPointerException();
		}
		
		int[] c = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		
		while(i < a.length && j < b.length) {
			if(a[i] < b[j]) {
				c[k] = a[i];
				++i;
			} else {
				c[k] = b[j];
				++j;
			}
			++k;
		}
		
		while(i < a.length) {
			c[k] = a[i];
			++i;
			++k;
		}
		
		while(j < b.length) {
			c[k] = b[j];
			++j;
			++k;
		}
		
		// Remove duplicates from array by using two indexes in linear time
		int slow = 0, fast = 1;
		while(fast < c.length) {
			if(c[slow] == c[fast]) {
				++fast;
			} else {
				c[slow + 1] = c[fast];
				++slow;
				++fast;
			}
		}
		
		// reset remaining elements to zero at the end of the array as array will have older elements left after removing duplicates
		// at the end
		while(++slow < c.length) {
			c[slow] = 0;
		}
		
		return c;
	}
	
	/**
	 * Method 2:
	 * Use a LinkedHashSet data structure property to merge two given sorted arrays and eliminate duplicates from being added to the set.
	 * 
	 * Time Complexity: O(m + n)
	 * Space Complexity: O(m + n)
	 * 
	 * @param a
	 * @param b
	 * @return c
	 */
	public static final int[] mergeArraysAndRemoveDuplicatesUsingSet(int[] a, int[] b) {
		if(a == null || b == null) {
			throw new NullPointerException();
		}
		
		// This data structure will maintain order and eliminate duplicates
		Set<Integer> set = new LinkedHashSet<>();
		int i = 0, j = 0;
		while(i < a.length && j < b.length) {
			if(a[i] < b[j]) {
				set.add(a[i]);
				++i;
			} else {
				set.add(b[j]);
				++j;
			}
		}
		
		while(i < a.length) {
			set.add(a[i]);
			++i;
		}
		
		while(j < b.length) {
			set.add(b[j]);
			++j;
		}
		
		// Move elements from set to an array
		int[] c = new int[set.size()];
		int k = 0;
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext()) {
			c[k++] = iterator.next();
		}
		
		return c;
	}

	public static void main(String[] args) {
		final int[] a = new int[] {2, 2, 6, 8, 9, 12, 15};
		final int[] b = new int[] {3, 5, 5, 8, 8, 10, 15, 20};
		
		int[] c = mergeArraysAndRemoveDuplicates(a, b);
		System.out.println("Merged arrays:");
		for(int i : c) {
			System.out.print(i + " ");
		}
		
		int[] d = mergeArraysAndRemoveDuplicatesUsingSet(a, b);
		System.out.println("\nMerged arrays using set:");
		for(int i : d) {
			System.out.print(i + " ");
		}
	}
}

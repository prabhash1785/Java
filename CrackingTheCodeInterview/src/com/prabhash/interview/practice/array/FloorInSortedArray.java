package com.prabhash.interview.practice.array;

/**
 * Find highest possible floor of a given number available in Sorted Array.
 * 
 * @author Prabhash Rathore
 *
 */
public class FloorInSortedArray {
	
	/**
	 * Iterate through array and keep track of number which is less than equal to x but it is greatest floor of x.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param a
	 * @param x
	 * @return result
	 */
	public static int floorInSortedArray(int[] a, int x) {
		if(a == null) {
			throw new NullPointerException();
		}
		
		// Optimization: if first number is greater than x then there won't any floor of x in this array
		if(a[0] > x) {
			return -1;
		}
		
		// Optimization: if last number is less than equal to x then this is the highest floor of x
		if(a[a.length - 1] <= x) {
			return a[a.length - 1];
		}
		
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++) {
			if(a[i] <= x && result < a[i]) {
				result = a[i];
			}
		}
		
		return result;
	}
	
	/**
	 * Since array is sorted, use binary search to find the highest floor of x available in given array.
	 * 
	 * Time Complexity: O(log n)
	 * 
	 * @param a
	 * @param x
	 * @return floor
	 */
	public static int findFloorUsingBinarySearch(int[] a, int x) {
		if(a == null) {
			throw new NullPointerException();
		}
		
		// Optimization: if first number is greater than x then there won't any floor of x in this array
		if(a[0] > x) {
			return -1;
		}
		
		// Optimization: if last number is less than equal to x then this is the highest floor of x
		if(a[a.length - 1] <= x) {
			return a[a.length - 1];
		}
		
		int start = 0;
		int end = a.length - 1;
		int floor = Integer.MIN_VALUE;
		while(start <= end) {
			int mid = start + ((end - start) / 2);
			if(a[mid] <= x) {
				floor = Math.max(a[mid], floor);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return floor;
	}

	public static void main(String[] args) {
		int a[] = new int[] {1, 2, 8, 10, 10, 12, 19};
		int x = 5;
		
		System.out.println("Floor of x is: " + floorInSortedArray(a, x));
		System.out.println("Floor of x using Binary Search algorithm: " + findFloorUsingBinarySearch(a, x));
	}
}

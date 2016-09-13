package com.prabhash.java.interview.search;

/**
 * Given a sorted array which is rotated k times. Find a number in this sorted array in logarithmic time.
 * 
 * For example:
 * 4, 7, 9, 10, 45, 89 => 45, 89, 4, 7, 9, 10   
 * 7 => index 3
 * 
 * @author Prabhash Rathore
 *
 */
public class BinarySearchInRotatedSortedArray {
	
	/**
	 * Since the array is sorted, we can use Binary Search to find the number in the array. However since the array is rotated so there
	 * should be a pivot in array around which the array is rotated. In the first pass, find this pivot around which the array is rotated.
	 * Then apply binary search to these two halves of the array - one from 0 to pivotIndex and other from (pivotIndex + 1) to end.
	 * 
	 * @param a
	 * @param n
	 * @return numIndex
	 */
	public static int binarySearchInRotatedArray(int[] a, int n) {
		if(a == null) {
			return -1;
		}
		
		int arrayPivot = findPivot(a); // find pivot around which the array is rotated
		int numIndex = binarySearch(a, 0, arrayPivot, n);
		if(numIndex == -1) {
			numIndex = binarySearch(a, arrayPivot + 1, a.length - 1, n);
		}
		return numIndex;
	}
	
	private static int findPivot(int[] a) {
		if(a == null) {
			return -1;
		}
		
		int start = 1;
		while(a[start] > a[start - 1]) {
			++start;
		}
		
		return start - 1;
	}
	
	public static int binarySearch(int[] a, int start, int end, int num) {
		if(a == null) {
			return -1;
		}
		
		while(start <= end) {
			int mid = (start + end) / 2;
			if(a[mid] == num) {
				return mid;
			} else if(num < a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] rotatedSortedArray = new int[] {
				45, 89, 4, 7, 9, 10
		}; 

		System.out.println("Index of 7 is: " + binarySearchInRotatedArray(rotatedSortedArray, 7));
		System.out.println("Index of 89 is: " + binarySearchInRotatedArray(rotatedSortedArray, 89));
		System.out.println("Index of 100 is: " + binarySearchInRotatedArray(rotatedSortedArray, 100));
	}

}

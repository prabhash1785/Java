package com.prabhash.interview.practice.sort;

/**
 * 
 * Merge Sort uses Divide and Conquer algorithm to sort arrays. 
 * Process - First sort left half, sort right half and then merge both halves. Repeat this process until each sub array has one element which
 * is sorted on it's own. Then merge these sorted sub-arrays to get the final sorted array.
 * Properties of Merge Sort:
 * 		- Stable Sort (Maintains the input order of equal elements in sorted array)
 * 		- This is used to sort a Linked-List.
 * 		- Used for Collections.sort() in Java.
 * 		- Merge Sort's merge operation is useful in Online Sorting.
 * Best Time Complexity = O(nlog(n))
 * Worst Time Complexity = O(nlog(n))
 * Space complexity = O(n)
 * @author Prabhash Rathore 
 *
 */
public class MergeSort {
	
	public static void mergeSort(int[] a) {
		
		if(a == null) {
			throw new NullPointerException("Array is null");
		}
		
		if(a.length < 2) {
			return;
		}
		
		mergeSortHelper(a, 0, a.length - 1);
		
	}
	
	private static void mergeSortHelper(int[] list, int start, int end) {
		
		if(start < end) {
			
			int mid = (start + end) / 2;
			mergeSortHelper(list, start, mid);
			mergeSortHelper(list, mid + 1, end);
			
			merge(list, start, mid, end);
			
		}
		
	}
	
	private static void merge(int[] a, int start, int mid, int end) {
		
		int[] helper = new int[a.length]; // helper array needed to merge sorted arrays
		
		for(int i = start; i <= end; i++) {
			helper[i] = a[i];
		}
		
		int i = start, j = mid + 1, k = start;
		
		while(i <= mid && j <= end) {
			
			if(helper[i] < helper[j]) {
				a[k] = helper[i];
				i++;
				k++;
			} else {
				a[k] = helper[j];
				j++;
				k++;
			}
			
		}
		
		while(i <= mid) {
			a[k] = helper[i];
			k++;
			i++;
		}
		
		while(j <= end) {
			a[k] = helper[j];
			k++;
			j++;
		}
		
	}

	public static void main(String[] args) {
		
		// int[] input = new int[] {12, 2, 17, 1, 5, 10};
		int[] input = new int[] {6, 5, 3, 1, 8, 7, 2, 4, 45, 12, 67, 39, 89};
		
		mergeSort(input);
		
		System.out.println("Sorted array:");
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}

	}

}

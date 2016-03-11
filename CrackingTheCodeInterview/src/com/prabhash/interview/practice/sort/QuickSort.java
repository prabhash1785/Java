package com.prabhash.interview.practice.sort;

/**
 * 
 * Quicksort, or partition-exchange sort, is a sorting algorithm developed by Tony Hoare that, on average, makes O(n log n) comparisons to sort n items. It's
 * a Divide and Conquer Algorithm.
 * 
 * In Quick Sort, we pick a random element called pivot and partition the array such that all numbers that are less than the partitioning element
 * comes before all elements that are greater than it. Repeated partition of the array and it's sub-arrays around an element eventually sorts the array.
 * 
 * Properties of Quick Sort:
 * 		- Since the partitioned element is not guaranteed to be the median or anywhere near the median, this can make Quick Sort sorting slow and in these cases
 * 		  time complexity could be O(n ^ 2)
 * 		- Before starting the quick sort, shuffle the algorithm for higher performance guarantee.
 * 		- This is a non-stable sort.
 * 		
 * Application:
 * 		- Java's Arrays.sort() uses Quick Sort algorithm.
 *  
 * Best Time Complexity = O(nlog(n))
 * Worst Time Complexity = O(n^2)
 * Space complexity = O(n) auxiliary naive
 * Space complexity = O(log n) auxiliary (Sedgewick 1978) [Used by the System Stack for Recursion]  
 * @author Prabhash Rathore 
 *
 */
public class QuickSort {
	
	public static void sort(int[] a) throws Exception {
		
		if(a == null) {
			throw new Exception("Array is null");
		}
		
		if(a.length < 2) {
			System.out.println("Array of less that 2 elements. It is already sorted.");
			return;
		}
		
		quickSort(a, 0, a.length - 1);
		
	}
	
	private static void quickSort(int[] list, int start, int end) {
		
		if(start < end) {
			
			int pivot = getPivot(list, start, end);
			
			quickSort(list, start, pivot - 1); //Pass (pivot - 1)
			
			quickSort(list, pivot, end); //Make sure to pass pivot not (pivot + 1)
					
		}
		
	}
	
	private static int getPivot(int[] array, int start, int end) {
		
		int pivot = array[(start + end) / 2];
		
		while(start <= end) {
			
			while(array[start] < pivot) {
				start++;
			}
			
			while(array[end] > pivot) {
				end--;
			}
			
			//swap elements if left hand side elements are greater than pivot or right hand side elements are smaller than pivot
			if(start <= end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				
				start++;
				end--;
			}
			
		}
		
		return start; //return start not pivot
		
	}

	public static void main(String[] args) throws Exception {
		
		final int[] array = new int[] {18, 14, 4, 9, 12, 7};
		
		sort(array);
		
		System.out.println("Sorted array:");
		for(int i : array) {
			System.out.print(i + " ");
		}

	}

}

package com.prabhash.interview.practice.sort;

/**
 * Insertion Sort
 * 
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(1)
 * 
 * @author prrathore
 *
 */
public class InsertionSort {
	
	public static void insertionSort(int[] a) {
		
		if(a == null) {
			throw new NullPointerException("Array is null");
		}
		
		for(int i = 1; i < a.length; i++) {
			
			int num = a[i]; // make sure a[i] is stored in a temp variable or else we will lose value while shifting the left array values
			int j = i - 1;
			
			while(j >= 0 && num < a[j]) {
				
				a[j + 1] = a[j]; // left shifting
				j--;	
			}
			
			a[j + 1] = num; // once shifting is done, copy num to a[j + 1] index
		}
	}

	private static void print(int[] a) {
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		
		final int[] array = new int[] {2, 8, 10, 4, 0, 14, 7, 1, 5};
		
		System.out.println("Original array:");
		print(array);
		
		System.out.println("\n\nSorted array");
		
		insertionSort(array);
		
		print(array);
		
		

	}

}

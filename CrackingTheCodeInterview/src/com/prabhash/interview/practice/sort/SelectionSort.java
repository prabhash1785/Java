package com.prabhash.interview.practice.sort;

/**
 * Selection Sort
 * 
 * @author prrathore
 *
 */
public class SelectionSort {
	
	public static void sort(int[] a) {
		
		if(a == null) {
			System.out.println("Array is null");
			return;
		}
		
		for(int i = 0; i < a.length - 1; i++) {
			
			for(int j = i + 1; j < a.length; j++) {
				
				if(a[i] > a[j]) {
					
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					
				}
				
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		int[] array = new int[] {2, 1, 5, 3, 4, 3};
		
		System.out.println("Array before sorting:");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		sort(array);
		
		System.out.println("\nArray after sorting:");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

}

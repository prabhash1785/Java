package com.prabhash.interview.practice.sort;

/**
 * Bubble Sort
 * 
 * @author prrathore
 *
 */
public class BubbleSort {
	
	public static void sort(int[] a) throws Exception {
		
		if(a == null) {
			throw new Exception("Array is null");
		}
		
		for(int i = 0; i < a.length; i++) {
			
			boolean swapped = false; //if no swap made in any pass, then break as array must be sorted
			
			for(int j = 0; j < a.length - 1; j++) {
				
				if(a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					
					swapped = true;
				}
				
			}
			
			if(!swapped) {
				break;
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		int[] array = new int[] {2, 1, 5, 3, 4, 3};
		
		System.out.println("Array before sorting:");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		try {
			sort(array);
		} catch(Exception e) {
			System.out.println("\nCannot sort when array is null");
		}
		
		System.out.println("\nArray after sorting:");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

}

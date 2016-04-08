package com.prabhash.interview.practice.array;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Set of different utility methods to find max k numbers in an array.
 * 
 * @author prrathore
 *
 */
public class FindMax {
	
	/**
	 * Find the maximum number in given array.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param a
	 * @return
	 */
	public static int findMax(final int[] a) {
		
		if(a == null) {
			throw new NullPointerException();
		}
		
		if(a.length == 0) {
			throw new IllegalArgumentException("Array is empty");
		}
		
		int max = a[0];
		
		for(int i = 1; i < a.length; i++) {
			if(max < a[i]) {
				max = a[i];
			}
		}
		
		return max;
	}
	
	/**
	 * Find top two highest number in given array.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param a
	 * @param max
	 */
	public static int[] findTopTwo(final int[] a) {
		
		if(a == null) {
			throw new NullPointerException();
		}
		
		if(a.length < 2) {
			throw new IllegalArgumentException("Array has insufficient number of elements");
		}
		
		final int[] maxNumbers = new int[2];
		
		maxNumbers[0] = a[0];
		maxNumbers[1] = a[1];
		
		// keep these first two numbers sorted
		if(maxNumbers[0] < maxNumbers[1]) {
			swap(maxNumbers);
		}
		
		for(int i = 2; i < a.length; i++) {
			
			if(maxNumbers[1] < a[i]) {
				maxNumbers[1] = a[i];
			}
			
			if(maxNumbers[1] > maxNumbers[0]) {
				swap(maxNumbers);
			}
		}
		
		return maxNumbers;
	}
	
	/**
	 * Find k maximum numbers in an array. Preferred method when you have to find generic number of maximum elements in an array.
	 * 
	 * This algorithm uses Priority Queue (implementation of Min Heap) to store k intermediate max numbers. First store k initial
	 * numbers in Min Heap. Then starting from k+1 to array.length numbers, compare a[i] to root of min heap, if a[i] is greater
	 * than root, then remove root and add a[i] to heap and heapify. At the end, heap should contain k maximum numbers.
	 * 
	 * Time Complexity: O(n log k)
	 * 
	 * @param a input array
	 * @param k number of maximum elements to be found
	 * @return maxNumbers queue containing top k maximum numbers
	 */
	public static Queue<Integer> findKMaxNumbers(final int[] a, final int k) {
		
		if(a == null) {
			throw new NullPointerException();
		}
		
		if(a.length < k) {
			throw new IllegalArgumentException("Insufficient number of elements in array");
		}
		
		final Queue<Integer> maxNumbers = new PriorityQueue<>(k);
		
		for(int i = 0; i < k; i++) {
			maxNumbers.offer(a[i]);
		}
		
		for(int i = k; i < a.length; i++) {
			
			if(a[i] > maxNumbers.peek()) {
				maxNumbers.poll(); // O(log k) time
				maxNumbers.offer(a[i]); // O(log k) time
			}
		}
		
		return maxNumbers;
	}
	
	private static void swap(final int[] a) {
		
		int temp = a[0];
		a[0] = a[1];
		a[1] = temp;
	}
	
	private static void printFindMaxOutput(final int[] a, int max) {
		
		System.out.println("Input Array:");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println("\nMax element: " + max);
	}
	
	private static void printFindMaxOutput(final int[] input, final int[] output) {
		
		System.out.println("Input Array:");
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		
		System.out.println("");
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}
	
	private static void printFindMaxOutput(final int[] input, final Queue<Integer> output) {
		
		System.out.println("\nInput Array:");
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		
		System.out.println("");
		Iterator<Integer> iterator = output.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}

	public static void main(String[] args) {
		
		// test case 1
		int[] array = new int[] {3, 15, 2, 17, 8, 43, 12};
		int max = findMax(array);
		printFindMaxOutput(array, max);
		
		//test case 2
		array = new int[] {45, 22, 100, 80};
		max = findMax(array);
		printFindMaxOutput(array, max);
		
		//test case 3
		array = new int[] {9};
		max = findMax(array);
		printFindMaxOutput(array, max);
		
		// test case 1 to find max two numbers
		int[] array2 = new int[] {3, 15, 2, 17, 8, 43, 12};
		int[] maxTwoNumbers = findTopTwo(array2);
		printFindMaxOutput(array2, maxTwoNumbers);
		
		// test case 1 to find max two numbers
		array2 = new int[] {3, 15};
		maxTwoNumbers = findTopTwo(array2);
		printFindMaxOutput(array2, maxTwoNumbers);
		
		// test case 1 to find max k numbers
		int[] array3 = new int[] {3, 15, 2, 17, 8, 43, 12};
		int k = 2;
		Queue<Integer> maxKNumbers = findKMaxNumbers(array3, k);
		printFindMaxOutput(array3, maxKNumbers);
		
		// test case 2 to find max k numbers
		array3 = new int[] {3, 15, 2, 17, 8, 43, 12};
		k = 4;
		maxKNumbers = findKMaxNumbers(array3, k);
		printFindMaxOutput(array3, maxKNumbers);
	}
}

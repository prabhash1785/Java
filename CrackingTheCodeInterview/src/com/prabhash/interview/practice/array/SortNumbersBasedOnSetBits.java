package com.prabhash.interview.practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sort numbers based on number of set bits.
 * 
 * @author Prabhash Rathore
 *
 */
public class SortNumbersBasedOnSetBits {
	
	/**
	 * Stable Sort given array in decreasing order of set bit count. 
	 * 
	 * Time Complexity: O(n logn)
	 * 
	 * @param a
	 * @return output
	 */
	public static int[] sortInDecreatingOrderBasedOnSetBits(int[] a) {
		if(a == null) {
			return null;
		}
		
		List<Number> list = new ArrayList<>();
		for(int i = 0; i < a.length; i++) {
			int bitCount = getSetBitCount(a[i]); // Time Complexity: O(1)
			list.add(new Number(a[i], bitCount));
		}
		
		Collections.sort(list);
		
		int[] output = new int[a.length];
		int index = 0;
		for(Number n : list) {
			output[index++] = n.num; 
		}
		
		return output;
	}
	
	private static int getSetBitCount(int n) {
		return Integer.bitCount(n);
	}
	
	public static class Number implements Comparable<Number>{
		private int num;
		private int bitCount;
		
		public Number(int num, int bitCount) {
			this.num = num;
			this.bitCount = bitCount;
		}
		
		/**
		 * Custom comparator which will sort in decreasing order by comparing bitCount.
		 */
		@Override
		public int compareTo(Number number) {
			if(number == null) {
				throw new NullPointerException();
			}
			return Integer.compare(number.bitCount, this.bitCount);
		}
	}
	
	public static void printArrayElements(int[] a) {
		if(a == null) {
			System.out.println("\nArray is null");
			return;
		}
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] input = new int[] {
				5, 2, 3, 9, 4, 6, 7, 15, 32	
		};
		
		System.out.println("Original Array:");
		printArrayElements(input);
		
		int[] sortedArray = sortInDecreatingOrderBasedOnSetBits(input);
		System.out.println("\nSorted array based on decreaing bit count:");
		printArrayElements(sortedArray);
	}
}

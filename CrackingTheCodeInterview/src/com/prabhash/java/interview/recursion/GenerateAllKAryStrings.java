package com.prabhash.java.interview.recursion;

public class GenerateAllKAryStrings {
	
	private static int count = 0;
	
	/**
	 * Print all k-ary strings.
	 * 
	 * Time Complexity: O(k ^ n)
	 * 
	 * @param a
	 * @param n
	 * @param k
	 */
	public static void GenerateKAryStrings(int[] a, int n, int k) {
		
		if(n < 1) {
			print(a);
			count++;
		} else {
			for(int j = 0; j < k; j++) {	
				a[n - 1] = j;
				GenerateKAryStrings(a, n - 1, k);
			}
		}
	}
	
	private static void print(final int[] a) {
		
		if(a == null) {
			return;
		}
		
		for(int i : a) {
			System.out.print(i);
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		
		final int k = 3;
		final int n = 3;
		final int[] array = new int[n];
		
		GenerateKAryStrings(array, n, k);
		System.out.println("Total number of strings = " + count);
	}
}

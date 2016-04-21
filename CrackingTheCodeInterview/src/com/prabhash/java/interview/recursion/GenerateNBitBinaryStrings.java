package com.prabhash.java.interview.recursion;

/**
 * Print all permutation of Binary String.
 * 
 * @author prrathore
 *
 */
public class GenerateNBitBinaryStrings {
	
	/**
	 * Using backtracking generate all binary strings of n-bits.
	 * 
	 * Time Complexity: O(2 ^ n)
	 * 
	 * @param a
	 * @param n
	 */
	public static void binary(char[] a, int n) {
		
		if(n < 1) {
			System.out.println(a);
		} else {
			a[n - 1] = '0';
			binary(a, n - 1);
			a[n - 1] = '1';
			binary(a, n - 1);
		}
	}

	public static void main(String[] args) {
		
		int size = 3;
		char[] array = new char[size];
		binary(array, size);
	}
}

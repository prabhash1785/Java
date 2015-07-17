package com.prabhash.java.interview.ch1;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 * 
 * To find a String is permutation of other string, following needs to be checked:
 * - Length of both string must be equal
 * - Each character should match and their count should be equal in both strings
 * 
 * @author prrathore
 *
 */
public class Q1_3 {
	
	/**
	 * First check the length of both string and make sure their length is equal.
	 * Second sort both string and make sure these sorted string pass equality test.
	 * 
	 * Time Complexity: O(n logn)
	 * Space Complexity: O(n)
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean checkPermutationUsingSort(String s1, String s2) {
		
		if(s1.length() != s2.length()) {
			return false;
		}
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		return new String(c1).equals(new String(c2));
		
	}

	public static void main(String[] args) {
		
		String a = "hello";
		String b = "lhleo";
		
		System.out.println("Both string is permutation of each other: " + checkPermutationUsingSort(a, b));

	}

}

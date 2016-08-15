package com.prabhash.interview.practice.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SmallestSubArrayCoveringAllValues {
	
	/**
	 * Brute force algorithm would be to check elements in set to all the possible sub-arrays of given paragraph. An array of n elements
	 * have n ^ 2 sub-arrays and comparing each sub-array with n elements in set would result in O(n ^ 3) time complexity.
	 * 
	 * This is a better algorithm where for each element position in array, we keep matching set elements until we find all set elements
	 * or we run out of elements in sub-array. This reduces time complexity to quadratic time. Keep track of minimum sub-array length 
	 * which will be the final output.
	 * 
	 * Time Complexity: O(n ^ 2)
	 * Space Complexity: O(n)
	 * 
	 * @param paragraph
	 * @param set
	 * @return subArray
	 */
	public static SubArray findSmallestSubArrayUsingBruteForce(String[] paragraph, Set<String> set) {
		if(paragraph == null || set == null) {
			throw new NullPointerException();
		}
		
		SubArray subArray = new SubArray(-1, -1);
		int subArraySize = Integer.MAX_VALUE;
		List<String> foundStrings = null;
		
		for(int i = 0; i < paragraph.length; i++) {
			// reset list back to original position for each sub array
			foundStrings = new LinkedList<>();
			
			for(int j = i; j < paragraph.length; j++) {
				if(set.contains(paragraph[j])) {
					foundStrings.add(paragraph[j]);
				}
				
				if(foundStrings.size() == set.size()) {
					if(subArraySize > (j - i)) {
						subArraySize = j - i;
						subArray = new SubArray(i, j);
						break;
					}
					
				}
			}
		}
		
		return subArray;
	}
	
	public static class SubArray {
		private int start;
		private int end;
		
		public SubArray(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		String[] paragraph = new String[] {
			"apple", "banana", "mango", "peach", "grapes", "apple", "orange", "banana", "apple"	
		};
		
		Set<String> set = new HashSet<>();
		set.add("grapes");
		set.add("orange");
		
		SubArray subArray = findSmallestSubArrayUsingBruteForce(paragraph, set);
		System.out.println("Smallest sub-array containing words from set are:");
		System.out.println("Start Index: "+ subArray.start + " ::: End Index: " + subArray.end);
	}

}

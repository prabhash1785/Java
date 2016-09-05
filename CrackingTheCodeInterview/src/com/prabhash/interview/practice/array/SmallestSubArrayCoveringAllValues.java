package com.prabhash.interview.practice.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Find smallest sub-array covering all values in given set.
 * 
 * @author Prabhash Rathore
 *
 */
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
	
	/**
	 * Optimized method to find min sub-array containing all elements in the given set.
	 * 
	 * Maintain two pointers startIndex and endIndex. Iterate over paragraph while endIndex < paragraph length. If a paragraph
	 * word is found in set then increment count. When count is equal to number of elements in set, update sub-array length if length
	 * < previous subArray length. Also if string at startIndex is in set then decrement count as that word is going to be not counted in
	 * subsequent subarray when startIndex moves right. Continue to iterate and at the end, it will give the smallest subArray length
	 * with all elements from set. 
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param paragraph
	 * @param set
	 * @return subArray
	 */
	public static SubArray findSmallestSubArrayOptimized(String[] paragraph, Set<String> set) {
		if(paragraph == null || set == null) {
			throw new NullPointerException();
		}
		
		// Size of set cannot be more than length of paragraph
		if(set.size() > paragraph.length) {
			return null;
		}
		
		SubArray subArray = new SubArray(-1, -1);
		int startIndex = 0, endIndex = 0;
		int count = 0;
		
		while(endIndex < paragraph.length) {
			if(set.contains(paragraph[endIndex])) {
				++count;
			}
			
			while(count == set.size()) {
				int currentSubArraySize = endIndex - startIndex;
				if((subArray.start == -1 && subArray.end == -1) || 
						(currentSubArraySize < (subArray.end - subArray.start))) {
					subArray.start = startIndex;
					subArray.end = endIndex;
				}
				
				if(set.contains(paragraph[startIndex])) {
					--count;
				}
				++startIndex;
			}
			
			++endIndex;
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
		
		String[] paragraph2 = new String[] {
			"apple", "banana", "apple", "apple", "dog", "cat", "apple", "dog", "banana", "apple", "cat", "dog"	
		};
		Set<String> set2 = new HashSet<>();
		set2.add("banana");
		set2.add("cat");
		
		SubArray subArray2 = findSmallestSubArrayOptimized(paragraph2, set2);
		if(subArray2 == null) {
			System.out.println("Set elements are not available in paragraph");
		} else {
			System.out.println("\nSmallest sub-array containing words from set are:");
			System.out.println("Start Index: " + subArray2.start + " :: End Index: " + subArray2.end);
		}
	}

}

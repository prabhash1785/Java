package com.prabhash.java.interview.practice.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string find longest non-repeating sub-sequence.
 * 
 * @author Prabhash Rathore
 *
 */
public class FindLongestNonRepeatingSubSequence {

	/**
	 * For each character in the String, find the longest possible substring without repeating any character. This can be done using
	 * two nested for loops. Also to make sure no already visited character repeats, we can maintain a set.
	 * 
	 * Time Complexity: O(n ^ 2)
	 * Space Complexity: O(n)
	 * 
	 * @return maxLength
	 */
	public static int findLongestSequenceUsingExhaustiveSearch(String s) {
		if(s == null) {
			return -1;
		}
		
		int maxLength = 0;
		for(int i = 0; i < s.length(); i++) {
			int count = 0;
			Set<Character> set = new HashSet<>();
			for(int j = i; j < s.length(); j++) {
				if(set.contains(s.charAt(j))) {
					break;
				}
				
				++count;
				set.add(s.charAt(j));
			}
			
			if(count > maxLength) {
				maxLength = count;
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		String input = "abcdamnb";
		System.out.println("Longest substring length: " + findLongestSequenceUsingExhaustiveSearch(input));
		
		input = "";
		System.out.println("Longest substring length: " + findLongestSequenceUsingExhaustiveSearch(input));
		
		input = "aaaa";
		System.out.println("Longest substring length: " + findLongestSequenceUsingExhaustiveSearch(input));
		
		input = "ghijklmnopq";
		System.out.println("Longest substring length: " + findLongestSequenceUsingExhaustiveSearch(input));
	}

}

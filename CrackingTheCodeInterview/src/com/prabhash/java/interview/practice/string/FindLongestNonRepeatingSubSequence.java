package com.prabhash.java.interview.practice.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
	
	/**
	 * Optimized method to find longest non-repeating substring in one pass. In order to find longest substring, maintain two start and
	 * end pointers to your string characters and maintain a map to keep track of previously visited chars.
	 * If a char is already visited then remove that char from map, update that char's position with new or current position, update
	 * current size and also update your startIndex to the index value of char after the char removed from map.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param s
	 * @return maxLength
	 */
	public static int findLongestSubSequenceLengthInOnePass(String s) {
		if(s == null) {
			return -1;
		}
		
		if(s.length() == 0) {
			return 0;
		}
		
		int maxLength = 0;
		int currentLength = 0;
		int startIndex = 0, endIndex = 0;
		Map<Character, Integer> charMap = new HashMap<>();
		
		while(endIndex < s.length()) {
			char c = s.charAt(endIndex);
			if(charMap.containsKey(s.charAt(endIndex))) {
				int prevIndex = charMap.remove(c); // remove current char as it already exists
				charMap.put(c, endIndex); // update char with it's new index or index of current char in loop
				
				startIndex = prevIndex + 1; // update start index to the char after the index of char present in map
				
				currentLength = endIndex - startIndex + 1; // add an offset of 1
			} else {
				charMap.put(c, endIndex);
				++currentLength;
			}
			
			++endIndex;
			if(currentLength > maxLength) {
				maxLength = currentLength;
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		// test cases for Brute Force Algorithm
		String input1 = "abcdamnb";
		System.out.println("Longest substring length: " + findLongestSequenceUsingExhaustiveSearch(input1));
		
		input1 = "";
		System.out.println("Longest substring length: " + findLongestSequenceUsingExhaustiveSearch(input1));
		
		input1 = "aaaa";
		System.out.println("Longest substring length: " + findLongestSequenceUsingExhaustiveSearch(input1));
		
		input1 = "ghijklmnopq";
		System.out.println("Longest substring length: " + findLongestSequenceUsingExhaustiveSearch(input1));
		
		// test cases for optimized algorithm
		String input2 = "abcdamnb";
		System.out.println("Longest substring length: " + findLongestSubSequenceLengthInOnePass(input2));
		
		input2 = "";
		System.out.println("Longest substring length: " + findLongestSubSequenceLengthInOnePass(input2));
		
		input2 = "aaaa";
		System.out.println("Longest substring length: " + findLongestSubSequenceLengthInOnePass(input2));
		
		input2 = "ghijklmnopq";
		System.out.println("Longest substring length: " + findLongestSubSequenceLengthInOnePass(input2));
	}

}

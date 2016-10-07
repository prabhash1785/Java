package com.prabhash.java.interview.practice.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Given a string s, return the shortest substring that is only occurring once.
 * Examples:
 * s="aabbabbaab" gives either "bab" or "baa"
 * s="aaaa" gives "aaaa"  
 * 
 * @author Prabhash Rathore
 *
 */

public class FindSmallestNonRepeatingSubString {

	/**
	 * Iterate through string and find all possible substrings and make sure to keep track of their counts in a Map. After that iterate
	 * through map and retrieve the shortest substring with count 1. 
	 * 
	 * Time Complexity: O(n ^ 2)
	 * Space Complexity: O(n ^ 2)
	 * 
	 * @param s
	 * @return substring with count 1
	 */
	public static String getSmallestSubStringUsingMap(String s) {
		if(s == null || s.length() == 0) {
			return null;
		}
		
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			int intermediateEndIndex = i + 1; // intermediate end index
			int end = s.length();
			while(intermediateEndIndex <= end) {
				String subString = s.substring(i, intermediateEndIndex);
				if(map.containsKey(subString)) {
					map.put(subString, map.get(subString) + 1);
				} else {
					map.put(subString, 1);
				}
				++intermediateEndIndex;
			}
		}
		
		String shortestSubString = s; // Since we are looking for shortest string make sure to initialize this variable to longest possible value
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> entry : entrySet) {
			if(entry.getValue() == 1 && entry.getKey().length() < shortestSubString.length()) {
				shortestSubString = entry.getKey();
			}
		}
		
		return shortestSubString;
	}
	
	public static void main(String[] args) {
		String input = "aaaa";
		System.out.println(input + "Shortes substring is: " + getSmallestSubStringUsingMap(input));
		
		String input2 = "aabbabbaab";
		System.out.println(input + "Shortes substring is: " + getSmallestSubStringUsingMap(input2));
	}
}

package com.prabhash.java.interview.practice.string;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Given a string like ABDBAACAABBBCD. Return character with lowest count, in case of tie, return the character which occurs first
 * in the string. For example in above case, answer is D.
 * 
 * @author Prabhash Rathore
 *
 */
public class GetCharWithMinCount {
	
	/**
	 * Given a string, find char with min count. If there are more than one chars with min count then return the first char from string.
	 * 
	 * Iterate through string and create a LinkedHashMap of character with their counts. Also make sure to maintain character order in
	 * map so that we can break ties in case there are more than one chars with min count. Finally iterate through map and find a char
	 * with min count.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param input
	 * @return charWithMinCount
	 */
	public static char getCharWithMinCount(String input) {
		if(input == null || input.length() == 0) {
			throw new IllegalArgumentException();
		}
		
		Map<Character, Integer> map = new LinkedHashMap<>(); // use LinkedHashMap to maintain order of insertion
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		char charWithMinCount = ' ';
		int minCount = Integer.MAX_VALUE;
		Set<Entry<Character, Integer>> keySet = map.entrySet();
		Iterator<Entry<Character, Integer>> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			Entry<Character, Integer> entry = iterator.next();
			int count = entry.getValue();
			if(count < minCount) {
				charWithMinCount = entry.getKey();
				minCount = count;
			}
		}
		
		return charWithMinCount;
	}

	public static void main(String[] args) {
		final String s = "ABDBAACAABBBCD";
		
		char ch = getCharWithMinCount(s);
		System.out.println("Char with min count: " + ch);

	}

}

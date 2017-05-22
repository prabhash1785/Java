package com.prabhash.java.interview.practice.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of words, return a list with the smallest possible prefix for each word that uniquely identifies it in the given list.
 * 
 * Example
 * input:  {"a", "simple", "single", "solution"}
 * output: {"a", "sim", "sin", "so"}
 * 
 * Assumption: Each word in list will have at least one unique prefix. 
 * 
 * @author Prabhash Rathore
 *
 */
public class GetUniquePrefixes {
	
	/**
	 * Method 1:
	 * Return for each word the unique prefix which does not exist in the list.
	 * 
	 * Create a map of prefix and their corresponding counts as a first pass. In second pass, for each word in list, check if any prefix
	 * has count exactly one which implies that this is an unique prefix and add this to output list.
	 * 
	 * Time Complexity: O(n m) where m is the size of longest word in String
	 * Space Complexity: O(n m)
	 * 
	 * @param list
	 * @return result
	 */
	public static List<String> getUniquePrefixes(List<String> list) {
		List<String> result = new ArrayList<>();
		if(list == null || list.size() == 0) {
			return result;
		}

		// create a map of prefixes and their count
		Map<String, Integer> prefixMap = new HashMap<>();
		for(int i = 0; i < list.size(); i++) {
			String word = list.get(i);
			int j = 1;
			while(j <= word.length()) {
				String prefix = word.substring(0, j);
				if(prefixMap.containsKey(prefix)) {
					prefixMap.put(prefix, prefixMap.get(prefix) + 1);
				} else {
					prefixMap.put(prefix, 1);
				}
				++j;
			}
		}

		for(int i = 0; i < list.size(); i++) {
			String word = list.get(i);

			String prefix = null;
			for(int j = 1; j <= word.length(); j++) {
				prefix = word.substring(0, j);
				if(prefixMap.containsKey(prefix) && prefixMap.get(prefix) == 1) {
					result.add(prefix);
					break;
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Method 2:
	 * Sort the given list. Then for each word, compare it's characters with prev and next word. Based on comparison, return the unique
	 * prefix for each word.
	 * 
	 * Time Complexity: O(nlogn + nm) = O((n + m)logn) where m is the size of longest string in list
	 * 
	 * @param list
	 * @return result
	 */
	public static List<String> getUniquePrefixesWithoutUsingExtraMemory(List<String> list) {
		List<String> result = new ArrayList<>();
		if(list == null || list.size() == 0) {
			return result;
		}
		
		// sort the list
		Collections.sort(list);
		
		String prev = null;
		String current = list.get(0);
		String second = null;
		for(int i = 1; i < list.size(); i++) {
			second = list.get(i);
			
			int j = 0;
			StringBuffer prefix = new StringBuffer();
			while(prev != null && j < current.length() && j < prev.length()) {
				if(current.charAt(j) != prev.charAt(j)) {
					break;
				}
				prefix.append(current.charAt(j));
				++j;
			}
			
			while(j < current.length() && j < second.length()) {
				if(current.charAt(j) != second.charAt(j)) {
					break;
				}
				prefix.append(current.charAt(j));
				++j;
			}
			
			prefix.append(current.charAt(j)); // add the last unmatching character to make prefix unique
			
			result.add(prefix.toString());
			prev = current;
			current = second;
		}
		
		// make to sure to get the prefix of last string in list
		int j = 0;
		StringBuffer prefix = new StringBuffer();
		while(prev != null && j < current.length() && j < prev.length()) {
			prefix.append(current.charAt(j));
			if(current.charAt(j) != prev.charAt(j)) {
				break;
			}
			++j;
		}
		result.add(prefix.toString());
		
		return result;
	}

	public static void main(String[] args) {
		List<String> input = Arrays.asList("a", "simple", "single", "solution");
	    
	    List<String> output = getUniquePrefixes(input);
	    System.out.println("Unique prefixes:");
	    for(String s : output) {
	     System.out.println(s); 
	    }
	    
	    List<String> output2 = getUniquePrefixesWithoutUsingExtraMemory(input);
	    System.out.println("Unique prefixes from method 2:");
	    for(String s : output2) {
	     System.out.println(s); 
	    }
	}
}

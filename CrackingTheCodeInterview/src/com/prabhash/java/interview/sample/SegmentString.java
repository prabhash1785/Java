package com.prabhash.java.interview.sample;

import java.util.HashSet;
import java.util.Set;

public class SegmentString {
	
	private static final Set<String> dictionary = new HashSet<String>();
	
	/**
	 * Segment string into multiple words based on a dictionary match.
	 * 
	 * Time Complexity: O(2 ^ n) same as number of Power Set of a set.
	 * 
	 * @return
	 */
	public static String segmentString(Set<String> dictionary, String word) {
		
		if(word == null) {
			return null;
		}
		
		if(dictionary.contains(word)) {
			return word;
		}
		
		for(int i = 1; i < word.length(); i++) {
			
			String prefix = word.substring(0, i);
			
			if(dictionary.contains(prefix)) {
				
				String suffix = word.substring(i);
				
				String segmentedWord = segmentString(dictionary, suffix);
				
				if(segmentedWord != null) {
					return prefix + " " + segmentedWord;
				}
				
			}
			
		}
		
		return null;
		
	}

	public static void main(String[] args) {
		
		// set up the dictionary
		dictionary.add("hello");
		dictionary.add("world");
		dictionary.add("he");
		dictionary.add("hell");
		dictionary.add("low");
		dictionary.add("or");
		dictionary.add("people");
		dictionary.add("hi");
		
		String word = "helloworldhipeople";
		
		String tokenizedWords = segmentString(dictionary, word);
		System.out.println("Tokenized String: " + tokenizedWords);

	}

}

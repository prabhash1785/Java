package com.prabhash.java.interview.ch1;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * 
 * @author prrathore
 *
 */
public class Q1_1 {
	
	private static String input = "abcdefghji";
	
	/**
	 * This method uses an additional HashMap DataStructure to keep track if a char is already present. If any char is repeated then
	 * it doesn't have unique characters.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param s
	 * @return
	 */
	public static boolean hasUniqueCharacters(String s) {
		
		if(s == null) {
			throw new IllegalArgumentException();
		}
		
		boolean result = true;
		
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();
		
		char[] charArray = s.toCharArray();
		
		for(int i = 0; i < charArray.length; i++)
			map.put(charArray[i], false);
		
		for(int i = 0; i < charArray.length; i++) {
			if(map.get(charArray[i]) == true) {
				result = false;
				break;
			}
			
			map.put(charArray[i], true);
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		
		System.out.println("Has abcdeaf unique chars: " + hasUniqueCharacters(input));

	}

}

package com.prabhash.java.interview.ch1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * 
 * @author prrathore
 *
 */
public class Q1_1 {
	
	/**
	 * Brute Force
	 * 
	 * Time Complexity: O(n ^ 2)
	 * Space Complexity:O(1)
	 *  
	 */
	public static boolean isUniuewithBruteForce(String s) {
		
		if(s == null) {
			throw new IllegalArgumentException();
		}
		
		//Optimization. If String is ASCII string then it can't have more than 256 characters
		if(s.length() > 256) {
			return false;
		}
		
		char[] ch = s.toCharArray();
		
		for(int i = 0; i < ch.length; i++) {
			for(int j = i + 1; j < ch.length; j++) {
				if(ch[i] == ch[j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Method 1 using an Array.
	 * 
	 * Assumption: String only contains ASCII characters so that we can easily create an array to store all unique ASCII characters.
	 * ASCII characters is stored in 1 byte memory and there is a total of 2 ^ 8 = 256 characters.
	 * 
	 * If String contains UTF characters then this method is not an efficient method as UTF contains = 2 ^ 32 = 4.3 billion characters.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1) since ASCII character set has fixed length  
	 *  
	 */
	public static boolean hasUniqueWithArray(String s) {
		if(s == null) {
			throw new IllegalArgumentException();
		}
		
		//since ASCII character set can't have more than 256 characters so it's an easy optimization
		if(s.length() > 256) {
			return false;
		}
		
		boolean result = true;
		
		int[] charTracker = new int[256]; //since ASCII has 2 ^ 8 = 256 characters
		
		char[] ch = s.toCharArray();
		
		for(int i = 0; i < ch.length; i++) {
			int k = (int) ch[i]; //convert character to it's corresponding ASCII value
			if(charTracker[k] == 1) {
				result = false;
				break;
			}
			
			charTracker[k] = 1;
		}
		
		return result;
		
	}
	
	/**
	 * Method 2 using Hash Map
	 * 
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
		
		//Optimization. If String is ASCII string then it can't have more than 256 characters
		if(s.length() > 256) {
			return false;
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
	
	/**
	 * Same implementation as above method 2. This has a minor optimization where we don't have to initialize hashmap with String elements. 
	 * Just use Map containsKey() method to check if map has a key before doing a get with key. This will prevent NullPointerException and saves us
	 * an extra for loop of initializing HashMap.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param s
	 * @return
	 */
	public static boolean hasUniqueCharactersWithHashTableV2(String s) {

		if(s == null) {
			throw new IllegalArgumentException();
		}
		
		//Optimization. If String is ASCII string then it can't have more than 256 characters
		if(s.length() > 256) {
			return false;
		}

		Map<Character, Boolean> map = new HashMap<Character, Boolean>();

		char[] charArray = s.toCharArray();

		for(int i = 0; i < charArray.length; i++) {
			
			char c = charArray[i];
			if(map.containsKey(c) && map.get(c) == true) {
				return false;
			}

			map.put(charArray[i], true);
		}

		return true;

	}
	
	/**
	 * Use an array of boolean to check if a character is already available
	 * 
	 * @param args
	 */
	public static boolean hasUniqueCharsUsingBoolArray(String s) throws Exception {
		
		if(s == null) {
			throw new IllegalArgumentException();
		}
		
		// Assuming String has ASCII characters then it can not have more than 256 characters
		if(s.length() > 256) {
			return false;
		}
		
		boolean[] charTracker = new boolean[256];
		
		char[] charArray = s.toCharArray();
		
		for(int i = 0; i < charArray.length; i++) {
			
			int charValue = (int) charArray[i];
			
			if(charValue > 256) {
				throw new Exception("Provided String is not ASCII");
			}
			
			if(charTracker[charValue]) {
				return false;
			}
			
			charTracker[charValue] = true;
			
		}
		
		return true;
		
	}
	
	/**
	 * Sort the given string and compare subsequent characters to see if they match. If any character match then that means there are
	 * repeating characters.
	 * 
	 * Time Complexity: O(nlogn) - Sorting time
	 * Space: O(1) assuming sorting used doesn't take extra memory
	 * 
	 * @param s
	 * @return
	 */
	public static boolean hasUniqueCharsUsingSorting(String s) {
		
		if(s == null) {
			throw new IllegalArgumentException();
		}
		
		if(s.length() > 256) {
			return false;
		}
		
		char[] charArray = s.toCharArray();
		
		Arrays.sort(charArray);
		
		for(int i = 0; i < charArray.length - 1; i++) {
			
			if(charArray[i] == charArray[i+1]) {
				return false;
			}
			
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		
		String input = "$@^asdf!1";
		
		System.out.println("Has abcdeaf unique chars: " + hasUniqueCharacters(input));
		
		System.out.println("Has abcdeaf unique chars: " + hasUniqueCharactersWithHashTableV2(input));
		
		System.out.println(hasUniqueWithArray(input));
		
		System.out.println(isUniuewithBruteForce(input));
		
		try {
			System.out.println(hasUniqueCharsUsingBoolArray(input));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(hasUniqueCharsUsingSorting("abcad"));
		
	}

}

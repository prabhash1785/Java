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

	public static void main(String[] args) {
		
		System.out.println("Has abcdeaf unique chars: " + hasUniqueCharacters(input));
		
		System.out.println("Has abcdeaf unique chars: " + hasUniqueCharactersWithHashTableV2("abc"));
		
		System.out.println(hasUniqueWithArray("abcderbzx"));
		
		System.out.println(isUniuewithBruteForce("servuiso"));
		
	}

}

package com.prabhash.java.interview.ch1;

/**
 * Program to reverse a given string.
 * 
 * @author prrathore
 *
 */
public class Q1_2 {
	
	/**
	 * This method will reverse string by traversing given string from rear and appending each character to a StringBuilder object.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param s
	 */
	public static void reverseStringMethod1(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = (s.length() - 1); i >= 0; i--) {
			
			sb.append(s.charAt(i));
			
		}
		
		System.out.println("Reversed String: " + sb.toString());
		
	}
	
	/**
	 * Reverse String in place.
	 * 
	 * Time Complexity: O(n/2) = O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param input
	 */
	public static void reverseStringInPlace(String input) {
		
		int startIndex = 0;
		int endIndex = input.length() - 1;
		
		char[] charArray = input.toCharArray();
		
		while(startIndex < endIndex) {
			char temp = charArray[startIndex];
			charArray[startIndex] = charArray[endIndex];
			charArray[endIndex] = temp;
			
			startIndex++;
			endIndex--;
		}
		
		System.out.println("Revrsed String in place: " + new String(charArray));
		
	}
	
	/**
	 * Recursively reverse a String. Not a recommended method.
	 * 
	 * @param input
	 */
	public static void recursiveReversal(String input) {
		System.out.println("Recursive reversal of String: " + new String(recursiveReversalUtil(input.toCharArray(), 0, input.length() - 1)));
	}
	
	private static char[] recursiveReversalUtil(char[] s, int start, int end) {
		
		if(start > end) {
			return s;
		}
		
		char temp = s[start];
		s[start] = s[end];
		s[end] = temp;
		
		return recursiveReversalUtil(s, ++start, --end);
		
	}

	public static void main(String[] args) {
		
		final String input = "hello";
		
		reverseStringMethod1(input);
		
		reverseStringInPlace(input);
		
		recursiveReversal(input);

	}

}

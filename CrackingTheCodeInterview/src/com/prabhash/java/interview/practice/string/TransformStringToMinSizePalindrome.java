package com.prabhash.java.interview.practice.string;

/**
 * Given a string, convert this to a palindrome by adding minimum number of characters. If it is already a palindrome then
 * return origin string.
 * 
 * @author Prabhash Rathore
 *
 */
public class TransformStringToMinSizePalindrome {
	
	/**
	 * To convert given string to a minimum size palidrome, keep a postString which needs to be added to input String to make it a 
	 * palindrome. Keep adding character from start to end of input text to post string until (string + postString) becomes a palindrome.  
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param s
	 * @return new palindrome
	 */
	public static String convertToMinSizePalindrome(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
				
		String postString = "";
		int startIndex = 0;
		
		while(!isPalindrome(s + postString) && startIndex < s.length()) {
			postString = s.charAt(startIndex) + postString;
			startIndex++;
		}
		
		return s + postString;
	}
	
	private static boolean isPalindrome(String s) {
		if(s == null) {
			return false;
		}
		
		int start = 0, end = s.length() - 1;
		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			++start;
			--end;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "radar";
		String palindrome1 = convertToMinSizePalindrome(s1);
		System.out.println(s1 + " => " + palindrome1);
		
		String s2 = "hello";
		String palindrome2 = convertToMinSizePalindrome(s2);
		System.out.println(s2 + " => " + palindrome2);
	}
}

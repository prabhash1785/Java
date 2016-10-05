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
	 * Method 1:
	 * To convert given string to a minimum size palindrome, keep a preString which needs to be added to input String to make it a 
	 * palindrome. Keep adding character from end to start of input text to pre string until (preString + string) becomes a palindrome.  
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param s
	 * @return new palindrome
	 */
	public static String convertToMinSizePalindromeByPrependingChars(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
				
		String preString = "";
		int endIndex = s.length() - 1;
		
		while(!isPalindrome(preString + s) && endIndex >= 0) {
			preString = preString + s.charAt(endIndex);
			endIndex--;
		}
		
		return preString + s;
	}
	
	/**
	 * Method 2:
	 * To convert given string to a minimum size palidrome, keep a postString which needs to be added to input String to make it a 
	 * palindrome. Keep adding character from start to end of input text to post string until (string + postString) becomes a palindrome.  
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param s
	 * @return new palindrome
	 */
	public static String convertToMinSizePalindromeByAppendingChars(String s) {
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
		String palindrome1 = convertToMinSizePalindromeByPrependingChars(s1);
		System.out.println(s1 + " => " + palindrome1);
		
		String s2 = "hello";
		String palindrome2 = convertToMinSizePalindromeByPrependingChars(s2);
		System.out.println(s2 + " => " + palindrome2);
		
		String s3 = "radar";
		String palindrome3 = convertToMinSizePalindromeByAppendingChars(s3);
		System.out.println(s3 + " => " + palindrome3);
		
		String s4 = "hello";
		String palindrome4 = convertToMinSizePalindromeByAppendingChars(s4);
		System.out.println(s4 + " => " + palindrome4);
	}
}

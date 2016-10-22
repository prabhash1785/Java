package com.prabhash.java.interview.practice.string;

/**
 * Given a string of open and close braces, find the longest valid subsequence of braces. 
 * 
 * @author Prabhash Rathore
 *
 */
public class FindLongestValidBraceSubstring {
	
	/**
	 * Find longest valid brace substring from a given string of braces.
	 * 
	 * To find longest valid brace substring, find all valid subsequence of given string and for each subsequence keep track of open and close
	 * brace count. If you find open brace, increment count else decrement. At any point, if count == 0 that means we have a valid brace 
	 * pattern. If this pattern is longer than last longest substring then update your longest substring. If at any point, brace count < 0, 
	 * that means it's an invalid sequence, stop iterating for this specific subsequence.
	 * 
	 *  Time Complexity: O(n ^ 2)
	 * 
	 * @param s
	 * @return longestString
	 */
	public static String findLongestValidBraceString(String s) {
		if(s == null || s.length() < 2) {
			return "";
		}
		
		String longestString = "";
		for(int i = 0; i < s.length(); i++) {
			int j = i;
			int braceCount = 0;
			while(j < s.length()) {
				if(s.charAt(j) == '(') {
					++braceCount;
				} else {
					--braceCount;
				}
				
				if(braceCount == 0 && (j - i + 1 > longestString.length())) {
					longestString = s.substring(i, j + 1);
				}
				
				// Found an invalid brace sequence, break out of here
				if(braceCount < 0) {
					break;
				}
				
				++j;
			}
		}
	
		return longestString;
	}
	
	/**
	 * Find longest brace string length in linear time.
	 * 
	 * Every time you see an open brace, increase open brace count. For close brace, if openBrace count > 0, then increase length by 2 as
	 * each brace comprises of 2 braces. If openbrace count < 0, then this must not be a valid brace substring so reset validlength and
	 * openbrace count. At the end of each iteration, check if validLength > maxValidLength, if it is then update value of maxValidLength.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param s
	 * @return maxValidLength
	 */
	public static int findLongestValidBraceSubStringLengthOptimized(String s) {
		if(s == null || s.length() < 2) {
			return 0;
		}
		
		int validLength = 0;
		int openParenthesisCount = 0;
		int maxValidLength = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char parenthesis = s.charAt(i);
			if(parenthesis == '(') {
				openParenthesisCount++;
			} else {
				if(openParenthesisCount > 0) {
					openParenthesisCount--;
					validLength = validLength + 2;
				} else {
					validLength = 0;
					openParenthesisCount = 0;
				}
			}
			if(maxValidLength < validLength) {
				maxValidLength = validLength;
			}
		}
		return maxValidLength;
	}
	
	/**
	 * Optimized method to find longest valid brace substring.
	 * 
	 * Every time you see an open brace, increase open brace count. For close brace, if openBrace count > 0, then increase length by 2 as
	 * each brace comprises of 2 braces. If openbrace count < 0, then this must not be a valid brace substring so reset validlength and
	 * openbrace count. At the end of each iteration, check if validLength > maxValidLength, if it is then find substring from (i + 1 -
	 * validLength) to (i + 1)th position and update maxValidString value.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param s
	 * @return maxValidString
	 */
	public static String findLongestValidBraceSubStringOptimized(String s) {
		if(s == null || s.length() < 2) {
			return "";
		}
		
		int validLength = 0;
		int openParenthesisCount = 0;
		String maxValidString = "";
		
		for (int i = 0; i < s.length(); i++) {
			char parenthesis = s.charAt(i);
			if(parenthesis == '(') {
				openParenthesisCount++;
			} else {
				if(openParenthesisCount > 0) {
					openParenthesisCount--;
					validLength += 2;
				} else {
					validLength = 0;
					openParenthesisCount = 0;
				}
			}
			if(maxValidString.length() < validLength) {
				maxValidString = s.substring(i + 1 - validLength, i + 1);
			}
		}
		return maxValidString;
	}
	
	public static void main(String[] args) {
		String input1 = "(()()";
		String longestSubstring = findLongestValidBraceString(input1);
		System.out.println("Longest substring: " + longestSubstring);
		
		String input2 = ")))()()(())(((";
		String longestSub2tring2 = findLongestValidBraceString(input2);
		System.out.println("Longest substring: " + longestSub2tring2);
		
		// Method 2 test cases
		System.out.println("Longest Brace string for " + input1 + ": " + findLongestValidBraceSubStringLengthOptimized(input1));
		System.out.println("Longest Brace string for " + input2 + ": " + findLongestValidBraceSubStringLengthOptimized(input2));
		
		// Method 3 test cases
		System.out.println("Longest Brace string for " + input1 + ": " + findLongestValidBraceSubStringOptimized(input1));
		System.out.println("Longest Brace string for " + input2 + ": " + findLongestValidBraceSubStringOptimized(input2));
	}
}

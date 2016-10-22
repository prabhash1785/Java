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

	public static void main(String[] args) {
		String input1 = "(()()";
		String longestSubstring = findLongestValidBraceString(input1);
		System.out.println("Longest substring: " + longestSubstring);
		
		String input2 = ")))()()(())(((";
		String longestSub2tring2 = findLongestValidBraceString(input2);
		System.out.println("Longest substring: " + longestSub2tring2);
	}
}

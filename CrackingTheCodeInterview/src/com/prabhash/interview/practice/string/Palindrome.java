package com.prabhash.interview.practice.string;

/**
 * Find if a String is Palindrome
 * 
 * @author prrathore
 *
 */
public class Palindrome {
	
	/**
	 * Keeping two pointers, one at start and other at end of string, compare characters from start and end. If any character does not match,
	 * then it's not a palindrome else it is.
	 * 
	 * Time Complexity = O(n/2) = O(n)
	 * Space Complexity =  O(1) 
	 * 
	 * @param s
	 * @return boolean
	 */
	public static boolean isPalindrome(String s) {

		int start = 0;
		int end = s.length() - 1;

		boolean isPalindrome = true;

		while(start < end) {

			if(s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				isPalindrome = false;
				break;
			}

		}

		return isPalindrome;

	}

	public static void main(String[] args) {

		String input = "abcba";
		boolean isPalindrome = isPalindrome(input);
		
		System.out.println(input + " is Palindrome: " + isPalindrome);

	}

}
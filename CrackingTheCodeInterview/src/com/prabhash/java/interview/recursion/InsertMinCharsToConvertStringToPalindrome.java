package com.prabhash.java.interview.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the minimum number of characters which needs to be added to a given string to make it a palindrome.
 * 
 * @author Prabhash Rathore
 *
 */
public class InsertMinCharsToConvertStringToPalindrome {
	
	/**
	 * This is a recursive algorithm to find minimum number of characters to be added to make a string palindrome. For a string to
	 * be palindrome, each character from start and end should be equal in order. So here is how we can determine how many characters
	 * needs to be added:
	 * 
	 * If 
	 * 		charAtStart == charAtEnd, then add 0 chars, move both index inwards
	 * else 
	 * 		min(insertChars(charAtStart + 1, charAtEnd), insertChars(charAtStart, charAtEnd + 1)) + 1
	 * 
	 * This problem can be further optimized by using Dynamic Programming as there are overlapping subproblems which are being
	 * solved again and again. Refer findMinCharsOptimized(s) method.
	 * 
	 * Time Complexity: O(2 ^ n)
	 * 
	 * @param s
	 * @return int
	 */
	public static int findMinInsertions(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		
		int start = 0;
		int end = s.length() - 1;
		return findMinInsertionsHelper(s, start, end);
	}
	
	private static int findMinInsertionsHelper(String s, int start, int end) {
		if(start > end) {
			return 0;
		}
		
		if(s.charAt(start) == s.charAt(end)) {
			return findMinInsertionsHelper(s, start + 1, end - 1); // recurse by moving both index if they are equal
		}
		
		// recurse when both start and end moved one at a time
		int countWhenStartIndexMoved =  findMinInsertionsHelper(s, start + 1, end)  + 1;
		int countWhenEndIndexMoved = findMinInsertionsHelper(s, start, end - 1) + 1;
		
		int minCount = Math.min(countWhenStartIndexMoved, countWhenEndIndexMoved);
		return minCount;
	}
	
	/**
	 * Since there are overlapping subproblems in above recursion, we can solve it using Dynamic Programming to improve time complexity.
	 * We will use a cache which will store the char count needed to convert string to palindrome so that we don't have to solve
	 * overlapping subproblems repeatedly.
	 * 
	 * Time Complexity: O(n ^ 2)
	 * 
	 * @param s
	 * @return int
	 */
	public static int findMinCharsOptimized(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		
		Map<String, Integer> cache = new HashMap<>();
		return findMinCharsOptimizedHelper(s, 0, s.length() - 1, cache);
	}
	
	private static int findMinCharsOptimizedHelper(String s, int start, int end, Map<String, Integer> cache) {
		if(start > end || start > s.length() - 1 || end < 0) {
			return 0;
		}
		
		if(cache.containsKey(s)) {
			return cache.get(s);
		}
		
		int count = 0;
		if(s.charAt(start) == s.charAt(end)) {
			count = findMinCharsOptimizedHelper(s, start + 1, end + 1, cache);
		} else {
			int leftCount = findMinCharsOptimizedHelper(s, start + 1, end, cache) + 1;
			int rightCount = findMinCharsOptimizedHelper(s, start, end - 1, cache) + 1;
			count = Math.min(leftCount, rightCount);
		}
		
		cache.put(s.substring(start, end + 1), count); // (end + 1) because substring method excludes last index
		return count;
	}

	public static void main(String[] args) {
		String input = "ab";
		int count = findMinInsertions(input);
		System.out.println(input + " => " + count);
		
		input = "aa";
		count = findMinInsertions(input);
		System.out.println(input + " => " + count);
		
		input = "abcd";
		count = findMinInsertions(input);
		System.out.println(input + " => " + count);
		
		input = "abcda";
		count = findMinInsertions(input);
		System.out.println(input + " => " + count);
		
		input = "abcde";
		count = findMinInsertions(input);
		System.out.println(input + " => " + count);
		
		input = "abcde";
		count = findMinCharsOptimized(input);
		System.out.println(input + " => " + count);
	}
}

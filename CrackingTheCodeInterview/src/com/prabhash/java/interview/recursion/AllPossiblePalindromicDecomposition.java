package com.prabhash.java.interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a String, generate all possible palindromic decomposition.
 * 
 * @author Prabhash Rathore
 *
 */
public class AllPossiblePalindromicDecomposition {
	
	/**
	 * Generate all possible palindromic decomposition of a given string.
	 * 
	 * Time Complexity: O(2 ^ n)
	 * 
	 * @param s
	 * @return allPalindromes
	 */
	public static List<List<String>> generateAllPossiblePalindromicDecompositions(String s) {
		if(s == null || s.length() == 0) {
			return null;
		}
		
		List<List<String>> allPalindromes = new ArrayList<>();
		List<String> palindromeList = new ArrayList<>();
		
		helper(s, palindromeList, allPalindromes);
		return allPalindromes;
	}
	
	private static void helper(String s, List<String> palindromes, List<List<String>> result) {
		if(s.length() == 0 && palindromes.size() > 0) {
			result.add(new ArrayList<>(palindromes)); // make sure to add a copy of palindromes list
			return;
		}
		
		for(int i = 1; i <= s.length(); i++) {
			String subString = s.substring(0, i);
			if(isPalindrome(subString)) {
				palindromes.add(subString);
				helper(s.substring(i), palindromes, result);
				palindromes.remove(subString); // make sure to remove stake entries from previous recursive stack
			}
		}
	}
	
	private static boolean isPalindrome(String s) {
		if(s == null || s.length() == 0) {
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
	
	private static void printAllPalindromes(List<List<String>> allPalindromes) {
		if(allPalindromes == null || allPalindromes.size() == 0) {
			System.out.println("No palindromes available!");
			return;
		}
		
		for(List<String> list : allPalindromes) {
			for(String s : list) {
				System.out.print(s + " ");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		// test case 1
		final String input = "nitin";
		List<List<String>> allPalindromes = generateAllPossiblePalindromicDecompositions(input);
		
		System.out.println("Here are all possible palindromic decomposition:");
		printAllPalindromes(allPalindromes);
		
		// test case 2
		final String input2 = "geeks";
		List<List<String>> allPalindromes2 = generateAllPossiblePalindromicDecompositions(input2);
		
		System.out.println("\nHere are all possible palindromic decomposition:");
		printAllPalindromes(allPalindromes2);
	}
}

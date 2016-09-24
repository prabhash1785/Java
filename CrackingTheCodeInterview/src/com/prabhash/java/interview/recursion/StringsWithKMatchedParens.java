package com.prabhash.java.interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Program to generate list of strings with given k number of matched parentheses.
 * 
 * For n = 3, output is:
 * ((()))
 * (()())
 * (())()
 * ()(())
 * ()()()
 * 
 * @author Prabhash Rathore
 *
 */
public class StringsWithKMatchedParens {
	
	/**
	 * This is a very recursive solution. Keep two counters one for open brace and other for close brace. Both counters initial value
	 * will be equal to k. As long as open brace count > 0, keep adding open brace and recurse by decrementing open brace count. To put
	 * close brace, make sure open brace count < close brace for it to be a proper brace string. When both open and close brace count
	 * are 0, add this brace string to list.
	 * 
	 * @param k
	 * @return result
	 */
	public static List<String> getKMatchedParens(int k) {
		if(k <= 0) {
			return null;
		}
		
		List<String> result = new ArrayList<>();
		getKMatchedParensHelper(k, k, "", result);
		
		return result;
	}
	
	private static void getKMatchedParensHelper(int openBraceNeeded, int closeBraceNeeded, String text, List<String> result) {
		if(openBraceNeeded == 0 && closeBraceNeeded == 0) {
			result.add(text);
			return;
		}
		
		if(openBraceNeeded > 0) {
			text += "(";
			getKMatchedParensHelper(openBraceNeeded - 1, closeBraceNeeded, text, result);
			text = text.substring(0, text.length() - 1); // Make sure to remove the last character after each recursion
		}
		
		if(openBraceNeeded < closeBraceNeeded) {
			text += ")";
			getKMatchedParensHelper(openBraceNeeded, closeBraceNeeded - 1, text, result);
		}
	}
	
	public static void printBracesFromList(List<String> list) {
		if(list == null || list.size() == 0) {
			System.out.println("\nNo braces found!");
		}
		
		for(String text : list) {
			System.out.println(text);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		List<String> result = getKMatchedParens(n);
		printBracesFromList(result);
	}

}

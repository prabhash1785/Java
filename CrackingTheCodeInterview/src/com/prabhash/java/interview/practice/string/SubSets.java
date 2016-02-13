package com.prabhash.java.interview.practice.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Find all subsets or power-set of a given string.
 * 
 * Number of subsets for a given string for of size n = 2^n
 * 
 * Time Complexity: O(2 ^ n)
 * 
 * @author prrathore
 *
 */
public class SubSets {
	
	/**
	 * Method 1: Recursive method to find powerset of a string.
	 * 
	 * Time Complexity: O(2 ^ n)
	 * 
	 * @param s
	 * @return
	 */
	public static List<String> findAllSubSets(String s) {
		
		if(s == null || s.length() == 0) {
			return null;
		}
		
		List<String> list = new ArrayList<>();
		
		list.add(""); // add empty subset
		
		for(int i = 0; i < s.length(); i++) {
			
			String pre = String.valueOf(s.charAt(i));
			
//			if(i + 1 > s.length()) {
//				break;
//			}
			
			String suf = s.substring(i + 1);
			
			list.add(pre);
			
			helper(pre, suf, list);
		}
		
		return list;
	}
	
	private static void helper(String prefix, String suffix, List<String> list) {
		
		for(int k = 0; k < suffix.length(); k++) {
			
			String subSet = prefix + suffix.charAt(k);
			list.add(subSet);
			
//			if(k + 1 >= suffix.length()) {
//				break;
//			}
			
			helper(subSet, suffix.substring(k + 1), list);
		}
		
	}
	
	/**
	 * Method 2: Find powerset using Combinatorics method.
	 * 
	 * Use binary string from 0 to (1 << n) or (2 ^ n) to represent subsets of a string. 
	 * 
	 * @param args
	 */
	public static List<String> powerSetUsingCombinatorics(String input) {
		
		if(input == null || input.length() == 0) {
			return null;
		}
		
		List<String> powerSet = new ArrayList<>();
		
		int inputLength = input.length();
		int powerSetSize = 1 << inputLength;
		
		for(int i = 0; i < powerSetSize; i++) {
			
			String subSet = Integer.toBinaryString(i);
			
			// pad zeroes in front of subset if it's length is les than input length
			if(subSet.length() < inputLength) {
				subSet = padZeroes(subSet, inputLength);
			}
			
			StringBuffer sb = new StringBuffer();
			
			for(int k = 0; k < subSet.length(); k++) {
					
				if(subSet.charAt(k) == '1') {
					sb.append(input.charAt(k));
				}
			}
			
			powerSet.add(new String(sb));
			
		}
		
		return powerSet;
	}
	
	/**
	 * Recursively pad zeroes to string until it's size is equal to n
	 * 
	 * @param s
	 * @param n
	 * @return
	 */
	private static String padZeroes(String s, int n) {
		
		if(s.length() == n) {
			return s;
		}
		
		return padZeroes("0" + s, n);
	}
	
	private static void printList(List<String> list) {
		
		if(list == null) {
			throw new NullPointerException("List is null");
		}
		
		System.out.println("Number of subsets: " + list.size());
		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			System.out.println("{" + iterator.next() + "}");
		}
	}	
	
	public static void main(String[] args) {
		
		String text = "abcd";
		
		List<String> subsets = findAllSubSets(text);
		System.out.println("Powerset using recursive method:");
		printList(subsets);
	
		List<String> powerSet = powerSetUsingCombinatorics(text);	
		System.out.println("\n\nPowerset using combinatorics method:");
		printList(powerSet);

	}

}

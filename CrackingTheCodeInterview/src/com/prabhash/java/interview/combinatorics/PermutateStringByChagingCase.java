package com.prabhash.java.interview.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all permutations of a string keeping the sequence but changing cases.
 * 
 * Examples:
 * Input : ab
 * Output : AB Ab ab aB
 * 
 * a -> a A
 * ab -> ab aB Ab AB
 * List<String> F(s)
 * 
 * Input : ABC
 * Output : abc Abc aBc ABc abC AbC aBC ABC
 * 
 * @author Prabhash Rathore
 *
 */
public class PermutateStringByChagingCase {

	/**
	 * Time Complexity: O(2 ^ n)
	 * 
	 * @param s
	 * @return List<String>
	 */
	public static List<String> permutateStringWithCase(String s) {
		if(s == null || s.length() == 0) {
			return new ArrayList<>();
		}
		
		return permutateStringWithCaseHelper(s.toLowerCase());
	}
	
	private static List<String> permutateStringWithCaseHelper(String s) {
		List<String> list = new ArrayList<>();
		if(s.length() == 0) {
			list.add("");
			return list;
		}
		
		char prefix = s.charAt(0);
		List<String> subList = permutateStringWithCaseHelper(s.substring(1));
		
		for(int i = 0; i < subList.size(); i++) {
			String item = subList.get(i);
			String s1 = prefix + item;
			String s2 = Character.toUpperCase(prefix) + item;
			
			list.add(s1);
			list.add(s2);
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		String input = "abc";
		List<String> perms = permutateStringWithCase(input);
		
		if(perms.size() == 0) {
			System.out.println("No permutations found!!");
		} else {
			System.out.println("Here are case change permutations of " + input + ":");
			for(String s : perms) {
				System.out.println(s);
			}
		}
	}
}

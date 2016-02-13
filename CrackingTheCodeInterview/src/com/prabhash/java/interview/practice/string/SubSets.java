package com.prabhash.java.interview.practice.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Find all subsets of a given string.
 * 
 * Number of subsets for a given string for of size n = 2^n
 * 
 * Time Complexity: O(2 ^ n)
 * 
 * @author prrathore
 *
 */
public class SubSets {
	
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
	
	public static void printList(List<String> list) {
		
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
		
		String text = "abc";
		
		List<String> subsets = findAllSubSets(text);
		
		printList(subsets);

	}

}

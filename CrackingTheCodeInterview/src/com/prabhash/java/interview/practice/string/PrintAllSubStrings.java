package com.prabhash.java.interview.practice.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all substrings for a given string.
 * 
 * @author Prabhash Rathore
 *
 */
public class PrintAllSubStrings {
	
	public static List<String> getAllSubStrings(String s) {
		if(s == null) {
			return null;
		}
		
		List<String> list = new ArrayList<>();
		for(int i = 0; i < s.length(); i++) {
			String t = "";
			for(int j = i + 1; j <= s.length(); j++) {
				t = s.substring(i, j);
				list.add(t);
			}
		}
		
		return list;
	}
	
	public  static void printList(final List<String> list) {
		if(list == null) {
			return;
		}
		
		for(String s : list) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		String text = "hellothereyoulookgood";
		List<String> substrings = getAllSubStrings(text);
		System.out.println("Here all all substrings for text " + text + ":\n");
		printList(substrings);
	}

}
 
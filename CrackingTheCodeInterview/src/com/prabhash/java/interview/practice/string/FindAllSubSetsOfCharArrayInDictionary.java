package com.prabhash.java.interview.practice.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * You are given a dictionary (a set of words). They will enter a set of characters you have to print all the words that can be 
 * formed using these characters.
 * 
 * For eg:
 * dict:- { “Rat”, “mat” ,”bat”, “chat”, “cat”, “tab”, “fab”, “batt” }
 * chars:- t a b c
 * output:- bat, cat, tab
 * 
 * @author Prabhash Rathore
 *
 */
public class FindAllSubSetsOfCharArrayInDictionary {
	
	private static final Set<String> dictionary = new HashSet<>();
	
	static {
		dictionary.add("Rat");
		dictionary.add("mat");
		dictionary.add("bat");
		dictionary.add("chat");
		dictionary.add("cat");
		dictionary.add("tab");
		dictionary.add("fab");
		dictionary.add("batt");
	}
	
	/**
	 * Generate all subsets for given character array. Compare each subset in dictionary and if it exists, add that to 
	 * output list.
	 * 
	 * @param array
	 * @return subsetsInDictionary
	 */
	public static List<String> findSubSetsInDictionary(char[] array) {
		if(array == null) {
			throw new NullPointerException();
		}
		
		final Set<String> allLowerCaseDict = new HashSet<>();
		Iterator<String> iter = dictionary.iterator();
		while(iter.hasNext()) {
			String s = iter.next().toLowerCase();
			allLowerCaseDict.add(s);
		}
		
		List<String> wordsInDict = new ArrayList<>();
		getPerms(new String(array), wordsInDict, allLowerCaseDict);
		
		return wordsInDict;
	}
	
	/**
	 * Find all the Permutations for a give n string using Recursion. This is the preferred method to find permutation of a String.
	 * 
	 * Time Complexity: O(n!)
	 */
	public static List<String> getPerms(String str, List<String> wordsInDict, Set<String> dict) {
		if (str == null) {
			return null;
		}
		List<String> permutations = new ArrayList<String>();
		if (str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}

		char first = str.charAt(0); // get the first character
		String remainder = str.substring(1); // remove the first character
		List<String> words = getPerms(remainder, wordsInDict, dict);
		for (String word : words) {
			
			if(dict.contains(word.toLowerCase())) {
				wordsInDict.add(word);
			}
			
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				
				if(dict.contains(s.toLowerCase())) {
					wordsInDict.add(s);
				}
				
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	/**
	 * Utility method to add character to a string in a given position
	 * 
	 */
	private static String insertCharAt(String str, char ch, int i) {
		String start = str.substring(0, i);
		String last = str.substring(i);
		return start + ch + last;
	}

	/**
	 * Find all subsets for given array of characters.
	 * 
	 * Time Complexity: (2 ^ n)
	 * 
	 * @param array
	 * @return subsets
	 */
	public static List<String> findAllSubSets(char[] array) {
		if(array == null) {
			return null;
		}
		
		String text = new String(array);
		
		List<String> subsets = new ArrayList<String>();
		subsets.add("");
		
		for(int i = 0; i < text.length(); i++) {
			String prefix = String.valueOf(text.charAt(i));
			String suffix = text.substring(i + 1);
			
			subsets.add(String.valueOf(prefix));
			
			findAllSubSetsHelper(prefix, suffix, subsets);
		}
		
		return subsets;
	}
	
	private static void findAllSubSetsHelper(String prefix, String suffix, List<String> list) {
		for(int k = 0; k < suffix.length(); k++) {
			String word = prefix + suffix.charAt(k);
			list.add(word);
			
			findAllSubSetsHelper(word, suffix.substring(k + 1), list);
		}
	}
	
	private static void printListString(List<String> subsets) {
		if(subsets == null) {
			System.out.println("\nNo string found");
		}
		
		System.out.println("Number of strings: " + subsets.size());
		for(String s : subsets) {
			System.out.print("{" + s + "} ");
		}
	}
	
	public static void main(String[] args) {
		char[] charArray = new char[] {'t', 'a', 'b', 'c'};
		
		// all permutations of given array
//		List<String> perms = getPerms(new String(charArray));
//		System.out.println("Here are all permutations");
//		printListString(perms);
		
		// all subsets of char array
//		List<String> allSubSets = findAllSubSets(charArray);
//		System.out.println("\nHere are all subsets:");
//		printListString(allSubSets);
		
		List<String> subsetsInDict = findSubSetsInDictionary(charArray);
		System.out.println("\nHere are possible subsets in dictionary:");
		printListString(subsetsInDict);
	}

}

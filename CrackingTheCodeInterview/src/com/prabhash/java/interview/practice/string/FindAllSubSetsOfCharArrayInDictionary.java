package com.prabhash.java.interview.practice.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	 * Store given char array in a Map with count of each character. Then compare each word from dictionary to map of chracters,
	 * if dictionary word is a subset of character array stored in map, then it'a valid word.
	 * 
	 * @param array
	 * @return subsetsInDictionary
	 */
	public static List<String> findSubSetsInDictionary(char[] array) {
		if(array == null) {
			throw new NullPointerException();
		}
		
		List<String> wordsInDict = new ArrayList<>();
		
		Iterator<String> iterator = dictionary.iterator();
		while(iterator.hasNext()) {
			String word = iterator.next();
			if(isSubSet(word.toCharArray(), array)) {
				wordsInDict.add(word);
			}
		}
		
		return wordsInDict;
	}
	
	/**
	 * Check if char array1 is subset of char array2. Store chars in array2 to a Map with corresponding count of each character.
	 * Then compare chars in array1 with chars stored in Map. If everything matches then it's a valid subset word else not.
	 * 
	 * @param word1
	 * @param word2
	 * @return boolean
	 */
	private static boolean isSubSet(char[] array1, char[] array2) {
		if(array1 == null || array2 == null) {
			return false;
		}
		
		if(array1.length > array2.length) {
			return false;
		}
		
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < array2.length; i++) {
			if(map.containsKey(array2[i])) {
				int value = map.get(array2[i]);
				map.put(array2[i], ++value);
			} else {
				map.put(array2[i], 1);
			}
		}
		
		for(int i = 0; i < array1.length; i++) {
			if(!map.containsKey(array1[i])) {
				return false;
			} else {
				if(map.get(array1[i]) <= 0) {
					return false;
				}
				
				int count = map.get(array1[i]);
				map.put(array1[i], --count);
			}
		}
		
		return true;
	}
	
	private static void printListString(List<String> subsets) {
		if(subsets == null) {
			System.out.println("\nNo string found");
		}
		
		System.out.println("Number of strings: " + subsets.size());
		for(String s : subsets) {
			System.out.print(s + " ");
		}
	}
	
	public static void main(String[] args) {
		char[] charArray = new char[] {'t', 'a', 'b', 'c'};
		
		List<String> subsetsInDict = findSubSetsInDictionary(charArray);
		System.out.println("\nHere are possible subsets in dictionary:");
		printListString(subsetsInDict);
	}
}

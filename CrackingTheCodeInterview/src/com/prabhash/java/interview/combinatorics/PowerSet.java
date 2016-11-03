package com.prabhash.java.interview.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PowerSet {
	
	/**
	 * Method 1:
	 * Find powerset of a given list of string recursively.
	 * To calculate powerset recursively, calculate powerset of the one unit object from input list. And then keep adding new element to the
	 * output of previous computation in addition to the original computation to final result.
	 * 
	 * For example: input = {a, b}
	 * PowerSet of {b} = {}, {b}
	 * PowerSet of {a, b} = PowerSet of {b} + [Add {a} to each object of PowerSet of {b}}
	 * 					  = {}, {b}, {a}, {a, b}
	 * 
	 * Time Complexity: O(2 ^ n)
	 * 
	 * @param list
	 * @return List<List<String>>
	 */
	public static List<List<String>> getPowerSetRecursively(List<String> list) {
		if(list == null) {
			return null;
		}
		
		return getPowerSetRecursivelyHelper(list, 0);
	}
	
	private static List<List<String>> getPowerSetRecursivelyHelper(List<String> list, int index) {
		List<List<String>> result = new ArrayList<>();
		if(index >= list.size()) {
			result.add(new LinkedList<>()); // add empty list
			return result;
		}
		
		String current = list.get(index);
		List<List<String>> setObjects = getPowerSetRecursivelyHelper(list, index + 1);
		
		// Add the previous list and then also append the current string to all strings in the list to form new set objects
		result.addAll(setObjects);
		for(List<String> stringList : setObjects) {
			List<String> l = new ArrayList<>(stringList); // copy list into a new list to prevent overwrites
			l.add(current);
			
			result.add(l);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
    	List<String> list = Arrays.asList("foo", "bar", "baz", "sun");
    	List<List<String>> powerSet = getPowerSetRecursively(list);
    	System.out.println("Here is power set:");
    	for(List<String> strings : powerSet) {
    		System.out.print("{");
    		for(String s : strings) {
    			System.out.print(s + " ");
    		}
    		System.out.print("}\n");
  
    	}
	}
}

package com.prabhash.java.interview.combinatorics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Generate permutations for given input.
 * 
 * @author Prabhash Rathore
 *
 */
public class Permutations {

	/**
	 * Generate permutations for given input string.
	 * 
	 * Time Complexity: O(n!) where n is size of string
	 * 
	 * @param s
	 * @return List<String>
	 */
	public static List<String> getPermutationsForString(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}

		return getPermutationsForStringHelper(s);
	}

	private static List<String> getPermutationsForStringHelper(String s) {
		List<String> list = new ArrayList<>();
		if (s.length() == 0) {
			list.add(""); // this is important, without this no permutation will be created
			return list;
		}

		char c = s.charAt(0);

		List<String> perms = getPermutationsForStringHelper(s.substring(1));

		for (int j = 0; j < perms.size(); j++) {
			String t = perms.get(j);
			for (int k = 0; k <= t.length(); k++) {
				String pre = t.substring(0, k);
				String suffix = t.substring(k);
				String perm = pre + c + suffix;
				list.add(perm);
			}
		}

		return list;
	}
	
	/**
	 * Generate permutations of given array of objects.
	 * 
	 * Time complexity: O(n!) where n is the size of array
	 * 
	 * @param object
	 * @return permutations
	 */
	public static List<List<Object>> getPermutationOfObjects(Object[] object) {
		if(object == null || object.length == 0) {
			return null;
		}
		
		List<List<Object>> permutations = getPermutationOfObjectsHelper(object, 0);

		if(permutations == null) {
			return null;
		}
		
		return permutations;
	}
	
	private static List<List<Object>> getPermutationOfObjectsHelper(Object[] objects, int index) {
		List<List<Object>> result = new ArrayList<>();
		if(index >= objects.length) {
			result.add(new LinkedList<>()); // MUST DO: Make sure to add an empty list otherwise no permutations will be created
			return result;
		}
		
		Object obj = objects[index];
		List<List<Object>> list = getPermutationOfObjectsHelper(objects, index + 1);
		
		for(int i = 0; i < list.size(); i++) {
			List<Object> o = list.get(i);
			
			for(int j = 0; j <= o.size(); j++) {
				List<Object> perm = new LinkedList<>(o); // copy of original array from previous list<list> computation
				if(j < o.size()) {
					perm.add(j, obj);
				} else {
					perm.add(obj);
				}
				result.add(perm);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		String text = "abc";
		List<String> permutations = getPermutationsForString(text);
		System.out.println("Here are permutations:");
		for (String s : permutations) {
			System.out.println(s);
		}
		
		// Test case for Object Permutations
		Object[] objects = new Object[] {
				"foo", "bar", "baz"
		};
		
		List<List<Object>> objectPermutations = getPermutationOfObjects(objects);
		System.out.println("Here are all object permutations with size: " + objectPermutations.size());
		for(List<Object> p : objectPermutations) {
			for(Object o : p) {
				System.out.print(o.toString() + " ");
			}
			System.out.print("\n");
		}
	}
}

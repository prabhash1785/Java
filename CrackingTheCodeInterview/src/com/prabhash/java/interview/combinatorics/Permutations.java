package com.prabhash.java.interview.combinatorics;

import java.util.ArrayList;
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
	
	public static Object[][] getPermutationOfObjects(Object[] object) {
		if(object == null || object.length == 0) {
			return null;
		}
		
		List<Object[]> permutations = getPermutationOfObjectsHelper(object, 0);
		Object[][] permutationsArray = (Object[][]) permutations.toArray();
		
		return permutationsArray;
	}
	
	private static List<Object[]> getPermutationOfObjectsHelper(Object[] objects, int index) {
		List<Object[]> result = new ArrayList<>();
		if(index >= objects.length) {
			result.add(new Object[] {null});
			return result;
		}
		
		Object obj = objects[index];
		List<Object[]> list = getPermutationOfObjectsHelper(objects, index + 1);
		
		for(int i = 0; i <= list.size(); i++) {
			Object[] o = list.get(i);
			
			for(int j = 0; j < o.length; j++) {
				List<Object> p = new ArrayList<>();
				int counter = 0;
				while(counter < j) {
					p.add(o[counter]);
					++counter;
				}
				
				p.add(o);
				++counter;
				
				while(counter < o.length) {
					p.add(o[counter - 1]);
					++counter;
				}
				
				result.add(p.toArray());
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
		
		Object[][] objectPermutations = getPermutationOfObjects(objects);
		System.out.println("Here are all object permutations:");
		for(Object[] p : objectPermutations) {
			for(Object o : p) {
				System.out.println(o.toString());
			}
		}
	}
}

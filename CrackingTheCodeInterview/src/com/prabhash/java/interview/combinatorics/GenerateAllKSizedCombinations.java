package com.prabhash.java.interview.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generate all k-sized combinations from a n-sized list.
 * 
 * @author Prabhash Rathore
 *
 */
public class GenerateAllKSizedCombinations {
	
	/**
	 * Generate all k-sized combinations.
	 * 
	 * @param list
	 * @param m
	 * @return result
	 */
	public static List<List<Integer>> generateKSizedCombinations(List<Integer> list, int m) {
		if(list == null || m < 1) {
			throw new IllegalArgumentException();
		}

		List<List<Integer>> result = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();
		helper(list, 0,  m, combination, result);

		return result;
	}

	private static void helper(List<Integer> list, int i, int m, List<Integer> combination, List<List<Integer>> result) {
		// base condition
		if(i > list.size()) {
			return;
		}

		if(combination.size() == m) {
			result.add(new ArrayList<>(combination));
			return;
		}

		for(int j = i; j < list.size(); j++) {
			combination.add(list.get(j));
			helper(list, j + 1, m, combination, result);
			combination.remove(combination.size() - 1);
		}
	}

	public static void main(String[] args) {
		final List<Integer> list = Arrays.asList(2, 6, 1, 8);
		final int m = 2;
		
		List<List<Integer>> result = generateKSizedCombinations(list, m);
		System.out.println("Here are all " + m  + " sized combinations:");
		for(List<Integer> l : result) {
			for(Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.print("\n");
		}
	}
}

package com.prabhash.interview.practice.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shuffler {
	
	public static void shuffleNumbers(final List<Integer> list) {
		
		if(list == null) {
			throw new NullPointerException();
		}
		
		// shuffle elements in list
		Collections.shuffle(list);
	}
	
	private static <T> void printListElements(final List<T> list) {
		
		if(list == null) {
			throw new NullPointerException();
		}
		
		for(T item : list) {
			System.out.print(item + " ");
		}
	}

	public static void main(String[] args) {
		
		final List<Integer> a = new ArrayList<>();
		
		for(int i = 0; i < 52; i++) {
			a.add(i + 1);
		}
		
		System.out.println("Original list: ");
		printListElements(a);
		
		shuffleNumbers(a);
		
		System.out.println("\nList after shuffling:");
		printListElements(a);
	}

}

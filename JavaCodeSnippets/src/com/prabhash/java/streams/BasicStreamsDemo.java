package com.prabhash.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BasicStreamsDemo {
	
	public static void printEvenNumbers(final List<Integer> list) {
		
		Predicate<Integer> evenNumberPred = n -> (n % 2 == 0);
		
		long evenNumbersCount = list.stream().filter(evenNumberPred).count();
		System.out.println("Even number count is: " + evenNumbersCount);
	}

	public static void main(String[] args) {
		
		final List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(4);
		list.add(11);
		list.add(34);
		list.add(7);
		list.add(19);
		
		printEvenNumbers(list);
	}

}

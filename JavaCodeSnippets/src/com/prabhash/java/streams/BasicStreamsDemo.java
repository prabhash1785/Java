package com.prabhash.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStreamsDemo {
	
	public static void printEvenNumbers(final List<Integer> list) {
		
		Predicate<Integer> evenNumberPred = n -> (n % 2 == 0);
		
		long evenNumbersCount = list.stream().filter(evenNumberPred).count();
		System.out.println("Even number count is: " + evenNumbersCount);
		
		list.stream()
		    .filter(evenNumberPred)
		    .forEach(i -> System.out.println(i));
	}
	
	public static void convertStringToUpperCase() {
		
		List<String> collected = Stream.of("hello", "java8", "lambda", "STreams")
									   .map(s -> s.toUpperCase())
									   .collect(Collectors.toList());
		
		collected.forEach(s -> System.out.println(s));
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
		convertStringToUpperCase();
		
		//pick even numbers from given list
		Predicate<Integer> oddPredicate = n -> n % 2 != 0;
		long count = Stream.of(2, 5, 6, 7, 10).filter(oddPredicate).count();
		System.out.println("Number of odd elements in list: " + count);
	}

}

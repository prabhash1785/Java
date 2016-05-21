package com.prabhash.java.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class FunctionalInterfaceDemo {
	
	public static void main(String[] args) {
			
		// use Predicate functional interface for boolean type operations
		Predicate<String> isStringEmpty = s -> s.isEmpty();
		String text = "hello";
		System.out.println("Is text empty: " + isStringEmpty.test(text));
		
		// use BinaryOperator functional interface for binary operations
		BinaryOperator<Integer> sum = (a, b) -> a + b;
		final int x = 4, y = 10;  
		System.out.println("Sum of x and y = " + sum.apply(x, y));
	}
}

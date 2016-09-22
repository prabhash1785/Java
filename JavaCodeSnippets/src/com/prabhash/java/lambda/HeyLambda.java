package com.prabhash.java.lambda;

import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Lambda Expression Play-Ground
 * 
 * @author Prabhash Rathore
 *
 */
public class HeyLambda {
	
	/**
	 * Interface with only one method
	 *
	 */
	@FunctionalInterface
	public static interface Animal {
		public String speak();
	}
	
	public static void printAnimalSpeech(Animal animal) {
		System.out.println(animal.speak());
	}

	public static void main(String[] args) {
		Animal animal = () -> "hey there"; // Implementation of Interface using Lambda Expression
		printAnimalSpeech(animal);
		
		Predicate<String> isEvenLengthString = s -> s.length() % 2 == 0;
		assertTrue("Not an even length string", isEvenLengthString.test("four"));
	}
}

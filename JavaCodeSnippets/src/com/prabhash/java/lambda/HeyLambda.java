package com.prabhash.java.lambda;

/**
 * Lambda Expression Play-Ground
 * 
 * @author Prabhash Rathore
 *
 */
public class HeyLambda {
	
	public static interface Animal {
		public String speak();
	}
	
	public static void printAnimalSpeech(Animal animal) {
		System.out.println(animal.speak());
	}

	public static void main(String[] args) {
		Animal animal = () -> "hey there"; // Implementation of Interface using Lambda Expression
		printAnimalSpeech(animal);
	}
}

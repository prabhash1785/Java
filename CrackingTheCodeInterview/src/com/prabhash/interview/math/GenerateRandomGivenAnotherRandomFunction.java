package com.prabhash.interview.math;

import java.util.Random;

/**
 * Generate random number with specific seed given some random number function.
 * 
 * @author Prabhash Rathore
 *
 */
public class GenerateRandomGivenAnotherRandomFunction {
	
	/**
	 * Function with static functionality. It return random number with seed 1. The value is either 0 or 1.
	 * 
	 * @return
	 */
	public static int f1() {
		Random random = new Random();
		return random.nextInt(2);
	}
	
	public static int f29Usingf1() {
		int randomNum = (f1() + 1) * (f1() + 1) * (f1() + 1) * (f1() + 1) * (f1() + 1);
		if(randomNum <= 30) {
			return randomNum - 1;
		}
		
		return f29Usingf1();
	}
	
	/**
	 * Generates pseudo random number from 1 to 5 with equal probability.
	 * 
	 * @return pseudo random number
	 */
	public static int f5() {
		final Random random = new Random();
		return random.nextInt(5) + 1;
	}
	
	public static int f7Usingf5() {
		int randomNum = f5() * f5();
		if(randomNum <= 21) {
			return ((randomNum % 7) + 1);
		}
		
		return f7Usingf5();
	}

	public static void main(String[] args) {
		System.out.println("Here are some random numbers generated for f1():");
		for(int i = 0; i < 10; i++) {
			System.out.println(f1());
		}
		
		System.out.println("\nHere are some random numbers generated for f29() using f1():");
		for(int i = 0; i < 1000; i++) {
			System.out.println(f29Usingf1());
		}
		
//		System.out.println("\nHere are some random numbers generated for f5():");
//		for(int i = 0; i < 10; i++) {
//			System.out.println(f5());
//		}
//		
//		System.out.println("\nHere are some random numbers generated for f7() using f5():");
//		for(int i = 0; i < 10; i++) {
//			System.out.println(f7Usingf5());
//		}
	}
}

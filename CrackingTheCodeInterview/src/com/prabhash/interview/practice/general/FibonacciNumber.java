package com.prabhash.interview.practice.general;

import java.math.BigInteger;

public class FibonacciNumber {
	
	/**
	 * Use BigInteger instead of int type to prevent Out of Bound errors while calculating large Fibonacci Numbers.
	 * 
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	private static BigInteger findNthFibonacciNumberHelper(BigInteger a, BigInteger b, int n) {
		
		if(n < 1) {
			return b;
		}
		
		return findNthFibonacciNumberHelper(b, b.add(a), n - 1);
		
	}
	
	public static BigInteger findNthFibonacciNumber(int n) {
		return findNthFibonacciNumberHelper(BigInteger.ZERO, BigInteger.ONE, n - 2);
	}

	public static void main(String[] args) {
		
		int n = 50;
		BigInteger nthFibonacciNumber = findNthFibonacciNumber(n);
		
		System.out.println(n + "th Fibonacci number is: " + nthFibonacciNumber);
		
	}

}

package com.prabhash.interview.practice.general;

/**
 * Reverse the given number.
 * 
 * @author prrathore
 *
 */
public class ReverseNumber {
	
	/**
	 * Reverse a positive number.
	 * 
	 * @param n
	 * @return x
	 */
	public static int reverseNumber(int n)  {
		int x = 0;
		while(n > 0) {
			int rem = n % 10;
			x = (x * 10) + rem;
			n = n / 10;
		}

		return x;
	}

	public static void main(String[] args) {
		int a = 3456;
		int reversedNum = reverseNumber(a);
		System.out.println("Here is reversed number: " + reversedNum);
	}

}

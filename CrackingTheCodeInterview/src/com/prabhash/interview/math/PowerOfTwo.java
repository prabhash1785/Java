package com.prabhash.interview.math;

/**
 * Find if a number is power of two.
 * 
 * @author prrathore
 *
 */
public class PowerOfTwo {

	/**
	 * Method 1:
	 * 
	 * Continuously divide the number by 2 until number is greater than 1. If anytime remainder > 0, then it's not a power
	 * of 2 else it's a power of 2.
	 * 
	 * Time Complexity: O(log n)
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwoUsingDivision(int n) {
		
		if(n <= 0) {
			return false;
		}
		
		int rem = 0;
		while(n > 1) {
			
			rem = n % 2;
			n = n / 2;
			
			if(rem != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Method 2:
	 * 
	 * Since int holds a max of 2 ^ 32 integer value, we can keep calculating exponential of 2 starting from 2 to 32. If any
	 * exponential == n, then it's a power of 2. If at any point, exponential > n, then it must not be a power of 2.
	 * 
	 * Time Complexity: O(log n)
	 * 
	 * @param n
	 * @return boolean
	 */
	public static boolean isPowerOfTwoUsingMultiplication(int n) {
		
		if(n <= 0) {
			return false;
		}
		
		int i = 0;
		double exp = 0;
		
		while(i <= 32) { // because int can hold a max of 2 ^ 32 number so no point going more than 32 times
			
			exp = Math.pow(2, i);
			
			if(exp == n) {
				return true;
			} else if(exp > n) {
				return false;
			}
			
			i++;
		}
		
		return false;
	}
	
	/**
	 * Method 3:
	 * 
	 * For any number to be power of 2, there should be only one bit set, every other bit should be unset. So find the bits of the given
	 * number, check the number of set bits, it has exactly one set bit, then it's a power of 2 else it is not.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwoUsingBitInspection(int n) {
		
		int setBitCount = Integer.bitCount(n);
		System.out.println("Set Bit Count = " + setBitCount);
		
		if(setBitCount == 1) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		int num = 64;
		boolean isPowerOfTwo = isPowerOfTwoUsingDivision(num);
		System.out.println(num + " is power of 2: " + isPowerOfTwo);
		
		isPowerOfTwo = isPowerOfTwoUsingMultiplication(num);
		System.out.println(num + " is power of 2: " + isPowerOfTwo);
		
		isPowerOfTwo = isPowerOfTwoUsingBitInspection(num);
		System.out.println(num + " is power of 2: " + isPowerOfTwo);
	}

}

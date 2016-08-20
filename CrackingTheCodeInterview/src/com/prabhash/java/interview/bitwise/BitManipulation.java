package com.prabhash.java.interview.bitwise;

/**
 * Lower level bit manipulation
 * 
 * @author prrathore
 *
 */
public class BitManipulation {
	
	/**
	 * Check if number is odd or even.
	 * 
	 * For a number to be even, it's least sugnificany bit must be zero else it is odd.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isEven(int n) {
		if((n & 1) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Set the ith bit of the given number.
	 * 
	 * Bitwise OR is used to set bit. In this case to set an ith bit, we will use mask value of 1 and then do a bitwise left shift
	 * on this number "i" times. Then do a Bitwise OR of original number and mask.
	 * 
	 * @param n
	 */
	public static void setIthBit(int n, int bitPosition) {
		System.out.println("Original bit pattern: " + Integer.toBinaryString(n)) ;
		int mask = 1 << bitPosition;
		int maskedNum = n | mask;
		System.out.println("Masked number with ith bit set: " + Integer.toBinaryString(maskedNum));
	}
	
	/**
	 * Ith bit can be restet by using following mask and doing a bitwise & with original number.
	 * Mask = ~(1 << i)
	 * 
	 * @param n
	 * @param i
	 */
	public static void resetIthBit(int n, int i) {
		System.out.println("Original bit pattern: " + Integer.toBinaryString(n)) ;
		int mask = ~(1 << i);
		int maskedNum = n & mask;
		System.out.println("Masked number with ith bit set: " + Integer.toBinaryString(maskedNum));
	}

	public static void main(String[] args) {
		
		// Set kth bit
		setIthBit(16, 0);
		setIthBit(16, 1);
		
		// check even or odd
		int a = 12;
		int b = 9;
		System.out.println(a + " is even: " + isEven(a));
		System.out.println(b + " is even: " + isEven(b));
		
		// reset ith bit
		resetIthBit(23, 2);
	}

}

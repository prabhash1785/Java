package com.prabhash.java.interview.bitwise;

/**
 * Lower level bit manipulation
 * 
 * @author prrathore
 *
 */
public class BitManipulation {
	
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

	public static void main(String[] args) {
		
		// Set kth bit
		setIthBit(16, 0);
		setIthBit(16, 1);
	}

}

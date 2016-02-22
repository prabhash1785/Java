package com.prabhash.java.bits;

public class BitManipulation {

	public static void main(String[] args) {
		
		// divide by 32
		int a = 105;
		
		int result = a >> 5; // same as dividing by (2 ^ 5 = 32)
		System.out.println(a + " / 32 = " + result);
		
		int b = 0x1F; // same as 31
		int x = result & b; // same as mod 32
		System.out.println("x = " + x);

	}

}

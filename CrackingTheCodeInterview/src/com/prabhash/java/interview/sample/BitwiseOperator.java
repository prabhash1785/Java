package com.prabhash.java.interview.sample;

/**
 * Bitwise Operation
 * 
 * @author prrathore
 *
 */
public class BitwiseOperator {

	public static void main(String[] args) {
		
		final int n = 12;
		
		// Left bitwise operation is equivalent to multiplying the left operated with 2 to the power of number on right operand
		// a = n * (2 ^ 2)
		int a = n << 2;
		System.out.println("a: " + a); //Prints 48
		
		//Right bitwise operator
		// Divide left operand with (2 ^ operand on right)
		final int m = 128;
		
		int r = m >> 2;
		System.out.println("r: " + r); // 32
		
		
		//Bitwise AND
		//Do logical AND on all BITS of these ints
		final int x = 4;
		final int y = 3;
		int z = x & y;
		
		System.out.println("z: " + z); //Prints 0
		
		//Bitwise OR
		z = x | y;
		System.out.println("z after Bitwise OR: " + z);

	}

}

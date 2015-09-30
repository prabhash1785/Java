package com.prabhash.java.sample;

/**
 * Check to see what integer type definitions are correct.
 * 
 * @author prrathore
 *
 */
public class IntegerDefinitions {

	public static void main(String[] args) {
		
		int a = 0123; //valid Octet number
		// int b = 0678; //Invalid Octet number because 8 is out of bound in octet number. Compilation error.
		int c = 0xfda; //Valid Hex number
		// int d = 1 2 3; //invalid integer, space is not allowed
		int e = 123; //valid integer
		int f = 1_2_3; //valid integer with underscore to represent large numbers
		int g = 0b1010; //valid binary number
		
		System.out.println(a + " " + c + " " + e + " " + f + " " + g);

	}

}

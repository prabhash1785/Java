package com.prabhash.java.interview.practice.string;

/**
 * Find of a string is rotation of other string
 * 
 * @author Prabhash Rathore
 *
 */
public class FindIfStringIsRotation {
	
	/**
	 * Find if s1 is a rotation of s2.
	 * 
	 * For s1 to be rotation of s2, following applies:
	 * - s1.length == s2.length
	 * - s1 must be a substring of (s2 + s2)
	 * 
	 * Note: Sorting string will not work because substring is order dependent and sorting changes the order.
	 * 
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	public static boolean isRotation(String s1, String s2) {
		if(s1 == null || s2 == null) {
			return false;
		}
		
		if(s1.length() != s2.length()) {
			return false;
		}
		
		String concatenatedString = s2 + s2;
		if(isSubString(s1, concatenatedString)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Finds if s1 is substring of s2.
	 * 
	 * For s1 to be a substring of s2, following applies:
	 * - s1.length() <= s2.length()
	 * - s1 must be a part of s2 starting from some index i
	 * 
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	public static boolean isSubString(String s1, String s2) {
		if(s1 == null || s2 == null) {
			return false;
		}
		
		if(s1.length() > s2.length()) {
			return false;
		}
		
		for(int i = 0; i < (s2.length() - s1.length()); i++) {
			int j = 0, count = 0;
			while((j < s1.length()) && ((i + count) < s2.length())) {
				if(s1.charAt(j) != s2.charAt(i + count)) {
					break;
				}
				++j;
				++count;
			}
			if(j == s1.length()) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// substring test
		String s1 = "helloworld", s2 = "hello";
		System.out.println("Is s2 substring of s1: " + isSubString(s2, s1));
		System.out.println("Is s2 substring of s1: " + isSubString("catre", "cater"));
		
		// rotation test
		System.out.println("Is rotation: " + isRotation("cater", "acter"));
		System.out.println("Is rotation: " + isRotation("cat", "cate"));
		System.out.println("Is rotation: " + isRotation("laumbrel", "umbrella"));
	}
}

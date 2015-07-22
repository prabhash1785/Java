package com.prabhash.java.interview.ch1;

/**
 * Find if rotataion of a string is substring of that string by making one call to substring function. 
 * 
 * @author prrathore
 *
 */
public class Q1_8 {
	
	/**
	 * Find out if s2 is a substring of s1.
	 * 
	 * For a string s2 to be substring of s1, we need to check following:
	 *  - length of s2 should be less than or equal to the length of s1
	 *  - Using while loop, check each character of s2 in s1 until the length of s1 is reached. For every char mismatch, reset s2 index back to zero. If all
	 *  characters of s2 are in s1 in same order then s2 is substring of s1.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isSubstring(String s1, String s2) throws Exception {
		
		if((s1 == null) || (s2 == null)) {
			throw new Exception("One of the String parameter is null");
		}
		
		if(s1.length() == 0 || s2.length() == 0) {
			throw new Exception("We need a valid string to do substring test");
		}
		
		if(s2.length() > s1.length()) { //substring length cannot be greater than original string
			return false; 
		}
		
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		
		boolean isSubstring = false;
		
		int s1CharIndex = 0;
		int s2CharIndex = 0;
		
		while(s1CharIndex < ch1.length) {
			
			isSubstring = false;
			s2CharIndex = 0;
			
			while(s2CharIndex < ch2.length) {
				
				if(ch2[s2CharIndex] != ch1[s1CharIndex]) {
					s1CharIndex++; // increase the pointer on first string
					break;
				}
				
				s1CharIndex++;
				s2CharIndex++;
								
			}
			
			if(s2CharIndex == ch2.length) {
				isSubstring = true;
				break;
			}
			
			
		}
		
		return isSubstring;
		
	}

	public static void main(String[] args) throws Exception {
		
		String s1 = "mantango";
		String s2 = "ang";
		
		System.out.println("Is substring: " + isSubstring(s1, s2));

	}

}

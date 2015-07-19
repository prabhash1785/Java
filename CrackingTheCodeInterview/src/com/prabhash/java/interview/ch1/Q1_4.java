package com.prabhash.java.interview.ch1;

import java.util.Arrays;

/**
 * Replace all space in a string with '%20' assuming there is enough memory to copy new characters to the same string.
 * 
 * @author prrathore
 *
 */
public class Q1_4 {
	
	/**
	 * First determine the count of white space in given string.
	 * Find the new length of String after replacing white space with '%20'
	 * Resize array with the new count.
	 * Start from the back of the array, replace white space with '%20' and character with character.
	 * 
	 * @param s
	 * @param length
	 */
	public static void replaceSpace(String s, int length) {
		
		int spaceCount = 0;
		int newLength = 0;
		
		char[] ch = s.toCharArray();
		
		// find the total number of white space count
		for(int i = 0; i < length; i++) {
			
			if(ch[i] == ' ') {
				spaceCount++;
			}
			
		}
		
		newLength = length + (spaceCount * 2);
		
		//create a new array with increased capacity
		ch = Arrays.copyOf(ch, newLength);
		
		for(int i = length - 1; i >= 0; i--) {
			
			if(ch[i] == ' ') {
				ch[newLength - 1] = '0';
				ch[newLength - 2] = '2';
				ch[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				ch[newLength - 1] = ch[i];
				newLength = newLength - 1;
			}
			
		}
		
		System.out.println("Here is white space replaced String: " + new String(ch));
		
	}

	public static void main(String[] args) {
		
		String input = "ap p l e";
		
		replaceSpace(input, input.length());

	}

}

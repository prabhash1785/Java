package com.prabhash.java.interview.ch1;

/**
 * Compress a String like this:
 * aabcccd  = a2b1c3d1
 * 
 * if compressed string is not smaller than original string then replace original string. 
 * 
 * @author prrathore
 *
 */
public class Q1_5 {
	
	/**
	 * Time Complexity: O(1)
	 * Space: O(1)
	 * 
	 * @param input
	 * @return
	 */
	public static String compressString(String input) {
		
		StringBuffer compressedString = new StringBuffer();
		
		for(int i = 0; i < input.length(); i++) {
			
			char ch = input.charAt(i);
			int charCount = 1;
			
			while((i < input.length() - 1) && (input.charAt(i) == input.charAt(i+1))) {
				charCount++;
				i++;
			}
			
			compressedString.append(ch).append(charCount);
			
		}
		
		String output = null;
		
		if(input.length() < compressedString.length()) {
			output = input;
		} else {
			output = compressedString.toString();
		}
		
		return output;
	}

	public static void main(String[] args) {
		
		String input = "aabccccaaa";
		String input2 = "aabccccaaaz";
		String input3 = "pqrst";
		
		System.out.println("Compressed String: " + compressString(input)); //a2b1c4a3
		System.out.println("Compressed String: " + compressString(input2)); //a2b1c4a3z1
		System.out.println("Compressed String: " + compressString(input3)); //pqrst
		
	}

}

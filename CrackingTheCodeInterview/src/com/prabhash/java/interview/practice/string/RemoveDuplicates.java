package com.prabhash.java.interview.practice.string;

/**
 * Remove duplicates in a given string.
 * 
 * @author prrathore
 *
 */
public class RemoveDuplicates {
	
	/**
	 * Remove duplicates in one pass without shuffling the character array.
	 * 
	 * @param s
	 * @return String
	 */
	public static String removeAdjacentPairs(String s) {
		
		if(s == null) {
			throw new IllegalArgumentException();
		}
		
		char[] ch = s.toCharArray();
		int j = 0;
		for(int i = 1; i < s.length(); i++) {
			while(j >= 0 && ch[i] == ch[j]) {
				i++;
				j--;
			}
			ch[++j] = ch[i];
		}
		
		// here j is the position of final string after removing duplicates
		return new String(ch, 0, j + 1); // j + 1 because this String constructor accepts a count from offset 
		// return convertCharArrayToString(ch, j);
	}
	
	public static String convertCharArrayToString(char[] c, int j) {
		
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k <= j; k++) {
			sb.append(c[k]);
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		
		String text = "ABCCBCBA";
		String output = removeAdjacentPairs(text);
		
		System.out.println(output);
	}

}

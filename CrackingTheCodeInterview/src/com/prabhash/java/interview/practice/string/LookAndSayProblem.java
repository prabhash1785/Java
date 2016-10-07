package com.prabhash.java.interview.practice.string;

/**
 * Look and Say Sequence - The look-and-say sequence starts with 1. Subsequent numbers are derived by describing the previous
 * number in terms of consecutive digits. 
 * 
 * To generate an entry of the sequence from the previous entry, read off digits of previous entry, counting the number of
 * digits in groups of the same digit.
 * 
 * @author Prabhash Rathore
 *
 */
public class LookAndSayProblem {
	
	/**
	 * Find the nth number in look and say sequence.
	 * 
	 * Time Complexity: O(n (2^n))
	 * 
	 * @param n
	 * @return
	 */
	public static String lookAndSay(int n) {
		String s = "1";
		for(int i = 1; i < n; i++) {
			System.out.println(i + "th lookandsay number: " + s);
			s = nextNumber(s);
		}
		return s;
	}
	
	private static String nextNumber(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			int count = 1;
			while(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				i++;
				count++;
			}
			sb.append(count);
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int n = 5;
		String nthLookAndSayNumber = lookAndSay(n);
		System.out.println(n + " look and say number is: " + nthLookAndSayNumber);
	}
}

package com.prabhash.interview.practice.array;

import java.util.Set;

public class SmallestSubArrayCoveringAllValues {
	
	public static SubArray findSmallestSubArrayUsingBruteForce(String[] paragraph, Set<String> set) {
		if(paragraph == null || set == null) {
			throw new NullPointerException();
		}
		
		SubArray subArray = new SubArray(-1, -1);
		
		
		
		return subArray;
	}
	
	public static class SubArray {
		private int start;
		private int end;
		
		public SubArray(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

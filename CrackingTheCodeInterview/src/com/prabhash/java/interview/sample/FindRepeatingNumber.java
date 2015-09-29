package com.prabhash.java.interview.sample;

import java.util.Arrays;

public class FindRepeatingNumber {
	
	    public static int findDuplicate(int[] nums) {
	    	
	    	Arrays.sort(nums);
	        
	        int n = nums[nums.length - 1];
	        int originalSum = (n * (n + 1)) / 2;
	        
	        int sum = 0;
	        for(int i = 0; i < nums.length; i++) {
	            sum = sum + nums[i];
	        }
	        
	        int num = sum - originalSum;
	        
	        return num;
	        
	    }


	public static void main(String[] args) {
		
		int[] input = new int[] {2, 1, 1};
		
		int output = findDuplicate(input);
		System.out.println("Output: " + output);

	}

}

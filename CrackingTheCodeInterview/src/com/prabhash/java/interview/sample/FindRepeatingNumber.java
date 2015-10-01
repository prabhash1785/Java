package com.prabhash.java.interview.sample;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *  
 * @author prrathore
 *
 */
public class FindRepeatingNumber {
	
	public static int findDuplicate(int[] nums) {
		
	    int n = nums.length; // start at last index
	    int slow = n;
	    int fast = n;
	    do{
	        slow = nums[slow-1];
	        fast = nums[nums[fast-1]-1];
	    }while(slow != fast);
	    slow = n;
	    while(slow != fast){
	        slow = nums[slow-1];
	        fast = nums[fast-1];
	    }
	    return slow;
	}

	public static void main(String[] args) {
		
		int[] input = new int[] {2, 1, 1};
		
		int output = findDuplicate(input);
		System.out.println("Output: " + output);

	}

}

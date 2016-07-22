package com.prabhash.interview.practice.array;

/**
 * Find if path exists from start of array to end of array following a max hop of value stored at the current index of array. 
 * 
 * @author Prabhash Rathore
 *
 */
public class FindIfPathExistsInArray {

	/**
	 * 
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param list
	 * @return boolean
	 */
	public static boolean findIfPathExists(final int[] list) {
		if(list == null) {
			return false;
		}
		
		int furtheseReachSoFar = 0, lastIndex = list.length - 1;
		for(int i = 0; i <= furtheseReachSoFar && furtheseReachSoFar < lastIndex; ++i) {
			furtheseReachSoFar = Math.max(furtheseReachSoFar, i + list[i]);
			System.out.println("furtheseReachSoFar: " + furtheseReachSoFar + " :: " + "i: " + i);
			if(furtheseReachSoFar == lastIndex) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		int[] a = new int[] {3, 3, 1, 0, 2, 0, 1};
		a = new int[] {3, 2, 0, 0, 2, 0, 1};
		boolean pathExists = findIfPathExists(a);
		System.out.println("Does path exists: " + pathExists);
	}
}

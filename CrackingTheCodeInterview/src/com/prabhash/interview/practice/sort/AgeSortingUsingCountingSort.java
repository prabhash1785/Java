package com.prabhash.interview.practice.sort;

/**
 * Sort human age in linear O(n) time where ages are given in the range [0, 200] (0 and 200 both inclusive).
 * 
 * @author Prabhash Rathore
 *
 */
public class AgeSortingUsingCountingSort {

	// since 0 and 200 both are inclusive so size of countingArray must be 200 + 1 = 201
	public static final int MAX_AGE_BUCKETS = 201;
	
	/**
	 * Since human age are relative smaller int numbers so we can use an intermediate array whose index will represent actual age and 
	 * it's content would be count of that age in input array. We need to store count of array because age could be repeated.
	 * 
	 * This is an example of Counting Sort which works in linear time. Go through original array, store that age at the index equal to age
	 * value in countingArray. Also make sure to increment age count. In the second pass, iterate through countingArray and store age value
	 * which is the index i in countingArray. Also make sure if count for age is greater than 0 then add i that many time to sorted array.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param ages
	 * @return sortedArray
	 */
	public static int[] sortAge(int[] ages) {
		if(ages == null || ages.length == 0) {
			return ages;
		}
		
		int[] countingArray = new int[MAX_AGE_BUCKETS];
		for(int i = 0; i < ages.length; i++) {
			int currentCount = countingArray[ages[i]];
			++currentCount;
			countingArray[ages[i]] = currentCount;
		}
		
		int[] sortedArray = new int[ages.length];
		for(int i = 0, j = 0; i < MAX_AGE_BUCKETS; i++) {
			int ageCount = countingArray[i]; // countingArray[i] represents number of times age is repeated in input array
			while(ageCount > 0) {
				sortedArray[j] = i; // i represents age
				--ageCount;
				++j;
			}
		}
		
		return sortedArray;
	}
	
	public static void printArray(int[] a) {
		if(a == null) {
			System.out.println("!Array is empty!");
			return;
		}
		
		for(int i : a) {
			System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] age = new int[] {
			9, 88, 0, 9, 200, 100, 55, 67, 102, 88, 9, 88
		};
		
		System.out.println("Original age array:");
		printArray(age);
		
		System.out.println("\nSorted age array");
		int[] sortedAgeArray = sortAge(age);
		printArray(sortedAgeArray);
	}

}

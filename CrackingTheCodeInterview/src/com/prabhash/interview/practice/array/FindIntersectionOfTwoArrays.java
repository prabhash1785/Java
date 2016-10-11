package com.prabhash.interview.practice.array;

/**
 * Given two sorted arrays. Find intersection of these two arrays in linear time without using any extra memory. If there are repeated
 * elements in both arrays then make sure those repeated elements are returned in intersection.
 * 
 * @author Prabhash Rathore
 *
 */
public class FindIntersectionOfTwoArrays {

	/**
	 * To find intersection of two arrays in linear time without any extra memory, maintain an index for each array and if you find
	 * a match, add to intersection array and move both indexes else depending upon their relation, move one of the indexes until you
	 * exhaust one of the arrays. 
	 * 
	 * @param sortedArrayA
	 * @param sortedArrayB
	 * @return intersection
	 */
	public static int[] getIntersection(int[] sortedArrayA, int[] sortedArrayB) {
		if(sortedArrayA == null || sortedArrayB == null || sortedArrayA.length == 0 || sortedArrayB.length == 0) {
			return null;
		}
		
		int intersectionArraySize = sortedArrayA.length > sortedArrayB.length ? sortedArrayB.length : sortedArrayA.length;
		int[] intersection = new int[intersectionArraySize];
		
		int i = 0, j = 0, k = 0;
		while(i < sortedArrayA.length && j < sortedArrayB.length) {
			if(sortedArrayA[i] == sortedArrayB[j]) {
				intersection[k] = sortedArrayA[i];
				++i;
				++j;
				++k;
			} else if(sortedArrayA[i] < sortedArrayB[j]) {
				++i;
			} else {
				++j;
			}
		}
		
		return intersection;
	}
	
	private static void printArray(int[] a) {
		if(a == null) {
			System.out.println("Empty array!!");
			return;
		}
		
		for(int i : a) {
			System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {
				4, 8, 9, 9, 12, 15, 15, 20
		};
		
		int[] b = new int[] {
			2, 9, 9, 15, 20, 25, 30	
		};
		
		int[] intersection = getIntersection(a, b);
		System.out.println("Here is array intersection:");
		printArray(intersection);
	}
}

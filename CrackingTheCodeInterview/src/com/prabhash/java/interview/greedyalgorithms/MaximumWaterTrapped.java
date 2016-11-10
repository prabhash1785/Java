package com.prabhash.java.interview.greedyalgorithms;

/**
 * Compute the maximum water trapped by a pair of vertical lines.
 * 
 * @author Prabhash Rathore
 *
 */
public class MaximumWaterTrapped {
	
	/**
	 * Compute maximum water trapped by running two indexes, one start and other end. For these index combinations, calculate new area
	 * by using following calculations:
	 * height = min(a[start], a[end]) since height has to be the minimum to two vertical lines as these are rectangles
	 * width = end - start
	 * If new area is greater than max area then update max area.
	 * 
	 * Move these start and end pointers in such a way that we keep the max height in order to find a future max area. If height is same at
	 * both start and end index then move both these pointers inwards.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param heights
	 * @return maxWaterTrapped
	 */
	public static int computeMaximumWaterTrapped(int[] heights) {
		if(heights == null || heights.length == 0) {
			return 0;
		}
		
		int maxWaterTrapped = 0;
		int start = 0, end = heights.length - 1;
		
		while(start < end) {
			int width = end - start;
			int height = Math.min(heights[start], heights[end]);
			int newArea = width * height;
			maxWaterTrapped = Math.max(maxWaterTrapped, newArea);
			
			if(heights[start] < heights[end]) {
				++start;
			} else if(heights[start] > heights[end]) {
				--end;
			} else {
				++start;
				--end;
			}
		}
		
		return maxWaterTrapped;
	}

	public static void main(String[] args) {
		final int[] heights = new int[] {1, 2, 1, 3, 4, 4, 5, 6, 2, 1, 3, 1, 3, 2, 1, 2, 4, 1};
		int maxWaterTrapped = computeMaximumWaterTrapped(heights);
		System.out.println("Max water trapped is: " + maxWaterTrapped);
	}
}

package com.prabhash.java.interview.greedyalgorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a list of buildings of unit width lying around X-axis with different heights. These buildings form multiple rectangles when
 * observed in a 2-dimensional plane. Calculate the area of largest rectangle.
 * 
 * @author Prabhash Rathore
 *
 */
public class LargestRectangleUnderSkyline {
	
	/**
	 * Using two for loops, calculate maximum area possible starting from each ith building. At any point, if you find a building which
	 * is shorter than ith building then break out of that inner loop, calculate area for that ith building, update max Area and progress 
	 * to the next ith building in outer loop.
	 * 
	 * Time Complexity: O(n ^ 2)
	 * 
	 * @param buildings
	 * @return maxArea
	 */
	public static int calculateAreaOfMaxRectangle(List<Integer> buildings) {
		if(buildings == null || buildings.size() == 0) {
			return 0;
		}
		
		int maxArea = 0;
		for(int i = 0; i < buildings.size(); i++) {
			int height = buildings.get(i);
			int j = i;
			for(;j < buildings.size(); j++) {
				// if a building is shorter than ith building so rectangle with this height cannot be continuous so break
				if(buildings.get(j) < height) { 
					break; 
				}	
			}
			
			int currentArea = height * (j - i + 1); // add 1 because building width is 1 unit so worst case for one building width would be 1
			maxArea = Math.max(maxArea, currentArea);
		}
		
		return maxArea;
	}
	
	/**
	 * Find max area under skyline in linear time.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param heights
	 * @return maxArea
	 */
	public static int maxAreaOfSkyLineOptimized(List<Integer> heights) {
		if(heights == null || heights.size() == 0) {
			return 0;
		}
		
		class Data {
			int position;
			int height;
			
			Data(int position, int height) {
				this.position = position;
				this.height = height;
			}
		}
		
		int maxArea = 0;
		Stack<Data> stack = new Stack<>();
		int i = 0;
		for(; i < heights.size(); i++) {
			if(stack.size() > 0 && heights.get(i) == stack.peek().height) {
				stack.pop();
			} else {
				while(stack.size() > 0 && heights.get(i) < stack.peek().height) {
					int width = i - stack.peek().position;
					int height = stack.pop().height;
					maxArea = Math.max(maxArea, height * width);
				}
			}
			stack.push(new Data(i, heights.get(i)));
		}
		
		// if at the end of for loop there are left over buildings in Stack then let's calculate area for these buildings 
		while(stack.size() > 0) {
			int width = i - stack.peek().position;
			int height = stack.pop().height;
			maxArea = Math.max(maxArea, height * width);
		}
		
		return maxArea;
	}

	public static void main(String[] args) {
		final List<Integer> buildingHeights = Arrays.asList(1, 4, 2, 5, 6, 3, 2, 6, 6, 5, 2, 1, 3);
		int areaOfLargestRectangle = calculateAreaOfMaxRectangle(buildingHeights);
		System.out.println("Largest area under skyline is: " + areaOfLargestRectangle);
		
		// test case 2
		int areaOfLargestRectangle2 = maxAreaOfSkyLineOptimized(buildingHeights);
		System.out.println("\nLargest area under skyline is: " + areaOfLargestRectangle2);
	}
}

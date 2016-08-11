package com.prabhash.java.interview.search;

/**
 * Find the starting index and end index of given number in a sorted array.
 * 
 * @author Prabhash Rathore
 *
 */
public class FindIndexRangeOfGivenNumber {
	
	/**
	 * Using linear scan find the start index and end index of given number.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param a
	 * @param num
	 * @return IndexRange
	 */
	public static IndexRange findIndexRangeUsingLinearScan(int[] a, int num) {
		if(a == null) {
			throw new NullPointerException();
		}
		
		if(a.length == 0) {
			return new IndexRange(-1, -1);
		}
		
		int leftIndex = -1, rightIndex = -1;
		for(int i = 0; i < a.length; i++) {
			if(a[i] == num) {
				if(leftIndex == -1) {
					leftIndex = i;
				}
				
				rightIndex = i;
			}
		}
		
		return new IndexRange(leftIndex, rightIndex);
	}
	
	/**
	 * Find starting and ending index range of given number using Binary Search since the given array is sorted.
	 * To find the index range, first determine the index of given number using Binary Search and then again using Binary Search,
	 * determine left Index range and right index range.
	 * 
	 * Time Complexity: O(log n)
	 * 
	 * @param a
	 * @param k
	 * @return IndexRange
	 */
	public static IndexRange findIndexRangeUsingBinarySearch(int[] a, int k) {
		if(a == null) {
			throw new NullPointerException();
		}
		
		if(a.length == 0) {
			return new IndexRange(-1, -1);
		}
		
		int low = 0, high = a.length - 1;
		int leftIndex = -1, rightIndex = -1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(k < a[mid]) {
				high = mid - 1;
			} else if(k > a[mid]) {
				low = mid + 1;
			} else {
				leftIndex = findEdgeIndex(a, low, mid, Direction.LEFT);
				rightIndex = findEdgeIndex(a, mid, high, Direction.RIGHT);
				break;
			}
		}
		
		return new IndexRange(leftIndex, rightIndex);
	}
	
	private static int findEdgeIndex(int[] a, int low, int high, Direction direction) {
		int edgeIndex = -1;
		if(direction.equals(Direction.LEFT)) {
			edgeIndex = high;
		} else {
			edgeIndex = low;
		}
		
		int num = a[edgeIndex];
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(num < a[mid]) {
				high = mid - 1;
			} else if(num > a[mid]) {
				low = mid + 1;
			} else {
				edgeIndex = mid;
				if(direction.equals(Direction.LEFT)) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		
		return edgeIndex;
	}
	
	public static enum Direction {
		LEFT, RIGHT
	}
	
	public static class IndexRange {
		private int leftIndex;
		private int rightIndex;
		
		public IndexRange(int leftIndex, int rightIndex) {
			this.leftIndex = leftIndex;
			this.rightIndex = rightIndex;
		}
		
		@Override
		public String toString() {
			return "{" + this.leftIndex + "," + this.rightIndex + "}";
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] {2, 2, 5, 6, 6, 10, 10, 10, 10, 10, 15, 18, 20, 20, 25, 25, 30, 30};
		int num = 10;
		
		IndexRange indexRange = findIndexRangeUsingLinearScan(a, num);
		System.out.println("Index range of " + num + " is: " + indexRange);
		
		int[] b = new int[] {1, 2, 2, 4, 4, 4, 7, 11, 11, 13};
		int num2 = 11;
		
		IndexRange indexRange2 = findIndexRangeUsingBinarySearch(b, num2);
		System.out.println("\nIndex range of " + num2 + " is: " + indexRange2);
	}
}

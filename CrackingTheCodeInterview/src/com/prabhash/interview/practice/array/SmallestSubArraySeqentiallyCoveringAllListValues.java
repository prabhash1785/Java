package com.prabhash.interview.practice.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Find the smallest sub-array covering all values in the list sequentially.
 * 
 * @author Prabhash Rathore
 *
 */
public class SmallestSubArraySeqentiallyCoveringAllListValues {
	
	/**
	 * Using 2 for loops iterate through sub-arrays starting at each index in the array. For each inner loop, compare query list elements
	 * in order. Once all query list elements are found, update subArray size if current subArray size is smaller than previous ones.
	 * 
	 * Time Complexity: O(n ^ 2)
	 * 
	 * @param paragraph
	 * @param query
	 * @return subArray
	 */
	public static SubArray findSmallestSubArrayUsingBruteForce(String[] paragraph, List<String> query) {
		if(paragraph == null || query == null) {
			throw new NullPointerException();
		}
		
		if(query.size() > paragraph.length) {
			return null;
		}
		
		SubArray subArray = new SubArray(-1, -1);
		for(int i = 0; i < paragraph.length; i++) {
			for(int j = i, k = 0; j < paragraph.length && k < query.size(); j++) {
				if(paragraph[j].equals(query.get(k))) {
					++k;
				}
				if(k >= query.size()) {
					if((subArray.start == -1 && subArray.end == -1) || 
							((j - i) < (subArray.end - subArray.start))) {
						subArray.start = i;
						subArray.end = j;
					}
					break;
				}
			}
		}
		
		return subArray;
	}
	
	/**
	 * Using one pass, find the smallest subarray which covers all elements in list sequentially.
	 * Keep two pointers left and right for paragraph array and a pointer to traverse query list sequentially. Traverse paragraph
	 * until right < paragraph.length. Everytime paragraph[right].equals(query.get(queryIndex)), increment queryIndex. When all the
	 * query elements are found, compare subarray length and update length if smaller subarray is found.
	 * 
	 * Once paragraph[left].equals(query.get(0)), reset queryIndex = 0, set left = right + 1 and since queryIndex resets to 0, this inner
	 * while loop will exit.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param paragraph
	 * @param query
	 * @return subArray
	 */
	public static SubArray findSmallestSubArrayOptimized(String[] paragraph, List<String> query) {
		if(paragraph == null || query == null) {
			throw new NullPointerException();
		}
		
		if(query.size() > paragraph.length) {
			return null;
		}
		
		SubArray subArray = new SubArray(-1, -1);
		int left = 0, right = 0;
		int queryIndex = 0;
		
		while(right < paragraph.length) {
			if(paragraph[right].equals(query.get(queryIndex))) {
				++queryIndex;
			}
			
			while(queryIndex >= query.size()) {
				int subArraySize = right - left;
				if((subArray.start == -1 && subArray.end == -1) || 
						(subArraySize < (subArray.end - subArray.start))) {
					subArray.start = left;
					subArray.end = right;
				}
				
				if(paragraph[left].equals(query.get(0))) {
					queryIndex = 0;
					left = right + 1;
				} else {
					++left;
				}
			}
			
			++right;
		}
		
		return subArray;
	}
	
	public static class SubArray {
		int start, end;
		
		public SubArray(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return "Start Index: " + this.start + " :: End Index: " + this.end;
		}
	}

	public static void main(String[] args) {
		String[] paragraph = new String[] { "cat", "apple", "banana", "apple", "apple", "dog", "cat", "apple", "dog", "banana", "apple",
				"cat", "dog" };
		
		List<String> queryList = new ArrayList<>();
		queryList.add("banana");
		queryList.add("cat");
		
		SubArray subArray = findSmallestSubArrayUsingBruteForce(paragraph, queryList);
		System.out.println("SubArray value: " + subArray);
		
		SubArray subArray2 = findSmallestSubArrayOptimized(paragraph, queryList);
		System.out.println("SubArray value: " + subArray2);
	}

}

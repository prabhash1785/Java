package com.prabhash.interview.practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Given an array with repeated numbers. Find k numbers with max frequency. 
 * 
 * @author Prabhash Rathore
 *
 */
public class FindKNumbersWithMaxFrequecy {
	
	/**
	 * Method 1:
	 * Iterate through array and put the number and it's corresponding frequency in a HashMap. Then transfer these entries from Map into
	 * a List which stores objects of custom type Number composed of number and it's corresponding frequency. Sort this list based on
	 * frequency count. Once sorted, copy top k objects from list into an array which is the output.
	 * 
	 * Time Complexity: O(n logn)
	 * Space Complexity: O(n)
	 * 
	 * @param a
	 * @param k
	 * @return result
	 */
	public static int[] findKNumbersWithMaxFrequencyUsingList(int[] a, int k) {
		if(a == null) {
			return null;
		}
		
		if(k <= 0 || k > a.length) {
			throw new IllegalArgumentException();
		}
		
		List<Number> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < a.length; i++) {
			if(map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}
		}
		
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for(Entry<Integer, Integer> entry : entrySet) {
			list.add(new Number(entry.getKey(), entry.getValue()));
		}
		
		Collections.sort(list); // sort in increasing order based on frequency
		
		int[] result = new int[k];
		for(int i = list.size() - 1, index = 0; i >= 0 && index < k; i--, index++) {
			result[index] = list.get(i).value;
		}
		
		return result;
	}
	
	/**
	 * Method 2:
	 * Using a Min-Heap (Min Priority Queue), we can solve this problem in O(n logk) time. First scan through array and record number
	 * and it's corresponding frequency in a Map. After that instantiate a k-sized Min-Heap and store first k numbers from Map into
	 * heap. After k + 1 to nth entries from Map, check if this entry is greater than root of heap. If it is then remove heap root and 
	 * add this element to heap. Repeat this process. At the end, you will have heap with k max repeating numbers.
	 * 
	 * Time Complexity: (n logk)
	 * Space Complexity: O(n)
	 * 
	 * @param a
	 * @param k
	 * @return result
	 */
	public static int[] findKMaxNumbersUsingPriorityQueue(int[] a, int k) {
		if(a == null) {
			return null;
		}
		
		if(k <= 0 || k > a.length) {
			throw new IllegalArgumentException();
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < a.length; i++) {
			if(map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}
		}
		
		Queue<Number> queue = new PriorityQueue<>(k);
		int count = 0;
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for(Entry<Integer, Integer> entry : entrySet) { 
			if(count < k) {
				queue.offer(new Number(entry.getKey(), entry.getValue()));
				++count;
				continue;
			}
			
			Number num = queue.peek();
			if(entry.getValue() > num.frequency) {
				queue.remove();
				queue.offer(new Number(entry.getKey(), entry.getValue()));
			}
		}
		
		int[] result = new int[k];
		int index = 0;
		while(!queue.isEmpty()) {
			result[index] = queue.remove().value;
			++index;
		}
		
		return result;
	}
	
	/**
	 * Method 3:
	 * This finds max k-repeating numbers in Linear Time using Counting Sort.
	 * First scan through input array and record each number and it's frequency in a Map. Then create an array of Node which will store
	 * numbers from map as a value at their frequency index. This way when we traverse this temp array from end, we will be able to
	 * find numbers with max frequencies.
	 * 
	 * Make sure that there could be numbers with same frequency so in temp array, chain/bucket such numbers using a Linked List at the
	 * same frequency index.
	 * 
	 * This algorithm just returns first top k repeating numbers. It considers two numbers with same frequency as two distinct numbers.
	 * 
	 *  Time Complexity: O(n)
	 *  Space Complexity: O(n)
	 * 
	 * @param a
	 * @param k
	 * @return result
	 */
	public static int[] findKMaxRepeatingNumbersInLinearTime(int[] a, int k) {
		if(a == null) {
			return null;
		}
		
		if(k <= 0 || k > a.length) {
			throw new IllegalArgumentException();
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < a.length; i++) {
			if(map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}
		}
		
		// in a temp array, store numbers from Map with their frequency as index and value as array value at that frequency index. There
		// could be more than one number with same frequency so store them as a Linked List at that index.
		Node[] frequencySorter = new Node[a.length];
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for(Entry<Integer, Integer> entry : entrySet) {
			int frequency = entry.getValue();
			Node node = frequencySorter[frequency];
			if(node == null) {
				node = new Node(entry.getKey());
				frequencySorter[frequency] = node;
			} else {
				while(node.next != null) {
					node = node.next;
				}
				node.next = new Node(entry.getKey());
			}
		}
		
		int[] result = new int[k];
		for(int i = frequencySorter.length - 1, index = 0; i >= 0 && index < k; i--) {
			Node node = frequencySorter[i];
			while(node != null && index < k) {
				if(node.value != 0) {
					result[index] = node.value;
					node = node.next;
					++index;
				} else {
					break;
				}
			}
		}
		
		return result;	
	}
	
	public static class Node {
		private int value;
		public Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static class Number implements Comparable<Number> {
		private int value;
		private int frequency;
		
		public Number(int value, int frequency) {
			this.value = value;
			this.frequency = frequency;
		}
		
		@Override
		public int compareTo(Number num) {
			if(num == null) {
				throw new NullPointerException();
			}
			
			return Integer.compare(this.frequency, num.frequency);
		}
	}
	
	public static void printArray(int[] a) {
		if(a == null) {
			throw new NullPointerException();
		}
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] {
			2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6	
		};
		
		int k = 3;
		
		// test Method 1
		System.out.println(k + " elements with max frequency are: ");
		int[] output = findKNumbersWithMaxFrequencyUsingList(array, k);
		printArray(output);
		
		// test Method 2
		System.out.println("\n" + k + " elements with max frequency using Heap Algorithm are: ");
		int[] output2 = findKMaxNumbersUsingPriorityQueue(array, k);
		printArray(output2);
		
		// test Method 3
		int[] b = new int[] {
				2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 7, 10, 10, 10
		};
		System.out.println("\n" + k + " elements with max frequency using Counting Sort are: ");
		int[] output3 = findKMaxRepeatingNumbersInLinearTime(b, k);
		printArray(output3);
	}

}

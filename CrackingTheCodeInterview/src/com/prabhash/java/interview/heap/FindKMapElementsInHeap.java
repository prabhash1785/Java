package com.prabhash.java.interview.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Compute k largest elements from a Max-Heap without modifying the given heap.
 * 
 * @author Prabhash Rathore
 *
 */
public class FindKMapElementsInHeap {
	
	/**
	 * Find k max elements from a given Max Heap represented as an array without modifying the original heap.
	 * 
	 * This is solved by using the property of heap that it is partially sorted and the root of heap is always greater than it's children.
	 * So using the above property, we will create an intermediate Max Heap (Priority Queue) and add the first elements from array as
	 * that will be the highest element in given Max Heap. In a loop which will run until we find k max elements, pop the highest element
	 * from temp Max Heap, calculate the index of left child (2*i + 1) and right child (2*i + 2) and if these index are within bound, then
	 * add these elements to temp Max Heap. At the end of loop, we will have k max elements.
	 * 
	 * Time Complexity: O(k logk)
	 * Space Complexity: O(k)
	 * 
	 * @param maxHeap
	 * @param k
	 * @return result
	 */
	public static List<Integer> findKMaxElements(int[] maxHeap, int k) {
		if(maxHeap == null) {
			return null;
		}
		
		if(maxHeap.length < k) {
			throw new IllegalArgumentException("Heap has lesser elements than expected");
		}
		
		List<Integer> result = new ArrayList<>();
		
		Queue<HeapElement> tempMaxHeap = new PriorityQueue<>(new HeapElementComparator());
		tempMaxHeap.add(new HeapElement(0, maxHeap[0]));
		
		for(int i = 0; i < k; i++) {
			HeapElement heapElement = tempMaxHeap.remove();
			result.add(heapElement.value);
			
			int leftChildIndex = (2 * heapElement.index) + 1;
			int rightChildIndex = (2 * heapElement.index) + 2;
			
			if(leftChildIndex < maxHeap.length) {
				tempMaxHeap.add(new HeapElement(leftChildIndex, maxHeap[leftChildIndex]));
			}
			
			if(rightChildIndex < maxHeap.length) {
				tempMaxHeap.add(new HeapElement(rightChildIndex, maxHeap[rightChildIndex]));
			}
		}
		
		return result;
	}
	
	public static class HeapElement {
		private int index;
		private int value;
		
		public HeapElement(int index, int value) {
			this.index = index;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return this.index + " :: " + this.value;
		}
	}
	
	public static class HeapElementComparator implements Comparator<HeapElement> {
		
		@Override
		public int compare(HeapElement heapElement1, HeapElement heapElement2) {
			return Integer.compare(heapElement2.value, heapElement1.value); // for sorting in descending order pass param2 first than param1
		}
	}
	
	public static void main(String[] args) {
		
		int[] maxHeapElements = new int[] {561, 314, 401, 28, 156, 359, 271, 11, 3};
		int k = 4;
		
		List<Integer> kMaxElements = findKMaxElements(maxHeapElements, k);
		System.out.println(k + " max elements from heap are:");
		for(Integer i : kMaxElements) {
			System.out.print(i + " ");
		}
	}
}

package com.prabhash.java.interview.sample;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LargestTracker
 * 
 * @author Prabhash Rathore
 *
 */
public class LargestTracker {
	
	private static LargestTracker instance;
	private List<Integer> list;
	private int elementCount; // keep track of number of actual elements in list
	
	private LargestTracker() {
		list = new ArrayList<>();
		elementCount = 0;
	}
	
	/**
	 * Create singleton instance of LargestTracker class. This is class loader and thread safe, i.e. it will only create one instance
	 * of this class even though different classloaders in a JVM will load this class and call this getInstance method.
	 * 
	 * @return instance
	 */
	public static LargestTracker getInstance() {
		if(instance != null) {
			return instance;
		} else {
			try {
				Class<?> largestTrackerClass = ClassLoader.getSystemClassLoader().loadClass("com.prabhash.java.interview.sample.LargestTracker");
				Field field = largestTrackerClass.getDeclaredField("instance");
				synchronized(largestTrackerClass) {
					Object instance = field.get(null);
					if(instance == null) {
						instance = largestTrackerClass.newInstance();
					}
					
					// assign this instance to class instance variable to prevent future expensive lookups
					LargestTracker.instance = (LargestTracker) instance;
				}
			} catch(ClassNotFoundException classNotFoundException) {
				System.out.println("com.navdy.interview.exercise.LargestTracker class not found!!");
			} catch(NoSuchFieldException noSuchFieldException) {
				System.out.println("Instance field does not exist!");
			} catch(IllegalAccessException illegalAccessException) {
				System.out.println("Illegal access of field!");
			} catch(InstantiationException instantiationException) {
				System.out.println("Instantiation exception");
			}
		}
		
		return instance;
	}
	
	/**
	 * Returns the top k elements from list in ascending order.
	 * 
	 * Time Complexity: O(n logm) where n = total elements, m = number of elements to be returned
	 * 
	 * @param numberOfTopLargestElements
	 * @return topLargestElmentList
	 */
	public List<Integer> getNLargest(int numberOfTopLargestElements) {
		if(numberOfTopLargestElements > elementCount) {
			throw new RuntimeException("Not enough elements available!!");
		}
		
		List<Integer> topLargestElmentList = new ArrayList<>();
		
		// Max Priority Queue to retrieve k min elements in O(n logk) time
		Queue<Integer> priorityQueue = new PriorityQueue<>(numberOfTopLargestElements, 
				(i, j) -> { return Integer.compare(j, i); });
		
		int index = 0;
		for(; index < numberOfTopLargestElements; index++) {
			priorityQueue.add(list.get(index));
		}
		
		while(index < elementCount) {
			if(list.get(index) < priorityQueue.peek()) {
				priorityQueue.remove();
				priorityQueue.add(list.get(index));
			}
			++index;
		}
		
		while(!priorityQueue.isEmpty()) {
			topLargestElmentList.add(priorityQueue.remove());
		}
		
		Collections.reverse(topLargestElmentList);
		return topLargestElmentList;
	}
	
	/**
	 * Add an entry to the list.
	 * 
	 * Time Complexity: O(1)
	 * 
	 * @param anEntry
	 */
	public void add(int anEntry) {
		list.add(elementCount, anEntry);
		++elementCount;
	}
	
	/**
	 * Clears the elements in the list. The way elements are cleared is by resetting the elementCount = 0 which is a pointer to
	 * keep track of number of elements in list. This helps in achieving constant time complexity.
	 * 
	 * Time Complexity: O(1)
	 */
	public void clear() {
		elementCount = 0;
	}
	
	public static void main(String[] args) {
		LargestTracker largestTracker = LargestTracker.getInstance();
		largestTracker.add(5);
		largestTracker.add(2);
		largestTracker.add(15);
		largestTracker.add(3);
		largestTracker.add(1);
		largestTracker.add(20);
		largestTracker.add(7);
		
		List<Integer> kMax = largestTracker.getNLargest(4);
		System.out.println("K min elements are:");
		for(Integer i : kMax) {
			System.out.print(i + " ");
		}
		
		largestTracker.clear();
		System.out.println("\nElement count = " + largestTracker.elementCount);
		
		LargestTracker largestTracker2 = LargestTracker.getInstance();
		LargestTracker largestTracker3 = LargestTracker.getInstance();
		
		if(largestTracker2 == largestTracker3) {
			System.out.println("Same instance!");
		} else {
			System.out.println("Instance are different!");
		}
	}
}

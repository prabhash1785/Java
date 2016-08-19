package com.prabhash.interview.math;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * In a party there are total n persons are there. every person is having one gift with him. Every person will give his gift 
 * to another such that every person at the end has exactly one gift. Any one can give his gift to anyone. say 5 people (A,B,C,D,E).
 * 
 * A–>D
 * D–>C
 * C–>E
 * B–>A
 * E–>B
 * 
 * @author Prabhash Rathore
 *
 */
public class RandomGiftDistribution {
	
	/**
	 * Simple solution is to randomize the order of people name in given list and then in random list, each person can give their gift
	 * to the next subsequent person. Make sure that last person gives his gift to first.
	 * 
	 * Since we are Randomizing list of people, this will guarantee that every invocation of this method will generate different order of
	 * gift sharing pairs.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param people
	 */
	public static void randomGiftSharingAmountPeople(String[] people) {
		if(people == null) {
			throw new NullPointerException();
		}
		
		// Shuffle the position of people in the list
		Collections.shuffle(Arrays.asList(people));
		
		Map<String, String> giftDistributionMap  = new HashMap<>();
		int i = 0;
		while(i + 1 < people.length) {
			giftDistributionMap.put(people[i], people[i + 1]);
			++i;
		}
		
		// Make last guy give the gift to first guy
		giftDistributionMap.put(people[i], people[0]);
		
		System.out.println("\nHere is gift distributuion:");
		printGiftSharingPair(giftDistributionMap);
	}
	
	private static void printGiftSharingPair(final Map<String, String> giftMap) {
		if(giftMap == null) {
			System.out.println("Null Gift pait map!!");
		}
		
		Set<Entry<String, String>> giftSet = giftMap.entrySet();
		for(Entry<String, String> entry : giftSet) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		String[] people = new String[] {
			"John", "Amy", "Roger", "Mason", "Adam"	
		};
		
		System.out.println("People available for gift exchange:");
		for(String name : people) {
			System.out.println(name);
		}
		
		randomGiftSharingAmountPeople(people);
	}
}

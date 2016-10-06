package com.prabhash.java.collection;

import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {
	
	/**
	 * Sorted map sorts based on keys not on value. 
	 * 
	 * Use a treemap to keep track of words and their respective count. Then iterate through map and find word with lowest count
	 * and if count is equal then return word with lowest index.
	 * 
	 * TreeMap is not a recommended data structure for this problem. Instead using a LinkedHashMap.
	 * 
	 * Time Complexity: O(n logn)
	 * 
	 * @param words
	 */
	public static void findWordWithMinCount(String[] words) {
		class Data implements Comparable<Data> {
			private int index;
			private int count;
			
			@Override
			public int compareTo(Data data) {
				if(this.count < data.count) {
					return -1;
				} else if(this.count > data.count) {
					return 1;
				} else {
					return Integer.compare(this.index, data.index);
				}
			}
			
			@Override
			public String toString() {
				return "index= " + index + " :: count= " + count;  
			}
		}
		
		// SortedMap sorts based on keys not based on value
		SortedMap<String, Data> sortedMap = new TreeMap<>();
		
		for(int i = 0; i < words.length; i++) {
			Data data = null;
			if(sortedMap.containsKey(words[i])) {
				data = sortedMap.get(words[i]);
				data.count += 1;
				sortedMap.put(words[i], data); // this is a costly operation because of cost of sorting keys
			} else {
				data = new Data();
				data.count = 1;
				data.index = i;
				sortedMap.put(words[i], data);
			}
		}
		
		// Print SortedMap data, data is sorted based on keys not on comparable values
		Set<Entry<String, Data>> entrySet = sortedMap.entrySet();
		for(Entry<String, Data> entry : entrySet) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
		
		String wordWithMinCount = "";
		int minCount = words.length;
		int minIndex = words.length;
		for(Entry<String, Data> entry : entrySet) {
			if(minCount > entry.getValue().count) {
				minCount = entry.getValue().count;
				minIndex = entry.getValue().index;
				wordWithMinCount = entry.getKey();
			} else if(minCount == entry.getValue().count) {
				if(minIndex > entry.getValue().index) {
					minIndex = entry.getValue().index;
					wordWithMinCount = entry.getKey();
				}
			}
		}
		
		System.out.println("Word with min count: " + wordWithMinCount + " index: " + minIndex + " count: " + minCount);
	}

	public static void main(String[] args) {
		SortedMap<String, Integer> sortedText = new TreeMap<>();
		
		final String[] words = new String[] {
				"apple", "mango", "bar", "apple", "foo", "mango", "bar", "apple", "foo", "mango"
		};
		
		for(String word : words) {
			if(sortedText.containsKey(word)) {
				sortedText.put(word, sortedText.get(word) + 1);
			} else {
				sortedText.put(word, 1);
			}
		}
		
		Set<Entry<String, Integer>> entrySet = sortedText.entrySet();
		for(Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
		
		findWordWithMinCount(words);
	}
}

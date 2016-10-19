package com.prabhash.java.cache.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LRU class using Java collection's library classes. To maintain order of nodes for LRU eviction using a Deque and for highly efficient
 * look up using a Map.
 * 
 * @author Prabhash Rathore
 *
 * @param <K>
 * @param <V>
 */
public class LRUCacheUsingCollectionLinkedListAndMap<K, V> {
	
	private Deque<Data> deque;
	private Map<K, Data> map;
	private int capacity;
	private int size;
	
	public LRUCacheUsingCollectionLinkedListAndMap() {
		this(0);
	}
	
	public LRUCacheUsingCollectionLinkedListAndMap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.deque = new LinkedList<>();
		this.map = new HashMap<>();
	}
	
	/**
	 * Time Complexity: O(1)
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		if(key == null) {
			throw new IllegalArgumentException("Null key not allowed in cache");
		}
		
		Data newNode = new Data(key, value);
		
		if(map.containsKey(key)) {
			Data object = map.get(key);
			
			// remove this from LL
			deque.remove(object);
			
			// move new object to front of LL and update HashMap
			deque.addFirst(newNode);
			map.put(key, newNode);
		} else {
			map.put(key, newNode);
			deque.addFirst(newNode);
		}
		
		// remove last node from Deque and Map if size exceeds capacity
		if(size + 1 > capacity) {
			Data object = deque.removeLast();
			map.remove(object.key);
			return;
		}
		
		++size;
	}
	
	/**
	 * Time Complexity: O(1)
	 * 
	 * @param key
	 * @return V
	 */
	public V get(K key) {
		if(key == null || !map.containsKey(key)) {
			return null;
		}
		
		Data data = map.get(key);
		
		// move this node to front of Deque
		deque.remove(data);
		deque.addFirst(data);
		
		return data.value;
	}
	
	public class Data {
		private K key;
		private V value;
		
		public Data(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		LRUCacheUsingCollectionLinkedListAndMap<String, String> cache = new LRUCacheUsingCollectionLinkedListAndMap<>(2);
		cache.put("foo", "bar");
		System.out.println("foo value is: " + cache.get("foo"));
		
		cache.put("fruits", "apple");
		cache.put("vegetables", "caulifower");

		System.out.println("foo value is: " + cache.get("foo"));
		System.out.println("vegetables value is: " + cache.get("vegetables"));
		System.out.println("fruits value is: " + cache.get("fruits"));
	}

}

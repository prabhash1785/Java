package com.prabhash.java.cache.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple LRU (Least Recently Used) Cache which has a fixed size. Size is determined while instatntiating LRU Cache.
 * 
 * LRU cache works on the principle of moving the recently used object in the front of the list and if cache is full, then oldest 
 * entry is deleted in order to new items.
 * 
 * Details on get() operation:
 * If object not in map, return null. The object to be retrieved needs to be moved to front of Linked List.
 * 
 * Details on put() operations:
 * If map already contains key then  update value of this object in Linked List. Also move this node to front of Linked List.
 * If map does not contain key then add this to map and put this in front of Linked List.
 * If new node increases the size of Cache Threshhold then delete tail node and also remove it from Hash Map.
 * 
 * @author prrathore
 *
 */
public class LRUCache {
	
	private Node head; //front of Linked List, represents the latest fetched data
	private Node tail;
	private int size;
	private int count;
	
	private Map<String, Node> map;
	
	public LRUCache(int size) {
		this.head = null;
		this.tail = null;
		this.size = size;
		this.count = 0;
		
		map = new HashMap<>();	
	}
	
	/**
	 * Time Complexity: O(1)
	 * 
	 * @param key
	 * @return value
	 */
	public String get(String key) {
		
		if(key == null) {
			return null;
		}
		
		String value = null;
		
		if(map.containsKey(key)) {
			
			Node node = map.get(key);
			
			value = node.data;
			
			//move this node to front of Cacche as per LRU use case
			moveNodeToFront(node);
		}
		
		return value;
	}
	
	/**
	 * Time Complexity: O(1)
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, String value) {
		
		if(map.containsKey(key)) {
			
			Node node = map.get(key);
			node.data = value;
			
			moveNodeToFront(node);
		} else {
			
			Node node = new Node(key, value);
			map.put(key, node);
			
			if(head == null) {
				this.head = node;
				this.tail = node;
			} else {
				node.next = null;
				node.prev = this.head;
				this.head.next = node;
				
				this.head = node;
			}
		
			// If size if greater than allowed limit then remove tail and do not increase size
			// Also make sure this node is removed from hash map
			if((count + 1) > size) {
				Node tempNode = tail;
				
				tail = tail.next;
				tail.prev = null;
				tempNode.next = null;
				
				//Remove tail node from Hash Map
				map.remove(tempNode.key);
				
				tempNode = null;
				
				return;
			}
		}
		
		count += 1;
		
	}
	
	private void moveNodeToFront(Node node) {
		
		if(head == null || tail == null) {
			System.out.println("Empty LRU Cache, not going to do anything");
			return;
		}
		
		//If node is already the first node
		if(node == head) {
			return; // do nothing as it's already in front
		}
		
		// For nodes in the middle
		if(node.next != null && node.prev != null) {
			
			node.next.prev = node.prev;
			node.prev.next = node.next;
			
			node.next = null;
			node.prev = this.head;
			this.head = node;
		} else if(node.prev == null) { // for tail nodes
			
			tail = node.next;
			tail.prev = null;
			
			node.next = null;
			node.prev = this.head;
			this.head.next = node;
			
			this.head = node;
		}
	}
	
	/**
	 * Node of LRU Cache represented with a Doubly Linked List.
	 * 
	 * @author prrathore
	 *
	 */
	public static class Node {
		
		private String key;
		private String data;
		private Node prev;
		private Node next;
		
		public Node(String key, String data) {
			this.key = key;
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
	
		LRUCache cache = new LRUCache(2);
		
		cache.put("2", "apple");
		cache.put("4", "mango");
		
		String a = cache.get("2");
		System.out.println("a = " + a);
		
		String b = cache.get("4");
		System.out.println("b = " + b);
		
		cache.put("10", "banana");
		
		a = cache.get("2");
		System.out.println("Now a is: " + a);
		
		

	}
}

package com.prabhash.java.collection;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Bidirectional Map is a map which supports both lookup by key and lookup by value.
 * 
 * @author prrathore
 *
 */
public class BidirectionalMap {
	
	public static void biDirectionalMapGuave() {
		BiMap<String, String> biMap = HashBiMap.create();
		biMap.put("hello", "world");
		
		System.out.println(biMap.get("hello"));
		System.out.println(biMap.inverse().get("world"));
	}
	
	public static void biDirectionalMapApache() {
		BidiMap<String, String> bidiMap = new TreeBidiMap<>();
		bidiMap.put("hello", "world");
		bidiMap.put("foo", "bar");
		bidiMap.put("Toyota", "Honda");
		bidiMap.put("Apple", "Google");
		
		System.out.println(bidiMap.get("foo")); 
		System.out.println(bidiMap.getKey("bar"));
	}

	public static void main(String[] args) {
		biDirectionalMapGuave();
		biDirectionalMapApache();
	}

}

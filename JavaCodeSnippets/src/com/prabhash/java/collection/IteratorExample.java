package com.prabhash.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Example of Collections Iterator interface
 * 
 * @author prrathore
 *
 */
public class IteratorExample {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("Foo");
		list.add("Bar");
		list.add("Hello");
		
		System.out.println("List size: " + list.size());
		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			// list.add("World"); //this should throw Concurrent Modification Exception as list is modified while collection is iterating through it
			// list.remove(0); // throw ConcurrentModificationException			
			System.out.println(iterator.next());
			iterator.remove();
		}
		
		// find size of list
		System.out.println("List after removing elements: " + list.size());

	}

}

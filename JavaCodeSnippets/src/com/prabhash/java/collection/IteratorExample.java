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
		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			list.add("World"); //this should throw Concurrent Modification Exception as list is modified while collection is iterating through it
			System.out.println(iterator.next());
		}

	}

}

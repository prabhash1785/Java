package com.prabhash.java.collection;

import java.util.Iterator;
import java.util.Vector;

/**
 * Use Vector to store a list of names.
 * 
 * @author prrathore
 *
 */
public class VectorExample {
	
	public static void main(String[] args) {
		
		final Vector<String> names = new Vector<>();
		
		names.add("US");
		names.add("India");
		names.add("Australia");
		names.add("England");
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				names.add("Canada");
				names.add("Switzerland");
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				names.add("Russia");
				names.add("Netherlands");
			}
			
		});
		
		t1.start();
		t2.start();
		
		// Wait for above two threads to complete operation before running further
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException i) {
			System.out.println("One of the threads where interrupted: " + Thread.currentThread().getName());
		}
		
		Iterator<String> iterator = names.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		// Java 8 style of printing from collection
		System.out.println("Print string from collections using Java 8 Lambdas: ");
		names.forEach(s -> System.out.println(s));

	}

}

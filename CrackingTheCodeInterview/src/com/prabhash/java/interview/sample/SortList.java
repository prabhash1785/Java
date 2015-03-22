package com.prabhash.java.interview.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sort list using Java APIs.
 * 
 * @author prrathore
 *
 */
public class SortList {
	
	private static List<String> stringList = new ArrayList<String>(); 

	public static void main(String[] args) {
		
		stringList.add("Max");
		stringList.add("Summer");
		stringList.add("Joe");
		stringList.add("Ben");
		stringList.add("Zen");
		stringList.add("Emmy");
		
		System.out.println("List before sorting:");
		for(String s : stringList) {
			System.out.println(s);
		}
		
		Collections.sort(stringList); //this sorts list of string because String class implements Comparable interface
		
		System.out.println("List after sorting:");
		for(String s : stringList) {
			System.out.println(s);
		}

	}

}

package com.prabhash.java.interview.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Program to sort a list by using a Comparator object.
 * 
 * @author prrathore
 *
 */
public class ComparatorImpl {
	
	private List<Employee> list = new ArrayList<Employee>();

	public static void main(String[] args) {
		
		ComparatorImpl c = new ComparatorImpl();
		c.list.add(c.new Employee(15, "Russel"));
		c.list.add(c.new Employee(4, "Peter"));
		c.list.add(c.new Employee(23, "Amber"));
		c.list.add(c.new Employee(34, "Max"));
		c.list.add(c.new Employee(12, "Joe"));
		
		Iterator<Employee> iterator = c.list.iterator();
	
		System.out.println("Before sorting the list: ");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		//Sort the list using by passing comparator function
		Collections.sort(c.list, c.new Employee()); //sort list by passing a Comparator object
		
		ListIterator<Employee> li = c.list.listIterator();
		
		System.out.println("After sorting the list: ");
		while(li.hasNext()) {
			System.out.println(li.next());
		}
		
	}
	
	private class Employee implements Comparator<Employee> {
		private int id;
		private String name;
		
		public Employee() {
			this(0, null);
		}
		
		public Employee(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public int compare(Employee e1, Employee e2) {
			if(e1.id > e2.id) {
				return 1;
			} else if(e1.id < e2.id) {
				return -1;
			} else {
				return 0;
			}
		}
		
		@Override
		public String toString() {
			return this.id + " :: " + this.name;
		}
	}

}

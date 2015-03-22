package com.prabhash.java.interview.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Sample program to use a hash map
 * 
 * @author Prabhash Rathore
 *
 */
public class SampleMap {
	
	private static Map<String, Employee> map = new HashMap<String, Employee>();

	public static class Employee {
		private String name;
		private String company;
		
		public Employee(String name, String company) {
			this.name = name;
			this.company = company;
		}
		
		@Override
		public String toString() {
			return this.name + " works for company " + this.company;
		}
	}
	
	public static void main(String[] args) {
		
		map.put("Max", new Employee("Max", "IBM"));
		map.put("Joseph", new Employee("Joseph", "Cisco"));
		map.put("Dan", new Employee("Dan", "PayPal"));
		map.put("Steve", new Employee("Steve", "Apple"));
		
		//print map data
		Set<String> set = map.keySet();
		
		for(String s : set) {
			System.out.println(s + " --> " + map.get(s));
		}

	}

}

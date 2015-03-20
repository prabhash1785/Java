package com.prabhash.java.interview.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class will implement Comparable interface to compare two objects.
 * 
 * @author prrathore
 *
 */
public class ComparableImpl {
	
	private static Employee e1 = new Employee(25, "Peter");
	private static Employee e2 = new Employee(10, "Russel");
	
	private static List<Employee> empList = new ArrayList<Employee>();  

	public static void main(String[] args) {
		
		System.out.println("Is e1 > e2: " + e1.compareTo(e2));
		
		empList.add(e1);
		empList.add(e2);
		empList.add(new Employee(34, "Mango"));
		empList.add(new Employee(4, "Apple"));
		empList.add(new Employee(12, "Honda"));
		
		System.out.println("List before sorting: ");
		for(Employee e : empList) {
			System.out.println(e);
		}
		
		//sort the list
		Collections.sort(empList);
		System.out.println("List after sorting: ");
		for(Employee e : empList) {
			System.out.println(e);
		}

	}
	
	//Nested class Employee
	private static class Employee implements Comparable<Employee> {
		
		private int empNum;
		private String empName;
		
		public Employee() {
			this(0, null);
		}
		
		public Employee(int empNum, String empName) {
			this.empNum = empNum;
			this.empName = empName;
		}
		
		@Override
		public int compareTo(Employee emp) {
			if(this.empNum > emp.empNum) {
				return 1;
			} else if(this.empNum < emp.empNum) {
				return -1;
			} else {
				return 0;
			}
			
		}
		
		@Override
		public String toString() {
			return this.empNum + " :: " + this.empName;
		}
		
	}

}

package com.prabhash.java.interview.sample;

/**
 * This class will implement Comparable interface to compare two objects.
 * 
 * @author prrathore
 *
 */
public class ComparableImpl {
	
	private static Employee e1 = new Employee(25, "Peter");
	private static Employee e2 = new Employee(10, "Russel");

	public static void main(String[] args) {
		
		System.out.println("Is e1 > e2: " + e1.compareTo(e2));

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
		
	}

}

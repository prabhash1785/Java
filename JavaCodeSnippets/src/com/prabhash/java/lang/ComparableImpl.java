package com.prabhash.java.lang;

/*
 * This is a sample program to implement Comparable interface from java.lang.Comparable interface.
 * When Comparable interface method is implemented by a class which wants to compare itself to other objects then this class
 * needs to override the compareTo method.
 * @author Prabhash Rathore
 * 
 */
public class ComparableImpl {
	
	private Employee emp1 = new Employee(10,"Ricky");
	private Employee emp2 = new Employee(100, "Amber");	
	
	public static void main(String[] args) {
		
		ComparableImpl comp = new ComparableImpl();
		System.out.println("Here is the comparison result: " + comp.emp1.compareTo(comp.emp2));

	}
	
	//Nested class for Employee object
	public static class Employee implements Comparable<Employee> {
		
		private int empID;
		private String name;
		
		public Employee() {
			this.empID = 0;
			this.name = null;
		}
		
		public Employee(int empID, String name) {
			this.empID = empID;
			this.name = name;			
		}
		
		@Override
		public int compareTo(Employee e1) {
						
			if(this.empID < e1.empID)
				return -1;
			else if(this.empID > e1.empID)
				return 1;
			else
				return 0;			
			
		}
		
	}

}

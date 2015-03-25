package com.prabhash.java.exercises;

import java.util.Date;

public class Employee implements Cloneable {
	
	private String employeeNumber; 
	private String firstName; 
	private String lastName; 
	private Date dob;
	private double salary;
	
//	@Override
//	public boolean equals(Object o) {
//		if(o == null) {
//			return false;
//		}
//		
//		if(!(o instanceof Employee)) {
//			return false;
//		} else {
//			Employee e = (Employee) o;
//			
//			if(e.employeeNumber == this.employeeNumber && e.dob.equals(this.dob)) {
//				return true;
//			}
//		}
//		
//		return false;
//		
//	}
//	
//	@Override
//	public int hashCode() {
//		final int prime = 23;
//		int result = 1;
//		
//		result = result * prime + employeeNumber.hashCode();
//		result = result * prime + dob.hashCode();
//		
//		return result;
//	}
	
	@Override
	public String toString() {
		return this.employeeNumber + " " + this.firstName + " " + this.lastName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result
				+ ((employeeNumber == null) ? 0 : employeeNumber.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (employeeNumber == null) {
			if (other.employeeNumber != null)
				return false;
		} else if (!employeeNumber.equals(other.employeeNumber))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(salary) != Double
				.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	public static void main(String[] args) {
		
		Employee employee = new Employee();
		System.out.println("Employee: " + employee);
		
		//Employee e2 = employee.clone();
		
		try {
			System.out.println("Clone text: " + employee == employee.clone());
		} catch(CloneNotSupportedException e) {
			System.out.println("Clone not supported!!");
			e.printStackTrace();
		}

	}

}

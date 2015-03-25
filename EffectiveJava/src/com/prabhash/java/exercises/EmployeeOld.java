package com.prabhash.java.exercises;

/**
 * Override equals and hashcode method. Use this in a HashMap.
 * 
 * @author prrathore
 *
 */
public class EmployeeOld {
	
	private String firstName;
	private String lastName;
	private int SSN;
	private String city;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + SSN;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
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
		EmployeeOld other = (EmployeeOld) obj;
		if (SSN != other.SSN)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
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
		return true;
	}

	public static void main(String[] args) {
		
		System.out.println(new EmployeeOld());

	}

}

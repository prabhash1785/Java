package com.prabhash.java.exercises;

/**
 * Example of Builder Design Pattern.
 * 
 * @author Prabhash Rathore
 *
 */
public class Customer {
	private final String firstName;
	private final String lastName;
	private final String middleName;
	private final String streetAddress;
	private final String city;
	private final String state;
	private final String zipCode;
	private final String homePhone;
	private final String cellPhone;
	private final String email;

	public static class Builder {
		// Required parameters
		private final String firstName;
		private final String lastName;
		private String middleName = null;
		private String streetAddress = null;
		private String city = null;
		private String state = null;
		private String zipCode = null;
		private String homePhone = null;
		private String cellPhone = null;
		private String email = null;

		public Builder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public Builder middleName(String s) {
			this.middleName = s;
			return this;
		}
		public Builder streetAddress(String s) {
			this.streetAddress = s;
			return this;
		}
		public Builder city(String s) {
			this.city = s;
			return this;
		}
		public Builder state(String s) {
			this.state = s;
			return this;
		}
		public Builder zipCode(String s) {
			this.zipCode = s;
			return this;
		}
		public Builder cellPhone(String s) {
			this.cellPhone = s;
			return this;
		}
		public Builder homePhone(String s) {
			this.homePhone = s;
			return this;
		}
		public Builder email(String s) {
			this.email = s;
			return this;
		}
		public Customer build() {
			return new Customer(this);
		}
	}
	private Customer(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.middleName = builder.middleName;
		this.streetAddress = builder.streetAddress;
		this.city = builder.city;
		this.state = builder.state;
		this.zipCode = builder.zipCode;
		this.homePhone = builder.homePhone;
		this.cellPhone = builder.cellPhone;
		this.email = builder.email;
	}

	@Override public String toString() {
		return firstName + "\t" + lastName + "\t" + state;
	}
	public static void main(String[] args) {
		Customer cust = new Customer.Builder("Clark","Kent").state("Kansas").build();
		System.out.println(cust);
	}
}



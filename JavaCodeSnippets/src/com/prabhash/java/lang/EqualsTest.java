package com.prabhash.java.lang;


/*
 * .equals() method compares the content of the object. Returns true if content is equal in the object
 * == operation on object checks for the equality of the reference of the object.
 * For Objects, equals method need to be explicitly overridden in order for the equality to work right.
 * 
 */
public class EqualsTest {

	public static void main(String[] args) {
		
		String s1 = "apple";
		String s2 = "apple";
		
		System.out.println("s1 hascode: " + s1.hashCode());
		System.out.println("s2 hascode: " + s2.hashCode());
		
		if(s1.equals(s2))
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
		
		if(s1 == s2)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
		
		System.out.println("\n Going to create new objects instead..");
		
		String s3 = new String("apple");
		String s4 = new String("apple");
		
		System.out.println("s3 hascode: " + s3.hashCode());
		System.out.println("s4 hascode: " + s4.hashCode());
		
		if(s3.equals(s4))
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
		
		if(s3 == s4)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
		
		System.out.println("\nGoing to compare objects usign equals and ==");
		
		Fruit fruit1 = new Fruit("apple");
		Fruit fruit2 = new Fruit("apple");
		
		System.out.println("Fruit1 hascode: " + fruit1.hashCode());
		System.out.println("Fruit2 hascode: " + fruit2.hashCode());
		
		if(fruit1.equals(fruit2))
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
		
		if(fruit1 == fruit2)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");

	}
	
		
	private static class Fruit {
		private String name;
		
		public Fruit(String name) {
			this.name = name;
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if((obj == null) && (obj.getClass() != this.getClass()))
				return false;
			else {
				Fruit fruit = (Fruit) obj;
				if(this.name == fruit.name)
					return true;
				else
					return false;
			}		
			
		}
		
		@Override
		public int hashCode() {
			
			int hash = 3;
			hash = 7 * hash + this.name.hashCode();
			System.out.println("Here is custom hash value: " + hash);
			return hash;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
	}

}

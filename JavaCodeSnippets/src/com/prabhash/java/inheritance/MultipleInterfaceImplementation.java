package com.prabhash.java.inheritance;

public class MultipleInterfaceImplementation {
	
	public static interface A {
		public void print();
	}
	
	public static interface B {
		public void print();
	}
	
	// Even thoug AB class implements two interface with same methods, below code will compile because as per interface
	// contract, it implements one method which is present in both interface
	public static class AB implements A, B {
		
		public void print() {
			System.out.println("Hello there!");
		}
	}

	public static void main(String[] args) {
		A a = new AB();
		a.print();
		
		B b = new AB();
		b.print();
	}
}

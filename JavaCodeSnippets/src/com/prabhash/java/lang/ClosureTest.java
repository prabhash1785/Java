package com.prabhash.java.lang;

public class ClosureTest {

	public static void main(String[] args) {
		
			int x = 5, y = 10;
			
			final class Inner {
				int z;
				
				public int getValue() {
					z = x + y;
					return z;
				}
			}
			
			System.out.println("Value of z: "+ new Inner().getValue());

	}

}

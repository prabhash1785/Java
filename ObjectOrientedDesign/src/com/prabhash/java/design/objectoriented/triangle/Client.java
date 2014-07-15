/*
 * This is a Design based question to determine the kind of triangle based on given sides.
 * Goal of this Program/Design is:
 * 	- To make the design flexible
 * 	- Easy to incorporate changes	 
 * Company: Microsoft
 * 
 */
package com.prabhash.java.design.objectoriented.triangle;

public class Client {

	public static void main(String[] args) {
		
		TriangleOperations client = new TriangleOperationsImpl();
		try {
			
			System.out.println(client.triangleType(6, 6, 6));
			System.out.println(client.triangleType(6, 6, 7));
			System.out.println(client.triangleType(4, 3, 5));
			System.out.println(client.triangleType(4, 6, 8));
			System.out.println(client.triangleType(4, 6, 1));
			
		} catch(InvalidTriangleException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}	

	}

}

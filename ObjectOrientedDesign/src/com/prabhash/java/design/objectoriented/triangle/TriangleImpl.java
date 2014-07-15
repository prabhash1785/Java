package com.prabhash.java.design.objectoriented.triangle;

/**
 * This is one implementation of a Triangle Object. 
 * @author Prabhash Rathore
 *
 */
public class TriangleImpl implements Triangle {
	
	private int side1;
	private int side2;
	private int side3;
	
	private String type;
	
	public TriangleImpl() {
		
	}
	
	public TriangleImpl(int side1, int side2, int side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 =  side3;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	//Check if triangle is a valid triangle
	public boolean isValidTriangle(int a, int b, int c) {
		if((a + b > c) && (b + c > a) && (c + a > b)) {
			System.out.println("It's a valid triangle!!");
			return true;
		} else {
			System.out.println("Not a valid triangle. Sum of any two sides is less than third side.");
			return false;
		}
	}
	
	@Override
	public int getLongestSide() {
		if(side1 > side2 && side1 > side3) {
			return side1;
		} else if(side2 > side3 && side2 > side1) {
			return side2;
		} else if(side3 > side1 && side3 > side2) {
			return side3;
		} else {
			return -1; //hypotenuse has to be the longest side, it can't be equal to any other sides
		}
	}
	
	@Override
	public String toString() {
		return type;
	}

}

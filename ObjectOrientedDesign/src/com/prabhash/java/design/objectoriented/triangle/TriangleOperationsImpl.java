package com.prabhash.java.design.objectoriented.triangle;

import static java.lang.Math.pow;

public class TriangleOperationsImpl implements TriangleOperations {

	private Triangle triangle;
	
	@Override
	public Triangle triangleType(int a, int b, int c) throws InvalidTriangleException {
		
		triangle = new TriangleImpl(a, b, c);
		if(triangle.isValidTriangle(a, b, c)) {
			
			if(a == b && b == c) {
				triangle.setType(TriangleProperties.EQUILATERAL);
			} else if(a == b || b == c || c == a) {
				triangle.setType(TriangleProperties.ISOSCELES);
			} else if(isRightTriangle(a, b, c)) {
				triangle.setType(TriangleProperties.RIGHT);
			} else {
				triangle.setType(TriangleProperties.SCALENE);
			}
			
			return triangle;
		
		} else {
			throw new InvalidTriangleException("Invalid Triangle");
		}
		
	}
	
	private boolean isRightTriangle(int a, int b, int c) {
		int hypotenuse = triangle.getLongestSide();
		//System.out.println("hypotenuse: " + hypotenuse);
		if(hypotenuse > 0) {
			int hypSquare = (int) pow(hypotenuse, 2);
			int sumOfOtherSideSquares = 0;
			if(hypotenuse == a) {
				sumOfOtherSideSquares = (int) (pow(b, 2) + pow(c, 2));
			} else if(hypotenuse == b) {
				sumOfOtherSideSquares = (int) (pow(c, 2) + pow(a, 2));
			} else {
				sumOfOtherSideSquares = (int) (pow(a, 2) + pow(b, 2));
			}
			
			//System.out.println("Hyp Square: " + hypSquare + " Other sides square: " + sumOfOtherSideSquares);
			if(hypSquare == sumOfOtherSideSquares) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}

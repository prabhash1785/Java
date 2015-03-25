package com.prabhash.java.exercises;

import java.util.HashMap;
import java.util.Map;

public class Point2D {
	
	private double x;
	private double y;
	
	public Point2D (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
//	@Override 
//	public boolean equals(Object o) { 
//		if (o == this) 
//			return true;
//		if (!(o instanceof Point2D))
//			return false;
//		Point2D p = (Point2D)o;
//		return p.x == x && p.y == y;
//	}
	
//	@Override
//	public int hashCode() {
//		int prime = 23;
//		int result = 1;
//		
//		result = result * prime + x
//		
//		return result;
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
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
		Point2D other = (Point2D) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}



	public static void main(String[] args) {
		
		Map<Point2D, String> map = new HashMap<Point2D, String>();
		
		map.put(new Point2D(2, 4), "Hello"); 
		
		String s = map.get(new Point2D(2, 4));
		
		//Print Hello is hashCode is implemented else prints null
		System.out.println("String is: " + s); 
		
		System.out.println(new Point2D(2, 4) == new Point2D(2, 4));
		System.out.println(new Point2D(2, 4).equals(new Point2D(2, 4)));
		
	}
	
}


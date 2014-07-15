package com.prabhash.java.design.objectoriented.triangle;

/**
 * This interface represents all the states and behaviors of a Triangle Object.
 */
public interface Triangle {
	
	public String getType();
	
	public void setType(String type);
	
	public boolean isValidTriangle(int a, int b, int c);
	
	public int getLongestSide();

}

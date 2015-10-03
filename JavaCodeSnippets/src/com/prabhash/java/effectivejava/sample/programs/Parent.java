package com.prabhash.java.effectivejava.sample.programs;

/**
 * Class to play around with inheritance. Child class will inheit from this class.
 * 
 * @author prrathore
 *
 */
public class Parent {
	
	private int a = 10;
	protected int b = 5;
	String s = "hello kids!!";
	public String p = "I am public";
	
	public int getA() {
		return this.a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
}

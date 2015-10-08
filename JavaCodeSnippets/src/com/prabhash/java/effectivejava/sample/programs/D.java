package com.prabhash.java.effectivejava.sample.programs;

public class D extends B{ 

	public D() { 

	} 

	public void m0(){ 
		System.out.println("DO"); 
	} 
	public void m1(){ 
		System.out.println("D1"); 

	} 

	public void test(){ 
		super.test(); 
	} 

	public static void main(String[] args) { 
		B d = new D(); 
		d.test(); 
	} 


}


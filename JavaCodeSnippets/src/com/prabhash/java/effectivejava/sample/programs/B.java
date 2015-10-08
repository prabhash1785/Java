package com.prabhash.java.effectivejava.sample.programs;

public class B { 

	public B() { 

	} 

	private void m0(){ 
		System.out.println("BO"); 
	} 
	public void m1(){ 
		System.out.println("B1"); 

	} 

	public void test(){ 
		this.m0(); 
		this.m1(); 
	} 
	
} 
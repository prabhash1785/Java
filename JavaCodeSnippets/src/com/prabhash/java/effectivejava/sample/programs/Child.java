package com.prabhash.java.effectivejava.sample.programs;

/**
 * I am Child and I inherit from Parent class.
 * 
 * @author prrathore
 *
 */
public class Child extends Parent {
	
	public Child() {
		// except private field from parent, you can access anything else using super
		System.out.println(super.b);
		System.out.println(super.s);
		System.out.println(super.p);
		
	}
	
	private int a = 34;
	public char ch = 'x'; 
	
	@Override
	public int getA() {
		super.p = "Chaged the value of parent";
		return this.a;
	}

	public static void main(String[] args) {
		
		Parent parent = new Child();
		Parent p = new Parent();
		Child c = new Child();
		
		//System.out.println(parent.a); // can't access "a" from parent class as it's private 
		// System.out.println(p.a); // can't access "a" from parent class as it's private 
		System.out.println(c.a);
		
		System.out.println(parent.getA()); // because of polymorphism, get a=34 from child instance
		System.out.println(p.getA()); // get Parent method
		
		// System.out.println(parent.ch); // can't get ch because parent does not have ch defined in it even though child insance has it
	
	}

}

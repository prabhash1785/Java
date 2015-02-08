package com.prabhash.java.lang;

/**
 * Java uses Pass by Value while passing parameters to function. What this essentially means is every time a function is called, Java sends
 * parameter by value by copying the parameter values for function call.
 * 
 * Even objects are passed by value so if you try to swap two objects they wouldn't be swapped as when objects are passed as parameters, 
 * the function gets a copy of the reference pointing to the same object. So when you swap objects, only thing gets swapped is their 
 * references on those objects.  
 * 
 * The only way to swap values in Java is to send values as member variables of one object and then exchange the value of those member
 * values for that one object.
 * 
 * @author prrathore
 *
 */
public class SwapIntegers {
	
	SwapIntegers() {
		
	}
	
	public static void swapByValye(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void swapByReference(Integer a, Integer b) {
		Integer temp = a;
		a = b;
		b = temp;
	}
	
	public static void swapWithObjects(Number m, Number n) {
		m.a = 5;
		m.b = 10;
		
		int temp = n.a;
		n.a = n.b;
		n.b =temp;	
		
	}
	
	private static class Number {
		private int a;
		private int b;
		
		public Number(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) {
		
		int p = 5;
		int q = 10;
		
		swapByValye(p, q); //Pass By Value doesn't swap the values
		
		System.out.println("p = " + p);
		System.out.println("q = " + q);
		
		//Let's try pass by reference
		Integer x = 10;
		Integer y = 20;
		swapByReference(x, y);
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		//Swap members of objects
		Number a = new Number(0, 0);
		Number b = new Number(20, 40);
		swapWithObjects(a, b);
		
		System.out.println("a :" + a.a + " " + a.b); // we can change the member variables of an object
		System.out.println(("b : " + b.a + " " + b.b)); // we can even swap the member variables of an object
		
	}	

}

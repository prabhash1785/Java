package com.prabhash.java.sample;

/**
 * Varargs Demo
 * 
 * Varargs
 *  - A method can only accept one varargs type parameter
 *  - Varargs parameter should be the last parameter in the parameter list
 * 
 * @author prrathore
 *
 */
public class VarArgsDemo {
	
	public static final void acceptVarArgs(String message, int... varargs) {
		
		System.out.println(message);
		for(int arg : varargs) {
			System.out.println(arg);
		}
		
	}

	public static void main(String[] args) {
		
		acceptVarArgs("Varargs Array", 1, 4, 12, 2, 78, 10, 26);

	}

}

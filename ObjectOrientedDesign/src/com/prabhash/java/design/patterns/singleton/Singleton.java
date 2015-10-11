package com.prabhash.java.design.patterns.singleton;

/**
 * Thread Safe Singleton Class
 * 
 * @author prrathore
 *
 */
public class Singleton {
	
	private static Singleton instance;
	
	private Singleton() {
		
	}
	
	public static final Singleton getInstance() {
		
		if(instance == null) {
			
			synchronized(Singleton.class) {
				
				instance = (instance == null) ? new Singleton() : instance;
				
			}
			
		}
		
		return instance;
		
	}
	
}

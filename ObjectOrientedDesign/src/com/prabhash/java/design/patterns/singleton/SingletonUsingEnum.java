package com.prabhash.java.design.patterns.singleton;

public class SingletonUsingEnum {
	
	// Define what the singleton must do.
	public interface MySingleton {
	    public void doSomething();
	}

	private enum Singleton implements MySingleton {

	    /**
	     * The one and only instance of the singleton.
	     *
	     * By definition as an enum there MUST be only one of these and it is inherently thread-safe.
	     */
	    INSTANCE {

	                @Override
	                public void doSomething() {
	                    System.out.println("Do something!!");
	                }

	            };
	}

	public static MySingleton getInstance() {
	    return Singleton.INSTANCE;
	}
}

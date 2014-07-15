package com.prabhash.java.design.objectoriented.triangle;

public class InvalidTriangleException extends Exception {
	
	private static final long serialVersionUID = 4206748726453439688L;

	public InvalidTriangleException() {
		super();
	}
	
	public InvalidTriangleException(String message) {
		super(message);
	}
	
	public InvalidTriangleException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidTriangleException(Throwable cause) {
		super(cause);
	}

}

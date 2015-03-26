package com.prabhash.java.exercises.designpatterns;

/**
 * Example of Decorator Pattern which adds extra functionality by wrapping existing objects.
 * 
 * @author prrathore
 *
 */
public class InstrumentedRot13 implements EncryptionStrategy {

	EncryptionStrategy stat;
	
	public InstrumentedRot13(EncryptionStrategy stat){
		this.stat = stat;
	}
	
	@Override
	public String encrypt(String clearText) {
		long start = System.nanoTime();
		String ret = stat.encrypt(clearText);
		long end = System.nanoTime();
		System.out.println("Time spent in nano second for reading and encryption: " + (end-start));
		return ret;
	}
}

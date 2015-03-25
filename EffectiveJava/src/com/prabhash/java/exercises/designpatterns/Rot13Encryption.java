package com.prabhash.java.exercises.designpatterns;

/**
 * 
 * Strategy implementation for encryption.
 * 
 * @author prrathore
 *
 */
public class Rot13Encryption implements EncryptionStrategy {
	
	@Override
	public String encrypt(String clearText) {
		
		StringBuilder encrypyedString = new StringBuilder();
		
		for(int i = 0; i < clearText.length(); i++) {
			char c = clearText.charAt(i);
			
			if (c >= 'a' && c <= 'm' || c >= 'A' && c <= 'M') 
				c += 13;
			else if (c >= 'n' && c <= 'z' || c >= 'N' && c <= 'Z') 
				c -= 13;
			
			encrypyedString.append(c);
			
		}
		
		return encrypyedString.toString();
	}
	

}

package com.prabhash.java.exercises.designpatterns;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class will read file and using a Strategy implementation will encrypt lines.
 * 
 * @author prrathore
 *
 */
public class SecureFileReader {
	
	private EncryptionStrategy encryptionStrategy;
	
	public SecureFileReader(EncryptionStrategy EncryptionStrategy) {
		this.encryptionStrategy = encryptionStrategy;
	}
	
	public void readAndEncrypt(String fileName, EncryptionStrategy encryptor) throws FileNotFoundException {
		
		try {
			File file = new File(fileName);
			
		} catch(NullPointerException f) {
			System.out.println("File not found!!");
			throw new FileNotFoundException();
		}
		
		
	}
	
	public static void main(String[] args) {
		SecureFileReader fileReader = new SecureFileReader(new Rot13Encryption());
		
		try {
			
			fileReader.readAndEncrypt("text.txt", fileReader.encryptionStrategy);
			
		} catch(FileNotFoundException f) {
			System.out.println("File not found!!");
		}
		
	}

}

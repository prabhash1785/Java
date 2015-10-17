package com.prabhash.java.security;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Generate checksum using Java MessageDigest class.
 * 
 * Applications of Message Digest algorithms like MD5, SHA-256, SHA-512:
 * 	- Passwords does not need to be transmitted over network instead a hash of Password could be sent over network and stored on server DB.
 * 	- For a low bandwidth network where each byte is precious while transmitting data, it's very effectively to just transmit Message Digest of files to compare their equalities.
 * 	- Also used for verifying the authenticity of softwares downloaded from internet.
 * 	- Could be used to do incremental builds of large Code base by just building new components whose message digest has been updated which leads to the conclusion the file content
 * 	  must have changed.
 * 
 * @author prrathore
 *
 */
public class CheckSum {
	
	/**
	 * Generate checksum of a String using MD5 Message Digest algorithm.
	 * 
	 * @param input
	 * @return
	 */
	public static byte[] getMD5DigestOfString(final String input) {
		
		if(input == null) {
			System.out.println("Given string is null");
			return null;
		}
		
		byte[] checksum = new byte[1024];
		
		try {
			final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			
			messageDigest.update(input.getBytes());
			
			checksum = messageDigest.digest();
			
			System.out.println("\nByte Array String value is:");
			for(byte b : checksum) {
				System.out.print(b);
			}
			
			
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return checksum;
		
	}
	
	/**
	 * Compute MD5 digest of a file.
	 * 
	 * @param fileName
	 * @return
	 */
	public static final byte[] getFileDigest(String fileName) {
		
		byte[] contentDigest = new byte[1024];
		
		InputStream inputStream = null;
		
		try {
			
			final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			
			inputStream = new BufferedInputStream(new FileInputStream(new File(fileName))); // example of Decorator Pattern
			System.out.println("\n\nNumber of bytes in file to be hashed: " + inputStream.available());
			
			byte[] data = new byte[1024];
			
			int bytesReadCount = inputStream.read(data);
			
			while(bytesReadCount != -1) {

				messageDigest.update(data);
				
				bytesReadCount = inputStream.read(data);
				
			}
			
			contentDigest = messageDigest.digest();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException io) {
			io.printStackTrace();
		} catch(NoSuchAlgorithmException noAlgorithm) {
			noAlgorithm.printStackTrace();
		} finally {
			if(inputStream != null) {
				try {
					inputStream.close(); // close the resource
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return contentDigest;
		
	}
	
	/**
	 * Compare two strings for their equality by comparing their MD5 hashes.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean compareCheckSums(final String s1, final String s2) {
		
		if(s1 == null || s2 == null) {
			System.out.println("\n\nSeems one of the input is null, cannot compare checksums");
		}
		
		byte[] checksum1 = getMD5DigestOfString(s1);
		byte[] checksum2 = getMD5DigestOfString(s2);
		
		if(new String(checksum1).equals(new String(checksum2))) {
			System.out.println("\n\nBoth string must be equal as their checksums are equal");
			return true;
		} else {
			System.out.println("\n\nTheir checksums are not equal");
			return false;
		}
		
	}

	public static void main(String[] args) {
		
		final String s = "I love Java!";
		final String other = "I love Java!";
		
		getMD5DigestOfString(s);
		
		compareCheckSums(s, other);
		
		// get hash of a file
		String filePath = "/Users/prrathore/temp/index.js";
		
		byte[] fileContentDigest = getFileDigest(filePath);
		System.out.println("\n\nFile Content MD5 digest is: " + new String(fileContentDigest));
	
	}

}

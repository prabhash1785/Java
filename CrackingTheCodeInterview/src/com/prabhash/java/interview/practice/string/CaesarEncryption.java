package com.prabhash.java.interview.practice.string;

/**
 * Encrypt given string by rotating each character by given number of steps. It should only encrypt alphabets, do not encrypt
 * numbers and special characters.
 * 
 * For eg, rotating hello by 1 should become = ifmmn
 * 
 * @author Prabhash Rathore
 *
 */
public class CaesarEncryption {

	public static String caesarEncryption(String s, int k) {
		if(k == 0) {
			return s;
		}
		
		StringBuilder encryptedString = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if(c >= 'a' && c <= 'z') {
				int before = c -  'a';
				int after = (before + k) % 26;
				c = (char)('a' + after);
			} else if(c >= 'A' && c <= 'Z') {
				int before = c -  'A';
				int after = (before + k) % 26;
				c = (char)('A' + after);
			}
			
			encryptedString.append(c);
		}
		
		return encryptedString.toString();
	}
	
	public static void main(String[] args) {
		String s = "1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M";
		String encryptedString = caesarEncryption(s, 27);
		System.out.println("Encrypted String: " + encryptedString);
		
		String s2 = "www.abc.xy";
		String encryptedString2 = caesarEncryption(s2, 87);
		System.out.println("Encrypted String: " + encryptedString2);
	}

}

package com.prabhash.java.interview.practice.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Generate excel column name from given number.
 * 
 * @author Prabhash Rathore
 *
 */
public class GenerateExcelColumnName {
	
	private static final int ALPHABET_SIZE = 26;
	private static final Map<Integer, Character> charMap = new HashMap<>();
	
	static {
		charMap.put(0, 'Z');
		charMap.put(1, 'A');
		charMap.put(2, 'B');
		charMap.put(3, 'C');
		charMap.put(4, 'D');
		charMap.put(5, 'E');
		charMap.put(6, 'F');
		charMap.put(7, 'G');
		charMap.put(8, 'H');
		charMap.put(9, 'I');
		charMap.put(10, 'J');
		charMap.put(11, 'K');
		charMap.put(12, 'L');
		charMap.put(13, 'M');
		charMap.put(14, 'N');
		charMap.put(15, 'O');
		charMap.put(16, 'P');
		charMap.put(17, 'Q');
		charMap.put(18, 'R');
		charMap.put(19, 'S');
		charMap.put(20, 'T');
		charMap.put(21, 'U');
		charMap.put(22, 'V');
		charMap.put(23, 'W');
		charMap.put(24, 'X');
		charMap.put(25, 'Y');
	}

	/**
	 * Generate excel String representation of given number.
	 * 
	 * Make sure id is > 0. Then apply remainder operator to given number and find the equivalent char for that remainder. Divide the
	 * (number - 1) by 26 and then repeat the same process until number reduces to 0. Finally reverse the String and return that as
	 * final output. 
	 * 
	 * @param id
	 * @return String
	 */ 
	public static String generateExcelColumnName(int id) {
		if(id <= 0) {
			throw new IllegalArgumentException();
		}
		
		StringBuilder sb = new StringBuilder();
		while(id > 0) {
			int rem = id % ALPHABET_SIZE;
			sb.append(charMap.get(rem));
			
			id = (id - 1) / ALPHABET_SIZE; // Make sure to subtract 1 from number to get correct division result
		}
		
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		int id1 = 53;
		System.out.println(id1 + " = " + generateExcelColumnName(id1));
		
		id1 = 26;
		System.out.println("\n" + id1 + " = " + generateExcelColumnName(id1));
		
		id1 = 51;
		System.out.println("\n" + id1 + " = " + generateExcelColumnName(id1));
		
		id1 = 52;
		System.out.println("\n" + id1 + " = " + generateExcelColumnName(id1));
		
		id1 = 80;
		System.out.println("\n" + id1 + " = " + generateExcelColumnName(id1));
		
		id1 = 676;
		System.out.println("\n" + id1 + " = " + generateExcelColumnName(id1));
		
		id1 = 702;
		System.out.println("\n" + id1 + " = " + generateExcelColumnName(id1));
		
		id1 = 705;
		System.out.println("\n" + id1 + " = " + generateExcelColumnName(id1));
	}
}

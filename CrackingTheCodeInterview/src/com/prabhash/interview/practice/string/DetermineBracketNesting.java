package com.prabhash.interview.practice.string;

/**
 * Find if a string has valid set of parentheses and if parentheses are valid then determine the nesting level of parentheses.
 * 
 * @author Prabhash Rathore
 *
 */
public class DetermineBracketNesting {
	
	/**
	 * To find the nesting of braces, do following:
	 * - Scan through the string
	 * - If you find an open brace, increment currentBracketCount
	 * - If you find a close brace, decrement currentBracketCount
	 * - At any point, if currentBracketCount < 0 that means it's an invalid string input with invalid brackets
	 * - If at any point currentBracketCount > maxBracketNesting then assign maxBracketNesting = currentBracketCount
	 * - After the scan of string is done, check if currentBracketCount > 0, if it is then some brackets were never closed, that means
	 * it was an invalid string
	 * - If everything is right then return maxBracketNesting
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param input
	 * @return
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public static int findBraceNesting(String input) throws IllegalArgumentException, Exception {
		
		if(input == null) {
			throw new Exception("String is null");
		}
		
		int currentBracketCount = 0;
		int maxBracketNesting = 0;
		
		for(int i = 0; i < input.length(); i++) {
			
			if(input.charAt(i) == '(') {
				currentBracketCount++;
			}
			
			if(input.charAt(i) == ')') {
				currentBracketCount--;
			}
			
			if(currentBracketCount < 0) {
				throw new IllegalArgumentException();
			}
			
			if(currentBracketCount > maxBracketNesting) {
				maxBracketNesting = currentBracketCount;
			}
			
		}
		
		if(currentBracketCount > 0) {
			throw new IllegalArgumentException();
		}
		
		return maxBracketNesting;
		
	}

	public static void main(String[] args) throws Exception {
		
		String s1 = "hellojavaconference";
		int bracketNesting1 = findBraceNesting(s1);
		System.out.println("Bracket count for " + s1 + " is: " + bracketNesting1);
		
		String s2 = "hello((there))!!)(I love you))(What a day)";
		try {
			int bracketNesting2 = findBraceNesting(s2);
			System.out.println("Bracket count for " + s2 + " is: " + bracketNesting2);
		} catch(Exception e) {
			System.out.println("Seems string has invalid set of braces!!");
		}
		
		String s3 = "yay(we made it) (LOL!!";
		try {
			int bracketNesting3 = findBraceNesting(s3);
			System.out.println("Bracket count for " + s3 + " is: " + bracketNesting3);
		} catch(Exception e) {
			System.out.println("Seems string has invalid set of braces!!");
		}
		
		String s4 = "(((What a beautiful day!!))) this is ((crazy)). ha( ha) ((LOL)) ";
		int bracketNesting4 = findBraceNesting(s4);
		System.out.println("Bracket count for " + s4 + " is: " + bracketNesting4);
		

	}

}

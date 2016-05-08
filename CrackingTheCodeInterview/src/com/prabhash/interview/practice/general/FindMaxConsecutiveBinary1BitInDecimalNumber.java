package com.prabhash.interview.practice.general;

import java.util.Scanner;

/**
 * Given a decimal number, find the max consecutive number of 1 bits in it's Binary Representation.
 * 
 * @author prrathore
 *
 */
public class FindMaxConsecutiveBinary1BitInDecimalNumber {

	/**
	 * Get the Reverse Binary Representation of a Decimal Number
	 * 
	 * @param n
	 * @return String
	 */
    public static String convertToBinary(int n) throws IllegalArgumentException {
        
        if(n < 1) {
            throw new IllegalArgumentException();
        }
        
        StringBuffer sb = new StringBuffer();
        while(n > 0) {
            int rem = n % 2;
            n = n / 2;
            sb.append(rem);
        }
        
        return sb.toString();
    }
    
    /**
     * Find maximum consecutive number of ones in Binary String
     * 
     * @param s
     * @return maxConsecutiveOneCount
     */
    public static int getMaxConsecutiveOnes(String s) {
        
        if(s == null) {
            return 0;
        }
        
        if(s.length() == 0) {
            return 0;
        }
        
        int maxConsecutiveOneCount = 0;
        for(int i = 0; i < s.length(); i++) {

            int consecutiveOneCount = 0;
            while(i < s.length() && s.charAt(i) == '1') {
                consecutiveOneCount++;
                i++;
            }
            
            if(consecutiveOneCount > maxConsecutiveOneCount) {
                maxConsecutiveOneCount = consecutiveOneCount;
            }
        }
        return maxConsecutiveOneCount;
    }
    
    public static void main(String[] args) {
    	
    	System.out.print("Enter a decimal number: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String binaryPattern = convertToBinary(n);
        int consecutiveOneCount = getMaxConsecutiveOnes(binaryPattern);
        System.out.println("\nMax consecutive 1 in Binary String is: " + consecutiveOneCount);
        
        in.close(); // close the scanner resource
    }
}

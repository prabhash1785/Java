package com.prabhash.java.interview.combinatorics;
import java.util.HashSet;
import java.util.Set;

/**
 * Find the size of longest common subset for given two strings.  
 * 
 * @author Prabhash Rathore
 *
 */
public class LongestCommonSubSetOfTwoStrings {
	
	/**
	 * Find the longest of longest common subset of given two strings.
	 * 
	 * Time Complexity: O(2 ^ n) where n is the length of longest string
	 * 
	 * @param x
	 * @param y
	 * @return longestSubSequence
	 */
	public static int longestSubsequence(String x, String y) {
        if(x == null || y == null || x.length() == 0 || y.length() == 0) {
            return 0;
        }
        
//        Set<String> subSequenceOfX = getAllSubSequence(x);
//        Set<String> subSequenceOfY = getAllSubSequence(y);
        
        Set<String> subSequenceOfX = binaryPowerSet(x);
        Set<String> subSequenceOfY = binaryPowerSet(y);
        
        int longestSubSequence = 0;
        for(String s : subSequenceOfX) {
        	if(subSequenceOfY.contains(s) && s.length() > longestSubSequence) {
        		longestSubSequence = s.length();
        	}
        }
        
        return longestSubSequence;
    }
    
	/**
	 * Method 1: Find powerset using recursive algorithm.
	 * 
	 * @param s
	 * @return powerSet
	 */
    public static Set<String> getAllSubSequence(String s) {
		if(s == null) {
			throw new NullPointerException();
		}
		
		final Set<String> powerSet = new HashSet<>();
		powerSet.add("");
		
		for(int i = 0; i < s.length(); i++) {
			String prefix = String.valueOf(s.charAt(i));
			String suffix = s.substring(i + 1);
			
			powerSet.add(prefix);
			getAllSubSequenceHelper(prefix, suffix, powerSet);
		}
		
		return powerSet; 
	}
	
	private static void getAllSubSequenceHelper(String prefix, String suffix, Set<String> list) {
		for(int i = 0; i < suffix.length(); i++) {
			String subset = prefix + suffix.charAt(i);
			list.add(subset);
			
			// recurse on the remaining suffix with subset as prefix
			getAllSubSequenceHelper(subset, suffix.substring(i + 1), list);
		}
	}
	
	/**
	 * Find powerset using Binary Strings from 0 to sizeof(string).
	 * 
	 * Time complexity: O(2 ^ n)
	 * 
	 * @param s
	 * @return powerSet
	 */
	public static Set<String> binaryPowerSet(String s) {
		Set<String> powerSet = new HashSet<>();
		
		char[] a = s.toCharArray();
		int n = a.length; //size of elements in input set
		
		int powerSetSize = (int) Math.pow(2, n);
		
		for(int i = 0; i < powerSetSize; i++) {
			
			String binary = Integer.toBinaryString(i);
			while(binary.length() < n) {
				binary = "0" + binary;
//				System.out.println("Binary number is -> " + binary);
			}
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < n; j++) {
				if(binary.charAt(j) == '1') {
					sb.append(a[j]);
				}
			}
			powerSet.add(sb.toString());	
		}		
			
		return powerSet;
	}
	
    public static void main(String[] args) {
//    	String x = "pxmfjrmvkehafjpxrehkkqcqbjpcmxymsgnfdzzplkdaewzoteyavwwzcnbtsrxyccjxfmbwsfquqelpicmmvymatfvwpemabhlxpjxuywludjhkfwpyowvnkpupalimnnecvtesblatxnewkywvvohdbgfavjxumqhvkznutjpowuvhmnyvzbykuzmchbnlmuiavdfbcuutaqqgiwhjefmcapfisdtohavoputtnhzecalriymlnfabvtbkhtnpenxkbtubuyskwykpablacspjkanwlnxeuuksccptvtqwomusmvuygfdmbkftbdlwmmxeudbdknqudfcrsaefetouygyejfelfqoqvhfabprdbjcihqrzfdbqcafvoowjskqwzironkxxsqedgbycvhnuskhdkkgfpggahvuznqytlldquvbofbxafrxmnbaignazengaxngdobatpmqfzghlamzuoelwvajlvzbuoxwluxqhsmcj";
//    	String y = "ohazmsexovixkuuneqnzdhhsweyjmrevqszglreqzacuzefaszzyzramuctxeusmzmtajezzfnrqmmmcyvrogrhntqwlbfpatgjxlweewaiaqidxrqplxdudscuqhrfjtqvksksnfmfhcodvghtkgzojpzytmdcimjzwaonnwmhmsaacnrblvvzhwbiokgziuvsfersuxiiydcfcvnkpbzljsqrqtgmhywkjxlxsixlxrwsnyypjkoxgtyczbouvojmfoqptnqfkvrynavuywnemedlvbvlafhorcfpqixphfwoybefcsbubegqmhcgyfbetfsyuqbadugfylowmzrifijkzlpawkewixgcfvqxapcyzpegrzrqczfdssgvspnjktlshhjqvvlkcmvwtwclpfwlwwulvfvmnnzldpiotcalpktbklalusufgbkrqgzdbagtqzlzealvq";
    	// Expected Output: 64
    	
    	String x = "hackerranks", y = "hackers";
    	int n = longestSubsequence(x, y);
    	System.out.println("Longest commmon subset size is: " + n);
    }
}

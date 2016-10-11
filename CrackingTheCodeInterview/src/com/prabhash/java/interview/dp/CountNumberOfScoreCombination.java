package com.prabhash.java.interview.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountNumberOfScoreCombination {
	
	private static int recursiveFunctionCallCounter = 0;
	
	/**
	 * Method 1:
	 * Using Brute Force, recursively find the number of unique score sequence which will sum upto a given total score.
	 * Maintain a sequence string and a set where these unique score sequences will be added. Finally return ths size of set of
	 * unique score sequence.
	 * 
	 * Time Complexity: O(scores.length ^ totalScore) - Exponential
	 *  
	 * @param totalScore
	 * @param scores
	 * @return number of unique combinations
	 */
	public static int countNumberOfScoreComobination(int totalScore, int[] scores) {
		if(scores == null || scores.length == 0) {
			return 0;
		}
		
		Set<String> scoreSequence = new HashSet<>();
		countNumberOfScoreComobinationHelper(totalScore, scores, "", scoreSequence);
		
		// Print all score combinations
		System.out.println("Here are all score sequences:");
		for(String s : scoreSequence) {
			System.out.println(s);
		}
		
		return scoreSequence.size();
	}
	
	private static void countNumberOfScoreComobinationHelper(int totalScore, int[] scores, String sequence, Set<String> set) {
		++recursiveFunctionCallCounter; // to check how many times my recursive function executed
		if(totalScore < 0) {
			return;
		}
		
		if(totalScore == 0) {
			char[] c = sequence.toCharArray();
			Arrays.sort(c); // just to make sure we don't add duplicate sequences to set
			set.add(String.valueOf(c));
			return;
		}
		
		for(int i = 0; i < scores.length; i++) {
			sequence += scores[i];
			countNumberOfScoreComobinationHelper(totalScore - scores[i], scores, sequence, set);
			sequence = sequence.substring(0, sequence.length() - 1); // remove the last score from sequence
		}
	}
	
	/**
	 * Method 2:
	 * Find number of unique sequence to get to a score using Dynamic Programming as brute force recursion is very expensive and we repeat the same work over and over. As part of DP,
	 * maintain a set of sorted String sequence which has already been worked upon.
	 * 
	 * Time Complexity: O(scores.length * totalScore * scores.length(log scores.length))
	 * 
	 * @param totalScore
	 * @param scores
	 * @return
	 */
	public static int getUniqueScoreCombinationUsingDP(int totalScore, int[] scores) {
		if(scores == null || scores.length == 0) {
			return 0;
		}
		
		// reset function call counter to 0
		recursiveFunctionCallCounter = 0;
		
		Set<String> scoreSequence = new HashSet<>();
		Set<String> uniqueSequence = new HashSet<>(); // DP approach to not recurse on any work if we have already solved it before
		
		getUniqueScoreCombinationUsingDPHelper(totalScore, scores, "", scoreSequence, uniqueSequence);
		
		return scoreSequence.size();
	}
	
	private static void getUniqueScoreCombinationUsingDPHelper(int totalScore, int[] scores, String sequence, Set<String> set
			, Set<String> uniqueString) {
		
		++recursiveFunctionCallCounter; // count number of times this function is called
		
		if(totalScore < 0) {
			return;
		}
		
		// Used to verify if we have already worked on a combination of string, if we have then don't repeat work
		char[] c = sequence.toCharArray();
		Arrays.sort(c);
		
		if(totalScore == 0) {
			set.add(String.valueOf(c));
			return;
		}
		
		if(uniqueString.contains(String.valueOf(c))) {
			return; // computation is already done for this, just return since we are only interested in unique values
		}
		
		for(int i = 0; i < scores.length; i++) {
			sequence += scores[i];
			getUniqueScoreCombinationUsingDPHelper(totalScore - scores[i], scores, sequence, set, uniqueString);
			sequence = sequence.substring(0, sequence.length() - 1); // remove the last score from sequence
		}
		
		uniqueString.add(sequence); // add the string sequence we have already solved as part of DP algorithm
	}

	public static void main(String[] args) {
		int totalScore = 12;
		int[] scores = new int[] {2, 3, 7};
		
		int numberOfScoreCombinations = countNumberOfScoreComobination(totalScore, scores);
		System.out.println("Number of score combination = " + numberOfScoreCombinations);
		System.out.println("Number of times countNumberOfScoreComobinationHelper recursive function executed: " + recursiveFunctionCallCounter);
		
		int numberOfScoreCombinationsUsingDP = getUniqueScoreCombinationUsingDP(totalScore, scores);
		System.out.println("Number of score combination using DP = " + numberOfScoreCombinationsUsingDP);
		System.out.println("Number of times countNumberOfScoreComobinationHelper recursive function executed: " + recursiveFunctionCallCounter);
	}
}

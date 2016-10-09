package com.prabhash.java.interview.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountNumberOfScoreCombination {
	
	private static int recursiveFunctionCallCounter = 0;
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
			sequence = sequence.substring(0, sequence.length() - 1); // remove the last score
		}
	}
	
	public static void main(String[] args) {
		int totalScore = 12;
		int[] scores = new int[] {2, 3, 7};
		
		int numberOfScoreCombinations = countNumberOfScoreComobination(totalScore, scores);
		System.out.println("Number of score combination = " + numberOfScoreCombinations);
		System.out.println("Number of times countNumberOfScoreComobinationHelper recursive function executed: " + recursiveFunctionCallCounter);
	}
}

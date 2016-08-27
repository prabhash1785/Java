package com.prabhash.java.interview.recursion;

/**
 * You have a ladder n-steps in height.  You can either take one step or two steps up the ladder at a time.  
 * Find out all the different combinations up the ladder. 
 * 
 * @author Prabhash Rathore
 *
 */
public class LadderProblem {
	
	/**
	 * Recursively find number of paths for step 1 and step 2 and add those two counts.
	 * 
	 * @param n
	 * @return count of different paths
	 */
	public static int countLadderStepCombination(int n) {
		if(n == 0) {
			return 1;
		}
		
		if(n < 0) {
			return 0;
		}
		
		return countLadderStepCombination(n - 1) + countLadderStepCombination(n - 2);
	}

	public static void main(String[] args) {
		int ladderStepCount = 4;
		int ladderPathCombination = countLadderStepCombination(ladderStepCount);
		System.out.println("Ladder path count: " + ladderPathCombination);
	}
}

package com.prabhash.java.games.chutesandladders.util;

import java.util.Random;

/**
 * This class is a final class which provides the utility functionality of a Spinner in the game of Chutes and Ladders.
 * 
 * @author Prabhash Rathore
 *
 */
public final class Spinner {
	
	/**
	 * This utility method has the behavior of a Spinner class which is when called returns a random number from 1 and 6.
	 * This random functionality is achieved by using the java.util.Random class of JDK.
	 * 
	 * @return int
	 */
	public static final int spin() {
		Random random = new Random();
		int spinResult = random.nextInt(6); //generate randomnumbers from 0 to 6 excluding 6 then return that number after adding 1
		
		//Since spin has to be from 1 and 6 so incrementing each number by 1
		return spinResult + 1;		
		
	}

}

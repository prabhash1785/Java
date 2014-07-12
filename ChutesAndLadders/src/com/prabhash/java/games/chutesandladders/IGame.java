package com.prabhash.java.games.chutesandladders;

import com.prabhash.java.games.chutesandladders.util.Constants;

/**
 * Interface definition for Chutes and Ladders game.
 * 
 * @author Prabhash Rathore
 *
 */
public interface IGame {
	
	public static final int defaultNumberOfPlayers = Constants.getTwo();
	public static final int maxNumberOfPlayers = Constants.getFour();
	
	public void playGame();

}

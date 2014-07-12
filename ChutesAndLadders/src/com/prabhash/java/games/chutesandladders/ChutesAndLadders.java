package com.prabhash.java.games.chutesandladders;

/**
 * This is a Simulator class to run the Chutes and Ladders game.
 * 
 * This class can be run as follows from command line:
 * java com.prabhash.java.games.chutesandladders.ChutesAndLadders Amber Ricky
 * 
 * @author Prabhash Rathore
 *
 */
public class ChutesAndLadders {

	/**
	 * This main method reads list of player names from Command line arguments, then gets a handle on Game object and starts the game by calling the playGame
	 * method of Game class. Game.playGame() method runs until a winner is decided.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		if(args == null || args.length == 0) {
			throw new Exception("At least 2 player names need to be provided at command line to begin the game!!");
		}
		
		//Get the handle on the game object using the factory method
		IGame game = Game.gameFactory(args);
		
		try {
			game.playGame();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}

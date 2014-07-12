package com.prabhash.java.games.chutesandladders;

/**
 * This class represents the Chutes and Ladders game comprising of all the Players and Board objects.
 * This is a Singleton class as at one time only one game instance is allowed. 
 * 
 * @author Prabhash Rathore
 *
 */
public class Game implements IGame {
	
	private static Game game = null;
	
	private static int numberOfPlayers;
	private static Player[] players;
	
	private static int numberOfTurns = 0; //track the number of turns taken in the game
	
	//Default Constructor for Serialization and Inheritance purposes for any future changes
	private Game() { 
		
	}
	
	/**
	 * Private Constructor which instantiates players and sets up the Board
	 *  
	 * @param listOfPlayers
	 * @throws Exception
	 */
	private Game(String[] listOfPlayers) throws Exception {
		
		if(listOfPlayers == null || listOfPlayers.length == 0) {
			throw new Exception("At least 2 player names need to be provided at command line to begin the game!!");
		}
		
		numberOfPlayers = listOfPlayers.length;
		
		//Making sure numbers of players should be >= 2 and <= 4		
		if(numberOfPlayers > maxNumberOfPlayers) {
			throw new Exception("More than 4 players are not allowed!!");
		} else if(numberOfPlayers < defaultNumberOfPlayers) {
			throw new Exception("There has to be at least two players to begin the game!!");
		}
		
		//instantiate Players
		players = new Player[numberOfPlayers];
		
		for(int i = 0; i < numberOfPlayers; i++) {
			players[i] = new Player(i + 1, listOfPlayers[i]);			
		}
		
		//Setup Chutes and Ladder Board
		Board.setUpBoard();
	}
	
	/**
	 * This is a factory method to get an object of Game class. This also controls the instantiation of this class by following Singleton Design Pattern.
	 * 
	 * @param numberOfPlayers
	 * @return Game
	 * @throws Exception
	 */
	public static Game gameFactory(String[] playerNames) throws Exception {
		if(game != null) {
			return game;
		} else {
			synchronized(Game.class) {
				game = new Game(playerNames);
			}
			return game;
		}
	}
	
	/**
	 * 
	 * Start Chutes and Ladders game by calling this method once you have the handle of this class. This method will run until one of the player reached 
	 * home/100th box on the board. 
	 * 
	 */
	public void playGame() {
		
		boolean foundWinner = false; //flag to detect if a player wins the game by reaching 100
		
		while(!foundWinner) {
			
			for(Player player : players) {
				
				if(player != null) {
					
					numberOfTurns++; //track the total number of turns taken in the game
					
					int currentPosition = player.getCurrentPosition();
					int spinResult = player.play(); //get the result after spinning the Spinner/Dice
					int newPosition = currentPosition + spinResult;
					
					System.out.print(numberOfTurns + ": " + player.getName() + ": " + currentPosition + " --> " + newPosition);
					
					if(newPosition > 100) {
						System.out.print(" <==> " + newPosition + " > 100. Score exactly 100 to WIN!!\n\n");
						continue;
					} else {
						
						//check if new position has a Chute, if yes make the player slide
						if(newPosition < 100 && Board.squares[newPosition].getChute() != null) {
							
							//int bottomPos = Board.squares[newPosition].getChute().getBottomPosition();
							
							int bottomPos = Board.squares[newPosition].getChute().slide(newPosition);
														
							System.out.print(" -- CHUTE --> " + bottomPos);
							
							newPosition = bottomPos;
						}
						
						//check if new Position has a Ladder, if yes make player go up the ladder
						if(newPosition < 100 && Board.squares[newPosition].getLadder() != null) {
							
							//int topPos = Board.squares[newPosition].getLadder().getTopPosition();
							
							int topPos = Board.squares[newPosition].getLadder().climb(newPosition);
														
							System.out.print(" -- LADDER --> " + topPos);
							
							newPosition = topPos;
						}						
						
						player.setCurrentPosition(newPosition);
						System.out.println("\n"); //line break for pretty output						
						
						if(newPosition == 100) {
							System.out.print("The Winner is " + player.getName() + "!");
							foundWinner = true;
							player.setResult(foundWinner); //setting the players result as winner, this can be used for future to persist players winning record
							break;
						}						
						
					}
				}
				
			}
		
		}
	}

}

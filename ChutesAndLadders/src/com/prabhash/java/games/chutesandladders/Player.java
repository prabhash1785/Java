package com.prabhash.java.games.chutesandladders;

import com.prabhash.java.games.chutesandladders.util.Spinner;

/**
 * This class represents Player playing the Chutes and Ladders game.
 * 
 * @author Prabhash Rathore
 *
 */
public class Player {
	
	private int playerID; //unique key
	private String name;
	private int currentPosition; //position of player on the board
	private boolean result; //final result of player
	
	public Player() {
		this.currentPosition = 0;
		this.result = false;
	}
	
	public Player(int playerID, String name) {
		this.playerID = playerID;
		this.name = name;
		this.currentPosition = 0;
		this.result = false;		
	}
	
	/**
	 * @return the playerID
	 */
	public int getPlayerID() {
		return playerID;
	}
	/**
	 * @param playerID the playerID to set
	 */
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the currentPosition
	 */
	public int getCurrentPosition() {
		return currentPosition;
	}
	/**
	 * @param currentPosition the currentPosition to set
	 */
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
	}
	
	/**
	 * Play method which lets a player play and spin the wheel to get a number and move forward in the game.
	 * 
	 */
	public int play() {
		return Spinner.spin();		
	}
	
	@Override
	public String toString() {
		return this.getPlayerID() + " " + this.getName() + " " + this.getCurrentPosition();
	}

}

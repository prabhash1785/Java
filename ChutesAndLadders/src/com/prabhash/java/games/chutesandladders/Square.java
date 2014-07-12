package com.prabhash.java.games.chutesandladders;

/**
 * This class represents individual square boxes on the Chutes and Ladders game board.
 * 
 * Field Members:
 * id 
 * 	Type - int
 * 	Purpose - any number from 1 to 100 representing a unique square on the board
 * 
 * ladder 
 * 	Type - Ladder
 * 	Purpose - Ladder for this square
 * 
 * chute 
 * 	Type - Chute
 * 	Purpose - Chute for this square
 * 
 * @author Prabhash Rathore
 *
 */
public class Square {
	
	private int id;
	private Ladder ladder;
	private Chute chute;
	
	public Square() {
		this.id = 0;
		this.ladder = null;
		this.chute = null;
	}
	
	public Square(int id) {
		this.id = id;
		this.ladder = null;
		this.chute = null;		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the ladder
	 */
	public Ladder getLadder() {
		return ladder;
	}
	/**
	 * @param ladder the ladder to set
	 */
	public void setLadder(Ladder ladder) {
		this.ladder = ladder;
	}
	/**
	 * @return the chute
	 */
	public Chute getChute() {
		return chute;
	}
	/**
	 * @param set the chute
	 */
	public void setChute(Chute chute) {
		this.chute = chute;
	}	

}

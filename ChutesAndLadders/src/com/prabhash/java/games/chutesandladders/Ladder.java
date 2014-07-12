package com.prabhash.java.games.chutesandladders;

/**
 * This class represents Ladders in the game of Chutes and Ladders.
 * 
 * @author Prabhash Rathore
 *
 */
public class Ladder {
	
	private int bottomPosition; //bottom position of Ladder
	private int topPosition; //top position ofLadder
	
	Ladder(int bottomPosition, int topPosition) {
		this.bottomPosition = bottomPosition;
		this.topPosition = topPosition;
	}
	
	/**
	 * @return the bottomPosition
	 */
	public int getBottomPosition() {
		return bottomPosition;
	}
	/**
	 * @param bottomPosition the bottomPosition to set
	 */
	public void setBottomPosition(int bottomPosition) {
		this.bottomPosition = bottomPosition;
	}
	/**
	 * @return the topPosition
	 */
	public int getTopPosition() {
		return topPosition;
	}
	/**
	 * @param topPosition the topPosition to set
	 */
	public void setTopPosition(int topPosition) {
		this.topPosition = topPosition;
	}
	
	/**
	 * This method will be called to let a player go up the Ladder on the Board.
	 * @param bottomPosition
	 * @return this.topPosition
	 */
	public int climb(int bottomPosition) {
		return this.topPosition;
	}

}

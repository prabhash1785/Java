package com.prabhash.java.games.chutesandladders;

/**
 * This class represents Chutes in the board game of Chutes and Ladders.
 * 
 * @author Prabhash Rathore
 *
 */
public class Chute {
	
	private int topPosition;
	private int bottomPosition;
	
	public Chute(int topPosition, int bottomPosition) {
		this.topPosition = topPosition;
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
	 * This method will be called to slide a player down the chutes.
	 * @param topPosition
	 * @return this.bottomPosition
	 */
	public int slide(int topPosition) {
		return this.bottomPosition;
	}

}

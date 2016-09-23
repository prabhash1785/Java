package com.prabhash.java.interview.recursion;

import java.util.Stack;

/**
 * Tower of Hanoi
 * 
 * @author Prabhash Rathore
 *
 */
public class TowerOfHanoi {
	
	/**
	 * This is a recursive algorithm to move n discs from origin tower to destination tower.
	 * 
	 * This is solved by first moving (n - 1) discs to buffer tower and then transfer last disc from origin to destination. Finally
	 * transfer (n - 1) discs from buffer to destination.
	 * 
	 * Time Compelxity: O(2 ^ n)
	 * 
	 * @param discCount
	 * @param origin
	 * @param destination
	 * @param buffer
	 */
	public static void towerOfHanoiMoves(int discCount, Tower origin, Tower destination, Tower buffer) {
		if(discCount <= 0) {
			return;
		}
		
		// move n - 1 discs to buffer
		towerOfHanoiMoves(discCount - 1, origin, buffer, destination);
		
		// move last disc from origin to destination
		int discID = origin.peg.pop();
		destination.peg.push(discID);
		System.out.println(discID + " moved from " + origin + " -> " + destination);
		
		// move n - 1 discs from buffer to destination
		towerOfHanoiMoves(discCount - 1, buffer, destination, origin);
	}
	
	public static class Tower {
		private String name;
		private Stack<Integer> peg;
		
		public Tower(String name) {
			this.name = name;
			peg = new Stack<>();
		}
		
		@Override
		public String toString() {
			return this.name;
		}
	}
	
	public static void main(String[] args) {
		final int discCount = 5;
		Tower origin = new Tower("Origin");
		Tower destination = new Tower("Destination");
		Tower buffer = new Tower("Buffer");
		
		// add discs to origin tower
		for(int i = discCount; i > 0; i--) {
			origin.peg.push(i);
		}
		
		towerOfHanoiMoves(discCount, origin, destination, buffer);
	}
}

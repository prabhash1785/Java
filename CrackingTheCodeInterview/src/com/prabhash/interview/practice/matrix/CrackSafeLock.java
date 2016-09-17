package com.prabhash.interview.practice.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * You are a programmer at a clandestine organization. Somewhere in the world is a keypad on a safe.
 * We want to brute force open the safe by trying all possible combinations.
 * 
 * The keypad looks like:
 * [X][2][3]
 * [4][X][6]
 * [7][8][9]
 * 
 * '1' and '5' are not used
 * 
 * From one key to next is a chess knight-piece 'L' shaped move.
 * In (x,y) that is (±2,±1) or (±1,±2).
 * 
 * The sequence starts at 2
 * 
 * We do not know the length 'n', but we will do examples of n==4
 * Examples: 2727, 2927, 2929, 2729, 2767, 2943, 2949
 * 
 * @author Prabhash Rathore
 *
 */
public class CrackSafeLock {
	
	private static final int[][] keypad = new int[][] {
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9}
	};
	
	/**
	 * This problem can be solved recursively. For the given cell, find all possible Knight-piece moves and then for each of those
	 * possible moves, repeat the same process recursively.
	 * 
	 * Keep adding each move key value to string key combination. If key combination is equal to given key size then add that to list.
	 * After each recursive call, make sure to remove last character from key string otherwise, you will not get all possible key
	 * combination.
	 * 
	 * Time Complexity: Depends on the dimension of keypad. Assuming it's just a numeric keypad with constraints that only Knight moves are possible
	 * then for each possible cell, we can get at most 2 possible "valid" moves (other 6 moves will go out of bound). So with this constraints, time
	 * complexity would be constant. But if let's say these constraints don't apply then worst came time complexity could be: O(8 ^ n) where n is the
	 * dimension of square shaped key pad and 8 are possible moves from any cell.
	 * 
	 * @param x
	 * @param y
	 * @param keyLength
	 * @return keyCombinations
	 */
	public static List<String> getAllPossibleKeyCombination(int x, int y, int keyLength) {
		if(!isValidCell(x, y)) {
			return null;
		}
		
		List<String> keyCombinations = new ArrayList<>();
		String initialKey = "" + keypad[x][y];
		getAllPossibleKeyCombinationHelper(x, y, keyLength, keyCombinations, initialKey);
		
		return keyCombinations;
	}

	private static void getAllPossibleKeyCombinationHelper(int x, int y, int keySize, List<String> keyCombination, String key) {
		if(!isValidCell(x, y)) {
			return;
		}
		
		if(key.length() == keySize) {
			keyCombination.add(key);
			return;
		}
		
		List<Cell> allValidMoves = getAllValidKnightMoves(x, y);
		for(Cell cell : allValidMoves) {
			if(key.length() < keySize) {
				key += keypad[cell.x][cell.y];
			}
			
			// recurse for each valid moves
			getAllPossibleKeyCombinationHelper(cell.x, cell.y, keySize, keyCombination, key);
			
			// After recursion make sure to remove last character from string otherwise you won't see all
			// possible combination of strings
			String substring = key.substring(0, key.length() - 1);
			key = substring;
		}
	}
	
	/**
	 * Get all possible valid Chess Knight-piece moves from given cell. A Knight on chess moves like this: 
	 * For (x,y) moves are: (x ± 2, y ± 1) or (x ± 1, y ± 2)
	 * 
	 * There are 8 total moves possible from given cell. Make sure those moves are valid before returning to caller.
	 * Cell with value 1 and 5 are not used so they are invalid.
	 * 
	 * @param x
	 * @param y
	 * @return moves
	 */
	private static List<Cell> getAllValidKnightMoves(int x, int y) {
		if(!isValidCell(x, y)) {
			return null;
		}
		
		List<Cell> moves = new ArrayList<>();
		
		// left top move
		int xLeftTop = x - 2;
		int yLeftTop = y - 1;
		if(isValidCell(xLeftTop, yLeftTop)) {
			moves.add(new Cell(xLeftTop, yLeftTop));
		}
		
		// left bottom move
		int xLeftBottom = x - 2;
		int yLeftBottom = y + 1;
		if(isValidCell(xLeftBottom, yLeftBottom)) {
			moves.add(new Cell(xLeftBottom, yLeftBottom));
		}
		
		// top left move
		int xTopLeft = x - 1;
		int yTopLeft = y - 2;
		if(isValidCell(xTopLeft, yTopLeft)) {
			moves.add(new Cell(xTopLeft, yTopLeft));
		}
		
		// top right move
		int xTopRight = x + 1;
		int yTopRight = y - 2;
		if(isValidCell(xTopRight, yTopRight)) {
			moves.add(new Cell(xTopRight, yTopRight));
		}
		
		// right top move
		int xRightTop = x + 2;
		int yRightTop = y - 1;
		if(isValidCell(xRightTop, yRightTop)) {
			moves.add(new Cell(xRightTop, yRightTop));
		}
		
		// right bottom move
		int xRightBottom = x + 2;
		int yRightBottom = y + 1;
		if(isValidCell(xRightBottom, yRightBottom)) {
			moves.add(new Cell(xRightBottom, yRightBottom));
		}
		
		// bottom left move
		int xBottomLeft = x - 1;
		int yBottomLeft = y + 2;
		if(isValidCell(xBottomLeft, yBottomLeft)) {
			moves.add(new Cell(xBottomLeft, yBottomLeft));
		}
		
		// bottom right move
		int xBottomRight = x + 1;
		int yBottomRight = y + 2;
		if(isValidCell(xBottomRight, yBottomRight)) {
			moves.add(new Cell(xBottomRight, yBottomRight));
		}
		
		return moves;
	}
	
	private static boolean isValidCell(int x, int y) {
		if(x < 0 || x >= keypad.length || y < 0 || y >= keypad.length) {
			return false;
		}
		
		// As per requirement, 1 and 5 keys cannot be used
		if(keypad[x][y] == 1 || keypad[x][y] == 5) {
			return false;
		}
		
		return true;
	}
	
	public static class Cell {
		private int x;
		private int y;
		
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "[" + this.x + ", " + this.y + "]";
		}
	}

	private static void printAllKeyCombinations(List<String> list) {
		if(list == null) {
			System.out.println("\nNo valid key combinations found!");
			return;
		}
		
		for(String s : list) {
			System.out.print(s + " ");
		}
	}
	
	public static void main(String[] args) {
		int xIndex = 0;
		int yIndex = 1;
		int keyLength = 4;
		
		List<String> keyCombinations = getAllPossibleKeyCombination(xIndex, yIndex, keyLength);
		System.out.println("Here are all key combinations:");
		printAllKeyCombinations(keyCombinations);
	}
}

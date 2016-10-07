package com.prabhash.java.interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Place N Queens in such a way that they don't attack each other on the NxN chess board.
 * 
 * @author Prabhash Rathore
 *
 */
public class NQueenProblem {
	
	public static List<Cell> placeQueens(int[][] grid, int queenCount) {
		if(grid == null) {
			throw new NullPointerException();
		}
		
		if(queenCount > grid.length || queenCount > grid[0].length) {
			System.out.println("Not enough cells on board to place all queens");
			return null;
		}
		
		List<Cell> list = new ArrayList<>();
		boolean result = placeQueensHelper(grid, list, queenCount - 1);
		
		if(!result) {
			return null;
		}
		
		return list;
	}
	
	private static boolean placeQueensHelper(int[][] grid, List<Cell> list, int queenCount) {
		if(queenCount < 0) {
			return true;
		}
		
		for(int row = 0; row < grid.length; row++) {
			if(isValidPosition(grid, row, queenCount)) {
				grid[row][queenCount] = 1;
				Cell cell = new Cell(row, queenCount);
				list.add(cell);
				
				boolean nextQueenPlacementResult = placeQueensHelper(grid, list, queenCount - 1);
				if(nextQueenPlacementResult) {
					return true;
				} else {
					grid[row][queenCount] = 0;
					list.remove(cell);
				}
			}
		}
		
		return false;
	}
	
	private static boolean isValidPosition(int[][] grid, int row, int col) {
		if(grid == null) {
			return false;
		}
		
		if(row < 0 || row >= grid.length || col < 0 || col > grid[0].length) {
			return false;
		}
		
		// check no other queens are available in same row
		for(int i = col + 1; i < grid.length; i++) {
			if(grid[row][i] == 1) {
				return false;
			}
		}
		
		// check no queens are in top right diagonal
		int i = row - 1;
		int j = col + 1;
		while(i >= 0 && j < grid.length) {
			if(grid[i][j] == 1) {
				return false;
			}
			--i;
			++j;
		}
		
		// check no queens are in bottom right diagonal
		int m = row + 1;
		int n = col + 1;
		while(m < grid.length && n < grid.length) {
			if(grid[m][n] == 1) {
				return false;
			}
			++m;
			++n;
		}
		
		return true;
	}
	
	private static void printQueenCells(List<Cell> list) {
		if(list == null) {
			System.out.println("Seems queen placement is not possible");
			return;
		}
		
		int queenID = 7;
		for(Cell cell : list) {
			System.out.println(queenID + " ==> " + cell);
		}
	}
	
	public static class Cell {
		int rowID;
		int colID;
		
		public Cell(int rowID, int colID) {
			this.rowID = rowID;
			this.colID = colID;
		}
		
		@Override
		public String toString() {
			return "(" + this.rowID + "," + this.colID + ")";
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj == null) {
				return false;
			}
			
			if(obj.getClass() != this.getClass()) {
				return false;
			}
			
			Cell c = (Cell) obj;
			if(c.rowID == this.rowID && c.colID == this.colID) {
				return true;
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			int hash = 7;
			hash = hash * 23 + this.rowID + this.colID;
			return hash;
		}
	}

	public static void main(String[] args) {
		final int SIZE = 8;
		final int[][] grid = new int[SIZE][SIZE];
		
		List<Cell> list = placeQueens(grid, SIZE);
		System.out.println("Here are queeen placements:");
		printQueenCells(list);
	}
}

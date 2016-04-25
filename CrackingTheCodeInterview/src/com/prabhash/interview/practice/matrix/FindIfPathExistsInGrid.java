package com.prabhash.interview.practice.matrix;

public class FindIfPathExistsInGrid {
	
	public static boolean doesPathExist(int[][] grid, Coordinate start, Coordinate end) {
		
		if(grid == null || start == null || end == null) {
			throw new IllegalArgumentException();
		}
		
		if(start.row >= grid.length || start.col >= grid[0].length || end.row >= grid.length || end.col >= grid[0].length) {
			throw new IllegalArgumentException();
		}
		
		if(start.equals(end)) {
			return true;
		}
		
		return pathExistsHelper(grid, start.row, start.col, end);
	}
	
	public static boolean pathExistsHelper(int[][] grid, int startRow, int startCol, Coordinate end) {
		
		if(startRow >= grid.length || startCol >= grid[0].length) {
			return false;
		}
		
		if(startRow == end.row && startCol == end.col) {
			return true;
		}
		
		return pathExistsHelper(grid, startRow + 1, startCol, end) || pathExistsHelper(grid, startRow, startCol + 1, end);
	}
	
	public static class Coordinate {
		
		private int row;
		private int col;
		
		public Coordinate(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if(obj == null) {
				return false;
			}
			
			if(obj.getClass() != this.getClass()) {
				return false;
			}
			
			Coordinate coordinate = (Coordinate) obj;
			if(this.row == coordinate.row && this.col == coordinate.col) {
				return true;
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			
			final int prime = 23;
			int hashCode = 3;
			
			hashCode = hashCode * prime + Integer.valueOf(row).hashCode();
			hashCode = hashCode * prime + Integer.valueOf(col).hashCode();
			
			return hashCode;
		}
		
		@Override
		public String toString() {
			return "[" + this.row + ", [" + this.col + "]";
		}
	}

	public static void main(String[] args) {
		
		final int[][] grid = new int[][] {
				{1, 0, 1, 1},
				{0, 1, 1, 0},
				{1, 0, 1, 1}
		};
		
		boolean pathExists = doesPathExist(grid, new Coordinate(0, 0), new Coordinate(grid.length - 1, grid[0].length - 1));
		System.out.println("Path exists between start and end of grid: " + pathExists);
	}
}

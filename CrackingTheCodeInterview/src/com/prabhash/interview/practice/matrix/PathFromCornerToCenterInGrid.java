package com.prabhash.interview.practice.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a square maze containing positive numbers, find all paths from a corner cell (any of the extreme four corners) 
 * to the middle cell. We can move exactly n steps from a cell in 4 directions i.e. North, East, West and South where n is 
 * value of the cell.
 * 
 * @author Prabhash Rathore
 *
 */
public class PathFromCornerToCenterInGrid {

	/**
	 * Find path from top left cell to middle cell if it exists.
	 * 
	 * @param grid
	 * @return
	 */
	public static void findPath(int[][] grid) {
		if(grid == null) {
			return;
		}
		
		Set<Cell> vistedCells = new HashSet<>();
		Cell currentCell = new Cell(0, 0);
		List<Cell> pathList = new ArrayList<>();
		findPathHelper(grid, currentCell, vistedCells, pathList);
	}
	
	public static void findPathHelper(int[][] a, Cell cell, Set<Cell> vistedCells, List<Cell> path) {
	
		if(a == null || cell == null || vistedCells == null) {
			return;
		}
		
		if(!isValidCell(a, cell, vistedCells)) {
			return;
		}
		
		vistedCells.add(cell);
		path.add(cell);
		
		// is it mid cell
		if(cell.x == a.length / 2 && cell.y == a[0].length / 2) {
			printPath(path); // print path if mid cell is located
			vistedCells.remove(cell); // clear vistedCells
			path.remove(cell); // clear path
			return;
		}
		
		int cellValue = a[cell.x][cell.y];
		
		findPathHelper(a, new Cell(cell.x + cellValue, cell.y), vistedCells, path); // top cell
		findPathHelper(a, new Cell(cell.x - cellValue, cell.y), vistedCells, path); // bottom cell
		findPathHelper(a, new Cell(cell.x, cell.y + cellValue), vistedCells, path); // right cell
		findPathHelper(a, new Cell(cell.x, cell.y - cellValue), vistedCells, path); // left cell
		
		// remove cell if it does not lead to mid cell
		vistedCells.remove(cell);
		path.remove(cell);
	}
	
	private static boolean isValidCell(int[][] a, Cell cell, Set<Cell> vistedCells) {
		
		if(a== null || cell == null || vistedCells == null) {
			return false;
		}
		
		if(cell.x < 0 || cell.x >= a.length || cell.y < 0 || cell.y >= a[0].length) {
			return false;
		}
		
		if(vistedCells.contains(cell)) {
			return false;
		}
		return true;
	}
	
	private static void printPath(List<Cell> path) {
		System.out.println("Here is the path:");
		for(Cell cell : path) {
			System.out.print(cell + ", ");
		}
		System.out.print("\n");
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
			return "{" + x + ", " + y + "}";
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj == null) {
				return false;
			}
			if(this.getClass() != obj.getClass()) {
				return false;
			}
			
			Cell cell = (Cell) obj;
			if(this.x == cell.x && this.y == cell.y) {
				return true;
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			int hashCode = 3;
			int primeFactor = 23;
			hashCode = hashCode * primeFactor + this.x;
			hashCode = hashCode * primeFactor + this.y;
			return hashCode;
		}
	}
	
	public static void main(String[] args) {
		
		int[][] maze = new int[][] {
		        { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
		        { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
		        { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
		        { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
		        { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
		        { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
		        { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
		        { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
		        { 6, 2, 4, 3, 4, 5, 4, 5, 1 }
		    };
		
		findPath(maze);
	}
}

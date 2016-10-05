package com.prabhash.java.interview.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Given a grid with countries represented as numbers. Write a method to find the size of perimeter, i.e. number of walls which needs
 * to be built to completely shield country from neighboring countries.
 * 
 * In below 2-D matrix, countries are represented with unique cell value. Cells with same value belong to one specific country.
 * 
 * 2 2 4 5 5 6
 * 2 2 4 4 4 6
 * 2 4 4 4 6 6
 * 2 2 2 4 4 6
 * 2 4 4 4 4 4
 * 
 * @author Prabhash Rathore
 *
 */
public class FindCountryPerimeter {
	
	/**
	 * Recursively calculate all border country vertices. A vertex is at border if it has at least one country next to it. We identify
	 * border vertex by comparing it's id with neighbors. If ids do not match then these vertices belong to same country.
	 * 
	 * To calculate total perimeter, for each border vertex, find the number of neighbor countries around it. Total perimeter is the sum
	 * of perimeter of each border vertex.
	 * 
	 * @param grid
	 * @param country
	 * @return perimeter
	 */
	public static int calculateCountryPerimeter(int[][] grid, Vertex country) {
		if(grid == null || country == null) {
			throw new NullPointerException();
		}
		
		List<Vertex> borderVertices = new ArrayList<>();
		Set<Vertex> vistedSet = new HashSet<>();
		calculateCountryPerimeterHelper(grid, country, vistedSet, borderVertices);
		
		int perimeter = 0;
		Iterator<Vertex> iterator = borderVertices.iterator();
		while(iterator.hasNext()) {
			Vertex vertex = iterator.next();
			System.out.println("Border Vertex => " + vertex);
			perimeter += getNeighborForeignCountryCount(grid, vertex); 
		}
		return perimeter;
	}
	
	private static void calculateCountryPerimeterHelper(int[][] grid, Vertex vertex, Set<Vertex> vistedSet, List<Vertex> borderVertices) {
		if(vertex == null) {
			return;
		}
		
		vistedSet.add(vertex);
		
		// is vertex a border vertex? Border vertex must have at least one foreign country next to it
		if(getNeighborForeignCountryCount(grid, vertex) > 0) {
			borderVertices.add(vertex);
		}
		
		List<Vertex> neighbors = getNeighborsWithSameCountryID(grid, vertex);
		for(Vertex v : neighbors) {
			if(!vistedSet.contains(v)) {
				calculateCountryPerimeterHelper(grid, v, vistedSet, borderVertices);
			}
		}
	}
	
	private static int getNeighborForeignCountryCount(int[][] grid, Vertex v) {
		if(v == null) {
			return 0;
		}
		
		int neightborCountryCount = 0;
		int row = v.row;
		int col = v.col;
		int countryID = v.countryID;
		
		// left neighbor
		if(isValidCell(grid, row, col - 1) && grid[row][col - 1] != countryID) {
			++neightborCountryCount;
		}
		
		// right neighbor
		if(isValidCell(grid, row, col + 1) && grid[row][col + 1] != countryID) {
			++neightborCountryCount;
		}
		
		// top neighbor
		if (isValidCell(grid, row - 1, col) && grid[row - 1][col] != countryID) {
			++neightborCountryCount;
		}

		// bottom neighbor
		if (isValidCell(grid, row + 1, col) && grid[row + 1][col] != countryID) {
			++neightborCountryCount;
		}
		
		return neightborCountryCount;
	}
	
	private static List<Vertex> getNeighborsWithSameCountryID(int[][] grid, Vertex v) {
		if(v == null) {
			return null;
		}
		
		List<Vertex> neighbors = new ArrayList<>();
		int row = v.row;
		int col = v.col;
		int countryID = v.countryID;
		
		// left neighbor
		if(isValidCell(grid, row, col - 1) && grid[row][col - 1] == countryID) {
			neighbors.add(new Vertex(row, col - 1, countryID));
		}
		
		// right neighbor
		if(isValidCell(grid, row, col + 1) && grid[row][col + 1] == countryID) {
			neighbors.add(new Vertex(row, col + 1, countryID));
		}
		
		// top neighbor
		if (isValidCell(grid, row - 1, col) && grid[row - 1][col] == countryID) {
			neighbors.add(new Vertex(row - 1, col, countryID));
		}

		// bottom neighbor
		if (isValidCell(grid, row + 1, col) && grid[row + 1][col] == countryID) {
			neighbors.add(new Vertex(row + 1, col, countryID));
		}
		
		return neighbors;
	}
	
	private static boolean isValidCell(int[][] grid, int row, int col) {
		// check bounds
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
			return false;
		}
		
		return true;
	}
	
	public static class Vertex {
		private int row, col;
		private int countryID;
		
		public Vertex(int row, int col, int countryID) {
			this.row = row;
			this.col = col;
			this.countryID = countryID;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj == null) {
				return false;
			}
			
			if(obj.getClass() != this.getClass()) {
				return false;
			}
			
			Vertex v = (Vertex) obj;
			if(this.col == v.col && this.row == v.row) {
				return true;
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			int hash = 7;
			hash = (hash * 23) + this.row + this.col + this.countryID;
			return hash;
		}
		
		@Override
		public String toString() {
			return "row: " + this.row + " col: " + this.col + " countryID: " + this.countryID;
		}
	}

	public static void main(String[] args) {
		// country is represented by cell value. Cell with same value is part of same country
		final int[][] countryGrid = new int[][] {
				{2, 2, 4, 5, 5, 6},
				{2, 2, 4, 4, 4, 6},
				{2, 4, 4, 4, 6, 6},
				{2, 2, 2, 4, 4, 6},
				{2, 4, 4, 4, 4, 4}
		};
		
		int countryRow = 0;
		int countryCol = 5;
		Vertex country = new Vertex(countryRow,  countryCol, countryGrid[countryRow][countryCol]);
		
		int perimeterSize = calculateCountryPerimeter(countryGrid, country);
		System.out.println("Perimeter = " + perimeterSize);
	}
}

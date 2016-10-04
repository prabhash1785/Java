package com.prabhash.java.interview.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a grid with countries represented as numbers. Write a method to find the size of perimeter.
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
	
	public static int calculateCountryPerimeter(Vertex[][] grid, Vertex country) {
		if(grid == null || country == null) {
			throw new NullPointerException();
		}
		
		Set<Vertex> vistedSet = new HashSet<>();
		return calculateCountryPerimeterHelper(grid, country, vistedSet);
	}
	
	private static int calculateCountryPerimeterHelper(Vertex[][] grid, Vertex vertex, Set<Vertex> vistedSet) {
		if(vertex == null) {
			return 0;
		}
		
		List<Vertex> neighbors = getNeighbors(vertex);
	}
	
	private static List<Vertex> getNeighbors(Vertex v) {
		if(v == null) {
			return null;
		}
		
		List<Vertex> neighbors = new ArrayList<>();
		
		return neighbors;
	}
	
	public static class Vertex {
		private int row, col;
		private int countryID;
		
		public Vertex(int row, int col) {
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
		// TODO Auto-generated method stub

	}

}

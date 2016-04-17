package com.prabhash.interview.practice.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Search a Word in a 2D Grid of characters Given a 2D grid of characters and a
 * word, find all occurrences of given word in grid. A word can be matched in
 * all 8 directions at any point. Word is said be found in a direction if all
 * characters match in this direction (not in zig-zag form).
 * 
 * The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up
 * and 4 Diagonal directions.
 * 
 * @question-ref http://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters
 *               
 * @author prrathore
 *
 */
public class FindWordInGrid {

	/**
	 * At every position in the Grid, continue to check subsequent characters in
	 * grid and given word to find a match. This comparison will be done in 8
	 * directions (left, right, top, bottom and four diagonals from that
	 * position in grid). If no match found then move to next position in grid
	 * and repeat the same comparison process. If a match is found, store that
	 * position in a list.
	 * 
	 * Time Complexity: O(MNL) where, M - Row length N - Col length L - word
	 * length to be searched
	 */
	public static List<Coordinate> findWordsInGrid(char[][] grid, String word) {

		if (grid == null || word == null) {
			throw new NullPointerException();
		}

		List<Coordinate> list = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (wordMatchFound(grid, word, i, j)) {
					list.add(new Coordinate(i, j));
				}
			}
		}

		return list;
	}

	private static boolean wordMatchFound(final char[][] grid,
			final String word, int i, int j) {

		// optimization - do not continue to compare all directions as soon as
		// first char does not match
		if (grid[i][j] != word.charAt(0)) {
			return false;
		}

		// right
		int x = i, y = j, z = 0;
		while (x < grid.length && y < grid[0].length && z < word.length()
				&& grid[x][y] == word.charAt(z)) {
			y++;
			z++;
		}
		if (z == word.length()) {
			return true;
		}

		// left
		x = i;
		y = j;
		z = 0;
		while (x < grid.length && y >= 0 && y < grid[0].length
				&& z < word.length() && grid[x][y] == word.charAt(z)) {
			y--;
			z++;
		}

		if (z == word.length()) {
			return true;
		}

		// top
		x = i;
		y = j;
		z = 0;
		while (x >= 0 && x < grid.length && y < grid[0].length
				&& z < word.length() && grid[x][y] == word.charAt(z)) {
			x--;
			z++;
		}

		if (z == word.length()) {
			return true;
		}

		// bottom
		x = i;
		y = j;
		z = 0;
		while (x < grid.length && y < grid[0].length && z < word.length()
				&& grid[x][y] == word.charAt(z)) {
			x++;
			z++;
		}

		if (z == word.length()) {
			return true;
		}

		// 4 diagonals
		x = i;
		y = j;
		z = 0;
		while (x < grid.length && y < grid[0].length && z < word.length()
				&& grid[x][y] == word.charAt(z)) {
			x++;
			y++;
			z++;
		}

		if (z == word.length()) {
			return true;
		}

		x = i;
		y = j;
		z = 0;
		while (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
				&& z < word.length() && grid[x][y] == word.charAt(z)) {
			x--;
			y--;
			z++;
		}

		if (z == word.length()) {
			return true;
		}

		x = i;
		y = j;
		z = 0;
		while (x < grid.length && y >= 0 && y < grid[0].length
				&& z < word.length() && grid[x][y] == word.charAt(z)) {
			x++;
			y--;
			z++;
		}

		if (z == word.length()) {
			return true;
		}

		x = i;
		y = j;
		z = 0;
		while (x >= 0 && x < grid.length && y < grid[0].length
				&& z < word.length() && grid[x][y] == word.charAt(z)) {
			x--;
			y++;
			z++;
		}

		if (z == word.length()) {
			return true;
		}

		return false;
	}

	private static class Coordinate {

		private int x;
		private int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "{" + this.x + ", " + this.y + "}";
		}
	}

	public static void main(String[] args) {

		final char[][] grid = new char[][] {
				{ 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K',
						'S' },
				{ 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E',
						'K' },
				{ 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C',
						'E' } };
		final String word = "EEE";

		List<Coordinate> list = findWordsInGrid(grid, word);

		System.out.println("Here are matching word coordinates:");
		for (Coordinate c : list) {
			System.out.println(c);
		}
	}
}
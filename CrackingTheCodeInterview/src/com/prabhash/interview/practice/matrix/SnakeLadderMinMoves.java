package com.prabhash.interview.practice.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadderMinMoves {

	private static class Box {

		int cellNumber;
		int distanceFromFirstCell;

		public Box() {

		}

		public Box(int cellNumber, int distanceFromFirstCell) {
			this.cellNumber = cellNumber;
			this.distanceFromFirstCell = distanceFromFirstCell;
		}

	}

	public static int getMinDistance(int[] move, int n) {

		boolean[] visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			visited[i] = false;
		}

		Queue<Box> queue = new LinkedList<Box>();

		queue.add(new Box(0, 0));
		visited[0] = true;

		Box c = new Box();
		
		while(queue.peek() != null) {

			c = queue.peek();

			if(c.cellNumber == n-1) {
				break; // made it to home
			}

			c = queue.remove();
			int vertex = c.cellNumber;

			for(int j = vertex + 1; j <= (vertex + 6) && j < n; j++) {

				// if those cell is not visited
				if(!visited[j]) {

					Box b = new Box();
					b.distanceFromFirstCell = c.distanceFromFirstCell + 1;
					visited[j] = true;

					// Check if there a snake or ladder at 'j'
	                // then tail of snake or top of ladder
	                // become the adjacent of 'i'
	                if (move[j] != -1)
	                    b.cellNumber = move[j];
	                else
	                    b.cellNumber = j;

	                queue.add(b);


				}


			}

		}

		return c.distanceFromFirstCell;

	}
	


	public static void main(String[] args) {

		int n = 30; //total number of cells on board
		int[] moves = new int[30]; //move pointers

		// if moves object does not have any snake or ladder then it's value is -1
		for(int i = 0; i < n ; i++) {
			moves[i] = -1;
		}

		// Ladders
	    moves[2] = 21;
	    moves[4] = 7;
	    moves[10] = 25;
	    moves[19] = 28;

	    // Snakes
	    moves[26] = 0;
	    moves[20] = 8;
	    moves[16] = 3;
	    moves[18] = 6;

	    int numberOfMoves = getMinDistance(moves, n);
	    System.out.print("Minimum number of moves: " + numberOfMoves);
 
	}

}
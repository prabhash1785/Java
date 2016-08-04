package com.prabhash.java.interview.ch4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Find a number in minimum steps
 * Given an infinite number line from -INFINITY to +INFINITY and we are on zero. We can move n steps either side at each n’th time.
 * 
 * 1st time; we can move only 1 step to both ways, means -1 1;
 * 
 * 2nd time we can move 2 steps  from -1 and 1
 * -1 :  -3 (-1-2)  1(-1+2)
 * 1 :  -1 ( 1-2)  3(1+2)
 * 
 * 3rd time we can move 3 steps either way from -3, 1, -1, 3
 * -3:  -6(-3-3) 0(-3+3)
 * 1:   -2(1-3)   4(1+3)
 * -1:  -4(-1-3)  2(-1+3)
 * 3:     0(0-3)   6(3+3) 
 * 
 * Find the minimum number of steps to reach a given number n. 
 * 
 * Examples:
 * 
 * Input : n = 10
 * Output : 4
 * We can reach 10 in 4 steps,  1, 3, 6, 10 
 * 
 * Input : n = 13
 * Output : 5
 * We can reach 10 in 4 steps,  -1, 2, 5, 9, 14
 * 
 * Ref: http://www.geeksforgeeks.org/find-a-number-in-minimum-steps/
 * 
 * @author Prabhash Rathore
 *
 */
public class FindNumberInMinSteps {
	
	/**
	 * The pattern of adding n step at nth level will generate a pattern just like Binary Tree. So finding the given number in minimum
	 * step reduces down to BFS Tree Traversal Algorithm.
	 * 
	 * @param n
	 * @return level
	 */
	public static int findNumInMinSteps(int n) {
		if(n == 0) {
			return 0;
		}
		
		int start = 0, level = 1;
		Deque<Integer> queue = new LinkedList<>();
		Deque<Integer> nextLevel = new LinkedList<>();
		
		queue.addLast(start);
		while(!queue.isEmpty()) {
			int num = queue.removeFirst();
			System.out.print(num + " ");
			if(num == n) {
				return level - 1; // level - 1 so that we don't count root level in final outcome
			}
			nextLevel.addLast(num - level);
			nextLevel.addLast(num + level);
			
			if(queue.isEmpty()) {
				queue = nextLevel;
				nextLevel = new LinkedList<>();
				++level;
				System.out.print("\n");
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int n = 10;
		int step = findNumInMinSteps(n);
		System.out.println("\n" + n + " is found in steps: " + step);
	}
}

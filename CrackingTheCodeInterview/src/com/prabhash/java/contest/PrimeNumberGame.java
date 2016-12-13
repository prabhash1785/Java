package com.prabhash.java.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Alice and Bob invented the following silly game:
 * 
 * The game starts with an integer, n, that's used to build a of distinct
 * integers in the inclusive range from to (i.e., 1 t0 n). Alice always plays first,
 * and the two players move in alternating turns. During each move, the current
 * player chooses a prime number, p, from set. The player then removes and all of
 * its multiples from set. The first player to be unable to make a move loses the
 * game. Alice and Bob play games. Given the value of for each game, print the
 * name of the game's winner on a new line. If Alice wins, print Alice;
 * otherwise, print Bob.
 * 
 * Note: Each player always plays optimally, meaning they will not make a move
 * that causes them to lose the game if some better, winning move exists.
 * 
 * Input Format
 * 
 * The first line contains an integer, g, denoting the number of games Alice and
 * Bob play. Each line of the subsequent lines contains a single integer, n,
 * describing a game.
 * 
 * Constraints
 * 1 <= g <= 1000
 * 1 <= n <= 10 ^ 5
 * 
 * For each game, print the name of the winner on a new line. If Alice wins,
 * print Alice; otherwise, print Bob.
 * 
 * Sample Input 0
 * 
 * 3
 * 1 
 * 2 
 * 5 
 * 
 * Sample Output 0
 * Bob 
 * Alice 
 * Alice 
 * 
 * Explanation 0
 * 
 * Alice and Bob play the following games:
 * 
 * We are given , so . Because Alice has no valid moves (there are no prime
 * numbers in the set), she loses the game. Thus, we print Bob on a new line. We
 * are given , so . Alice chooses the prime number and deletes it from the set,
 * which becomes . Because Bob has no valid moves (there are no prime numbers in
 * the set), he loses the game. Thus, we print Alice on a new line. We are given
 * , so . Alice chooses the prime number and deletes the numbers and from the
 * set, which becomes . Now there are two primes left, and . Bob can remove
 * either prime from the set, and then Alice can remove the remaining prime.
 * Because Bob is left without a final move, Alice will always win. Thus, we
 * print Alice on a new line.
 * 
 * @author Prabhash Rathore
 *
 */
public class PrimeNumberGame {
	
	/**
	 * One way to implement this is Brute Force algorithm where you do linear scan on your number set to look for primes. Unfortunately
	 * this technique does not scale for large inputs.
	 * 
	 * Optimized Method: Using Sieve algorithm, find all the primes upto n. This can be done in O(log log n) time. After that depending
	 * upon size of primes number list, determine the winner.
	 * 
	 * Time Complexity: O(log logn n) 
	 * 
	 * @param n
	 * @return String - winner of game
	 */
	public static String findWinnerInTheGameOfPrimes(int n) {
		if(n < 2) {
			return "Bob"; // For n < 2, since there is no Prime so Bob wins
		}
		
		List<Integer> allPrimes = findAllPrimesUptoNUsingSieve(n);
		if(allPrimes.size() % 2 == 0) {
			return "Bob";
		} else {
			return "Alice";
		}
	}
	
	/**
	 * Get all primes upto n using Sieve Algorithm
	 * 
	 * Time Complexity: O(n log log n)
	 * 
	 * @param n
	 * @return primes
	 */
	private static List<Integer> findAllPrimesUptoNUsingSieve(int n) {
		List<Integer> primes = new ArrayList<>();
		if(n < 2) {
			return primes;
		}
		
		// save first n numbers in an array with boolean values as true
		boolean[] array = new boolean[n + 1];
		for(int i = 0; i <= n; i++) {
			array[i] = true;
		}
		
		int limit = (int) Math.sqrt(n);
		
		int firstPrime = 2;
		int squareOfFirstPrime = (int) Math.pow(firstPrime, 2);
		
		while(squareOfFirstPrime <= n) {
			for(int i = 2; firstPrime * i <= n; i++) {
				array[firstPrime * i] = false; // mark numbers as composite
			}
			
			// find next possible unmarked prime
			firstPrime = firstPrime  + 1;
			while(firstPrime <= limit && !array[firstPrime]) {
				++firstPrime;
			}
			
			squareOfFirstPrime = (int) Math.pow(firstPrime, 2); 
		}
		
		// finally add all unmarked numbers as prime in the list
		for(int i = 2; i <= n; i++) {
			if(array[i]) {
				primes.add(i);
			}
		}
		return primes;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		int[] a = new int[g];
		for (int a0 = 0; a0 < g; a0++) {
			int n = in.nextInt();
			a[a0] = n;
		}
		
		in.close();

		for (int i = 0; i < a.length; i++) {
			int n = a[i];
			
			String winner = findWinnerInTheGameOfPrimes(n);
			System.out.println(winner);
		}
	}
}

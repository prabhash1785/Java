package com.prabhash.java.interview.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * Find first n Primes using Sieve method.
 * 
 * @author Prabhash Rathore
 *
 */
public class FindAllPrimesUsingSieveTechnique {
	
	/**
	 * Find all primes until given number n using linear scan.
	 * 
	 * Time Complexity: O(n ^ (3/2))
	 * 
	 * @param n
	 * @return primes
	 */
	public static List<Integer> primeNumbersUsingLinearScan(int n) {
		List<Integer> primes = new ArrayList<>();
		if(n <= 1) {
			return primes;
		}
		
		for(int i = 2; i <= n; i++) {
			if(isPrime(i)) {
				primes.add(i);
			}
		}
		
		return primes;
	}
	
	/**
	 * Find all primes upto N using Sieve Method.
	 * 
	 * Time Complexity: O(n log logn)
	 * 
	 * @param n
	 * @return primes
	 */
	public static List<Integer> findAllPrimesUptoNUsingSieve(int n) {
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
	
	/**
	 * Prime test of a number. As an optimization, we only need to test for divisors until the square root of given number.
	 * 
	 * Time Complexity: O(n ^ (1/2))
	 * 
	 * @param n
	 * @return boolean
	 */
	public static boolean isPrime(int n) {		
		int limit = (int) Math.sqrt(n);
		for(int i = 2; i <= limit; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// Prime test
		System.out.println("Is 2 prime: " + isPrime(2));
		System.out.println("Is 3 prime: " + isPrime(3));
		System.out.println("Is 4 prime: " + isPrime(4));
		System.out.println("Is 5 prime: " + isPrime(5));
		System.out.println("Is 12 prime: " + isPrime(12));
		System.out.println("Is 23 prime: " + isPrime(23));
		System.out.println("Is 49 prime: " + isPrime(49));
		
		// get first n primes numbers
		List<Integer> primes = primeNumbersUsingLinearScan(20);
		System.out.println("First primes using linear scan until 20:");
		for(Integer i : primes) {
			System.out.print(i + " ");
		}
		
		List<Integer> primes2 = primeNumbersUsingLinearScan(100);
		System.out.println("\nFirst primes using linear scan until 100:");
		for(Integer i : primes2) {
			System.out.print(i + " ");
		}
		
		//Sieve Prime Method test
		List<Integer> sievePrimes1 = findAllPrimesUptoNUsingSieve(20);
		System.out.println("\nFirst primes using sieve method until 20:");
		for(Integer i : sievePrimes1) {
			System.out.print(i + " ");
		}
		
		List<Integer> sievePrimes2 = findAllPrimesUptoNUsingSieve(100);
		System.out.println("\nFirst primes using sieve method until 100:");
		for(Integer i : sievePrimes2) {
			System.out.print(i + " ");
		}
	}
}

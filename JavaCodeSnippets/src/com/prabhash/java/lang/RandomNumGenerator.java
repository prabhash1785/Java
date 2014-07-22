package com.prabhash.java.lang;

/*
 * Program to generate random numbers using Java API: java.util.Random, java.util.concurrent.ThreadLocalRandom and Math.random()
 * java.util.random by default generates random numbers from -2^31 to 2^31 which consists both positive and negative numbers.
 * Ref: http://javarevisited.blogspot.com/2013/05/how-to-generate-random-numbers-in-java-between-range.html
 * 
 */
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumGenerator {

	private static int[] list;
	private static int n = 10;
	
		
	/*
	 * Method to generate random numbers using java.util.Random class
	 * This is thread safe method.
	 */ 
	public static int[] generateRandomNums(int n) {
		int[] list = new int[n];
		Random r = new Random();
		for(int i=1; i<n; i++) {
			list[i] = r.nextInt(100); //this will generate random numbers between 0 and 99 (excluding 100)
		}
		return list;
		
	}
	
	/*
	 * Method to generate random numbers using ThreadLocalRandom class. This is not thread safe.
	 */
	public static int[] generateRandomNumsForEachThread(int n) {
		int[] b = new int[n];
		
		for(int i = 0; i < n; i++) {
			b[i] = ThreadLocalRandom.current().nextInt(5, 500); // 5 is lower bound inclusive, 100 is upper bound exclusive
		}		
		
		return b;
	}
	
	/*
	 * this method generate Random numbers using Math.random()
	 * Math.random() generate floating random numbers from 0.0 to 1.0. This is thread safe method.
	 * To convert this to int, cast it by int and multiply by 10 or 100 or 1000.. for the appropriate range.
	 */
	public static int[] generateRandomNumbers(int n) {
		int[] a = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = (int) (10 * Math.random()); //Cast to int to convert from float to int and multiply by 100 to get a range of 100
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		
		list = generateRandomNums(n);
		System.out.println("Here are Randomly Generated Numbers using java.util.Random class: ");
		for(int i = 0;i < n; i++)
			System.out.println(list[i]);
		
		list = generateRandomNumbers(n);
		System.out.println("\nHere are Randomly Generated Numbers using Math.random() utility method: ");
		for(int j = 0;j < n; j++)
			System.out.println(list[j]);
		
		list = generateRandomNumsForEachThread(n);
		System.out.println("\nHere are Randomly Generated Numbers for each thread: ");
		for(int k = 0;k < n; k++)
			System.out.println(list[k]);
	}

}

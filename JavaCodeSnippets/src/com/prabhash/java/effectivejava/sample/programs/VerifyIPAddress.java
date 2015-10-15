/*
 * The Internet runs on web addresses.The addresses we type represent the IP address 
 * for each site and how the computer finds an individual web page.
 *
 * IP addresses are made up of four numbers, each between 0 and 255 separated by a period. 
 * For example, 128.253.21.58 is an IP address.
 * 
 * Write a program to enter four numbers and test if they make up a valid IP address.
 * In other words, test to see if the numbers entered are between 0 and 255 inclusive.
 * 
 *     Sample Run 1
 *         Please enter the first octet:
 *         898
 *         Please enter the second octet:
 *         34
 *         Please enter the third octet:
 *         712
 *         Please enter the fourth octet:
 *         45
 *         Octet 1 is incorrect
 *         Octet 3 is incorrect
 * 
 *         
 *      Sample Run 2
 *         Please enter the first octet:
 *         112
 *         Please enter the second octet:
 *         200
 *         Please enter the third octet:
 *         0
 *         Please enter the fourth octet:
 *         254
 *         IP Address: 112.200.0.254
 * 
 */

package com.prabhash.java.effectivejava.sample.programs;

import java.util.Scanner;

public class VerifyIPAddress {

	private static boolean verifyOctets(int l, int m, int n, int o) {

		boolean isOctetValid = true; // keep track of incorrect octet using a boolean flag

		if(l < 0 || l > 255) {
			isOctetValid = false;
			System.out.println("Octet 1 is incorrect");
		}

		if(m < 0 || m > 255) {
			isOctetValid = false;
			System.out.println("Octet 2 is incorrect");
		}

		if(n < 0 || n > 255) {
			isOctetValid = false;
			System.out.println("Octet 3 is incorrect");
		}

		if(o < 0 || o > 255) {
			isOctetValid = false;
			System.out.println("Octet 4 is incorrect");
		}

		return isOctetValid;

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter the first octet:");
		int firstOctet = scan.nextInt();

		System.out.println("Please enter the second octet:");
		int secondOctet = scan.nextInt();

		System.out.println("Please enter the third octet:");
		int thirdOctet = scan.nextInt();

		System.out.println("Please enter the fourth octet:");
		int fourthOctet = scan.nextInt();

		scan.close(); // close scanner to prevent resource leakage

		boolean areOctetsValid = verifyOctets(firstOctet, secondOctet, thirdOctet, fourthOctet);

		if(areOctetsValid) {
			System.out.println("IP Address: " + firstOctet + "." + secondOctet + "." + thirdOctet + "." + fourthOctet);
		}
		
	}

}
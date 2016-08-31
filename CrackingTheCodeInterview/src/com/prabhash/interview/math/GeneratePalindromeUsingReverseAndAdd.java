package com.prabhash.interview.math;

/**
 * The reverse and add function starts with a number, reverses its digits, and
 * adds the reverse to the original. If the sum is not a palindrome, repeat this
 * procedure until it does.
 * 
 * If it took more than 1,000 iterations (additions) or yield a palindrome that
 * is greater than 4,294,967,295, assume that no palindrome exist for the given
 * number.
 * 
 * Examples: Input : 195 Output : 9339
 * 
 * Input : 265 Output: 45254
 * 
 * Input : 196 Output : No palindrome exist
 * 
 * @author Prabhash Rathore
 *
 */
public class GeneratePalindromeUsingReverseAndAdd {

	public static void reverseAndAdd(int n) {
		System.out.println("Input: " + n);
		int iteration = 0;
		if (n <= 0 || n > Integer.MAX_VALUE) {
			System.out.println("No palindrome exist");
		}

		while(iteration <= 1000 && n <= Integer.MAX_VALUE) {
			int reverse = reverse(n);
			
			if(n == reverse) {
				System.out.println("Palindrome found: " + n);
				return;
			}
			
			n += reverse;

			++iteration;
		}

		System.out.println("No palindrome exist");
	}

	private static int reverse(int n) {
		int reverse = 0;
		int original = n;
		while (original > 0) {
			int rem = original % 10;

			reverse = (reverse * 10) + rem;

			original = original / 10;
		}

		return reverse;
	}

	public static void main(String[] args) {
		int n = 195;
		reverseAndAdd(n);
		
		reverseAndAdd(265);
		
		reverseAndAdd(196);
	}

}

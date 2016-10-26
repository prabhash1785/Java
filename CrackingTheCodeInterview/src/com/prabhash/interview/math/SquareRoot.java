package com.prabhash.interview.math;

/**
 * Calculate square root of a number using only multiplication and division.
 * 
 * @author Prabhash Rathore
 *
 */
public class SquareRoot {
	
	/**
	 * Calculates square root of a number to the given amount of precision for floating point numbers.
	 * 
	 * For numbers < 0, this method will return an imaginary number, i.e. (square root * i) where i is sqrt(-1). Since we can't add "i" to
	 * double data type so we will rather return (-1) * sqrt. 
	 * 
	 * For numbers n where 0 < n < 1, the square root of number actually increases instead of decrease so we will first calculate,
	 * square root of 1/n and then return output as inverse of square root.
	 * 
	 * For numbers >= 1, square root will be calculated by using Binary Search.
	 * 
	 * Time Complexity: O(logn / precision) as lower precision will take more time calculate square root results.
	 * 
	 * @param num
	 * @param precision
	 * @return double
	 */
	public static double calculateSquareRoot(double num, double precision) {
		boolean isNegativeNum = false;
		if(num < 0) {
			isNegativeNum = true;
			num = (-1) * num;
		}
		
		double sqrt = 0;
		if(num > 0 && num < 1) {
			double inverseOfNum = 1 / num;
			double inverseSquareRoot = getsquareRootHelper(inverseOfNum, 0, inverseOfNum, precision);
			sqrt = 1 / inverseSquareRoot;
		} else {
			sqrt = getsquareRootHelper(num, 1, num, precision);
		}
		
		if(isNegativeNum) {
			sqrt = (-1) * sqrt;
		}
		
		return sqrt;
	}
	
	private static double getsquareRootHelper(double num, double low, double high, double precision) {
		double mid = 0;
		while(low < high && high - low > precision) {
			mid = low + (high - low) / 2;
			
			double square = mid * mid;
			if(square == num) {
				return mid;
			} else if(square < num) {
				low = mid;
			} else {
				high = mid;
			}
		}
		
		return mid;
	}

	public static void main(String[] args) {
		double num1 = 25;
		System.out.println("Square root of " + num1 + ": " + calculateSquareRoot(num1, 0.0));
		
		num1 = 81;
		System.out.println("Square root of " + num1 + ": " + calculateSquareRoot(num1, 0.0));
		
		num1 = 36.5;
		System.out.println("Square root of " + num1 + ": " + calculateSquareRoot(num1, 0.0)); // smaller epsilon gives high precision results
		
		num1 = 36.5;
		System.out.println("Square root of " + num1 + ": " + calculateSquareRoot(num1, 0.1)); // higher epsilon given low precision results
		
		num1 = 1.5;
		System.out.println("Square root of " + num1 + ": " + calculateSquareRoot(num1, 0.001));
		
		num1 = 0.5;
		System.out.println("Square root of " + num1 + ": " + calculateSquareRoot(num1, 0.001));
		
		num1 = 0.25;
		System.out.println("Square root of " + num1 + ": " + calculateSquareRoot(num1, 0.0));
		
		num1 = -16;
		System.out.println("Square root of " + num1 + ": " + calculateSquareRoot(num1, 0.0));
		
		num1 = -0.5;
		System.out.println("Square root of " + num1 + ": " + calculateSquareRoot(num1, 0.001));
	}
}

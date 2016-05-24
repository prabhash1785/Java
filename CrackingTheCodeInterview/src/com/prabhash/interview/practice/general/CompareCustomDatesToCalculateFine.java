package com.prabhash.interview.practice.general;

import java.util.Scanner;

/**
 * Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:
 * 
 * If the book is returned on or before the expected return date, no fine will be charged (i.e.: .
 * If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, .
 * If the book is returned after the expected return month but still within the same calendar year as the expected return date, the .
 * If the book is returned after the calendar year in which it was expected, there is a fixed fine of .
 * 
 * Input Format
 * The first line contains  space-separated integers denoting the respective , , and  on which the book was actually returned. 
 * The second line contains  space-separated integers denoting the respective , , and  on which the book was expected to be returned (due date).
 *  
 * Output Format
 * 
 * Print a single integer denoting the library fine for the book received as input.
 * 
 * @author prrathore
 *
 */
public class CompareCustomDatesToCalculateFine {
    
    public static class Date {
        
        private int day;
        private int month;
        private int year;
        
        public Date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    
    public static int calculateFine(final Date actualDate, final Date expectedDate) {
        
        if(actualDate.year > expectedDate.year) {
            return 10000;
        } else if(actualDate.year == expectedDate.year) {
            if(actualDate.month > expectedDate.month) {
                return 500 * (actualDate.month - expectedDate.month);
            } else if(actualDate.month == expectedDate.month) {
                if(actualDate.day > expectedDate.day) {
                    return 15 * (actualDate.day - expectedDate.day);
                }
            }
        }
        
        return 0;
    }

    public static void main(String[] args) {
           	
    	System.out.println("Enter actual and expected date in two different lines:");
    	Scanner scanner = new Scanner(System.in);
    	Date actualDate = null;
    	Date expectedDate = null;
    	if(scanner.hasNextLine()) {
    		String input = scanner.nextLine();
    		String[] tokenizedWords = input.split("\\s+");
    		actualDate = new Date(Integer.valueOf(tokenizedWords[0]), 
    				Integer.valueOf(tokenizedWords[1]), Integer.valueOf(tokenizedWords[2]));
    	}
    	
    	if(scanner.hasNextLine()) {
    		String input = scanner.nextLine();
    		String[] tokenizedWords = input.split("\\s+");
    		expectedDate = new Date(Integer.valueOf(tokenizedWords[0]), 
    				Integer.valueOf(tokenizedWords[1]), Integer.valueOf(tokenizedWords[2]));
    	}
    	
    	scanner.close();
       
        int fine = calculateFine(actualDate, expectedDate);
        System.out.println(fine);
    }
}

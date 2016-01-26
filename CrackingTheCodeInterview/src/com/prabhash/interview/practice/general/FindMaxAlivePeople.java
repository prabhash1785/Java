package com.prabhash.interview.practice.general;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Find the maximum number of alive people in a year given a list of people with their birth dates and death dates.
 * 
 * @author Prabhash Rathore
 *
 */
public class FindMaxAlivePeople {
	
	private static final int START_YEAR;
	private static final int END_YEAR;
	private static final List<Person> list;
	
	// initialize all these static data when class is being initialized by JVM
	static {
		START_YEAR = 1900;
		END_YEAR = 2000;
		
		list = new ArrayList<>();
		list.add(new Person(1900, 1985));
		list.add(new Person(1910, 1965));
		list.add(new Person(1900, 1999));
		list.add(new Person(1924, 1948));
		list.add(new Person(1975, 1993));
		list.add(new Person(1920, 1922));
		list.add(new Person(1901, 1987));
		list.add(new Person(1955, 1981));
		list.add(new Person(1932, 1976));
		list.add(new Person(1901, 1991));
	}
	
	private static class Person {
		
		private int birthDate;
		private int deathDate;
		
		public Person() {
			this(0, 0);
		}
		
		public Person(int birthDate, int deathDate) {
			this.birthDate = birthDate;
			this.deathDate = deathDate;
		}
	}
	
	/**
	 * Time Complexity: O(mn) where m is number of years and n is number of persons
	 * Space Complexity: O(1)
	 * 
	 * @param yearStart
	 * @param yearEnd
	 * @param list
	 * @return
	 */
	public static int findYearWithMostPeopleAlive(int yearStart, int yearEnd, final List<Person> list) {
		
		if(yearStart > yearEnd) {
			throw new InvalidParameterException("Start year cannot be greate than end year");
		}

		int yearWithMostPeople = -1;
		int maxPeople = -1;

		for(int i = yearStart; i <= yearEnd; i++) {

			int numberOfPeopleInCurrentYear = 0;
			
			for(Person p : list) {

				if(p.birthDate <= i && p.deathDate >= i) {
					numberOfPeopleInCurrentYear++;
				}

			}

			if(numberOfPeopleInCurrentYear > maxPeople) {
				maxPeople = numberOfPeopleInCurrentYear;
				yearWithMostPeople = i;
			}

		}

		return yearWithMostPeople;

	}

	public static void main(String[] args) {
		
		int yearWithMaxAlivePeople = findYearWithMostPeopleAlive(START_YEAR, END_YEAR, list);
		
		System.out.println("Year with most people alive: " + yearWithMaxAlivePeople);

	}

}

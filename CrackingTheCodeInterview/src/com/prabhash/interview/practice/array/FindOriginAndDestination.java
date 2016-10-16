package com.prabhash.interview.practice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Given a list of tuples which represents origin city and destination city. From this random list of tuples, find the origin and final
 * destination cities.
 * 
 * @author Prabhash Rathore
 *
 */
public class FindOriginAndDestination {
	
	/**
	 * In order to find origin and final destination cities from shuffled list of city pairs, create a map of city name and marker to 
	 * represent if city is origin or destination. Iterate through list of city pairs and add it to map if this city does not exist along
	 * with it's marker if it is origin or destination. If a city already exists in map then remove it since final origin and destination
	 * must have one value in list and other intermediate cities will have two values. 
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param list
	 * @return cityPair
	 */
	public static CityPair getOriginAndDestination(List<CityPair> list) {
		if(list == null || list.size() == 0) { 
			return null;
		}
		
		Map<String, Character> map = new HashMap<>();
		for(CityPair city : list) {
			if(map.containsKey(city.origin)) {
				map.remove(city.origin);
			} else {
				map.put(city.origin, 'O');
			}
			
			if(map.containsKey(city.destination)) {
				map.remove(city.destination);
			} else {
				map.put(city.destination, 'D');
			}
		}
		
		if(map.size() <= 0 || map.size() > 2) {
			System.out.println("There should be exactly two cities in the map if it has correct set of input.");
			return null;
		}
		
		CityPair output = new CityPair();
		Set<Entry<String, Character>> entrySet = map.entrySet();
		for(Entry<String, Character> entry : entrySet) {
			if(entry.getValue() == 'O') {
				output.origin = entry.getKey();
			} else {
				output.destination = entry.getKey();
			}
		}
		
		return output;
	}
	
	public static class CityPair {
		private String origin;
		private String destination;
		
		public CityPair() {
			
		}
		
		public CityPair(String origin, String destination) {
			this.origin = origin;
			this.destination = destination;
		}
	}

	public static void main(String[] args) {
		List<CityPair> list = new ArrayList<>();
		list.add(new CityPair("Chicago", "Delhi"));
		list.add(new CityPair("New York", "Miami"));
		list.add(new CityPair("Dallas", "Denver"));
		list.add(new CityPair("San Jose", "New York"));
		list.add(new CityPair("Denver", "Chicago"));
		list.add(new CityPair("Miami", "Dallas"));
		
		CityPair cityPair = getOriginAndDestination(list);
		if(cityPair == null) {
			System.out.println("Could not find origin and destination city!!");
			return;
		}
		System.out.println("Origin: " + cityPair.origin);
		System.out.println("Destination: " + cityPair.destination);
	}

}

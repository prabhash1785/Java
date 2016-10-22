package com.prabhash.java.interview.timeinterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given list of reservation requests with time interval and number of bikes reserved. Write a method which accepts list of reservations
 * and returns a boolean value if it's possible to fulfill all these bike requests.
 * 
 * max_bikes = 40
 * 
 * reservations table:
 * start_time end_time amount
   		5        10     15
   		7         9      6
 * 
 * Assumption: Start time is inclusive and end time is exclusive, i.e., at end time bikes were already in returned state.
 * 
 * @author Prabhash Rathore
 *
 */
public class BikeInventoryBasedOnTimeInterval {
	
	public static class ReservationRequest {
		private int startTime;
		private int endTime;
		private int quantity;
		
		public ReservationRequest(int startTime, int endTime, int quantity) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.quantity = quantity;
		}
	}
	
	public static class Event implements Comparable<Event> {
		private int time;
		private int quantity;
		
		public Event(int time, int quantity) {
			this.time = time;
			this.quantity = quantity;
		}
		
		@Override
		public int compareTo(Event event) {
			return Integer.compare(this.time, event.time);
		}
	}
	
	/**
	 * Split each Reservation request into two events, one at start time and other at end time. At start time, bikes were rented and 
	 * at end time, bikes were returned so quantity should be negative.
	 * 
	 * Sort these events based on time in increasing order and then for each event, check if total rented bikes are always less than
	 * or equal to total bikes otherwise return false.
	 *  
	 * Time Complexity: O(n logn)
	 * 
	 * @param reservationList
	 * @param capacity
	 * @return boolean
	 */
	public static boolean isReservationPossible(List<ReservationRequest> reservationList, int capacity) {
		if(reservationList == null || reservationList.size() == 0) {
			return true;
		}
		
		List<Event> eventList = new ArrayList<>();
		for(ReservationRequest req : reservationList) {
			eventList.add(new Event(req.startTime, req.quantity));
			eventList.add(new Event(req.endTime, (-1) * req.quantity));
		}
		
		// Sort the events based on time
		Collections.sort(eventList);
		
		int totalBikesReserved = 0;
		for(Event event : eventList) {
			totalBikesReserved += event.quantity;
			
			if(totalBikesReserved > capacity) {
				return false;
			}
		}
		
		return true;	
	}

	public static void main(String[] args) {
		// test case 1
		List<ReservationRequest> list = new ArrayList<>();
        list.add(new ReservationRequest(5, 10, 15));
        list.add(new ReservationRequest(10, 15, 30));
        list.add(new ReservationRequest(15, 25, 40));
        list.add(new ReservationRequest(8, 12, 25));
        
        final int totalBikes = 40;
        
       System.out.println("Can bikes be reserved: " + isReservationPossible(list, totalBikes));
       
       // test case 2
       List<ReservationRequest> list2 = new ArrayList<>();
       list2.add(new ReservationRequest(5, 10, 15));
       list2.add(new ReservationRequest(10, 15, 30));
       list2.add(new ReservationRequest(15, 25, 40));
       
       System.out.println("Can bikes be reserved: " + isReservationPossible(list2, totalBikes));
	}

}

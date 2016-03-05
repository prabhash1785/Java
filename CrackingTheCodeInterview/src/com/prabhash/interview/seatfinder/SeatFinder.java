package com.prabhash.interview.seatfinder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SeatFinder {
	
	/**
	 * This method accepts an instance of Seat Stand (Multiple Rows of Seats) and number of seats for reservation and then
	 * finds the best possible seats right next to each other (consecutive) in same row and closest to the Stage.
	 * 
	 * It only looks for consecutive available seats in same row. It does not try to split requested seats in multiple rows.
	 * 
	 * @param numOfSeatsRequested
	 * @param seatStand Instane of Seat Stand representing rows of seats
	 * @return List<Seat> List of best seats in same row
	 * @throws Exception
	 */
	public static List<Seat> bestSeats(int numOfSeatsRequested, List<SeatRow> seatStand) throws Exception {
		
		if(seatStand == null) {
			throw new Exception("Seat Stand is null");
		}
		
		if(numOfSeatsRequested <= 0 || numOfSeatsRequested > Integer.MAX_VALUE) {
			throw new Exception("Invalid number of seats are requested!!");
		}
			
		List<Seat> bookedSeats = new ArrayList<Seat>();
		
		boolean seatsFound = false; // flag to skip checking rows once desired seats are found
		
		for(SeatRow row : seatStand) {
			
			List<Seat> rowSeats = row.getSeatRow();
			
			// if number of requested seats is more than total seats in a row, skip rest of the check
			if(numOfSeatsRequested > rowSeats.size()) {
				continue; 
			}
			
			Iterator<Seat> iterator = rowSeats.iterator();
			
			List<Seat> tempList = new ArrayList<Seat>();
			int availableSeatCounter = 0;
			
			while(iterator.hasNext()) {
				
				Seat seat = iterator.next();
				
				if(seat.isAvailble()) {
					
					availableSeatCounter++;
					tempList.add(seat);
					
					if(availableSeatCounter == numOfSeatsRequested) {
						bookedSeats = tempList;
						seatsFound = true;
						
						break;
					}
				} else {
					
					availableSeatCounter = 0;
					tempList.clear();
				}
					
			}
			
			if(seatsFound) {
				break;
			}
			
		}
	
		return bookedSeats;
	}

}

package com.prabhash.interview.seatfinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Since rows at a Venue can have variable number of seats hence using a SeatRow object to represent list of seats. 
 * 
 * @author prrathore
 *
 */
public class SeatRow {
	
	private List<Seat> seatRow = new ArrayList<Seat>();
	
	public SeatRow() {
		this(new ArrayList<Seat>());
	}
	
	public SeatRow(List<Seat> seatRow) {
		this.seatRow = seatRow;
	}

	public List<Seat> getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(List<Seat> seatRow) {
		this.seatRow = seatRow;
	}

}

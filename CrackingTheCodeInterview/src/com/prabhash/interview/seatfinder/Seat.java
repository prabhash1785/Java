package com.prabhash.interview.seatfinder;

/**
 * Mutable object to represent physical seats at a Venue.
 * 
 * This is not thread safe so use external synchronization while accessing same object in a multi-threaded environment.
 *  
 * @author Prabhash Rathore
 *
 */
public class Seat {

	private int colID;
	private int rowID;
	private boolean isAvailble;
	
	public Seat() {
		
	}
	
	public Seat(int coldID, int rowID, boolean isAvailable) {
		this.colID = coldID;
		this.rowID = rowID;
		this.isAvailble = isAvailable;
	}

	public int getColID() {
		return colID;
	}

	public void setColID(int colID) {
		this.colID = colID;
	}

	public int getRowID() {
		return rowID;
	}

	public void setRowID(int rowID) {
		this.rowID = rowID;
	}

	public boolean isAvailble() {
		return isAvailble;
	}

	public void setAvailble(boolean isAvailble) {
		this.isAvailble = isAvailble;
	}
	
	@Override
	public String toString() {
		return this.colID + ", " + this.rowID + ", " + this.isAvailble;
	}
	
}

package com.prabhash.interview.seatfinder.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.prabhash.interview.seatfinder.Seat;
import com.prabhash.interview.seatfinder.SeatFinder;
import com.prabhash.interview.seatfinder.SeatRow;

public class SeatFinderTest {
	
	private List<SeatRow> seatRows;
	
	@Before
	public void generateSeatStand() {
		
		seatRows = new ArrayList<SeatRow>();
		
		// Add row 1
		List<Seat> row1 = new ArrayList<Seat>(); 
		row1.add(new Seat(1, 1, false));
		row1.add(new Seat(2, 1, true));
		row1.add(new Seat(3, 1, true));
		row1.add(new Seat(4, 1, false));
		
		SeatRow seatRow1 = new SeatRow();
		seatRow1.setSeatRow(row1);
		seatRows.add(seatRow1);
	
		// Add row 2
		List<Seat> row2 = new ArrayList<Seat>(); 
		row2.add(new Seat(1, 2, true));
		row2.add(new Seat(2, 2, true));
		row2.add(new Seat(3, 2, false));
		row2.add(new Seat(4, 2, false));
		
		SeatRow seatRow2 = new SeatRow();
		seatRow2.setSeatRow(row2);
		seatRows.add(seatRow2);
		
		// Add row 3
		List<Seat> row3 = new ArrayList<Seat>(); 
		row3.add(new Seat(1, 3, false));
		row3.add(new Seat(2, 3, true));
		
		SeatRow seatRow3 = new SeatRow();
		seatRow3.setSeatRow(row3);
		seatRows.add(seatRow3);
		
	}
	
	@Test
	public void testSeatsReturnedInFirstRow() {
		
		int seatsNeeded = 2;
		
		try {
			List<Seat> seats = SeatFinder.bestSeats(seatsNeeded, seatRows);
			
			Assert.assertEquals(2, seats.size());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testSeatInformation() {
		
		int seatsNeeded = 1;
		
		try {
			List<Seat> seats = SeatFinder.bestSeats(seatsNeeded, seatRows);
			
			for(Seat seat : seats) {
				
				System.out.println("Seat info: " + seat.toString());
				
				Assert.assertEquals(1, seats.size());
				
				Assert.assertNotNull(seat);
				Assert.assertEquals(2, seat.getColID());
				Assert.assertEquals(1, seat.getRowID());
				Assert.assertEquals(true, seat.isAvailble());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testNoSeatsReturned() {
		
		int seatsNeeded = 3;
		
		try {
			List<Seat> seats = SeatFinder.bestSeats(seatsNeeded, seatRows);
			
			Assert.assertEquals(0, seats.size());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	@Test(expected = Exception.class)
//	public void testInvalidSeatsRequest() {
//		
//		int seatsNeeded = 0;
//	
//		try {
//			List<Seat> seats = SeatFinder.bestSeats(seatsNeeded, seatRows);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	@Test
	public void testInvalidSeatsRequest() {
		
		ExpectedException expectedException = ExpectedException.none();
		
		int seatsNeeded = 0;
		
		try {
			expectedException.expect(Exception.class);
			List<Seat> seats = SeatFinder.bestSeats(seatsNeeded, seatRows);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

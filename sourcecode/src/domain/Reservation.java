package domain;

import java.util.Date;
import java.util.ArrayList;

public class Reservation {
	HotelGuest hotelGuest;
	ArrayList<Date> occupiedDates = new ArrayList<Date>();
	int roomNumber;
	
	public void makeReservation(HotelGuest hotelGuest, ArrayList<Date> occupiedDates, int roomNumber) {
		this.hotelGuest = hotelGuest;
		this.occupiedDates = occupiedDates;
		this.roomNumber = roomNumber;
	}
}

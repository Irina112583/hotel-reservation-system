package domain;

import java.util.Date;
import java.util.ArrayList;

public interface Reservation {
	HotelGuest hotelGuest = new HotelGuest();
	ArrayList<Date> occupiedDates = new ArrayList<Date>();
	int roomNumber = 0;
	
	public Reservation makeReservation(HotelGuest hotelGuest, ArrayList<Date> occupiedDates, int roomNumber);
}

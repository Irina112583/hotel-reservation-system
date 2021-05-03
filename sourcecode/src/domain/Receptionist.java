package domain;

import java.util.ArrayList;
import java.util.Date;

public class Receptionist extends User{
	
	public boolean checkReservation(int roomNumber, HotelGuest hotelGuest, ArrayList<Date> occupiedDates) {
		
		return false;
	}
}

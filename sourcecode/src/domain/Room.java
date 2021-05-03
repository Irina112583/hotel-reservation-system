package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Room implements Reservation{
	int roomNumber;
	ArrayList<Date> occupiedDates;
	HotelGuest hotelGuest;
		
	public Room(int roomNumber){
		this.roomNumber = roomNumber;
	}
	
	public Room(int roomNumber, ArrayList<Date> occupiedDates){
		this.roomNumber = roomNumber;
		this.occupiedDates = occupiedDates;
	}
	
	public void setOccupiedDates(ArrayList<Date> newOccupiedDates) {
		for (int i=0; i<newOccupiedDates.size(); i++) {
            this.occupiedDates.add(newOccupiedDates.get(i));
        }
		
	}
	
	public void makeReservation(HotelGuest hotelGuest, ArrayList<Date> occupiedDates, int roomNumber) {
		this.hotelGuest = hotelGuest;
		this.occupiedDates = occupiedDates;
		this.roomNumber = roomNumber;
	}
	
	public void reserve(int roomNumber, Date checkinDate, Date checkoutDate) {
		ArrayList<Date> dates = new ArrayList<Date>();
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(checkinDate);
	 
	    while (calendar.getTime().before(checkoutDate))
	    {
	        Date result = calendar.getTime();
	        dates.add(result);
	        calendar.add(Calendar.DATE, 1);
	    }
	    
	    this.setOccupiedDates(dates);
	}
}

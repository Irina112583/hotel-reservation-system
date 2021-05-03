package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Room implements Reservation{
	public int roomNumber;
	ArrayList<Date> occupiedDates;
	HotelGuest hotelGuest;
	public String roomName;
		
	public Room(int roomNumber){
		this.roomNumber = roomNumber;
	}
	
	public Room(int roomNumber, String roomName, ArrayList<Date> occupiedDates){
		this.roomNumber = roomNumber;
		this.occupiedDates = occupiedDates;
		this.roomName = roomName;
	}
	
	public Room(int roomNumber, ArrayList<Date> occupiedDates, HotelGuest hotelGuest){
		this.roomNumber = roomNumber;
		this.occupiedDates = occupiedDates;
		this.hotelGuest = hotelGuest;
	}
	
	public void setOccupiedDates(ArrayList<Date> newOccupiedDates) {
		for (int i=0; i<newOccupiedDates.size(); i++) {
            this.occupiedDates.add(newOccupiedDates.get(i));
        }
	}
	
	public Reservation makeReservation(HotelGuest hotelGuest, ArrayList<Date> occupiedDates, int roomNumber) {
		System.out.println("A new reservation was created for the hotel guest " + hotelGuest +
				" for the room " + roomNumber + " on the following dates " + occupiedDates);
		return new Room(roomNumber, occupiedDates, hotelGuest);
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
	    
	    dates.add(checkoutDate);
	    
	    this.setOccupiedDates(dates);
	    System.out.println(occupiedDates);
	}
}

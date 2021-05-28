package domain;

import java.util.ArrayList;
import java.util.Date;

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

	public boolean makeReservation(HotelGuest hotelGuest, ArrayList<Integer> occupiedDates, int roomNumber) {
		System.out.println("A new reservation was created for the hotel guest " + hotelGuest.userName +
				" for the room " + roomNumber + " on the following dates " + occupiedDates);
		return true;
	}

	public boolean updateReservation(HotelGuest hotelGuest, ArrayList<Integer> occupiedDates, int roomNumber)
	{
		return false;
	}
	

	public int getReservationCharge(int roomNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getReservationDetail(int cardNumber)
	{
	}

}

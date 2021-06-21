package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Room {
	public int roomNumber;
	HashMap<Integer, ArrayList<Integer>> occupiedDates = new HashMap<Integer, ArrayList<Integer>>();
	private boolean availability;
	private int roomPrice;
	
	
	public Room(int roomNumber, boolean availability){
		this.roomNumber = roomNumber;
		this.availability = availability;
	}
	


	public boolean makeReservation(int cardNumber, ArrayList<Integer>reservationDates) {
		if(occupiedDates.containsKey(cardNumber) || availability == false)
		{
			return false;
		}
		else
		{
			occupiedDates.put(cardNumber, reservationDates);
			return true;
		}
	}

	public boolean updateReservation(int cardNumber, ArrayList<Integer>reservationDates)
	{
		if(occupiedDates.containsKey(cardNumber))
		{
			occupiedDates.remove(cardNumber);
			occupiedDates.put(cardNumber, reservationDates);
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	public boolean cancelReservation(int cardNumber)
	{
		if(occupiedDates.containsKey(cardNumber))
		{
			occupiedDates.remove(cardNumber);
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	public boolean checkReservation(int cardNumber, ArrayList<Integer> dates)
	{
		return occupiedDates.get(cardNumber) == dates;
	}
	

	public HashMap<Integer, ArrayList<Integer>> getOccupiedDays() {
		return occupiedDates;
	}
	
	public boolean checkAvailability(ArrayList<Integer> dates) {
		for(int i: occupiedDates.keySet())
		{
			for(Integer j: dates)
			{
				if(occupiedDates.get(i).contains(j))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public int getReservationCharge(int cardNumber) {
		if(occupiedDates.containsKey(cardNumber))
		{
			return occupiedDates.get(cardNumber).size()*roomPrice;
		}
		else
		{
			
			return 0;
		}
	}
	
	public String getReservationDetail(int cardNumber)
	{
		return "Room Reservation on " + String.valueOf(roomNumber) + " for " + String.valueOf(occupiedDates.get(cardNumber).size()) + " days.";
	}

	public boolean getAvailability() {
		return availability;
	}

	public boolean setAvailability(boolean availability) {
		if(occupiedDates.size() == 0) {
			this.availability = availability;
			return true;
		}
		return false;
	}

}

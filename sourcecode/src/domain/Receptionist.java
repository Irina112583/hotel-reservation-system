package domain;

import java.util.ArrayList;
import java.util.Date;

public class Receptionist extends User{
	
	public Receptionist(Hotel h) {
		super(h);
		// TODO Auto-generated constructor stub
	}

	private Hotel hotel;
	
	
	public boolean checkReservation(int roomNumber, HotelGuest guest, ArrayList<Integer> occupiedDates) {
		
		return hotel.allRooms.get(roomNumber).checkReservation(guest.entryCard.getCardNumber(), occupiedDates);
	}

	public boolean updateRoomReservation(HotelGuest guest, int roomNumber, ArrayList<Integer>reservationDates,int reservationId) {
		
		if(hotel.allRooms.get(roomNumber).updateReservation(guest.entryCard.getCardNumber(), reservationDates))
		{
			guest.entryCard.updateReservation(hotel.allRooms.get(roomNumber), reservationId);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean cancelRoomReservation(HotelGuest guest, int roomNumber,int reservationId) {
		
		if(hotel.allRooms.get(roomNumber).cancelReservation(guest.entryCard.getCardNumber()))
		{
			guest.entryCard.deleteReservation(reservationId);
			return true;
		}
		else
		{
			return false;
		}
	}
}

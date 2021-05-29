package domain;

import java.util.ArrayList;

public class User {
	int IDNumber;
	String fullName;
	String userName;
	String password;
	String emailAddress;
	String role;
	
	Hotel hotel;

	
	User(Hotel h){
		hotel = h;
	}
	
	public boolean makeCleaningReservation(HotelGuest guest,int cleaningDate, int cleaningSlot,int reservationId)
	{
		
		Cleaning cleaningReservation = new Cleaning(hotel);
		if(cleaningReservation.makeReservation(cleaningDate, cleaningSlot, guest.entryCard.getRoomNumber(), guest.entryCard.getCardNumber()))
		{
			guest.entryCard.addReservation(cleaningReservation, reservationId);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean updateCleaningReservation(HotelGuest guest, int cleaningDate, int oldCleaningSlot, int newCleaningSlot, int reservationId)
	{
		Cleaning cleaningReservation = new Cleaning(hotel);
		if(cleaningReservation.updateReservation(cleaningDate, oldCleaningSlot, newCleaningSlot, guest.entryCard.getRoomNumber(), guest.entryCard.getCardNumber()))
		{
			guest.entryCard.updateReservation(cleaningReservation, reservationId);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean deleteCleaningReservation(HotelGuest guest,int cleaningDate, int cleaningSlot, int reservationId)
	{
		Cleaning cleaningReservation = new Cleaning(hotel);
		if(cleaningReservation.deleteReservation(cleaningDate, cleaningSlot, guest.entryCard.getCardNumber()))
		{
			guest.entryCard.deleteReservation(reservationId);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean makeRoomReservation(HotelGuest guest,int roomNumber, ArrayList<Integer>reservationDates, int reservationId) {
		if( hotel.allRooms.get(roomNumber).makeReservation(guest.entryCard.getCardNumber(), reservationDates))
		{
			guest.entryCard.addReservation(hotel.allRooms.get(roomNumber),reservationId);
			return true;
		}
		else
		{
			return false;
		}
	}
}

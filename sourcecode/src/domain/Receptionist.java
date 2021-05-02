package domain;

import java.util.ArrayList;
import java.util.Date;

public class Receptionist extends User{
	
	public boolean checkReservationOfTheRoom(int roomNumber, HotelGuest hotelGuest, ArrayList<Date> occupiedDates) {
//		Hotel hotel = new Hotel();
//		ArrayList<Reservation> allReservations = hotel.getAllReservations();
//		for(int i = 0; i < allReservations.size(); ) {
//			if ((allReservations.get(i).hotelGuest == hotelGuest) 
//					&& (allReservations.get(i).roomNumber == roomNumber)
//					&& (allReservations.get(i).occupiedDates == occupiedDates)) {
//				EntryCard cardFromTheRoom  = Hotel.getCard(roomNumber);
//				cardFromTheRoom.assignToReservation(hotelGuest);
//				return true;
//			} else {
//				return false;
//			}
//		};
		return false;
	}
}

package domain;

import java.util.ArrayList;
import java.util.Date;

public class EntryCard {
	int keyToRoom;
	HotelGuest cardHolder;
	Reservation reservation;
	
	public EntryCard(int keyToRoom) {
		this.keyToRoom = keyToRoom;
	}
	
	public void assignSelfToHotelGuest(HotelGuest cardHolder) {
		this.cardHolder = cardHolder;
		System.out.println("The entry card " + this + " was assigned a hotel guest " + this.cardHolder.username);
	}
	
	public void assignReservation(ArrayList<Date> occupiedDates) {
		Room newRoomReservation = new Room(keyToRoom);
		this.reservation = newRoomReservation.makeReservation(this.cardHolder, occupiedDates, keyToRoom);//
	}
}

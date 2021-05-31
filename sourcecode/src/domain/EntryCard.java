package domain;

import java.util.HashMap;

public class EntryCard {
	int roomNumber;
	int cardNumber;

	HotelGuest cardHolder;
	HashMap<Integer, Reservation> reservations = new HashMap<Integer, Reservation>();
	
	public EntryCard(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public void assignSelfToHotelGuest(HotelGuest cardHolder) {
		this.cardHolder = cardHolder;
		System.out.println("The entry card " + this + " was assigned a hotel guest " + this.cardHolder.userName);
	}
	
	public int getRoomNumber()
	{
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber)
	{
		this.roomNumber = roomNumber;
	}
	
	public int getCardNumber()
	{
		return cardNumber;
	}
	
	public void setCardNumber(int cardNumber)
	{
		this.cardNumber = cardNumber;
	}
	
	public void addReservation(Reservation reservation, int reservationId) {
		reservations.put(reservationId, reservation);
	}
	
	public void updateReservation(Reservation reservation, int reservationId) {
		reservations.remove(reservationId);
		reservations.put(reservationId, reservation);
	}
	
	public void deleteReservation(int reservationId) {
		reservations.remove(reservationId);
	}
	
	public HashMap<Integer, Reservation> getReservations(Reservation reservation, int reservationId) {
		return reservations;
	}

}

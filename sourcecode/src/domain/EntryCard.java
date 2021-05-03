package domain;

public class EntryCard {
	int keyToRoom;
	HotelGuest cardHolder;
	Reservation reservation;
	
	public void assignToReservation(HotelGuest cardHolder) {
		this.cardHolder = cardHolder;
	}

}

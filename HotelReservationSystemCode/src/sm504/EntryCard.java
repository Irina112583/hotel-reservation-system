package sm504;

public class EntryCard {
	int keyToRoom;
	HotelGuest cardHolder;
	
	public void assignToReservation(HotelGuest cardHolder) {
		this.cardHolder = cardHolder;
	}

}

package sm504;

public class Receptionist {
	
	public void checkReservationOfTheRoom(int roomNumber, HotelGuest hotelGuest) {
		String roomStatus = Rooms.getRoom(roomNumber).status;
		if(roomStatus == "reservation requested") {
			EntryCard cardFromTheRoom  = EntryCards.getCard(roomNumber);
			cardFromTheRoom.assignToReservation(hotelGuest);
		} else {
			System.out.println("Reservation of this room was not requested");
		}
	}
}

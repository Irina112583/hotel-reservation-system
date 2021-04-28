package sm504;

public class Receptionist extends User{
	
	public void checkReservationOfTheRoom(int roomNumber, HotelGuest hotelGuest) {
		String roomStatus = Hotel.getRoom(roomNumber).status;
		if(roomStatus == "reservation requested") {
			EntryCard cardFromTheRoom  = Hotel.getCard(roomNumber);
			cardFromTheRoom.assignToReservation(hotelGuest);
		} else {
			System.out.println("Reservation of this room was not requested");
		}
	}
}

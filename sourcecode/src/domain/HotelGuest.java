package domain;

public class HotelGuest extends User{
	
	EntryCard entryCard;
	
	Hotel hotel;

	
	HotelGuest(Hotel h){
		hotel = h;
	}
	
	public void assignEntryCard(int roomNumber) {
		EntryCard eCard = new EntryCard(roomNumber);//when there will be database, this method will find entry card with passed room number 
		 eCard.assignSelfToHotelGuest(this);
		this.entryCard = eCard;
	}
	
	public void setUserName(String username) {
		this.userName = username;
	}
	
	public boolean makeCleaningReservation(int cleaningDate, int cleaningSlot,int reservationId)
	{
		
		Cleaning cleaningReservation = new Cleaning(hotel);
		if(cleaningReservation.makeReservation(cleaningDate, cleaningSlot, entryCard.getRoomNumber(), entryCard.getCardNumber()))
		{
			entryCard.addReservation(cleaningReservation, reservationId);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean updateCleaningReservation(int cleaningDate, int oldCleaningSlot, int newCleaningSlot, int reservationId)
	{
		Cleaning cleaningReservation = new Cleaning(hotel);
		if(cleaningReservation.updateReservation(cleaningDate, oldCleaningSlot, newCleaningSlot, entryCard.getRoomNumber(), entryCard.getCardNumber()))
		{
			entryCard.updateReservation(cleaningReservation, reservationId);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean deleteCleaningReservation(int cleaningDate, int cleaningSlot, int reservationId)
	{
		Cleaning cleaningReservation = new Cleaning(hotel);
		if(cleaningReservation.deleteReservation(cleaningDate, cleaningSlot, entryCard.getCardNumber()))
		{
			entryCard.deleteReservation(reservationId);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
}

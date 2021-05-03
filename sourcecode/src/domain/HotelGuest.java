package domain;

public class HotelGuest extends User{
	
	EntryCard entryCard;
	
	public void assignEntryCard(int roomNumber) {
		EntryCard eCard = new EntryCard(roomNumber);//when there will be database, this method will find entry card with passed room number 
		 eCard.assignSelfToHotelGuest(this);
		this.entryCard = eCard;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
}

package domain;

public class HotelGuest extends User{
	
	EntryCard entryCard;
	
	public void assignEntryCard(int roomNumber) {
		EntryCard eCard = new EntryCard();
		this.entryCard = eCard.assignSelfToHotelGuest(this);
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
}

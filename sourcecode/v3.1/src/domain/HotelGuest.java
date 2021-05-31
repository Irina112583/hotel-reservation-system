package domain;


public class HotelGuest extends User{
	
	public EntryCard entryCard;

	private final int roomNumbertoCardNumber = 10000;
	
	
	
	public void assignEntryCard(int roomNumber) {
		EntryCard eCard = new EntryCard(roomNumbertoCardNumber + roomNumber);//when there will be database, this method will find entry card with passed room number 
		 eCard.assignSelfToHotelGuest(this);
		this.entryCard = eCard;
	}
	
	@Override
	public EntryCard getEntryCard()
	{
		return entryCard;
	}
	
	public void setEntryCard(EntryCard entryCard)
	{
		this.entryCard = entryCard;
	}
	
	public void setUserName(String username) {
		this.userName = username;
	}
	
	public String getUserName() {
		return super.userName;
	}
}

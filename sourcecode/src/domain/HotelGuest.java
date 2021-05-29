package domain;


public class HotelGuest extends User{
	
	public HotelGuest(Hotel h) {
		super(h);
		// TODO Auto-generated constructor stub
	}

	EntryCard entryCard;
	private final int roomNumbertoCardNumber = 10000;
	
	
	
	public void assignEntryCard(int roomNumber) {
		EntryCard eCard = new EntryCard(roomNumbertoCardNumber + roomNumber);//when there will be database, this method will find entry card with passed room number 
		 eCard.assignSelfToHotelGuest(this);
		this.entryCard = eCard;
	}
	
	public void setUserName(String username) {
		this.userName = username;
	}
}

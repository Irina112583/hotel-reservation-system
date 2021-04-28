package sm504;

import java.util.Date;

public class Room {
	int roomNumber;
	static String status; //may change to enum
		
	public Room(int roomNumber){
		this.roomNumber = roomNumber;
		Room.status = "free";
	}
	
	public static void reserve(int roomNumber, Date checkinDate, Date checkoutDate) {
		status = "reserved";
		System.out.println("Reservation is active since " + checkinDate + " until " + checkoutDate);
	}
}

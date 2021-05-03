package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Hotel {	
	static List<Room> allRooms = new ArrayList<Room>();
	static ArrayList<Room> freeRooms = new ArrayList<Room>();
	static ArrayList<EntryCard> eCards = new ArrayList<EntryCard>();
	ArrayList<User> users = new ArrayList<User>();
	
	Room testRoomOne = new Room(1);
	Room testRoomTwo = new Room(2);
	
	public static ArrayList<Room> getFreeRooms(Date checkoutDate){
		for (int i = 0; i < allRooms.size(); i++) {
			if (allRooms.get(i).occupiedDates.contains(Calendar.getInstance().getTime())) {
				freeRooms.add(allRooms.get(i));
			}
		}
		return freeRooms;
	}
	
	
	public ArrayList<EntryCard> getAllECards() {
		return this.eCards;
	}
	
	public static EntryCard getCard(int roomNumber){
		for (int i = 0; i < eCards.size()-1; i++) {
			if (eCards.get(i).keyToRoom == roomNumber) {
				return eCards.get(i);
			}
		}
		return null;
	}
}

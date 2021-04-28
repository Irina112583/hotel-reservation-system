package sm504;

import java.util.ArrayList;
import java.util.List;

public class Hotel {	
	static List<Room> allRooms = new ArrayList<Room>();
	static List<Room> freeRooms = new ArrayList<Room>();
	
	static List<EntryCard> allEntryCards = new ArrayList<EntryCard>();
	
	Room testRoomOne = new Room(1);
	Room testRoomTwo = new Room(2);
	
	public static List<Room> getFreeRooms(){
		for (int i = 0; i < allRooms.size()-1; i++) {
			if (allRooms.get(i).status == "free") {
				freeRooms.add(allRooms.get(i));
			}
		}
		System.out.println(freeRooms);
		return freeRooms;
	}
	
	public static Room getRoom(int roomNumber) {
		for (int i = 0; i < allRooms.size()-1; i++) {
			if (allRooms.get(i).roomNumber == roomNumber) {
				return allRooms.get(i);
			}
		}
		return null;
	}
	
	public static EntryCard getCard(int roomNumber){
		for (int i = 0; i < allEntryCards.size()-1; i++) {
			if (allEntryCards.get(i).keyToRoom == roomNumber) {
				return allEntryCards.get(i);
			}
		}
		return null;
	}
}
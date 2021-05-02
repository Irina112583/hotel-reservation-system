package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Hotel {	
	static List<Room> allRooms = new ArrayList<Room>();
	static ArrayList<Room> freeRooms = new ArrayList<Room>();
	ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
	static List<EntryCard> allEntryCards = new ArrayList<EntryCard>();
	
	Room testRoomOne = new Room(1);
	Room testRoomTwo = new Room(2);
	
	public static ArrayList<Room> getFreeRooms(){
		for (int i = 0; i < allRooms.size(); i++) {
			if (allRooms.get(i).occupiedDates.contains(Calendar.getInstance().getTime())) {
				freeRooms.add(allRooms.get(i));
			}
		}
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
	
	public ArrayList<Reservation> getAllReservations() {
		return this.reservations;
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

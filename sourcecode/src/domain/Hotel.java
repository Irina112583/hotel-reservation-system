package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

public class Hotel {	
	static List<Room> allRooms = new ArrayList<Room>();
	static ArrayList<Room> freeRooms = new ArrayList<Room>();
	static ArrayList<EntryCard> eCards = new ArrayList<EntryCard>();
	
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
	
	/* DB & User Part*/
	
	DB db = new DBAdapter();
	
	public void insertUser(int IDNumber, String fullName, String username, String password, String emailAddress,
			String role){
		db.insertUser(IDNumber, fullName, username, password, emailAddress, role);			
	}
	
	public void updateUser(int IDNumber, String fullName, String username, String password, String emailAddress,
			String role){
		db.insertUser(IDNumber, fullName, username, password, emailAddress, role);
		JOptionPane.showMessageDialog(null, "User updated!");
	}
	
	public void deleteUser(int IDNumber){
		db.deleteUser(IDNumber);
	}
	
	public boolean verifyAccount(String username, String password) throws ClassNotFoundException{
		return db.verifyAccount(username, password);
	}
	
    public int getIDNumber(){
    	return db.getIDNumber();
    }
    public String getFullName(){
    	return db.getFullName();
    }
    public String getUsername(){
    	return db.getUsername();
    }
    public String getEmailAddress(){
    	return db.getEmailAddress();
    }
    public String getRole(){
    	return db.getRole();
    }
	
}

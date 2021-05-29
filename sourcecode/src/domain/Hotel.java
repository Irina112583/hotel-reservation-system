package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Hotel {	

	ArrayList<User> users = new ArrayList<User>();
	ArrayList<HotelGuest> hotelGuests = new ArrayList<HotelGuest>();
	
	ArrayList<Integer> freeRooms = new ArrayList<Integer>();
	
	public HashMap<Integer,TimeSlot> cleaningTimeSlots = new HashMap<Integer, TimeSlot>();
	public HashMap<Integer,Room> allRooms = new HashMap<Integer, Room>();


	public boolean setAvailableCleaningDates(ArrayList<Integer> dates) {
		for(int date: dates)
		{
			cleaningTimeSlots.put(date,new TimeSlot());
		}
		return true;
	}
	
	public boolean addRoom(int roomNumber, boolean availability) {
		return allRooms.put(roomNumber, new Room(roomNumber, availability)) != null ;
	}
	public boolean deleteRoom(int roomNumber) {
		if(allRooms.containsKey(roomNumber))
		{
			allRooms.remove(roomNumber);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean changeAvailabilityRoom(int roomNumber,boolean availabilty) {
		if(allRooms.containsKey(roomNumber))
		{
			return allRooms.get(roomNumber).setAvailability(availabilty);
		}
		else
		{
			return false;
		}
	}

	
	public ArrayList<Integer> getFreeRooms(ArrayList<Integer> dates){
		
		freeRooms.clear();
		
		for(int i: allRooms.keySet())
		{
			if(allRooms.get(i).checkAvailabilty(dates)) {
				freeRooms.add(i);
			}
		}
		
		return freeRooms;
	}
	
	
	
	/* DB & User Part*/
	
	DB db = new DBAdapter();
	
	public void insertUser(int IDNumber, String fullName, String username, String password, String emailAddress,
			String role){
		db.insertUser(IDNumber, fullName, username, password, emailAddress, role);			
	}
	
	public void updateUser(int IDNumber, String fullName, String username, String password, String emailAddress,
			String role){
		db.updateUser(IDNumber, fullName, username, password, emailAddress, role);

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

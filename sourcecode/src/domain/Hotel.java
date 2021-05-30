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
	
	ArrayList<Integer> freeRooms = new ArrayList<Integer>();
	
	public HashMap<Integer,HotelGuest> hotelGuests = new HashMap<Integer,HotelGuest>();
	public HashMap<Integer,TimeSlot> cleaningTimeSlots = new HashMap<Integer, TimeSlot>();
	public HashMap<Integer,Room> allRooms = new HashMap<Integer, Room>();
	public User currentUser;

	public Hotel() {
	}
	
	public User getCurrentUser()
	{
		return currentUser;
	}
	
	public void init() {
		String role = this.getRole();
		
		if(role.equals("Receptionist")) {
			this.currentUser = new Receptionist();
		} else if(role.equals("Guest")) {
			this.currentUser = new HotelGuest();
		} else if(role.equals("Manager")) {
			this.currentUser = new HotelManager();
		}
	}
	
	public User getChoosenUser(int entryCardNumber)
	{
		return hotelGuests.get(entryCardNumber);
	}
	
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
	
	
	public boolean makeCleaningReservation(int cleaningDate, int cleaningSlot)
	{
		
		Cleaning cleaningReservation = new Cleaning(this);
		if(cleaningReservation.makeReservation(cleaningDate, cleaningSlot, currentUser.getEntryCard().getRoomNumber(), currentUser.getEntryCard().getCardNumber()))
		{
			currentUser.getEntryCard().addReservation(cleaningReservation, cleaningDate);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean updateCleaningReservation(int cleaningDate, int oldCleaningSlot, int newCleaningSlot)
	{
		Cleaning cleaningReservation = new Cleaning(this);
		if(cleaningReservation.updateReservation(cleaningDate, oldCleaningSlot, newCleaningSlot, currentUser.getEntryCard().getRoomNumber(), currentUser.getEntryCard().getCardNumber()))
		{
			currentUser.getEntryCard().updateReservation(cleaningReservation, cleaningDate);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean deleteCleaningReservation(int cleaningDate, int cleaningSlot)
	{
		Cleaning cleaningReservation = new Cleaning(this);
		if(cleaningReservation.deleteReservation(cleaningDate, cleaningSlot, currentUser.getEntryCard().getCardNumber()))
		{
			currentUser.getEntryCard().deleteReservation(cleaningDate);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean makeRoomReservation(int roomNumber, ArrayList<Integer>reservationDates) {
		if( allRooms.get(roomNumber).makeReservation(getCurrentUser().getEntryCard().getCardNumber(), reservationDates))
		{
			currentUser.getEntryCard().addReservation(allRooms.get(roomNumber),currentUser.getEntryCard().getCardNumber());
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean makeRoomReservation(int entryCardNumber, int roomNumber, ArrayList<Integer>reservationDates) {
		if( allRooms.get(roomNumber).makeReservation(entryCardNumber, reservationDates))
		{
			getChoosenUser(entryCardNumber).getEntryCard().addReservation(allRooms.get(roomNumber),entryCardNumber);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkReservation(int entryCardNumber, int roomNumber, ArrayList<Integer> occupiedDates) {
		
		return allRooms.get(roomNumber).checkReservation(entryCardNumber, occupiedDates);
	}
	
	public boolean updateRoomReservation(int entryCardNumber, int roomNumber, ArrayList<Integer>reservationDates) {
		
		if(allRooms.get(roomNumber).updateReservation(entryCardNumber, reservationDates))
		{
			getChoosenUser(entryCardNumber).getEntryCard().updateReservation(allRooms.get(roomNumber), entryCardNumber);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean cancelRoomReservation(int entryCardNumber, int roomNumber) {
		
		if(allRooms.get(roomNumber).cancelReservation(entryCardNumber))
		{
			getChoosenUser(entryCardNumber).getEntryCard().deleteReservation(entryCardNumber);
			return true;
		}
		else
		{
			return false;
		}
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

package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Hotel {	
	static List<Room> allRooms = new ArrayList<Room>();
	static ArrayList<Room> freeRooms = new ArrayList<Room>();
	ArrayList<User> users = new ArrayList<User>();
	ArrayList<HotelGuest> hotelGuests = new ArrayList<HotelGuest>();
	
	public void createTestData() throws ParseException{
		ArrayList<Date> occupiedDates = new ArrayList<Date>();
		occupiedDates.add(new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2021"));
		Room testRoomOne = new Room(1, "Room 1", occupiedDates);
		Room testRoomTwo = new Room(2, "Room 2", occupiedDates);
	
		allRooms.add(testRoomOne);
		allRooms.add(testRoomTwo);
	
		HotelGuest hgtest = new HotelGuest();
		hgtest.setUserName("username");
	
		hotelGuests.add(hgtest);
	}
	
	public ArrayList<Room> getFreeRooms(Date checkoutDate) throws ParseException{
		allRooms.clear();
		freeRooms.clear();
		createTestData();
		
		Date dateToCheck;
		
		Calendar calendar = new GregorianCalendar();
	    calendar.setTime(new Date());
	    
	    while (calendar.getTime().before(checkoutDate))
	    {
	    	Date result = calendar.getTime();
	    	dateToCheck = result;
	    	for (int i = 0; i < allRooms.size(); i++) {
				if ((!allRooms.get(i).occupiedDates.contains(dateToCheck)) && (!freeRooms.contains(allRooms.get(i)))) {
					freeRooms.add(allRooms.get(i));
				}
				if ((allRooms.get(i).occupiedDates.contains(dateToCheck)) && (freeRooms.contains(allRooms.get(i)))) {
					freeRooms.remove(allRooms.get(i));
				}
			}
	    	
	        calendar.add(Calendar.DATE, 1);
	    }
	    
	    dateToCheck = checkoutDate;
	    
	    for (int i = 0; i < allRooms.size(); i++) {
			if (!allRooms.get(i).occupiedDates.contains(dateToCheck) && (!freeRooms.contains(allRooms.get(i)))) {
				freeRooms.add(allRooms.get(i));
			}
			if ((allRooms.get(i).occupiedDates.contains(dateToCheck)) && (freeRooms.contains(allRooms.get(i)))) {
				freeRooms.remove(allRooms.get(i));
			}
		}
		
		return freeRooms;
	}
	
	public void assignRoomToHotelGuest(String username, String roomName, Date checkoutDate) throws ParseException {
		createTestData();
		int roomNumber = 0;
		for (int i = 0; i < allRooms.size(); i++) {
			if (allRooms.get(i).roomName == roomName) {
				roomNumber = allRooms.get(i).roomNumber;
			}
		}
		
		for (int i = 0; i < hotelGuests.size(); i++) {
			if (hotelGuests.get(i).userName == username) {
				if(roomNumber !=0) {
					hotelGuests.get(i).assignEntryCard(roomNumber);
					
					ArrayList<Date> newOccupiedDates = new ArrayList<Date>();
				    Calendar calendar = new GregorianCalendar();
				    calendar.setTime(new Date());
				 
				    while (calendar.getTime().before(checkoutDate))
				    {
				        Date result = calendar.getTime();
				        newOccupiedDates.add(result);
				        calendar.add(Calendar.DATE, 1);
				    }
				    newOccupiedDates.add(checkoutDate);
				    
					hotelGuests.get(i).entryCard.assignReservation(newOccupiedDates);
				}
			}
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

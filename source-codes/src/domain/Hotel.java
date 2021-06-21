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
	
	DB db = new DBAdapter();

	ArrayList<User> users = new ArrayList<User>();
	
	ArrayList<Integer> freeRooms = new ArrayList<Integer>();
	
	public HashMap<Integer,Room> allRooms = new HashMap<Integer, Room>();
	public User currentUser;
	String role;

	public Hotel() {
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
	
	
	public ArrayList<Integer> getAllRoomsInTheHotel(){
		return db.getAllRoomsInTheHotel();
	}
	
	public ArrayList<Integer> getFreeRooms(ArrayList<Integer> dates){
		return db.getFreeRooms(dates);
	}
	
	public boolean makeRoomReservation(int roomNumber, ArrayList<Integer>reservationDates) {
		return db.makeRoomReservation(roomNumber, reservationDates);
	}
	
	public boolean makeRoomReservation(int userID, int roomNumber, ArrayList<Integer>reservationDates) {
		return db.makeRoomReservation(userID, roomNumber, reservationDates);
	}
	
	public boolean checkReservation(int entryCardNumber, int roomNumber, ArrayList<Integer> occupiedDates) {
		return allRooms.get(roomNumber).checkReservation(entryCardNumber, occupiedDates);
	}
	
	public User getCurrentUser()
	{
		currentUser = db.retrieveCurrentUser();
		return currentUser;
	}
	
	public User retrieveUserWithID(int userID){
		return db.retrieveUserWithID(userID);
	}
	
	public boolean insertNewUser(int IDNumber, String fullName, String username, String password, String emailAddress,
		String role, int status){
			currentUser = new User();
			currentUser.setIDNumber(IDNumber);
			currentUser.setFullName(fullName);
			currentUser.setUsername(username);
			currentUser.setPassword(password);
			currentUser.setEmailAddress(emailAddress);
			currentUser.setRole(role);
			currentUser.setUserStatus(status);
		
		return db.insertUser(currentUser);			
	}
	
	public void updateUser(int IDNumber, String fullName, String username, String password, String emailAddress,
		String role){
			currentUser.setIDNumber(IDNumber);
			currentUser.setFullName(fullName);
			currentUser.setUsername(username);
			currentUser.setPassword(password);
			currentUser.setEmailAddress(emailAddress);
			currentUser.setRole(role);
			db.updateUser(currentUser);
	}
	
	public void deleteUser(int IDNumber){
		db.deleteUser(IDNumber);
	}
	
	public boolean verifyAccount(String username, String password) throws ClassNotFoundException{
		return db.verifyAccount(username, password);
	}
	
	public ArrayList<User> retrieveUsersWithRole(String role){		
 		return db.retrieveUsersWithRole(role);
 	}
 	public void approveReceptionist(int IDNumber){
 		db.approveReceptionist(IDNumber);
 	}
 	public ArrayList<Reservation> retrieveReservations(int status){
 		return db.retrieveReservations(status);
 	}
 	
 	public boolean cancelReservation(int reservationID, int entryCard){
 		return db.cancelReservation(reservationID, entryCard);
 	}
 	
 	public void updateRoom(int reservationID, int newRoom){
 		db.updateRoom(reservationID, newRoom);
 	}
 	
 	public Reservation getRoomReservation(int roomNumber, int date, int status){
 		return db.getRoomReservation(roomNumber, date, status);
 	}
 	
 	public ArrayList<Reservation> getRoomReservations(int userID){
 		return db.getRoomReservations(userID);
 	}
 	
 	public ArrayList<domain.ReservationForServices> retrieveServiceReservations(int status){
 		return db.retrieveServiceReservations(status);
 	}
 	
 	public boolean makeCleaningReservation(int serviceType, int userID, int occupiedDate, int timeSlotID, int cardNumber, int roomNumber){
 		return db.makeCleaningReservation(serviceType, userID, occupiedDate, timeSlotID, cardNumber, roomNumber);
 	}
 	
 	public ArrayList<Timeslot> getAvailableTimeSlots(int entryCardNumber, int date){
 		return db.getAvailableTimeSlots(entryCardNumber, date);
 	}
 	
 	public void updateCleaningReservation(int entryCardNumber, int newDate, int newTimeSlot, int oldDate, int oldTimeSlot){
 		db.updateCleaningReservation(entryCardNumber, newDate, newTimeSlot, oldDate, oldTimeSlot);
 	}
 	
 	public ArrayList<domain.ReservationForServices> getCurrentUserServiceReservations(){
 		return db.getUserServiceReservations(currentUser.getIDNumber());
 	}
 	
 	public Timeslot getTimeSlot(int timeSlotId){
 		return db.getTimeSlot(timeSlotId);
 	}
 	
 	public boolean cancelCleaningReservation(int serviceResID){
 		return db.cancelCleaningReservation(serviceResID);
 	}
 	
	public int getRoomFee(int roomID){
		return db.getRoomFee(roomID);
	}
	
	public ArrayList<Reservation> GetUserNotCanceledRoomReservations(int userID){
		return db.GetUserNotCanceledRoomReservations(userID);
	}
	
	public ArrayList<domain.ReservationForServices> GetUserNotCanceledServiceReservations(int userID){
		return db.GetUserNotCanceledServiceReservations(userID);
	}
	
	public int getServiceFee(String serviceName){
		return db.getServiceFee(serviceName);
	}
	
	
	public void payCashForRoomReservation(int userID, int roomNumber){
		db.payCashForRoomReservation(userID, roomNumber);
	}
	
	public void payCashForServiceReservation(int userID, int roomNumber){
		db.payCashForServiceReservation(userID, roomNumber);
	}
}

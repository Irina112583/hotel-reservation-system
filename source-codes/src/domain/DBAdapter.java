package domain;

import java.sql.*;
import java.util.ArrayList;

public class DBAdapter extends DBSQLiteAdapter implements DB{
	
	Connection conn = null;
	DBSQLiteAdapter sqlite;

	@Override
	public Connection connect() throws ClassNotFoundException {
			
		sqlite = new DBSQLiteAdapter();
		conn = sqlite.connect();
		return conn;
	}
	
	@Override
	public boolean insertUser(User user) {
		
		return super.insertUser(user);
	}
	
	@Override
	public void deleteUser(int IDNumber){
		super.deleteUser(IDNumber);
	}
	
	@Override
	public User retrieveCurrentUser() {
		return super.retrieveCurrentUser();
	}
	
	@Override
	public User retrieveUserWithID(int userID){
		return super.retrieveUserWithID(userID);
	}

	@Override
 	public ArrayList<User> retrieveUsersWithRole(String role){
 		return super.retrieveUsersWithRole(role);
 	}
	
	@Override
	public boolean verifyAccount(String username, String password) throws ClassNotFoundException {
		return super.verifyAccount(username, password);
	}

	@Override
	public void updateUser(User user) {
		super.updateUser(user);
	}
	
	//***
	
	@Override
	public ArrayList<Integer> getFreeRooms(ArrayList<Integer> dates){
		
		return super.getFreeRooms(dates);
	}

	@Override
	public boolean makeRoomReservation(int roomNumber, ArrayList<Integer> reservationDates) {
		
		return super.makeRoomReservation(roomNumber, reservationDates);
	}

	@Override
	public boolean makeRoomReservation(int userID, int roomNumber, ArrayList<Integer> reservationDates) {
		
		return super.makeRoomReservation(userID, roomNumber, reservationDates);
	}
	
	@Override
	public ArrayList<Reservation> retrieveReservations(int status){
		return super.retrieveReservations(status);
	}

	@Override
	public boolean cancelReservation(int reservationID, int entryCard) {
		
		return super.cancelReservation(reservationID, entryCard);
	}

	@Override
	public void updateRoom(int reservationID, int newRoom) {
		
		super.updateRoom(reservationID, newRoom);	
	}
	
	@Override
	public ArrayList<Integer> getAllRoomsInTheHotel(){
		return super.getAllRoomsInTheHotel();
	}
	
	@Override
	public Reservation getRoomReservation(int roomNumber, int date, int status){
		return super.getRoomReservation(roomNumber, date, status);
	}
	
	@Override
	public ArrayList<Reservation> getRoomReservations(int userID){
		return super.getRoomReservations(userID);
	}
	
	@Override
	public boolean makeCleaningReservation(int serviceType, int userID, int occupiedDate, int timeSlotID, int cardNumber, int roomNumber){
		return super.makeCleaningReservation(serviceType, userID, occupiedDate, timeSlotID, cardNumber, roomNumber);
	}
	
	@Override
	public ArrayList<Timeslot> getAvailableTimeSlots(int entryCardNumber, int date){
		return super.getAvailableTimeSlots(entryCardNumber, date);
	}
	
	@Override
	public void updateCleaningReservation(int entryCardNumber, int newDate, int newTimeSlot, int oldDate, int oldTimeSlot){
		super.updateCleaningReservation(entryCardNumber, newDate, newTimeSlot, oldDate, oldTimeSlot);
	}
	
	@Override
	public ArrayList<ReservationForServices> getUserServiceReservations(int userID){
		return super.getUserServiceReservations(userID);
	}
	
	@Override
	public Timeslot getTimeSlot(int timeSlotId){
		return super.getTimeSlot(timeSlotId);
	}
	
	@Override
	public boolean cancelCleaningReservation(int serviceResID){
		return super.cancelCleaningReservation(serviceResID);
	}
	
	@Override
	public int getRoomFee(int roomID){
		return super.getRoomFee(roomID);
	}
	
	@Override
	public ArrayList<Reservation> GetUserNotCanceledRoomReservations(int userID){
		return super.GetUserNotCanceledRoomReservations(userID);
	}
	
	@Override
	public ArrayList<domain.ReservationForServices> retrieveServiceReservations(int status){
		return super.retrieveServiceReservations(status);
	}
	
	@Override
	public ArrayList<domain.ReservationForServices> GetUserNotCanceledServiceReservations(int userID){
		return super.GetUserNotCanceledServiceReservations(userID);
	}
	
	@Override
	public int getServiceFee(String serviceName){
		return super.getServiceFee(serviceName);
	}
	
	@Override
	public void payCashForRoomReservation(int userID, int roomNumber){
		super.payCashForRoomReservation(userID, roomNumber);
	}
	
	@Override
	public void payCashForServiceReservation(int userID, int roomNumber){
		super.payCashForServiceReservation(userID, roomNumber);
	}
}


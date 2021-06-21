package domain;

import java.sql.*;
import java.util.ArrayList;

public interface DB {

	public Connection connect() throws ClassNotFoundException;
	
	//User Operations...
	public boolean insertUser(User newUser);
	public void updateUser(User currentUser);
	public void deleteUser(int IDNumber);
	public boolean verifyAccount(String username, String password) throws ClassNotFoundException;
	public ArrayList<User> retrieveUsersWithRole(String role);
	public void approveReceptionist(int IDNumber);
 	public User retrieveCurrentUser();
 	public User retrieveUserWithID(int userID);
 	
 	//Room Operations...
    public ArrayList<Integer> getFreeRooms(ArrayList<Integer> dates);
    public boolean makeRoomReservation(int roomNumber, ArrayList<Integer>reservationDates);
    public boolean makeRoomReservation(int userID, int roomNumber, ArrayList<Integer> reservationDates);
    public ArrayList<Reservation> retrieveReservations(int status);
    public boolean cancelReservation(int reservationID, int entryCard);
    public void updateRoom(int reservationID, int newRoom);
    public ArrayList<Integer> getAllRoomsInTheHotel();
    public Reservation getRoomReservation(int roomNumber, int date, int status);
    public ArrayList<Reservation> getRoomReservations(int userID);

    
    //Service Operations...
    public boolean makeCleaningReservation(int serviceType, int userID, int occupiedDate, int timeSlotID, int cardNumber, int roomNumber);
    public ArrayList<Timeslot> getAvailableTimeSlots(int entryCardNumber, int date);
    public void updateCleaningReservation(int entryCardNumber, int newDate, int newTimeSlot, int oldDate, int oldTimeSlot);
    public ArrayList<domain.ReservationForServices> getUserServiceReservations(int userID);
    public Timeslot getTimeSlot(int timeSlotId);
    public boolean cancelCleaningReservation(int serviceResID);
    public ArrayList<domain.ReservationForServices> retrieveServiceReservations(int status);
    
    //Fee Operations...
    public int getRoomFee(int roomID);
    public int getServiceFee(String serviceName);
    public ArrayList<Reservation> GetUserNotCanceledRoomReservations(int userID);
    public ArrayList<domain.ReservationForServices> GetUserNotCanceledServiceReservations(int userID);
    public void payCashForRoomReservation(int userID, int roomNumber);
    public void payCashForServiceReservation(int userID, int roomNumber);
    
}

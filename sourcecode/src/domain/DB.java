package domain;

import java.sql.*;

public interface DB {

	public Connection connect() throws ClassNotFoundException;
	
	public void insertUser(int IDNumber, String fullName, String username, String password, String emailAddress, String role);
	public void updateUser(int IDNumber, String fullName, String username, String password, String emailAddress, String role);
	public void deleteUser(int IDNumber);
	
	public boolean verifyAccount(String username, String password) throws ClassNotFoundException;
	
    public int getIDNumber();
    public String getFullName();
    public String getUsername();
    public String getEmailAddress();
    public String getRole();
	
//	public void updateUser();

//	;
//	
//	public void makeReservation();
//	public void updateReservation();
//	public void deleteReservation();
}

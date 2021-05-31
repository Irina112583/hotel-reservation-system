package domain;

import java.sql.*;
import java.util.ArrayList;

public interface DB {

	public Connection connect() throws ClassNotFoundException;
	
	//User Operations...
	public void insertUser(int IDNumber, String fullName, String username, String password, String emailAddress, String role, int status);
	public void updateUser(int IDNumber, String fullName, String username, String password, String emailAddress, String role);
	public void deleteUser(int IDNumber);
	public boolean verifyAccount(String username, String password) throws ClassNotFoundException;
	public ArrayList<String> retrieveUsersWithRole(String role) throws ClassNotFoundException;
	
	public void approveReceptionist(String fullName);
 	public void deleteUser(String fullName);
	
    public int getIDNumber();
    public String getFullName();
    public String getUsername();
    public String getEmailAddress();
    public String getRole();
    public int getUserStatus();
	

    //Room Operations...
    
    public void getAllRooms();
    
}

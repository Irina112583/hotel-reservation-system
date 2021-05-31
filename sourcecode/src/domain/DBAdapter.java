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
	public void insertUser(int IDNumber, String fullName, String username, String password, String emailAddress,
			String role, int status) {
		
		super.insertUser(IDNumber, fullName, username, password, emailAddress, role, status);
	}
	
	public void deleteUser(int IDNumber){
		super.deleteUser(IDNumber);
	}
	
	public void deleteUser(String fullName){
 		super.deleteUser(fullName);
 	}

 	public ArrayList<String> retrieveUsersWithRole(String role) throws ClassNotFoundException {
 		return super.retrieveUsersWithRole(role);
 	}
	
	@Override
	public boolean verifyAccount(String username, String password) throws ClassNotFoundException {
		return super.verifyAccount(username, password);
	}

    public int getIDNumber(){
    	return super.getIDNumber();
    }
    public String getFullName(){
    	return super.getFullName();
    }
    public String getUsername(){
    	return super.getUsername();
    }
    public String getEmailAddress(){
    	return super.getEmailAddress();
    }
    public String getRole(){
    	return super.getRole();
    }
    
    @Override
 	public int getUserStatus() {
 		return super.getUserStatus();
 	}

	@Override
	public void updateUser(int IDNumber, String fullName, String username, String password, String emailAddress, String role) {
		super.updateUser(IDNumber, fullName, username, password, emailAddress, role);
	}

}

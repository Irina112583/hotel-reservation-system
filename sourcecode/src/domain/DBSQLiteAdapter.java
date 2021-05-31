package domain;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DBSQLiteAdapter{

	String sql = null;
	private static int IDNumber;
	private static String fullName;
	private static String username;
	private static String password;
	private static String emailAddress;
	private static String role;
	private static int userStatus;
	
	public Connection connect() throws ClassNotFoundException{
		
		Connection conn = null;
		String connUrl="jdbc:sqlite:HRSDB.db";
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn=DriverManager.getConnection(connUrl);

	       
		}  catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public void insertUser(int IDNumber, String fullName, String username, String password, String emailAddress, String role, int status){
     	sql = "INSERT INTO User VALUES(?,?,?,?,?,?,?);";
    	
    	try (Connection conn = this.connect();
    		PreparedStatement pst = conn.prepareStatement(sql)){
    			pst.setInt(1, IDNumber);
    			pst.setString(2,fullName);
    			pst.setString(3, username);
    			pst.setString(4, password);
    			pst.setString(5, emailAddress);
    			pst.setString(6, role);
    			pst.setInt(7, status);
        		
    			pst.executeUpdate();
        		pst.close();
        		//conn.commit();
        		conn.close();
        		if (status == 0)
 					JOptionPane.showMessageDialog(null, "Your request was sent to Manager for approval.");
         		else
         			JOptionPane.showMessageDialog(null, "You have successfully enrolled to HRS!");
        		
    		}catch (SQLException | ClassNotFoundException e) {
    			JOptionPane.showMessageDialog(null, "Some of information you entered is not suitable for registration. Check the fields and try again.", "Warning", JOptionPane.WARNING_MESSAGE);
		}
    }
    
    public void updateUser(int IDNumber, String fullName, String username, String password, String emailAddress, String role){
    	
    	String sql = "UPDATE User SET Fullname = '"+fullName+"' ,Password = '"+password+"' ,EmailAddress = '"+emailAddress+"' WHERE IDNumber = "+IDNumber+"";
    	
        try (Connection conn = this.connect();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.execute();
    		JOptionPane.showMessageDialog(null, "User updated!");
    		setFullName(fullName);
    		setEmailAddress(emailAddress);
    		setPassword(password);
        } catch (SQLException | ClassNotFoundException e) {
        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void approveReceptionist(String fullName){
    String sql = "UPDATE User SET Status = 1 WHERE Fullname = '"+ fullName + "'";

        try (Connection conn = this.connect();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.execute();
    		JOptionPane.showMessageDialog(null, "User approved!");
        } catch (SQLException | ClassNotFoundException e) {
        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteUser(int IDNumber){
    	String sql = "DELETE FROM User WHERE IDNumber = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, IDNumber);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "User deleted!");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteUser(String fullName){
     	String sql = "DELETE FROM User WHERE Fullname = ?";

         try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setString(1, fullName);
             pstmt.executeUpdate();
             JOptionPane.showMessageDialog(null, "Receptionist request declined and removed from the system!");

         } catch (SQLException | ClassNotFoundException e) {
             System.out.println(e.getMessage());
         }
     }

     public ArrayList<String> retrieveUsersWithRole(String role) throws ClassNotFoundException{

     	String sql = "SELECT * FROM User where Status = 0 AND Role = '" + role + "'";

     	 ArrayList<String> users = new ArrayList<String>();


     	 try (Connection conn = this.connect();
                  Statement stmt  = conn.createStatement();
                  ResultSet rs    = stmt.executeQuery(sql)){

     		 while (rs.next()){

 //             	setIDNumber(rs.getInt(1));
 //             	setFullName(rs.getString(2));
 //             	setUsername(rs.getString(3));
 //             	setPassword(rs.getString(4));
 //             	setEmailAddress(rs.getString(5));
 //             	setRole(rs.getString(6));
 //             	setUserStatus(rs.getInt(7));

 //    			 user.IDNumber = rs.getInt(1);
 //    			 user.fullName = rs.getString(2);
 //    			 user.userName = rs.getString(3);
 //    			 user.password = rs.getString(4);
 //    			 user.emailAddress = rs.getString(5);
 //    			 user.role = rs.getString(6);
 //    			 user.status = rs.getInt(7);

     			 users.add(rs.getString(2));
     		 }


     	 } catch (SQLException e) {

          	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
          }

     	 return users;
 }
     
    public boolean verifyAccount(String username, String password) throws ClassNotFoundException{

    	String sql = "SELECT * FROM User where Username = '" + username + "'";
    	boolean loginCheck = false;
    	
    	 try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){
    		 	if(rs.isBeforeFirst() == true && rs.getString("Password").equals(password)){
                	loginCheck = true;
                	setIDNumber(rs.getInt(1));
                	setFullName(rs.getString(2));
                	setUsername(rs.getString(3));
                	setPassword(rs.getString(4));
                	setEmailAddress(rs.getString(5));
                	setRole(rs.getString(6));
                	setUserStatus(rs.getInt(7));
                	
                	JOptionPane.showMessageDialog(null, "Authentication is OK!");
                	if(rs.getInt(7) == 0){
 						JOptionPane.showMessageDialog(null, "Your approval is in progress. Please contact to Hotel manager.", "Warning", JOptionPane.WARNING_MESSAGE);
 						return false;
 					}
                }
    		 	else{
 					JOptionPane.showMessageDialog(null, "Authentication denied! "
 							+ "The username or password has been refused by System."
 							+ " Please try again.");
 				}
                
            } catch (SQLException e) {
            	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
    	return loginCheck;
    }
    
    public int getIDNumber(){
    	return IDNumber;
    }
    public String getFullName(){
    	return fullName;
    }
    public String getUsername(){
    	return username;
    }
    public String getEmailAddress(){
    	return emailAddress;
    }
    public String getRole(){
    	return role;
    }
    public int getUserStatus(){
     	return userStatus;
     }
    
    public void setIDNumber(int IDNumber){
    	DBSQLiteAdapter.IDNumber = IDNumber;
    }
    public void setFullName(String fullName){
    	DBSQLiteAdapter.fullName = fullName;
    }
    public void setUsername(String username){
    	DBSQLiteAdapter.username = username;
    }
    public void setPassword(String password){
    	DBSQLiteAdapter.password = password;
    }
    public void setEmailAddress(String emailAddress){
    	DBSQLiteAdapter.emailAddress = emailAddress;
    }
    public void setRole(String role){
    	DBSQLiteAdapter.role = role;
    }
    public void setUserStatus(int userStatus){
     	DBSQLiteAdapter.userStatus = userStatus;
     }
}
package domain;

import java.sql.*;

import javax.swing.JOptionPane;

public class DBSQLiteAdapter{

	String sql = null;
	private static int IDNumber;
	private static String fullName;
	private static String username;
	private static String password;
	private static String emailAddress;
	private static String role;
	
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
	
    public void insertUser(int IDNumber, String fullName, String username, String password, String emailAddress, String role){
    	sql = "INSERT INTO User VALUES(?,?,?,?,?,?);";
    	
    	try (Connection conn = this.connect();
    		PreparedStatement pst = conn.prepareStatement(sql)){
    			pst.setInt(1, IDNumber);
    			pst.setString(2,fullName);
    			pst.setString(3, username);
    			pst.setString(4, password);
    			pst.setString(5, emailAddress);
    			pst.setString(6, role);
        		
    			pst.executeUpdate();
        		pst.close();
        		//conn.commit();
        		conn.close();
        		JOptionPane.showMessageDialog(null, "You have successfully enrolled to HRS!");
        		
    		}catch (SQLException | ClassNotFoundException e) {
    	        System.err.println(e.getClass().getName() + ": " + e.getMessage());
    	        System.exit(0);
		}
    }
    
    public void updateUser(int IDNumber, String fullName, String username, String password, String emailAddress, String role){
//    	String sql = "UPDATE User SET Fullname = ? , "
//                + "Password = ? "
//                + "EmailAddress = ? "
//                + "WHERE IDNumber = ?";
    	
    	String sql = "UPDATE User SET Fullname = '"+fullName+"' ,Password = '"+password+"' ,EmailAddress = '"+emailAddress+"' WHERE IDNumber = "+IDNumber+"";
    	
        try (Connection conn = this.connect();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.execute();
    		JOptionPane.showMessageDialog(null, "User updated!");
    		setFullName(fullName);
    		setEmailAddress(emailAddress);
    		setPassword(password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
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
    
    public boolean verifyAccount(String username, String password) throws ClassNotFoundException{

    	String sql = "SELECT * FROM User where Username = '" + username + "'";
    	boolean loginCheck = false;
    	
    	 try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){
                if(rs.getString("Password").equals(password)){
                	loginCheck = true;
                	setIDNumber(rs.getInt(1));
                	setFullName(rs.getString(2));
                	setUsername(rs.getString(3));
                	setPassword(rs.getString(4));
                	setEmailAddress(rs.getString(5));
                	setRole(rs.getString(6));
                	
                	JOptionPane.showMessageDialog(null, "Authentication is OK!");
                }
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
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
}
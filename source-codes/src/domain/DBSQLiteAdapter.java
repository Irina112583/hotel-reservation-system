package domain;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;

public class DBSQLiteAdapter{

	User currentUser;
	 ArrayList<User> users = new ArrayList<User>();
	 
	 public DBSQLiteAdapter() {
		 int today = Integer.parseInt(DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH).format(java.time.LocalDate.now()));
		 setPassivePastRoomReservationsJob(today);
		 setPassivePastServiceReservationsJob(today);
	}
	 
	 // DB Connection Operations
	
	public Connection connect() throws ClassNotFoundException{
		
		Connection conn = null;
		String connUrl="jdbc:sqlite:HRSDB.db";
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn=DriverManager.getConnection(connUrl);

	       
		}  catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}
	
	//This method (job) automatically updates the past room reservations as passive. 
	private void setPassivePastRoomReservationsJob(int today){
	    String sql = "UPDATE Reservation SET Status = 0 WHERE OccupiedDate < '"+ today + "'";

        try (Connection conn = this.connect();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.execute();
        } catch (SQLException | ClassNotFoundException e) {
        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	//This method (job) automatically updates the past service reservations as passive. 
	private void setPassivePastServiceReservationsJob(int today){
	    String sql = "UPDATE ServiceReservations SET Status = 0 WHERE OccupiedDate < '"+ today + "'";

        try (Connection conn = this.connect();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.execute();
        } catch (SQLException | ClassNotFoundException e) {
        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	// User Operations...
	
	public User retrieveCurrentUser(){
		return currentUser;
	}
	
	public boolean insertUser(User u){
     	
		boolean inserted = false;
		String sql = "INSERT INTO User VALUES(?,?,?,?,?,?,?);";
     	
    	
    	try (Connection conn = this.connect();
    		PreparedStatement pst = conn.prepareStatement(sql)){
    			pst.setInt(1, u.getIDNumber());
    			pst.setString(2,u.getFullName());
    			pst.setString(3, u.getUsername());
    			pst.setString(4, u.getPassword());
    			pst.setString(5, u.getEmailAddress());
    			pst.setString(6, u.getRole());
    			pst.setInt(7, u.getUserStatus());
        		
    			pst.executeUpdate();
        		pst.close();
        		//conn.commit();
        		conn.close();
        		if (u.getUserStatus() == 0)
 					JOptionPane.showMessageDialog(null, "Your request was sent to Manager for approval.");
         		else{
         			inserted = true;
         			JOptionPane.showMessageDialog(null, "You have successfully enrolled to HRS!");
         		}
         			
        		
    		}catch (SQLException | ClassNotFoundException e) {
    			JOptionPane.showMessageDialog(null, "Some of information you entered is not suitable for registration. Check the fields and try again.", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		return inserted;
    }
    
    public void updateUser(User user){
    	
    	String sql = "UPDATE User SET Fullname = '"+ user.getFullName() +"' ,Password = '"+user.getPassword()+"' ,EmailAddress = '"+user.getEmailAddress()+"' WHERE IDNumber = "+user.getIDNumber()+"";
    	
        try (Connection conn = this.connect();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.execute();
    		
            JOptionPane.showMessageDialog(null, "User updated!");
    		
        } catch (SQLException | ClassNotFoundException e) {
        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void approveReceptionist(int IDNumber){
    String sql = "UPDATE User SET Status = 1 WHERE IDNumber = '"+ IDNumber + "'";

        try (Connection conn = this.connect();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.execute();
    		JOptionPane.showMessageDialog(null, "User approved!");
        } catch (SQLException | ClassNotFoundException e) {
        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteUser(int IDNumber){
    	String sql = "DELETE FROM User WHERE IDNumber = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, IDNumber);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "The account is deleted from the system!");

        } catch (SQLException | ClassNotFoundException e) {
        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<User> retrieveUsersWithRole(String role){

     	String sql = "SELECT * FROM User where Role = '" + role + "'";

     	 try (Connection conn = this.connect();
                  Statement stmt  = conn.createStatement();
                  ResultSet rs    = stmt.executeQuery(sql)){

     		 while (rs.next()){
     			
     			User tmpUser = new User();
     			
     			tmpUser.setIDNumber(rs.getInt(1));
     			tmpUser.setFullName(rs.getString(2));
     			tmpUser.setUsername(rs.getString(3));
     			tmpUser.setPassword(rs.getString(4));
     			tmpUser.setEmailAddress(rs.getString(5));
     			tmpUser.setRole(rs.getString(6));
     			tmpUser.setUserStatus(rs.getInt(7));
     			users.add(tmpUser);
     		 }
     	 } catch (SQLException | ClassNotFoundException e) {

          	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
          }

     	 return users;
 }
    
    public User retrieveUserWithID(int userID){

     	String sql = "SELECT * FROM User where IDNumber = '" + userID + "';";
     	User tmpUser = new User();

     	 try (Connection conn = this.connect();
                  Statement stmt  = conn.createStatement();
                  ResultSet rs    = stmt.executeQuery(sql)){

     		 while (rs.next()){
     			tmpUser.setIDNumber(rs.getInt(1));
     			tmpUser.setFullName(rs.getString(2));
     			tmpUser.setUsername(rs.getString(3));
     			tmpUser.setPassword(rs.getString(4));
     			tmpUser.setEmailAddress(rs.getString(5));
     			tmpUser.setRole(rs.getString(6));
     			tmpUser.setUserStatus(rs.getInt(7));
     		 }
     	 } catch (SQLException | ClassNotFoundException e) {

          	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
          }

     	 return tmpUser;
 }
     
    public boolean verifyAccount(String username, String password) throws ClassNotFoundException{

    	String sql = "SELECT * FROM User where Username = '" + username + "'";
    	boolean loginCheck = false;
   	
    	 try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){
    		 	if(rs.isBeforeFirst() == true && rs.getString("Password").equals(password)){
                	loginCheck = true;
                	
                	currentUser = new User();
                	
                	currentUser.setIDNumber(rs.getInt(1));
                	currentUser.setFullName(rs.getString(2));
                	currentUser.setUsername(rs.getString(3));
                	currentUser.setPassword(rs.getString(4));
                	currentUser.setEmailAddress(rs.getString(5));
                	currentUser.setRole(rs.getString(6));
                	currentUser.setUserStatus(rs.getInt(7));
                	
                	
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
            	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
    	return loginCheck;
    }
    
    //Room Operations
    
    public ArrayList<Integer> getAllRoomsInTheHotel(){
    	
    	String sql = "SELECT * FROM Room;";
    	ArrayList<Integer> rooms = new ArrayList<Integer>();

    	 try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){

    		 while (rs.next()){
    				rooms.add(rs.getInt(2));
    			}

    	 } catch (SQLException | ClassNotFoundException e) {

         	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
         }

    	
    	return rooms;    	
    }
       
    public ArrayList<Integer> getFreeRooms(ArrayList<Integer> dates) {
    	
    	String sql = "SELECT OccupiedRoom FROM Reservation WHERE OccupiedDate=?;";
    	ArrayList<Integer> occupiedRooms = new ArrayList<Integer>();
    	ArrayList<Integer> freeRooms = new ArrayList<Integer>();

    	try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for(int i=0; i< dates.size(); i++){
            	pstmt.setInt(1, dates.get(i));
            	ResultSet rs = pstmt.executeQuery();
            	while(rs.next()){
            		occupiedRooms.add(rs.getInt(1));
            	}
            }

    	 } catch (SQLException | ClassNotFoundException e) {

    		 e.printStackTrace();
         	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
         }

    	freeRooms = getAllRoomsInTheHotel();
    	freeRooms.removeAll(occupiedRooms);
   	
    	return freeRooms;    	
   	 	
    }
    
    public boolean makeRoomReservation(int roomNumber, ArrayList<Integer> reservationDates) {
    	
    	boolean result = false;
    	
    	if(checkAvailableEntryCard() != 0){
    		
    	int cardNumber = assignEntryCard(currentUser.getIDNumber());
    	
    	String sql = "INSERT INTO Reservation (OccupiedDate, OccupiedRoom, OccupiedBy, EntryCard, Status, isCanceled) VALUES(?,?,?,?,?,?);";
    	try (Connection conn = this.connect();
        		PreparedStatement pst = conn.prepareStatement(sql)){
        			
    		for (int i = 0; i<reservationDates.size();i++){
    		        pst.setInt(1, reservationDates.get(i));
        			pst.setInt(2, roomNumber);
        			pst.setInt(3, currentUser.getIDNumber());
        			pst.setInt(4, cardNumber);
        			pst.setInt(5, 1); // Set status to 1
        			pst.setInt(6, 0); // isCanceled 0 for the first time.
        			pst.executeUpdate();
    		}
            		pst.close();
            		
            		conn.close();
            		result = true;
            		
            		JOptionPane.showOptionDialog(null, "Reservation is successfully completed. Please ask receptionst for you entry card.", "Reservation Complete!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
            		
        		}catch (SQLException | ClassNotFoundException e) {
        			JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    	return result;
    }
    
    public boolean makeRoomReservation(int userID, int roomNumber, ArrayList<Integer> reservationDates) {
    	
    	boolean result = false; 
    	if(checkAvailableEntryCard() != 0){
    		
    	int cardNumber = assignEntryCard(userID);
    		
    	String sql = "INSERT INTO Reservation (OccupiedDate, OccupiedRoom, OccupiedBy, EntryCard, Status, isCanceled) VALUES(?,?,?,?,?,?);";
    	
    	try (Connection conn = this.connect();
        		PreparedStatement pst = conn.prepareStatement(sql)){
    		
    		for (int i = 0; i<reservationDates.size();i++){
    		        pst.setInt(1, reservationDates.get(i));
        			pst.setInt(2, roomNumber);
        			pst.setInt(3, userID);
        			pst.setInt(4, cardNumber);
        			pst.setInt(5, 1); // Set status to 1
        			pst.setInt(6, 0); // isCanceled 0 for the first time.
        			pst.executeUpdate();
    		}
            		pst.close();
            		conn.close();
            		result = true;
            		JOptionPane.showOptionDialog(null, "Reservation is successfully completed. User entry card number is " + cardNumber, "Reservation Complete!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
            		
        		}catch (SQLException | ClassNotFoundException e) {
        			JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    	return result;
    }
    
    private int assignEntryCard(int userID){
    	
    	int cardNumber = checkAvailableEntryCard();
    	
    	String sql ="UPDATE EntryCard SET AssignedUserID = " + userID + " WHERE CardNumber IN (SELECT CardNumber FROM EntryCard WHERE AssignedUserID is NULL LIMIT 1);";

    	try (Connection conn = this.connect();
    	    PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.execute();
            System.out.println("The entry card " + cardNumber + " is assigned to the user with ID " + userID);
    	}
            catch (SQLException | ClassNotFoundException e) {

        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	
		return cardNumber;
    }
    
    private int checkAvailableEntryCard(){
    	String sql = "SELECT CardNumber FROM EntryCard WHERE AssignedUserID is NULL LIMIT 1"; 
    	int cardNumber = 0;
    	
    	try (Connection conn = this.connect();
                Statement stmt  = conn.createStatement();
                ResultSet rs   = stmt.executeQuery(sql)){

    	if(rs.next()){
   				cardNumber = rs.getInt(1);

    	}
    	else {
    		JOptionPane.showMessageDialog(null, "There is no available entry card. Please try again later or contact to administrator.", "Warning", JOptionPane.WARNING_MESSAGE);
    		
    	}

   	 } catch (SQLException | ClassNotFoundException e) {

        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    	
		return cardNumber;
    }
   
    public ArrayList<Reservation> retrieveReservations(int status){
    	
    	ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
    	
     	String sql = "SELECT * FROM Reservation where Status = '" + status + "'";

    	 try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){

    		 while (rs.next()){
    			
    			Reservation tmpRes = new Reservation();
    			
    			tmpRes.setReservationID(rs.getInt(1));
    			tmpRes.setOccupiedDate(rs.getInt(2));
    			tmpRes.setOccupiedRoom(rs.getInt(3));
    			tmpRes.setOccupiedBy(rs.getInt(4));
    			tmpRes.setEntryCard(rs.getInt(5));
    			tmpRes.setStatus(rs.getInt(6));
    			reservationList.add(tmpRes);
    		 }


    	 } catch (SQLException | ClassNotFoundException e) {

         	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
         }

    	 return reservationList;
    }
    
    public boolean cancelReservation(int reservationID, int entryCard){
    	
    	boolean isCanceled = false;
    	String sql ="UPDATE Reservation SET Status = 0, isCanceled = 1 WHERE ID = " + reservationID;

    	try (Connection conn = this.connect();
    	    PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.execute();
            JOptionPane.showOptionDialog(null, "Reservation is successfully canceled!", "Reservation Canceled!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
            isCanceled = true;
            conn.close();
            checkEntryCardinUsed(entryCard);            
               
    	}
            catch (SQLException | ClassNotFoundException e) {

        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	
		return isCanceled;
    }
    
    //if the related entryCard is not in any reservation, delete in the entry card to revoke it from the assigned user 
    private void checkEntryCardinUsed(int entryCard){
    	
     	String sql = "SELECT * FROM Reservation where Status = 1 AND EntryCard = " + entryCard;
     	
    	try (Connection conn = this.connect();
    			PreparedStatement pstmt = conn.prepareStatement(sql);
    		    ResultSet rs = pstmt.executeQuery()){
    				if(!rs.next()){
    					releaseEntryCard(entryCard);
    				}
    				conn.close();
    	
   	 		} catch (SQLException | ClassNotFoundException e) {

        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void releaseEntryCard(int entryCard){

    	 String sql ="UPDATE EntryCard SET AssignedUserID = NULL WHERE CardNumber = " + entryCard;

     	try (Connection conn = this.connect();
     	    PreparedStatement pst = conn.prepareStatement(sql)) {
             pst.execute();
             JOptionPane.showOptionDialog(null, "The entry card " + entryCard + " is now available. This entry card can be used for the next reservation.", "Entry Card Revoked!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
             conn.close();
             	}
     		
             catch (SQLException | ClassNotFoundException e) {

         	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
     	}
    }
    
    public void updateRoom(int resID, int newRoom){
   	 
    	String sql ="UPDATE Reservation SET OccupiedRoom = " + newRoom + " WHERE ID = " + resID;

    	try (Connection conn = this.connect();
    	    PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.execute();
            JOptionPane.showOptionDialog(null, "The room is updated. The new room for the selected date is " + newRoom + ".", "Room Updated!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
            conn.close();
            	}
    		
            catch (SQLException | ClassNotFoundException e) {

        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }

    public Reservation getRoomReservation(int roomNumber, int date, int status){
    	
    	Reservation  res = new Reservation();
    	
     	String sql = "SELECT * FROM Reservation where Status = " + status + " AND OccupiedRoom = " + roomNumber + " AND OccupiedDate = " + date;

    	 try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){

    		 while (rs.next()){
    			 res.setReservationID(rs.getInt(1));
    			 res.setOccupiedDate(rs.getInt(2));
    			 res.setOccupiedRoom(rs.getInt(3));
    			res.setOccupiedBy(rs.getInt(4));
    			res.setEntryCard(rs.getInt(5));
    			res.setStatus(rs.getInt(6));
    		 }


    	 } catch (SQLException | ClassNotFoundException e) {

         	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
         }

    	 return res;	
    }
    
   public ArrayList<Reservation> getRoomReservations(int userID){
    	
    	ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
    	
     	String sql = "SELECT * FROM Reservation where Status = 1 AND OccupiedBy = '" + userID + "'";

    	 try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){

    		 while (rs.next()){
    			
    			Reservation tmpRes = new Reservation();
    			
    			tmpRes.setReservationID(rs.getInt(1));
    			tmpRes.setOccupiedDate(rs.getInt(2));
    			tmpRes.setOccupiedRoom(rs.getInt(3));
    			tmpRes.setOccupiedBy(rs.getInt(4));
    			tmpRes.setEntryCard(rs.getInt(5));
    			tmpRes.setStatus(rs.getInt(6));
    			reservationList.add(tmpRes);
    		 }

    	 } catch (SQLException | ClassNotFoundException e) {

         	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
         }

    	 return reservationList;
    }
   
   
   public boolean makeCleaningReservation(int serviceType, int userID, int occupiedDate, int timeSlotID, int cardNumber, int roomNumber) {
   	
   	boolean result = false;
   	
   	if(checkAvailableEntryCard() != 0){
   	
   	String sql = "INSERT INTO ServiceReservations (ServiceType, OccupiedDate, Timeslot, OccupiedBy, OccupiedRoom, EntryCard, Status, isCanceled) VALUES(?,?,?,?,?,?,?,?);";
   	try (Connection conn = this.connect();
       		PreparedStatement pst = conn.prepareStatement(sql)){
       			
   				
   				pst.setInt(1, 1); // Set 1. 1 = Cleaning service
   		        pst.setInt(2, occupiedDate);
       			pst.setInt(3, timeSlotID);
       			pst.setInt(4, userID);
       			pst.setInt(5, roomNumber);
       			pst.setInt(6, cardNumber); 
       			pst.setInt(7, 1); // Set status to 1
       			pst.setInt(8, 0); // isCanceled field is 0 in the first creation.
       			pst.executeUpdate();
   		
           		pst.close();
           		conn.close();
           		result = true;
           		
           		JOptionPane.showOptionDialog(null, "You have made a cleaning reservation for selected date and time.", "Cleaning Reservation Completed!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
           		
       		}catch (SQLException | ClassNotFoundException e) {
       			JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
   		}
   	}
   	return result;
   }
 
   public ArrayList<domain.ReservationForServices> getUserServiceReservations(int userID){
	   ArrayList<ReservationForServices> rfsList = new ArrayList<>();
	   String sql = "SELECT * FROM ServiceReservations WHERE Status = 1 AND OccupiedBy = " + userID;
	   
   	try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
		 while (rs.next()){
			 
			 ReservationForServices rfs = new ReservationForServices();
			 	rfs.setReservationID(rs.getInt(1));
			 	rfs.setServiceType(rs.getInt(2));
			 	rfs.setOccupiedDate(rs.getInt(3));
			 	rfs.setTimeSlotID(rs.getInt(4));
			 	rfs.setOccupiedBy(rs.getInt(5));
			 	rfs.setOccupiedRoom(rs.getInt(6));
			 	rfs.setEntryCard(rs.getInt(7));
			 	rfs.setStatus(rs.getInt(8));
			 	rfs.setIsCanceled(rs.getInt(9));
			 	
			 	rfsList.add(rfs);
	
		 }
	} catch (SQLException | ClassNotFoundException e) {

    	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    }
	   
	return rfsList;
	   
   }
   
   public Timeslot getTimeSlot(int timeSlotId){
	   
	   String sql = "SELECT * FROM Timeslot WHERE ID = " + timeSlotId;
	   Timeslot ts = new Timeslot();
	   
   	try (Connection conn = this.connect();
               Statement stmt  = conn.createStatement();
               ResultSet rs    = stmt.executeQuery(sql)){
  		 while (rs.next()){
  				ts.setIDNumber(rs.getInt(1));
 		 		ts.setTimeSlot(rs.getString(2));
  			}
   	} catch (SQLException | ClassNotFoundException e) {

       	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
       }
	return ts;
   }

   public ArrayList<Timeslot> getAvailableTimeSlots(int entryCardNumber, int date){
   
    	String sql = "SELECT * FROM Timeslot;";
    	
    	ArrayList<Integer> reservedTimeSlots = getReservedTimeSlots(date);
    	ArrayList<Timeslot> tsList = new ArrayList<>();
   	 
    	try (Connection conn = this.connect();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
   		 while (rs.next()){
   			 
   			Timeslot ts = new Timeslot();
   				
   				ts.setIDNumber(rs.getInt(1));
  		 		ts.setTimeSlot(rs.getString(2));
  		 		tsList.add(ts);
  		 		
   			for(int i=0;i<reservedTimeSlots.size();i++){
   				if(rs.getInt(1) == reservedTimeSlots.get(i)){
   					tsList.remove(ts);
   				}
   			}
   			
   		 }
    	} catch (SQLException | ClassNotFoundException e) {

        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
	return tsList;
   }
   
   private ArrayList<Integer> getReservedTimeSlots(int date){
	   
  	 	String sql = "SELECT TimeSlot FROM ServiceReservations WHERE Status = 1 AND OccupiedDate = " + date;
		ArrayList<Integer> occupiedTimeSlots = new ArrayList<Integer>();

		try (Connection conn = this.connect();
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
				occupiedTimeSlots.add(rs.getInt(1));
	        	}

		 } catch (SQLException | ClassNotFoundException e) {

			 e.printStackTrace();
	     	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
	     }
		return occupiedTimeSlots;
   }
   
   public void updateCleaningReservation(int entryCardNumber, int newDate, int newTimeSlot, int oldDate, int oldTimeSlot){
	   	 
   	String sql ="UPDATE ServiceReservations SET OccupiedDate = " + newDate + ", TimeSlot = " + newTimeSlot + " WHERE EntryCard = " + entryCardNumber + " AND OccupiedDate = " + oldDate + " AND TimeSlot = " + oldTimeSlot;

   	try (Connection conn = this.connect();
   	    PreparedStatement pst = conn.prepareStatement(sql)) {
           pst.execute();
           JOptionPane.showOptionDialog(null, "The cleaning reservation is updated.", "Room Updated!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
           conn.close();
           	}
   		
           catch (SQLException | ClassNotFoundException e) {

       	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
   	}
   }
   
   public boolean cancelCleaningReservation(int serviceResID){
	   
   	String sql = "UPDATE ServiceReservations SET isCanceled = 1, Status = 0 WHERE ID = ?";
   	boolean isCanceled = false;

    try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, serviceResID);
        pstmt.executeUpdate();
        isCanceled = true;
        JOptionPane.showMessageDialog(null, "The service reservation is canceled.");

    } catch (SQLException | ClassNotFoundException e) {
    	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator. Error details: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    }
	   return isCanceled;
   }
   
   //Fee Operations
   
   public int getRoomFee(int roomID){
 	 	
	    String sql = "SELECT RoomFee FROM Room WHERE RoomNumber = " + roomID;
		int roomFee = 0;

		try (Connection conn = this.connect();
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
				roomFee = rs.getInt(1);
	        	}

		 } catch (SQLException | ClassNotFoundException e) {

			 e.printStackTrace();
	     	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
	     }
		return roomFee;
   }
   
   public ArrayList<Reservation> GetUserNotCanceledRoomReservations(int userID){
   	
   	ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
   	
    	String sql = "SELECT * FROM Reservation where isCanceled = 0 AND OccupiedBy = '" + userID + "'";

   	 try (Connection conn = this.connect();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){

   		 while (rs.next()){
   			
   			Reservation tmpRes = new Reservation();
   			
   			tmpRes.setReservationID(rs.getInt(1));
   			tmpRes.setOccupiedDate(rs.getInt(2));
   			tmpRes.setOccupiedRoom(rs.getInt(3));
   			tmpRes.setOccupiedBy(rs.getInt(4));
   			tmpRes.setEntryCard(rs.getInt(5));
   			tmpRes.setStatus(rs.getInt(6));
   			reservationList.add(tmpRes);
   		 }

   	 } catch (SQLException | ClassNotFoundException e) {

        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

   	 return reservationList;
   }
   
   public ArrayList<domain.ReservationForServices> GetUserNotCanceledServiceReservations(int userID){
	   	
	   	ArrayList<domain.ReservationForServices> serviceReservationList = new ArrayList<domain.ReservationForServices>();
	   	
	    	String sql = "SELECT * FROM ServiceReservations where isCanceled = 0 AND OccupiedBy = '" + userID + "'";

	   	 try (Connection conn = this.connect();
	                Statement stmt  = conn.createStatement();
	                ResultSet rs    = stmt.executeQuery(sql)){

	   		 while (rs.next()){
	   			
	   			domain.ReservationForServices tmpRes = new domain.ReservationForServices();
	   			
	   			tmpRes.setReservationID(rs.getInt(1));
	   			tmpRes.setServiceType(rs.getInt(2));
	   			tmpRes.setOccupiedDate(rs.getInt(3));
	   			tmpRes.setTimeSlotID(rs.getInt(4));
	   			tmpRes.setOccupiedBy(rs.getInt(5));
	   			tmpRes.setOccupiedRoom(rs.getInt(6));
	   			tmpRes.setEntryCard(rs.getInt(7));
	   			tmpRes.setStatus(rs.getInt(8));
	   			tmpRes.setIsCanceled(rs.getInt(9));
	   			serviceReservationList.add(tmpRes);
	   		 }

	   	 } catch (SQLException | ClassNotFoundException e) {

	        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
	        }

	   	 return serviceReservationList;
	   }
   
   public int getServiceFee(String serviceName){
	 	
	    String sql = "SELECT ServiceFee FROM Services WHERE ServiceType = '" + serviceName + "'";
		int serviceFee = 0;

		try (Connection conn = this.connect();
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					serviceFee = rs.getInt(1);
	        	}

		 } catch (SQLException | ClassNotFoundException e) {

			 e.printStackTrace();
	     	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
	     }
		return serviceFee;
  }
   
   public void payCashForRoomReservation(int userID, int roomNumber){
	   	 
	   	String sql ="UPDATE Reservation SET isCanceled =  1 WHERE OccupiedBy = " + userID + " AND OccupiedRoom = " + roomNumber;

	   	try (Connection conn = this.connect();
	   	    PreparedStatement pst = conn.prepareStatement(sql)) {
	           pst.execute();
	           JOptionPane.showOptionDialog(null, "Cash payment for room reservation is successfully done!.", "Cash payment completed!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
	           conn.close();
	           	}
	   		
	           catch (SQLException | ClassNotFoundException e) {

	       	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
	   	}
	   }
   
   public void payCashForServiceReservation(int userID, int roomNumber){
	   	 
	   	String sql ="UPDATE ServiceReservations SET isCanceled =  1 WHERE OccupiedBy = " + userID + " AND OccupiedRoom = " + roomNumber;

	   	try (Connection conn = this.connect();
	   	    PreparedStatement pst = conn.prepareStatement(sql)) {
	           pst.execute();
	           JOptionPane.showOptionDialog(null, "Cash payment for service reservation is successfully done!.", "Cash payment completed!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
	           conn.close();
	           	}
	   		
	           catch (SQLException | ClassNotFoundException e) {

	       	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
	   	}
	   }
   
   public ArrayList<domain.ReservationForServices> retrieveServiceReservations(int status){
	   ArrayList<domain.ReservationForServices> serviceReservationList = new ArrayList<domain.ReservationForServices>();
   	
    	String sql = "SELECT * FROM ServiceReservations where Status = '" + status + "'";

   	 try (Connection conn = this.connect();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){

   		 while (rs.next()){
   			
   			domain.ReservationForServices tmpRes = new domain.ReservationForServices();
   			
   			tmpRes.setReservationID(rs.getInt(1));
   			tmpRes.setServiceType(rs.getInt(2));
   			tmpRes.setOccupiedDate(rs.getInt(3));
   			tmpRes.setTimeSlotID(rs.getInt(4));
   			tmpRes.setOccupiedBy(rs.getInt(5));
   			tmpRes.setOccupiedRoom(rs.getInt(6));
   			tmpRes.setEntryCard(rs.getInt(7));
   			tmpRes.setStatus(rs.getInt(8));
   			tmpRes.setIsCanceled(rs.getInt(9));
   			serviceReservationList.add(tmpRes);
   		 }

   	 } catch (SQLException | ClassNotFoundException e) {

        	JOptionPane.showMessageDialog(null, "An error occured! Please contact to system administrator." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

   	 return serviceReservationList;
   }
   
}
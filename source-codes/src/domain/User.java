package domain;


public class User {
	
	private int IDNumber;
	private String fullName;
	private String username;
	private String password;
	private String emailAddress;
	private String role;
	private int userStatus;
	
    public int getIDNumber(){
    	return IDNumber;
    }
    public String getFullName(){
    	return fullName;
    }
    public String getUsername(){
    	return username;
    }
    public String getPassword(){
    	return password;
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
    	this.IDNumber = IDNumber;
    }
    public void setFullName(String fullName){
    	this.fullName = fullName;
    }
    public void setUsername(String username){
    	this.username = username;
    }
    public void setPassword(String password){
    	this.password = password;
    }
    public void setEmailAddress(String emailAddress){
    	this.emailAddress = emailAddress;
    }
    public void setRole(String role){
    	this.role = role;
    }
    public void setUserStatus(int userStatus){
    	this.userStatus = userStatus;
     }

}

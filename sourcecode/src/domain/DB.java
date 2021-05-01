package domain;

public class DB {
	
	private static DB uniqueDatainstance;
	
	private long ID = 10000000011L;
	private String fullName = "Manager";
	private String username = "admin";
	private String emailAddress = "admin@hrs.com";
	private String role = "Manager";
	private String password = "admin";
	
	private DB() {
	}
	
	public static synchronized DB getDataInstance(){
		if(uniqueDatainstance== null){
			uniqueDatainstance = new DB();			
		}
		return uniqueDatainstance;
	}
	
	public long getID() {
		return ID;
	}
	public String getFullName() {
		return fullName;
	}
	public String getUsername() {
		return username;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getRole() {
		return role;
	}
	public String getPassword() {
		return password;
	}
	
	
	/****************/

	
	public void setID(long ID) {
		this.ID = ID;
	}
	public void setName(String fullName) {
		this.fullName = fullName;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

package domain;


public class Timeslot {
	
	private int IDNumber;
	private String timeSlot;
	
    public int getIDNumber(){
    	return IDNumber;
    }
    public String getTimeSlot(){
    	return timeSlot;
    }
    
    public void setIDNumber(int id){
    	this.IDNumber = id;
    }
    public void setTimeSlot(String timeSlot){
    	this.timeSlot = timeSlot;
    }	
}

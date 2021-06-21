package domain;


public class Reservation {
	
	private int reservationID;
	private int occupiedDate;
	private int occupiedRoom;
	private int occupiedBy;
	private int entryCard;
	private int status;
	private int isCanceled;
	
    public int getReservationID(){
    	return reservationID;
    }
    public int getOccupiedDate(){
    	return occupiedDate;
    }
    public int getOccupiedRoom(){
    	return occupiedRoom;
    }
    public int getOccupiedBy(){
    	return occupiedBy;
    }
    public int getEntryCard(){
    	return entryCard;
    }
    public int getStatus(){
    	return status;
    }
    public int getIsCanceled(){
    	return isCanceled;
    }
 
    public void setReservationID(int reservationID){
    	this.reservationID = reservationID;
    }
    public void setOccupiedDate(int occupiedDate){
    	this.occupiedDate = occupiedDate;
    }
    public void setOccupiedRoom(int occupiedRoom){
    	this.occupiedRoom = occupiedRoom;
    }
    public void setOccupiedBy(int occupiedBy){
    	this.occupiedBy = occupiedBy;
    }
    public void setEntryCard(int entryCard){
    	this.entryCard = entryCard;
    }
    public void setStatus(int status){
    	this.status = status;
    }
    public void setIsCanceled(int isCanceled){
    	this.isCanceled = isCanceled;
    }
}

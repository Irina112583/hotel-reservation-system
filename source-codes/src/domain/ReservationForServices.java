package domain;


public class ReservationForServices {
	
	private int reservationID;
	private int serviceType;
	private int occupiedDate;
	private int occupiedBy;
	private int occupiedRoom;
	private int entryCard;
	private int timeSlot;
	private int status;
	private int isCanceled;
	
    public int getReservationID(){
    	return reservationID;
    }
    public int getServiceType(){
    	return serviceType;
    }
    public int getOccupiedDate(){
    	return occupiedDate;
    }
    public int getOccupiedBy(){
    	return occupiedBy;
    }
    public int getOccupiedRoom(){
    	return occupiedRoom;
    }
    public int getEntryCard(){
    	return entryCard;
    }
    public int getTimeSlotID(){
    	return timeSlot;
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
    public void setServiceType(int serviceType){
    	this.serviceType = serviceType;
    }
    public void setOccupiedDate(int occupiedDate){
    	this.occupiedDate = occupiedDate;
    }
    public void setOccupiedBy(int occupiedBy){
    	this.occupiedBy = occupiedBy;
    }
    public void setOccupiedRoom(int occupiedRoom){
    	this.occupiedRoom = occupiedRoom;
    }
    public void setEntryCard(int entryCard){
    	this.entryCard = entryCard;
    }
    public void setTimeSlotID(int timeSlot){
    	this.timeSlot = timeSlot;
    }
    public void setStatus(int status){
    	this.status = status;
    }
    public void setIsCanceled(int isCanceled){
    	this.isCanceled = isCanceled;
    }
}

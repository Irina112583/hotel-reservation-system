package domain;

public class Cleaning implements Reservation {
	
	private Hotel hotel;
	
	public Cleaning(Hotel h)
	{
		hotel = h;
	}
	
	public boolean makeReservation(int cleaningDate, int cleaningSlot, int roomNumber,int cardNumber)
	{
		if(hotel.cleaningTimeSlots.containsKey(cleaningDate))
		{
			return hotel.cleaningTimeSlots.get(cleaningDate).fillSlot(cardNumber,roomNumber, cleaningSlot);
			
		}
		else {
			return false;
		}
		
	}

	public boolean updateReservation(int cleaningDate, int oldCleaningSlot, int newCleaningSlot, int roomNumber,int cardNumber)
	{
		if(hotel.cleaningTimeSlots.containsKey(cleaningDate))
		{
			if(hotel.cleaningTimeSlots.get(cleaningDate).cancelSlot(cardNumber, oldCleaningSlot))
			{
				return hotel.cleaningTimeSlots.get(cleaningDate).fillSlot(cardNumber,roomNumber, newCleaningSlot);
			}
			else
			{
				return false;
			}
			
		}
		else {
			return false;
		}
	}

	public  boolean deleteReservation(int cleaningDate,int cleaningSlot,int cardNumber)
	{
		return hotel.cleaningTimeSlots.get(cleaningDate).cancelSlot(cardNumber, cleaningSlot);
	}
	

	public int getReservationCharge(int cardNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getReservationDetail(int cardNumber)
	{
		return "Cleaning Reservation";
	}


}

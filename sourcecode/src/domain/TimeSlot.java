package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class TimeSlot {
	
	private ArrayList<HashMap<Integer, Integer>> reservedCleanings= new ArrayList<HashMap<Integer, Integer>>();
	private int counter[] = new int[10];
	private final int reservationCount = 3;
	
	public boolean fillSlot(int cardNumber, int roomId, int slotNumber) {
		if(counter[slotNumber] < reservationCount)
		{
			reservedCleanings.get(slotNumber).put(cardNumber, roomId);
			counter[slotNumber]++;
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	public boolean cancelSlot(int cardNumber,int slotNumber) {
		if(reservedCleanings.get(slotNumber).containsKey(cardNumber))
		{
			reservedCleanings.get(slotNumber).remove(cardNumber);
			counter[slotNumber]--;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int availableCountofSlot(int slotNumber) {
		return counter[slotNumber];
	}
}

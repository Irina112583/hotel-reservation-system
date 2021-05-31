package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class TimeSlot {
	
	private ArrayList<HashMap<Integer, Integer>> reservedCleanings= new ArrayList<HashMap<Integer, Integer>>();
	private int counter[] = new int[10];
	private final int reservationCount = 3;
	
	public boolean fillSlot(int cardNumber, int roomId, int slotNumber) {
		for (int i = 0; i < 10; i++) {
				reservedCleanings.add(new HashMap<Integer, Integer>());
			}
		
		if(counter[slotNumber] < reservationCount)
		{
			reservedCleanings.get(slotNumber).put(cardNumber, roomId);
			counter[slotNumber]++;
			System.out.println("You have sucessfully ordered an additional cleaning service for the room " + cardNumber + " for time slot number " + slotNumber);
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	public boolean cancelSlot(int cardNumber,int slotNumber) {
		for (int i = 0; i < 10; i++) {
			reservedCleanings.add(new HashMap<Integer, Integer>());
		}
		
		for (int i = 0; i < 10; i++) {
			reservedCleanings.add(new HashMap<Integer, Integer>());
		}
		
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

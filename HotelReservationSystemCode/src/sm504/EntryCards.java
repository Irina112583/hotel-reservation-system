package sm504;

import java.util.ArrayList;
import java.util.List;

public class EntryCards {
	static List<EntryCard> allEntryCards = new ArrayList<EntryCard>();
	
	public static EntryCard getCard(int roomNumber){
		for (int i = 0; i < allEntryCards.size()-1; i++) {
			if (allEntryCards.get(i).keyToRoom == roomNumber) {
				return allEntryCards.get(i);
			}
		}
		return null;
	}
}

package domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class HotelGuest extends User{
	
	EntryCard entryCard;
	
	
	public static Date readDate(Scanner sc, String format) throws ParseException{
	     return new SimpleDateFormat(format).parse(sc.nextLine());
	}
	
}

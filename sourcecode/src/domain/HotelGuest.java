package domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class HotelGuest extends User{
	
	public static Date readDate(Scanner sc, String format) throws ParseException{
	     return new SimpleDateFormat(format).parse(sc.nextLine());
	}
	
	public void makeRoomReservation() throws ParseException {
		Hotel.getFreeRooms();
		System.out.println("Please enter number of the room that you want to reserve");
		Scanner in = new Scanner(System.in);
		int roomNumber = in.nextInt();
		Date checkinDate = new Date();
		System.out.println(checkinDate);
		System.out.println("Please enter estimated checkout date in the following format YYYY-MM-DD: ");
		Date checkoutDate = readDate(in, "YYYY-MM-DD");
		Room room = new Room(roomNumber);
		room.reserve(roomNumber, checkinDate, checkoutDate);
	}
}

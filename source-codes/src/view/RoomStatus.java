package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import domain.Hotel;

import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class RoomStatus extends JFrame {


	/**
	 * 
	 */

	
	ArrayList<domain.Reservation> roomReservationList;
	ArrayList<domain.ReservationForServices> serviceReservationList;
	int roomFee = 0;
	int serviceFee = 0;
	int totalDebt = 0;
	int selectedRoom = 0;
	int today = Integer.parseInt(DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH).format(java.time.LocalDate.now()));
	
	public RoomStatus(Hotel hotel, domain.Reservation reservation) {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 643);
		JPanel pnlReservation = new JPanel();
		pnlReservation.setForeground(Color.RED);
		pnlReservation.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlReservation.setBackground(new Color(240, 240, 240));
		setContentPane(pnlReservation);
		pnlReservation.setLayout(null);
		
		JLabel currencyL_1 = new JLabel();
		currencyL_1.setText("TL");
		currencyL_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		currencyL_1.setEnabled(false);
		currencyL_1.setBounds(390, 272, 27, 34);
		pnlReservation.add(currencyL_1);
		
		JLabel lblCurrentDebt_1 = new JLabel();
		lblCurrentDebt_1.setText("-");
		lblCurrentDebt_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCurrentDebt_1.setEnabled(false);
		lblCurrentDebt_1.setBounds(284, 274, 89, 30);
		pnlReservation.add(lblCurrentDebt_1);
		JLabel lblGuest = new JLabel();
		
 		JSeparator separator = new JSeparator();
 		separator.setBounds(12, 65, 546, 8);
 		pnlReservation.add(separator);
 		
 		JLabel lblGuest_1 = new JLabel();
 		lblGuest_1.setText("-");
 		lblGuest_1.setFont(new Font("Tahoma", Font.BOLD, 15));
 		lblGuest_1.setEnabled(false);
 		lblGuest_1.setBounds(284, 224, 274, 30);
 		pnlReservation.add(lblGuest_1);
 		
 		JLabel lblCurrentAvailabilityStatus_1 = new JLabel();
 		lblCurrentAvailabilityStatus_1.setText("-");
 		lblCurrentAvailabilityStatus_1.setFont(new Font("Tahoma", Font.BOLD, 15));
 		lblCurrentAvailabilityStatus_1.setEnabled(false);
 		lblCurrentAvailabilityStatus_1.setBounds(284, 174, 274, 30);
 		pnlReservation.add(lblCurrentAvailabilityStatus_1);
 		
 		JLabel lblcurrentRoom_1 =new JLabel();
 		lblcurrentRoom_1.setText("-");
 		lblcurrentRoom_1.setFont(new Font("Tahoma", Font.BOLD, 15));
 		lblcurrentRoom_1.setEnabled(false);
 		lblcurrentRoom_1.setBounds(284, 120, 274, 30);
 		pnlReservation.add(lblcurrentRoom_1);
 		
 		JSeparator separator_1 = new JSeparator();
 		separator_1.setBounds(12, 537, 546, 8);
 		pnlReservation.add(separator_1);
 		
 		//***
 		
		 
		 lblGuest.setText("Guest:");
		 lblGuest.setBounds(64, 232, 191, 16);
		 pnlReservation.add(lblGuest);
		 
		 JLabel lblReservedDates = new JLabel();
		 lblReservedDates.setText("Reserved Dates:");
		 lblReservedDates.setBounds(64, 334, 191, 16);
		 pnlReservation.add(lblReservedDates);
		 
     	ArrayList<Integer> selectedResDate = new ArrayList<>();
     	selectedResDate.add(reservation.getOccupiedDate()); 
     	
		 
		 JButton btnBack = new JButton("Close");
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 	}
		 });
		 btnBack.setBounds(460, 558, 98, 25);
		 pnlReservation.add(btnBack);
		 
		 JLabel lblHeading = new JLabel("Room Status");
		 lblHeading.setForeground(SystemColor.textInactiveText);
		 lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		 lblHeading.setFont(new Font("Serif", Font.PLAIN, 20));
		 lblHeading.setBounds(12, 24, 546, 16);
		 pnlReservation.add(lblHeading);
		 
		 JLabel lblCurrentAvailabilityStatus = new JLabel();
		 lblCurrentAvailabilityStatus.setText("Current Availability Status:");
		 lblCurrentAvailabilityStatus.setBounds(64, 182, 191, 16);
		 pnlReservation.add(lblCurrentAvailabilityStatus);

		 
		 JLabel lblCurrentDebt = new JLabel();
		 lblCurrentDebt.setText("Current Debt:");
		 lblCurrentDebt.setBounds(64, 282, 191, 16);
		 pnlReservation.add(lblCurrentDebt);
		 
		 JLabel lblcurrentRoom = new JLabel();
		 lblcurrentRoom.setText("Current Room:");
		 lblcurrentRoom.setBounds(64, 128, 191, 16);
		 pnlReservation.add(lblcurrentRoom);
		 
		 //***
		 
		 String column[]={"Reservation Dates"};
		 DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		 JTable jtRoomsList=new JTable(tableModel);
		 jtRoomsList.setRowSelectionAllowed(false);
		 jtRoomsList.setShowGrid(false);
		 jtRoomsList.setTableHeader(null);
		 
		 tableModel.setRowCount(0);
     	 Object[] rowData;
     	 
     	ArrayList<Integer> resDates = hotel.getFreeRooms(selectedResDate);

			rowData = new Object[1];
			

		
		 
		 jtRoomsList.setBorder(new LineBorder(new Color(0, 0, 0)));
		 jtRoomsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 jtRoomsList.setBounds(462,95,295,300);          

		 JScrollPane spRoomsList=new JScrollPane(jtRoomsList);
		 spRoomsList.setLocation(284, 334);
		 spRoomsList.setSize(121, 125);
		 spRoomsList.setVisible(true);
		 jtRoomsList.setBounds(30,40,200,300);    
		 pnlReservation.add(spRoomsList);
		 
		 
		 roomReservationList = hotel.GetUserNotCanceledRoomReservations(reservation.getOccupiedBy());
		 selectedRoom = reservation.getOccupiedRoom();
		 
		 
		 
			for(int i = 0; i< roomReservationList.size();i++){
				
				rowData[0] = roomReservationList.get(i).getOccupiedDate();
				tableModel.addRow(rowData);
			}
			
		 
	 		for( int i = 0; i<roomReservationList.size();i++ )
	 		{
	 			if(roomReservationList.get(i).getOccupiedDate()<today && roomReservationList.get(i).getOccupiedRoom() == selectedRoom ){
	 				roomFee += hotel.getRoomFee(reservation.getOccupiedRoom());
	 			}
	 		}
	 		
//	 		for( int i = 0; i<serviceReservationList.size();i++ )
//	 		{
//	 			if(serviceReservationList.get(i).getOccupiedDate()<today && serviceReservationList.get(i).getOccupiedRoom() == selectedRoom ){
//	 				serviceFee += hotel.getServiceFee("Cleaning");
//	 			}
//	 		}
	 		
	 		
	 		lblcurrentRoom_1.setText(String.valueOf(reservation.getOccupiedRoom()));
	 		
			if(reservation.getStatus() == 1)
				lblCurrentAvailabilityStatus_1.setText("This room is NOT AVAILABLE now.");
			else
				lblCurrentAvailabilityStatus_1.setText("This room is AVAILABLE now.");
					
			lblGuest_1.setText(hotel.retrieveUserWithID(reservation.getOccupiedBy()).getFullName());
	 		
	 		totalDebt = roomFee + serviceFee;
	 		lblCurrentDebt_1.setText(String.valueOf(totalDebt));
	 		
	 	
	 		
	 		
	}
}

package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import domain.Hotel;
import domain.Reservation;
import domain.ReservationForServices;

import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ReservationMonitoring extends JFrame {


	/**
	 * 
	 */
	
	ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	ArrayList<domain.ReservationForServices> serviceReservationList = new ArrayList<domain.ReservationForServices>();
	ArrayList<Integer> roomList = new ArrayList<Integer>();
	domain.ReservationForServices rfs = new ReservationForServices();
	int currentDate = Integer.parseInt(DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH).format(java.time.LocalDate.now()));

	public ReservationMonitoring(Hotel hotel) {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 658);
		JPanel pnlReservations = new JPanel();
		pnlReservations.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlReservations.setBackground(Color.WHITE);
		setContentPane(pnlReservations);
		pnlReservations.setLayout(null);

		JLabel lblNoDataAvailable = new JLabel("No data available");
		 lblNoDataAvailable.setBounds(80, 87, 188, 34);
		 lblNoDataAvailable.setEnabled(false);
		 lblNoDataAvailable.setVisible(false);
		 lblNoDataAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoDataAvailable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 pnlReservations.add(lblNoDataAvailable);
		 
		 
		  
		 //Room Part
		 
		 String column[]={"Room Number", "Current Status"};         
		 DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		 JTable jtRoomList=new JTable(tableModel);
		 
		 
		 jtRoomList.setBorder(new LineBorder(new Color(0, 0, 0)));
		 jtRoomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 jtRoomList.setBounds(462,95,295,300);          

		 JScrollPane spRoomList=new JScrollPane(jtRoomList);
		 spRoomList.setLocation(12, 42);
		 spRoomList.setSize(346, 416);
		 spRoomList.setVisible(true);
		 
		 JLabel lblNoServiceDataAvailable = new JLabel("No data available");
		 lblNoServiceDataAvailable.setBounds(510, 87, 188, 34);
		 lblNoServiceDataAvailable.setEnabled(false);
		 lblNoServiceDataAvailable.setVisible(false);
		 lblNoServiceDataAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoServiceDataAvailable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 pnlReservations.add(lblNoServiceDataAvailable);
		 jtRoomList.setBounds(30,40,200,300);
		 pnlReservations.add(spRoomList);


		 Object[] roomData;


		 try {
			 
			 roomData = new Object[2];
			 roomList = hotel.getAllRoomsInTheHotel();
				for(int i = 0; i< roomList.size();i++){
					roomData[0] = roomList.get(i);
					if(hotel.getRoomReservation(roomList.get(i), currentDate,1).getStatus() == 1)
						roomData[1] = "NOT AVAILABLE";
					else
						roomData[1] = "Available";
					
						tableModel.addRow(roomData);
				}			
		 }
			finally{
			
			if(tableModel.getRowCount() == 0){
				lblNoDataAvailable.setVisible(true);
			}
			reservationList.clear();
		}
		 

		 
		 // Service Part

		 String columnService[]={"ID", "Active Reserved Dates", "Reserved Time Slots" };         
		 DefaultTableModel tableModelService = new DefaultTableModel(columnService, 0);
		 JTable jtServiceList=new JTable(tableModelService);
		 
		 jtServiceList.setBorder(new LineBorder(new Color(0, 0, 0)));
		 jtServiceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 jtServiceList.setBounds(462,95,295,300);        
		 jtServiceList.setBounds(30,40,200,300);
		 jtServiceList.removeColumn(jtServiceList.getColumnModel().getColumn(0)); // to hide ID in the table.

		 JScrollPane spServiceList=new JScrollPane(jtServiceList);
		 spServiceList.setLocation(438, 42);
		 spServiceList.setSize(346, 416);
		 spServiceList.setVisible(true);
		 
		 pnlReservations.add(spServiceList);
		 
		 Object[] serviceData;


		 try {
			 
			 serviceData = new Object[3];
			 serviceReservationList = hotel.retrieveServiceReservations(1);
			 
			 
				for(int i = 0; i< serviceReservationList.size();i++){
					serviceData[0] = serviceReservationList.get(i).getReservationID();
					serviceData[1] = serviceReservationList.get(i).getOccupiedDate();
					serviceData[2] = hotel.getTimeSlot(serviceReservationList.get(i).getTimeSlotID()).getTimeSlot();
					
					tableModelService.addRow(serviceData);
				}			
		 }
			finally{
			
			if(tableModelService.getRowCount() == 0){
				lblNoServiceDataAvailable.setVisible(true);
			}
			//serviceReservationList.clear();
		}
		 
		
		 JButton btnGetServiceDetails = new JButton("Get Detailed Information");
		 btnGetServiceDetails.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		if(jtServiceList.getSelectionModel().isSelectionEmpty() ) {
		 			JOptionPane.showMessageDialog(null, "Please select a service.", "Warning", JOptionPane.WARNING_MESSAGE);
		 			return;
		 		}
		 	
		 		int selectedResID = (int) jtServiceList.getModel().getValueAt(jtServiceList.getSelectedRow(),0);
		 		for(int i = 0; i< serviceReservationList.size();i++){
		 			if(serviceReservationList.get(i).getReservationID() == selectedResID){
		 				rfs = serviceReservationList.get(i);
		 			}
		 		}
		 		
		 		ServiceStatus su = new ServiceStatus(hotel, rfs);
		 		su.setVisible(true);
		 		
		 	}
		 });
		 btnGetServiceDetails.setBounds(510, 487, 217, 25);
		 pnlReservations.add(btnGetServiceDetails);
		 
		 JButton btnGetRoomDetails = new JButton("Get Detailed Information");
		 btnGetRoomDetails.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	
		 		if(jtRoomList.getSelectionModel().isSelectionEmpty() ) {
		 			JOptionPane.showMessageDialog(null, "Please select a room.", "Warning", JOptionPane.WARNING_MESSAGE);
		 			return;
		 		}
		 		int roomNumber = (int) jtRoomList.getValueAt(jtRoomList.getSelectedRow(),0);
		 		Reservation res = new Reservation();
		 		res = hotel.getRoomReservation(roomNumber, currentDate, 1);
		 		
		 		if(res.getReservationID() == 0){
		 			JOptionPane.showMessageDialog(null, "This room does not have any data. It is available now.", "Room is ", JOptionPane.INFORMATION_MESSAGE);
		 			return;
		 		}
		 		else{
		 		RoomStatus roomStatus = new RoomStatus(hotel, res);
		 		roomStatus.setVisible(true);
		 		}
		 	}
		 });
		 btnGetRoomDetails.setBounds(63, 487, 217, 25);
		 pnlReservations.add(btnGetRoomDetails);
		 
		 JButton btnClose = new JButton("Close");
		 btnClose.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 		
		 	}
		 });
		 btnClose.setBounds(689, 562, 98, 25);
		 pnlReservations.add(btnClose);
		 
		 JLabel lblRooms = new JLabel("Rooms");
		 lblRooms.setForeground(SystemColor.textInactiveText);
		 lblRooms.setHorizontalAlignment(SwingConstants.CENTER);
		 lblRooms.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblRooms.setBounds(12, 13, 346, 16);
		 pnlReservations.add(lblRooms);
		 
		 JLabel lblServices = new JLabel("Services");
		 lblServices.setForeground(SystemColor.textInactiveText);
		 lblServices.setHorizontalAlignment(SwingConstants.CENTER);
		 lblServices.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblServices.setBounds(438, 13, 346, 16);
		 pnlReservations.add(lblServices);

	}
}

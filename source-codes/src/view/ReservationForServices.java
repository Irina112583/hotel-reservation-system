package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import domain.Hotel;
import domain.Timeslot;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class ReservationForServices extends JFrame {


	/**
	 * 
	 */

	
	int selectedDate;
	int selectedTimeSlot;
	int guestEntryCardNumber;
	int guestRoomNumber;
	
	ArrayList<domain.Reservation> guestReservations = new ArrayList<>();
	ArrayList<domain.Timeslot> tsList = new ArrayList<>();
	
	
	public ReservationForServices(Hotel hotel) {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 497);
		JPanel pnlReservation = new JPanel();
		pnlReservation.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlReservation.setBackground(new Color(240, 240, 240));
		setContentPane(pnlReservation);
		pnlReservation.setLayout(null);
		
		JButton btnReserve = new JButton("RESERVE");
		 btnReserve.setEnabled(false);
		 btnReserve.setBounds(526, 409, 187, 25);
		 pnlReservation.add(btnReserve);
		 
		JButton btnBack = new JButton("Close");
		
		 JLabel lblServiceResHeading = new JLabel("Cleaning Service Reservation");
		 lblServiceResHeading.setForeground(SystemColor.textInactiveText);
		 lblServiceResHeading.setHorizontalAlignment(SwingConstants.CENTER);
		 lblServiceResHeading.setFont(new Font("Serif", Font.PLAIN, 20));
		 lblServiceResHeading.setBounds(12, 13, 811, 25);
		 pnlReservation.add(lblServiceResHeading);
		 		 
		 //***
		 String roomHeaderRow[]={"Active Reserved Room(s)","Reserved Dates"};         
		 DefaultTableModel tableModelRooms = new DefaultTableModel(roomHeaderRow, 0);
		 JTable jtRoomsList=new JTable(tableModelRooms);
		 
		 jtRoomsList.setEnabled(false);
		 jtRoomsList.setBorder(new LineBorder(new Color(0, 0, 0)));
		 jtRoomsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 jtRoomsList.setBounds(462,95,295,300);          
		 JScrollPane spRoomsList=new JScrollPane(jtRoomsList);
		 spRoomsList.setEnabled(false);
		 spRoomsList.setLocation(58, 147);
		 spRoomsList.setSize(452, 180);
		 spRoomsList.setVisible(true);
		 

		 JLabel lblChooseRoom = new JLabel();
		 lblChooseRoom.setText("Choose a room and date you reserved:");
		 lblChooseRoom.setBounds(58, 118, 452, 16);
		 pnlReservation.add(lblChooseRoom);
		 
		 JLabel lblNoDataAvailableRoom = new JLabel("No data available");
		 lblNoDataAvailableRoom.setBounds(58, 188, 452, 25);
		 lblNoDataAvailableRoom.setEnabled(false);
		 lblNoDataAvailableRoom.setVisible(false);
		 lblNoDataAvailableRoom.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoDataAvailableRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlReservation.add(lblNoDataAvailableRoom);
		 	 
		 //***
		 JLabel lblNoDataAvailableTimeSlot = new JLabel("No data available");
		 lblNoDataAvailableTimeSlot.setBounds(572, 188, 200, 25);
		 lblNoDataAvailableTimeSlot.setEnabled(false);
		 lblNoDataAvailableTimeSlot.setVisible(false);
		 lblNoDataAvailableTimeSlot.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoDataAvailableTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlReservation.add(lblNoDataAvailableTimeSlot);
		 pnlReservation.add(spRoomsList);
		 
		 //***
		 String timeSlotHeaderRow[]={"Available Time Slots:"};         
		 DefaultTableModel tableModelTimeSlot = new DefaultTableModel(timeSlotHeaderRow, 0);
		 JTable jtTimeSlotList=new JTable(tableModelTimeSlot);
		 jtTimeSlotList.setEnabled(false);
		 jtTimeSlotList.setShowGrid(false);
		 jtTimeSlotList.setBorder(new LineBorder(new Color(0, 0, 0)));
		 jtTimeSlotList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 jtTimeSlotList.setBounds(662,95,295,300);		
		 JScrollPane spTimeSlotList=new JScrollPane(jtTimeSlotList);

		 spTimeSlotList.setEnabled(false);
		 spTimeSlotList.setLocation(572, 147);
		 spTimeSlotList.setSize(200, 180);
		 spTimeSlotList.setVisible(true);
		 pnlReservation.add(spTimeSlotList);
		 
		 JLabel lblChooseAnAvailableTimeSlot = new JLabel();
		 lblChooseAnAvailableTimeSlot.setText("Choose an available time slot:");
		 lblChooseAnAvailableTimeSlot.setBounds(572, 118, 178, 16);
		 pnlReservation.add(lblChooseAnAvailableTimeSlot);
		 
		 //***		 
	 		
	 		guestReservations = hotel.getRoomReservations(hotel.getCurrentUser().getIDNumber());
	 		
	 			tableModelRooms.setRowCount(0);
	 			Object[] rowDataRoom = new Object[2];
		     	 
					for(int i = 0; i<guestReservations.size();i++){
					rowDataRoom[0] = guestReservations.get(i).getOccupiedRoom();
					rowDataRoom[1] = guestReservations.get(i).getOccupiedDate();
					tableModelRooms.addRow(rowDataRoom);
					}
					 
					if(tableModelRooms.getRowCount() == 0){
						JOptionPane.showMessageDialog(null, "Please make a reservation first!", "Warning", JOptionPane.WARNING_MESSAGE);
						lblNoDataAvailableRoom.setVisible(true);
						lblNoDataAvailableTimeSlot.setVisible(true);
					}else
						jtRoomsList.setEnabled(true);		 

					Object[] rowDataTimeSlot = new Object[2];
					
					jtRoomsList.addMouseListener(new MouseAdapter() {
					 	@Override
					 	public void mouseClicked(MouseEvent e) {
					 		
					 		guestEntryCardNumber = guestReservations.get(jtRoomsList.getSelectedRow()).getEntryCard();
					 		guestRoomNumber = guestReservations.get(jtRoomsList.getSelectedRow()).getOccupiedRoom();
					 		
					 		tableModelTimeSlot.setRowCount(0);
					 		tsList = hotel.getAvailableTimeSlots(guestEntryCardNumber, (int) jtRoomsList.getValueAt(jtRoomsList.getSelectedRow(), 1));
							
							for(int i = 0; i<tsList.size();i++){
							rowDataTimeSlot[0] = tsList.get(i).getTimeSlot();
							tableModelTimeSlot.addRow(rowDataTimeSlot);
							}
							 
							if(tableModelRooms.getRowCount() == 0){
								lblNoDataAvailableRoom.setVisible(true);
								lblNoDataAvailableTimeSlot.setVisible(true);
							}else{
								
								jtTimeSlotList.setEnabled(true);
							}
							
							selectedDate = (int) jtRoomsList.getValueAt(jtRoomsList.getSelectedRow(), 1);
					 	}
					 });
					
					 
					 jtTimeSlotList.addMouseListener(new MouseAdapter() {
						 	@Override
						 	public void mouseClicked(MouseEvent e) {
						 		if(tableModelTimeSlot.getRowCount() != 0){
						 			String selectedts = (String) jtTimeSlotList.getValueAt(jtTimeSlotList.getSelectedRow(), 0);						 					
						 			 for (Timeslot ts : tsList)
						 		    {
						 		        if (ts.getTimeSlot().equals(selectedts))
						 		        {
						 		            selectedTimeSlot = ts.getIDNumber();   
						 		        }   
						 		    }
									btnReserve.setEnabled(true);}
						 	}
						 });

					 
		 
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 		
		 	}
		 });
		 btnBack.setBounds(725, 409, 98, 25);
		 pnlReservation.add(btnBack); 
		 
		 JSeparator separator_1 = new JSeparator();
		 separator_1.setBounds(12, 383, 811, 2);
		 pnlReservation.add(separator_1);
		 
		 JSeparator separator_1_1 = new JSeparator();
		 separator_1_1.setBounds(12, 61, 811, 2);
		 pnlReservation.add(separator_1_1);

		 btnReserve.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {		 		
		 		if(jtRoomsList.getSelectionModel().isSelectionEmpty() ) {
		 			JOptionPane.showMessageDialog(null, "Please select an available room.", "Warning", JOptionPane.WARNING_MESSAGE);
		 			return;
		 		}

		 		if(jtTimeSlotList.getSelectionModel().isSelectionEmpty() ) {
		 			JOptionPane.showMessageDialog(null, "Please choose a guest.", "Warning", JOptionPane.WARNING_MESSAGE);
		 			return;
		 		}

		 		boolean result = false; 
		 		
		 		// 1 = cleaning service. It is the only service to be provided for now.
		 		result = hotel.makeCleaningReservation(1, hotel.getCurrentUser().getIDNumber(),selectedDate, selectedTimeSlot, guestEntryCardNumber, guestRoomNumber);
						
		 		if(result)
		 			dispose();
		 		}
		 });
	}	
}

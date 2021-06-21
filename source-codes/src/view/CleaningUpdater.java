package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import domain.Hotel;
import domain.Timeslot;
import domain.User;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class CleaningUpdater extends JFrame {


	/**
	 * 
	 */
	
	int selectedDate;
	int selectedTimeSlot;
	int guestEntryCardNumber;
	int guestRoomNumber;
	
	ArrayList<domain.Reservation> guestReservations = new ArrayList<>();
	ArrayList<domain.Timeslot> tsList = new ArrayList<>();
	

	public CleaningUpdater(Hotel hotel, domain.ReservationForServices rfs) {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 733);
		JPanel pnlReservation = new JPanel();
		pnlReservation.setForeground(Color.RED);
		pnlReservation.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlReservation.setBackground(new Color(240, 240, 240));
		setContentPane(pnlReservation);
		pnlReservation.setLayout(null);
		JLabel lblGuest = new JLabel();
		JLabel lblcurrentRoom = new JLabel();
		
		JLabel lblNoDataAvailableRoom = new JLabel("No data available");
		lblNoDataAvailableRoom.setBounds(69, 441, 452, 25);
		lblNoDataAvailableRoom.setEnabled(false);
		lblNoDataAvailableRoom.setVisible(false);
		lblNoDataAvailableRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoDataAvailableRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlReservation.add(lblNoDataAvailableRoom);
		
		 //***
		 JLabel lblNoDataAvailableTimeSlot = new JLabel("No data available");
		 lblNoDataAvailableTimeSlot.setBounds(581, 441, 200, 25);
		 lblNoDataAvailableTimeSlot.setEnabled(false);
		 lblNoDataAvailableTimeSlot.setVisible(false);
		 lblNoDataAvailableTimeSlot.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoDataAvailableTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlReservation.add(lblNoDataAvailableTimeSlot);
		JButton btnUpdateTimeSlot = new JButton("Update Time Slot");
		 
		 btnUpdateTimeSlot.setBounds(544, 649, 187, 25);
		 pnlReservation.add(btnUpdateTimeSlot);
		 lblcurrentRoom.setText("Room:");
		 lblcurrentRoom.setBounds(69, 163, 191, 16);
		 pnlReservation.add(lblcurrentRoom);
		 
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
		 spTimeSlotList.setLocation(581, 400);
		 spTimeSlotList.setSize(200, 180);
		 spTimeSlotList.setVisible(true);
		 pnlReservation.add(spTimeSlotList);
		 
		 JLabel lblChooseAnAvailableTimeSlot = new JLabel();
		 lblChooseAnAvailableTimeSlot.setText("Choose an available time slot:");
		 lblChooseAnAvailableTimeSlot.setBounds(581, 371, 178, 16);
		 pnlReservation.add(lblChooseAnAvailableTimeSlot);
		 
		 //***
		 
		 lblGuest.setText("Guest:");
		 lblGuest.setBounds(69, 116, 191, 16);
		 pnlReservation.add(lblGuest);
		 
		 JLabel lblReservedDate = new JLabel();
		 lblReservedDate.setText("Current Reserved Date:");
		 lblReservedDate.setBounds(69, 213, 191, 16);
		 pnlReservation.add(lblReservedDate);
		
		 String column[]={"Available Time Slots"};         
		 DefaultTableModel tableModel = new DefaultTableModel(column, 0);

		 //***
		 
		 

		 
		 JButton btnBack = new JButton("Close");
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 	}
		 });
		 btnBack.setBounds(743, 649, 98, 25);
		 pnlReservation.add(btnBack);
		 
		 JLabel lblHeading = new JLabel("Service Reservation Update");
		 lblHeading.setForeground(SystemColor.textInactiveText);
		 lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		 lblHeading.setFont(new Font("Serif", Font.PLAIN, 20));
		 lblHeading.setBounds(12, 24, 829, 25);
		 pnlReservation.add(lblHeading);
		 
		 JLabel lblCurrentTimeSlot = new JLabel();
		 lblCurrentTimeSlot.setText("Current Reserved Time Slot:");
		 lblCurrentTimeSlot.setBounds(69, 267, 191, 16);
		 pnlReservation.add(lblCurrentTimeSlot);
		 
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
		 spRoomsList.setLocation(69, 400);
		 spRoomsList.setSize(452, 180);
		 spRoomsList.setVisible(true);
		 

		 JLabel lblChooseRoom = new JLabel();
		 lblChooseRoom.setText("Choose a room and date you reserved:");
		 lblChooseRoom.setBounds(69, 371, 452, 16);
		 pnlReservation.add(lblChooseRoom);
		 pnlReservation.add(spRoomsList);
		 
		 JLabel lblUser_1 = new JLabel();
		 lblUser_1.setText(hotel.retrieveUserWithID(rfs.getOccupiedBy()).getFullName());
		 lblUser_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 lblUser_1.setEnabled(false);
		 lblUser_1.setBounds(324, 108, 267, 30);
		 pnlReservation.add(lblUser_1);
		 
		 JLabel lblcurrentRoom_1 = new JLabel();
		 lblcurrentRoom_1.setText(String.valueOf(rfs.getOccupiedRoom()));
		 lblcurrentRoom_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 lblcurrentRoom_1.setEnabled(false);
		 lblcurrentRoom_1.setBounds(324, 151, 267, 30);
		 pnlReservation.add(lblcurrentRoom_1);
		 
		 JLabel lblReservedDate_1 = new JLabel();
		 lblReservedDate_1.setText(String.valueOf(rfs.getOccupiedDate()));
		 lblReservedDate_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 lblReservedDate_1.setEnabled(false);
		 lblReservedDate_1.setBounds(324, 205, 267, 30);
		 pnlReservation.add(lblReservedDate_1);
		 
		 JLabel lblCurrentTimeSlot_1 = new JLabel();
		 lblCurrentTimeSlot_1.setText(hotel.getTimeSlot(rfs.getTimeSlotID()).getTimeSlot());
		 lblCurrentTimeSlot_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 lblCurrentTimeSlot_1.setEnabled(false);
		 lblCurrentTimeSlot_1.setBounds(324, 259, 267, 30);
		 pnlReservation.add(lblCurrentTimeSlot_1);
		 
		 JSeparator separator = new JSeparator();
		 separator.setBounds(22, 80, 819, 278);
		 pnlReservation.add(separator);
		 
		 JSeparator separator_1 = new JSeparator();
		 separator_1.setBounds(22, 628, 819, 8);
		 pnlReservation.add(separator_1);
		 
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
								btnUpdateTimeSlot.setEnabled(true);}
					 	}
					 });
		 
		 //**
		 
				 spRoomsList.addMouseListener(new MouseAdapter() {
					 	@Override
					 	public void mouseClicked(MouseEvent arg0) {
					 		guestEntryCardNumber = guestReservations.get(jtRoomsList.getSelectedRow()).getEntryCard();
					 		selectedDate = (int) jtRoomsList.getValueAt(jtRoomsList.getSelectedRow(), 1);
					 		
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
							
							
					 	}
					 });
				 
				 //**
		 
		 btnUpdateTimeSlot.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {		 		
		 		if(jtRoomsList.getSelectionModel().isSelectionEmpty() ) {
		 			JOptionPane.showMessageDialog(null, "Please select an available room.", "Warning", JOptionPane.WARNING_MESSAGE);
		 			
		 			return;
		 		}

		 		hotel.updateCleaningReservation(guestEntryCardNumber, selectedDate, selectedTimeSlot, rfs.getOccupiedDate(), rfs.getTimeSlotID());
				dispose();
				ReservationForServicesEditor res = new ReservationForServicesEditor(hotel);
				res.setVisible(true);
		 		}
		 });
		 

	}
}

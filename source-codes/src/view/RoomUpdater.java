package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import domain.Hotel;
import domain.User;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class RoomUpdater extends JFrame {


	/**
	 * 
	 */

	public RoomUpdater(Hotel hotel, domain.Reservation selectedRes) {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 694);
		JPanel pnlReservation = new JPanel();
		pnlReservation.setForeground(Color.RED);
		pnlReservation.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlReservation.setBackground(new Color(240, 240, 240));
		setContentPane(pnlReservation);
		pnlReservation.setLayout(null);
		JLabel lblGuest = new JLabel();
		JLabel lblcurrentRoom = new JLabel();
		JButton btnUpdateRoom = new JButton("Update Room");
		 
		 btnUpdateRoom.setBounds(251, 607, 187, 25);
		 pnlReservation.add(btnUpdateRoom);
		 lblcurrentRoom.setText("Current Room:");
		 lblcurrentRoom.setBounds(69, 143, 191, 16);
		 pnlReservation.add(lblcurrentRoom);
		 
		 
		 lblGuest.setText("Guest:");
		 lblGuest.setBounds(69, 96, 191, 16);
		 pnlReservation.add(lblGuest);
		 
		 JLabel lblReservedDate = new JLabel();
		 lblReservedDate.setText("Reserved Date:");
		 lblReservedDate.setBounds(69, 193, 191, 16);
		 pnlReservation.add(lblReservedDate);
		
		 JLabel lblNoDataAvailable = new JLabel("No data available");
		 lblNoDataAvailable.setBounds(251, 358, 121, 25);
		 lblNoDataAvailable.setEnabled(false);
		 lblNoDataAvailable.setVisible(false);
		 lblNoDataAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoDataAvailable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlReservation.add(lblNoDataAvailable);
		
		 String column[]={"Available Rooms"};         
		 DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		 JTable jtRoomsList=new JTable(tableModel);
		 
		 tableModel.setRowCount(0);
     	 Object[] rowData;
     	 
     	ArrayList<Integer> selectedResDate = new ArrayList<>();
     	selectedResDate.add(selectedRes.getOccupiedDate()); 
     	ArrayList<Integer> freeRooms = hotel.getFreeRooms(selectedResDate);

			rowData = new Object[1];
			
			for(int i = 0; i< freeRooms.size();i++){
				
				rowData[0] = freeRooms.get(i);
				tableModel.addRow(rowData);
			}
			
			if(tableModel.getRowCount() == 0){
				lblNoDataAvailable.setVisible(true);
			}
		
		 
		 jtRoomsList.setBorder(new LineBorder(new Color(0, 0, 0)));
		 jtRoomsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 jtRoomsList.setBounds(462,95,295,300);          

		 JScrollPane spRoomsList=new JScrollPane(jtRoomsList);
		 spRoomsList.setLocation(251, 310);
		 spRoomsList.setSize(121, 187);
		 spRoomsList.setVisible(true);
		 jtRoomsList.setBounds(30,40,200,300);    
		 pnlReservation.add(spRoomsList);
		 
		 JButton btnBack = new JButton("Close");
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 	}
		 });
		 btnBack.setBounds(458, 607, 98, 25);
		 pnlReservation.add(btnBack);
		 
		 JLabel lblHeading = new JLabel("Room Update");
		 lblHeading.setForeground(SystemColor.textInactiveText);
		 lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		 lblHeading.setFont(new Font("Serif", Font.PLAIN, 20));
		 lblHeading.setBounds(12, 24, 544, 16);
		 pnlReservation.add(lblHeading);
		 
		 JSeparator separator = new JSeparator();
		 separator.setBounds(12, 62, 546, 8);
		 pnlReservation.add(separator);
		 
		 JSeparator separator_1 = new JSeparator();
		 separator_1.setBounds(10, 586, 546, 8);
		 pnlReservation.add(separator_1);
		 
		 JLabel lblUser_1 = new JLabel();
		 lblUser_1.setText(hotel.retrieveUserWithID(selectedRes.getOccupiedBy()).getFullName());
		 lblUser_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 lblUser_1.setEnabled(false);
		 lblUser_1.setBounds(293, 88, 263, 30);
		 pnlReservation.add(lblUser_1);
		 
		 JLabel lblcurrentRoom_1 = new JLabel();
		 lblcurrentRoom_1.setText(String.valueOf(selectedRes.getOccupiedRoom()));
		 lblcurrentRoom_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 lblcurrentRoom_1.setEnabled(false);
		 lblcurrentRoom_1.setBounds(293, 135, 263, 30);
		 pnlReservation.add(lblcurrentRoom_1);
		 
		 JLabel lblReservedDate_1 = new JLabel();
		 lblReservedDate_1.setText(String.valueOf(selectedRes.getOccupiedDate()));
		 lblReservedDate_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 lblReservedDate_1.setEnabled(false);
		 lblReservedDate_1.setBounds(293, 185, 263, 30);
		 pnlReservation.add(lblReservedDate_1);
		 
		 
		 btnUpdateRoom.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {		 		
		 		if(jtRoomsList.getSelectionModel().isSelectionEmpty() ) {
		 			JOptionPane.showMessageDialog(null, "Please select an available room.", "Warning", JOptionPane.WARNING_MESSAGE);
		 			
		 			return;
		 		}
		 		hotel.updateRoom(selectedRes.getReservationID(), (int) jtRoomsList.getValueAt(jtRoomsList.getSelectedRow(),0));
				dispose();
				ReservationEditor res = new ReservationEditor(hotel);
				res.setVisible(true);
		 		}
		 });
		 

	}
}

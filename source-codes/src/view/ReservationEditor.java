package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Frame;

import javax.sql.RowSetMetaData;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import domain.Hotel;
import domain.User;
import domain.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ReservationEditor extends JFrame {


	/**
	 * 
	 */

	
	 ArrayList<Reservation> reservationList = null;
	
	public ReservationEditor(Hotel hotel) {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 595);
		JPanel pnlReservations = new JPanel();
		pnlReservations.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlReservations.setBackground(Color.WHITE);
		setContentPane(pnlReservations);
		pnlReservations.setLayout(null);

		JLabel lblNoDataAvailable = new JLabel("No data available");
		 lblNoDataAvailable.setBounds(190, 87, 188, 34);
		 lblNoDataAvailable.setEnabled(false);
		 lblNoDataAvailable.setVisible(false);
		 lblNoDataAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoDataAvailable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 pnlReservations.add(lblNoDataAvailable);
		 
		 String column[]={"ID", "Guest", "Room", "Entry Card", "Dates"};         
		 DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		 JTable jt=new JTable(tableModel);
		 
		 
		 jt.removeColumn(jt.getColumnModel().getColumn(0)); // to hide resID in the table.
		 jt.setBorder(new LineBorder(new Color(0, 0, 0)));
		 jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 jt.setBounds(462,95,295,300);          

		 JScrollPane sp=new JScrollPane(jt);
		 sp.setLocation(12, 42);
		 sp.setSize(556, 447);
		 sp.setVisible(true);
		 jt.setBounds(30,40,200,300);    
		 pnlReservations.add(sp);
	 
		 Object[] rowData;
		 try {	 
			reservationList = new ArrayList<Reservation>();
			rowData = new Object[5];
			reservationList = hotel.retrieveReservations(1);
			for(int i = 0; i< reservationList.size();i++){
					rowData[0] = reservationList.get(i).getReservationID();
					rowData[1] = hotel.retrieveUserWithID(reservationList.get(i).getOccupiedBy()).getFullName();
					rowData[2] = reservationList.get(i).getOccupiedRoom();
					rowData[3] = reservationList.get(i).getEntryCard();
					rowData[4] = reservationList.get(i).getOccupiedDate();
					tableModel.addRow(rowData);

			}		
		
		}finally{
			if(tableModel.getRowCount() == 0){
				lblNoDataAvailable.setVisible(true);
			}
		}
		
		 JButton btnUpdateReservation = new JButton("Update Reservation");
		 btnUpdateReservation.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		if(jt.getSelectionModel().isSelectionEmpty() ) {
		 			JOptionPane.showMessageDialog(null, "Please select a reservation.", "Warning", JOptionPane.WARNING_MESSAGE);
		 			return;
		 		}
		 		
		 		for(int i = 0; i< reservationList.size();i++){
		 			if(reservationList.get(i).getReservationID() == (int) jt.getModel().getValueAt(jt.getSelectedRow(),0)){
		 				RoomUpdater ru = new RoomUpdater(hotel, reservationList.get(i));
		 				ru.setVisible(true);
		 			}
		 		}
		 		dispose();
		 	}
		 });
		 btnUpdateReservation.setBounds(241, 502, 217, 25);
		 pnlReservations.add(btnUpdateReservation);
		 
		 JButton btnCancelReservation = new JButton("Cancel Reservation");
		 btnCancelReservation.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	
		 		if(jt.getSelectionModel().isSelectionEmpty() ) {
		 			JOptionPane.showMessageDialog(null, "Please select a reservation.", "Warning", JOptionPane.WARNING_MESSAGE);
		 			return;
		 		}
		 		
		 		int resID = (int) jt.getModel().getValueAt(jt.getSelectedRow(),0);
		 		int entryCard = (int) jt.getValueAt(jt.getSelectedRow(),2);
		 		boolean isCanceled = false;
		 		try{
		 			isCanceled = hotel.cancelReservation(resID, entryCard);	
		 		}catch (Exception exception) {
		 			JOptionPane.showMessageDialog(null, "An error occured. Please choose an appropriate record or try it again later.", "Error", JOptionPane.ERROR_MESSAGE);
				}
		 		
		 		if(isCanceled)
		 			tableModel.removeRow(jt.getSelectedRow());
		 	}
		 });
		 btnCancelReservation.setBounds(12, 502, 217, 25);
		 pnlReservations.add(btnCancelReservation);
		 
		 JButton btnClose = new JButton("Close");
		 btnClose.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 		
		 	}
		 });
		 btnClose.setBounds(470, 502, 98, 25);
		 pnlReservations.add(btnClose);
		 
		 JLabel lblRoomRes = new JLabel("List of Active Reservations");
		 lblRoomRes.setForeground(SystemColor.textInactiveText);
		 lblRoomRes.setHorizontalAlignment(SwingConstants.CENTER);
		 lblRoomRes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblRoomRes.setBounds(12, 13, 556, 16);
		 pnlReservations.add(lblRoomRes);

	}
}

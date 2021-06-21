package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import domain.Hotel;

import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Reservation extends JFrame {


	/**
	 * 
	 */

	ArrayList<Integer> requestedDates;
	int parsedCheckinDate;
	int parsedCheckoutDate;
	int today = Integer.parseInt(DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH).format(java.time.LocalDate.now()));
	
	public Reservation(Hotel hotel) {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 724);
		JPanel pnlReservation = new JPanel();
		pnlReservation.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlReservation.setBackground(new Color(240, 240, 240));
		setContentPane(pnlReservation);
		pnlReservation.setLayout(null);
		
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("####-##-##");
			formatter.setValidCharacters("0123456789");
			formatter.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		
		JFormattedTextField txtCheckin = new JFormattedTextField(formatter);
		JLabel lblCheckin = new JLabel();
		JFormattedTextField txtCheckout = new JFormattedTextField(formatter);
		JButton btnCheckout = new JButton();
		JLabel lblCheckout = new JLabel();
		
		 JLabel lblNoDataAvailable = new JLabel("No data available");
		 lblNoDataAvailable.setBounds(224, 369, 121, 25);
		 lblNoDataAvailable.setEnabled(false);
		 lblNoDataAvailable.setVisible(false);
		 lblNoDataAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoDataAvailable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlReservation.add(lblNoDataAvailable);
		 
		 String column[]={"Available Rooms"};         
		 DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		 JTable jtRoomsList=new JTable(tableModel);
		 jtRoomsList.setEnabled(false);
		 jtRoomsList.setShowGrid(false);
		 
		 jtRoomsList.setBorder(new LineBorder(new Color(0, 0, 0)));
		 jtRoomsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 jtRoomsList.setBounds(462,95,295,300);          

		 JScrollPane spRoomsList=new JScrollPane(jtRoomsList);
		 spRoomsList.setEnabled(false);
		 spRoomsList.setLocation(224, 330);
		 spRoomsList.setSize(121, 215);
		 spRoomsList.setVisible(true);
		 jtRoomsList.setBounds(30,40,200,300);    
		 pnlReservation.add(spRoomsList);
		 
		 JButton btnBack = new JButton("Close");
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 		
		 	}
		 });
		 btnBack.setBounds(423, 632, 98, 25);
		 pnlReservation.add(btnBack);
		 
		 JLabel lblNewLabel = new JLabel("Room Reservation");
		 lblNewLabel.setForeground(SystemColor.textInactiveText);
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		 lblNewLabel.setBounds(12, 24, 509, 16);
		 pnlReservation.add(lblNewLabel);
		 
		 JButton btnReserve = new JButton("RESERVE");
		 btnReserve.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {		 		


		 		
		 		if(jtRoomsList.getSelectionModel().isSelectionEmpty() ) {
		 			JOptionPane.showMessageDialog(null, "Please select an available room.", "Warning", JOptionPane.WARNING_MESSAGE);
		 			return;
		 		}

		 		boolean result = hotel.makeRoomReservation((int) jtRoomsList.getValueAt(jtRoomsList.getSelectedRow(), jtRoomsList.getSelectedColumn()), requestedDates);
		 		
		 		if(result){
		 			tableModel.setRowCount(0);
			     	 for(int i = parsedCheckinDate; i<=parsedCheckoutDate; i++ )
			     	 {
			     		 requestedDates.add(i);
			     	 }	     	 

			     	Object[] rowData;
			     	 
			     	ArrayList<Integer> freeRooms = hotel.getFreeRooms(requestedDates);

						rowData = new Object[4];
						
						for(int i = 0; i< freeRooms.size();i++){
							
							rowData[0] = freeRooms.get(i);
							tableModel.addRow(rowData);
							
						}
						dispose();
		 		}
		 	}
		 });
		 
		 btnReserve.setEnabled(false);
		 btnReserve.setBounds(224, 632, 187, 25);
		 pnlReservation.add(btnReserve);
 
		 txtCheckout.setHorizontalAlignment(SwingConstants.CENTER);
		 txtCheckout.setBounds(326, 150, 130, 22);
		 pnlReservation.add(txtCheckout);
		 
		 
		 lblCheckout.setText("Enter check-out date (yyyy-MM-dd):");
		 lblCheckout.setBounds(68, 150, 246, 16);
		 pnlReservation.add(lblCheckout);
		 
		 btnCheckout.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		lblNoDataAvailable.setVisible(false);
		 		
		 		tableModel.setRowCount(0);
		 		
		     	String cleanCheckinDate = txtCheckin.getText().replaceAll("[_-]", "");
		     	if(isValidDate(cleanCheckinDate)){
		     		parsedCheckinDate = Integer.parseInt(cleanCheckinDate);
		     		if(parsedCheckinDate<today || parsedCheckinDate>20211231)
		     		{
		     			JOptionPane.showMessageDialog(null, "Check-in date cannot be a past date or beyond the last day of 2021.", "Warning", JOptionPane.WARNING_MESSAGE);
		     			return;
		     		}
		     	}else
		     		return;
		 		
		     	String cleanCheckoutDate = txtCheckout.getText().replaceAll("[_-]", "");
		     	if(isValidDate(cleanCheckoutDate)){
		     		parsedCheckoutDate = Integer.parseInt(cleanCheckoutDate);
		 			if(parsedCheckoutDate<parsedCheckinDate || parsedCheckoutDate>20211231)
		 			{
		 				JOptionPane.showMessageDialog(null, "Check-out date cannot be a past date, less than check-in date or beyond the last day of 2021.", "Warning", JOptionPane.WARNING_MESSAGE);
		 				return;
		 			}
		     	}else 
		     		return;
		     	
		     	
		     	 requestedDates = new ArrayList<Integer>();
		     	 for(int i = parsedCheckinDate; i<=parsedCheckoutDate; i++ )
		     	 {
		     		 requestedDates.add(i);
		     	 }	 
		     	 
		     	spRoomsList.setEnabled(true);
		 		jtRoomsList.setEnabled(true);

		     	Object[] rowData;
		     	 
		     	ArrayList<Integer> freeRooms = hotel.getFreeRooms(requestedDates);

					rowData = new Object[4];
					
					for(int i = 0; i< freeRooms.size();i++){
						
						rowData[0] = freeRooms.get(i);
						tableModel.addRow(rowData);
					}
					
					if(tableModel.getRowCount() == 0)
						lblNoDataAvailable.setVisible(true);
					else
						btnReserve.setEnabled(true);
		 	}
		 });
		 btnCheckout.setText("Check For Dates");
		 btnCheckout.setBounds(326, 202, 130, 20);
		 pnlReservation.add(btnCheckout);
		
		 txtCheckin.setHorizontalAlignment(SwingConstants.CENTER);
		 txtCheckin.setBounds(326, 100, 130, 22);
		 pnlReservation.add(txtCheckin);
		 
		 lblCheckin.setText("Enter check-in date (yyyy-MM-dd):");
		 lblCheckin.setBounds(68, 103, 246, 16);
		 pnlReservation.add(lblCheckin);
		 
		 JLabel lblChooseARoom = new JLabel();
		 lblChooseARoom.setText("Choose a room:");
		 lblChooseARoom.setEnabled(false);
		 lblChooseARoom.setBounds(224, 301, 121, 16);
		 pnlReservation.add(lblChooseARoom);
		 
		 JSeparator separator = new JSeparator();
		 separator.setBounds(12, 68, 509, 188);
		 pnlReservation.add(separator);
		 
		 JSeparator separator_1 = new JSeparator();
		 separator_1.setBounds(12, 601, 509, 2);
		 pnlReservation.add(separator_1);


	}
	
	 private boolean isValidDate(String inDate){
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
         dateFormat.setLenient(false);
         try {
             dateFormat.parse(inDate.trim());
         } catch (ParseException pe) {
        	 JOptionPane.showMessageDialog(null, "Please enter a valid date!", "Warning", JOptionPane.WARNING_MESSAGE);
             return false;
         }
         return true;
     }
}

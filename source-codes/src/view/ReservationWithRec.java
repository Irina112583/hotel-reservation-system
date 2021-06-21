package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import domain.Hotel;
import domain.User;

import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ReservationWithRec extends JFrame {


	/**
	 * 
	 */

	ArrayList<Integer> requestedDates;
	int parsedCheckinDate;
	int parsedCheckoutDate;
	private JTable jtGuestList;
	int today = Integer.parseInt(DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH).format(java.time.LocalDate.now()));
	
	public ReservationWithRec(Hotel hotel) {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 743);
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
		 
		 JLabel lblNoDataAvailableRoom = new JLabel("No data available");
		 lblNoDataAvailableRoom.setBounds(494, 371, 121, 25);
		 lblNoDataAvailableRoom.setEnabled(false);
		 lblNoDataAvailableRoom.setVisible(false);
		 lblNoDataAvailableRoom.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoDataAvailableRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlReservation.add(lblNoDataAvailableRoom);
		 
		 JLabel lblNoDataAvailableGuest = new JLabel("No data available");
		 lblNoDataAvailableGuest.setBounds(59, 371, 385, 25);
		 lblNoDataAvailableGuest.setEnabled(false);
		 lblNoDataAvailableGuest.setVisible(false);
		 lblNoDataAvailableGuest.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoDataAvailableGuest.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 pnlReservation.add(lblNoDataAvailableGuest);
		 
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
		 spRoomsList.setLocation(494, 330);
		 spRoomsList.setSize(121, 215);
		 spRoomsList.setVisible(true);
		 jtRoomsList.setBounds(30,40,200,300);    
		 pnlReservation.add(spRoomsList);
		 
		 
		 String columnGuests[]={"Guest ID","Fullname", "Username", "Email Address"};
		 DefaultTableModel tableModelGuests = new DefaultTableModel(columnGuests, 0);
		 jtGuestList = new JTable(tableModelGuests);
		 jtGuestList.setEnabled(false);
		 jtGuestList.setShowGrid(false);
		 jtGuestList.setBorder(new LineBorder(new Color(0, 0, 0)));
		 jtGuestList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 jtGuestList.setBounds(462,95,295,300);
		 
		 JScrollPane spGuestList = new JScrollPane(jtGuestList);
		 spGuestList.setEnabled(false);
		 spGuestList.setLocation(115, 103);
		 spGuestList.setSize(121, 215);
		 spGuestList.setVisible(true);
		 spGuestList.setBounds(59,330,385,215);
		 pnlReservation.add(spGuestList);
		 
		 JLabel lblchooseGuest = new JLabel();
		 lblchooseGuest.setEnabled(false);
		 lblchooseGuest.setText("Choose a guest for reservation:");
		 lblchooseGuest.setBounds(59, 301, 247, 16);
		 pnlReservation.add(lblchooseGuest);
		 
		 JLabel lblChooseARoom = new JLabel();
		 lblChooseARoom.setEnabled(false);
		 lblChooseARoom.setText("Choose a room:");
		 lblChooseARoom.setBounds(494, 301, 121, 16);
		 pnlReservation.add(lblChooseARoom);
		 
		 JButton btnBack = new JButton("Close");
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 		
		 	}
		 });
		 btnBack.setBounds(566, 653, 98, 25);
		 pnlReservation.add(btnBack);
		 
		 JLabel lblNewLabel = new JLabel("Room Reservation");
		 lblNewLabel.setForeground(SystemColor.textInactiveText);
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		 lblNewLabel.setBounds(12, 24, 652, 16);
		 pnlReservation.add(lblNewLabel);
		 
		 JButton btnReserve = new JButton("RESERVE");
		 btnReserve.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {		 		
		 		if(jtRoomsList.getSelectionModel().isSelectionEmpty() ) {
		 			JOptionPane.showMessageDialog(null, "Please select an available room.", "Warning", JOptionPane.WARNING_MESSAGE);
		 			return;
		 		}
		 		if(jtGuestList.getSelectionModel().isSelectionEmpty() ) {
		 			JOptionPane.showMessageDialog(null, "Please choose a guest.", "Warning", JOptionPane.WARNING_MESSAGE);
		 			return;
		 		}

		 		boolean result = hotel.makeRoomReservation( (int) jtGuestList.getValueAt(jtGuestList.getSelectedRow(), 0),(int) jtRoomsList.getValueAt(jtRoomsList.getSelectedRow(), 0), requestedDates);
		 		
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
						
						if(tableModel.getRowCount() == 0)
							lblNoDataAvailableRoom.setVisible(true);
						
						dispose();
		 		}
		 	}
		 });
		 
		 btnReserve.setEnabled(false);
		 btnReserve.setBounds(367, 653, 187, 25);
		 pnlReservation.add(btnReserve);
 
		 txtCheckout.setHorizontalAlignment(SwingConstants.CENTER);
		 txtCheckout.setBounds(314, 151, 130, 22);
		 pnlReservation.add(txtCheckout);

		 txtCheckin.setHorizontalAlignment(SwingConstants.CENTER);
		 txtCheckin.setBounds(314, 104, 130, 22);
		 pnlReservation.add(txtCheckin);
		 lblCheckin.setText("Enter check-in date (yyyy-MM-dd):");
		 lblCheckin.setBounds(59, 104, 243, 16);
		 pnlReservation.add(lblCheckin);
		 
		 lblCheckout.setText("Enter check-out date (yyyy-MM-dd):");
		 lblCheckout.setBounds(59, 151, 243, 16);
		 pnlReservation.add(lblCheckout);
		 
		 btnCheckout.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		tableModel.setRowCount(0);
		 		tableModelGuests.setRowCount(0);

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
		     	 for(int i = 0; i<=(parsedCheckoutDate-parsedCheckinDate); i++ )
		     	 {
		     		 if(isValidDate(String.valueOf(parsedCheckinDate))){
		     			 requestedDates.add(parsedCheckinDate);
		     			 parsedCheckinDate++;
		     		 }
		     	 }
		     	 
			 		spRoomsList.setEnabled(true);
			 		jtRoomsList.setEnabled(true);
			 		
			 		
			 		spGuestList.setEnabled(true);
			 		jtGuestList.setEnabled(true);
			 		
			 		
			 		lblChooseARoom.setEnabled(true);
			 		lblchooseGuest.setEnabled(true);

		     	Object[] rowData;
		     	 
		     	ArrayList<Integer> freeRooms = hotel.getFreeRooms(requestedDates);

					rowData = new Object[4];
					
					for(int i = 0; i< freeRooms.size();i++){
						
						rowData[0] = freeRooms.get(i);
						tableModel.addRow(rowData);
					}
					if(tableModel.getRowCount() == 0)
						lblNoDataAvailableRoom.setVisible(true);
					
					 Object[] rowGuestData;
					 ArrayList<User> users = null;
					 try {
						users = new ArrayList<User>();
						rowGuestData = new Object[4];
						users = hotel.retrieveUsersWithRole("Guest");
						for(int i = 0; i< users.size();i++){
							
							rowGuestData[0] = users.get(i).getIDNumber();
							rowGuestData[1] = users.get(i).getFullName();
							rowGuestData[2] = users.get(i).getUsername();
							rowGuestData[3] = users.get(i).getEmailAddress();
							tableModelGuests.addRow(rowGuestData);
						}		
					
					}finally{
						if(tableModelGuests.getRowCount() == 0)
							lblNoDataAvailableGuest.setVisible(true);
						else 
						users.clear();
					}
		 	if(tableModelGuests.getRowCount() > 0 && tableModel.getRowCount() > 0)
		 		btnReserve.setEnabled(true);
		 	}
		 });
		 btnCheckout.setText("Check For Dates");
		 btnCheckout.setBounds(314, 201, 130, 20);
		 pnlReservation.add(btnCheckout);
		 
		 JSeparator separator_1 = new JSeparator();
		 separator_1.setBounds(12, 69, 652, 2);
		 pnlReservation.add(separator_1);
		 
		 JSeparator separator_1_1 = new JSeparator();
		 separator_1_1.setBounds(12, 627, 652, 2);
		 pnlReservation.add(separator_1_1);
		 

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

package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import domain.Hotel;
import domain.Reservation;
import domain.User;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.stream.Collectors;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class NetCashPayment extends JFrame {


	/**
	 * 
	 */

	private JTable jtGuestList;
	ArrayList<domain.Reservation> roomReservationList;
	ArrayList<domain.ReservationForServices> serviceReservationList;
	int roomFee = 0;
	int serviceFee = 0;
	int totalDebt = 0;
	int selectedRoom = 0;
	int today = Integer.parseInt(DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH).format(java.time.LocalDate.now()));
	
	public NetCashPayment(Hotel hotel) {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 908);
		JPanel pnlReservation = new JPanel();
		pnlReservation.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlReservation.setBackground(new Color(240, 240, 240));
		setContentPane(pnlReservation);
		pnlReservation.setLayout(null);
		
		JButton btnCalculate = new JButton("Get All Debts of Selected Room");
		
		 
		 JLabel lblNoDataAvailableGuest = new JLabel("No data available");
		 lblNoDataAvailableGuest.setBounds(60, 189, 520, 25);
		 lblNoDataAvailableGuest.setEnabled(false);
		 lblNoDataAvailableGuest.setVisible(false);
		 lblNoDataAvailableGuest.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoDataAvailableGuest.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 pnlReservation.add(lblNoDataAvailableGuest);
		 
		 //***
		 
		 JLabel lblNewLabel = new JLabel("Leaving Request");
		 lblNewLabel.setForeground(SystemColor.textInactiveText);
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		 lblNewLabel.setBounds(12, 24, 613, 32);
		 pnlReservation.add(lblNewLabel);
		 

		 
		 JSeparator separator = new JSeparator();
		 separator.setBounds(12, 80, 613, 312);
		 pnlReservation.add(separator);
		 
		 JLabel lblRoomToCheck = new JLabel();
		 lblRoomToCheck.setText("Room to check out:");
		 lblRoomToCheck.setEnabled(false);
		 lblRoomToCheck.setBounds(60, 405, 163, 16);
		 pnlReservation.add(lblRoomToCheck);
		 
		 JLabel debtL = new JLabel();
		 debtL.setText("Total debt on chosen entry card:");
		 debtL.setHorizontalAlignment(SwingConstants.CENTER);
		 debtL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		 debtL.setEnabled(false);
		 debtL.setBounds(12, 715, 613, 22);
		 pnlReservation.add(debtL);
		 
		 JLabel lblTotalDebt = new JLabel();
		 lblTotalDebt.setText("-");
		 lblTotalDebt.setHorizontalAlignment(SwingConstants.CENTER);
		 lblTotalDebt.setFont(new Font("Tahoma", Font.BOLD, 18));
		 lblTotalDebt.setEnabled(false);
		 lblTotalDebt.setBounds(258, 757, 89, 30);
		 pnlReservation.add(lblTotalDebt);
		 
		 JLabel currencyL = new JLabel();
		 currencyL.setText("TL");
		 currencyL.setFont(new Font("Tahoma", Font.BOLD, 18));
		 currencyL.setEnabled(false);
		 currencyL.setBounds(354, 755, 27, 34);
		 pnlReservation.add(currencyL);
		 
		 JLabel lblRoomDebt = new JLabel();
		 lblRoomDebt.setText("Room Reservation Debt:");
		 lblRoomDebt.setEnabled(false);
		 lblRoomDebt.setBounds(60, 592, 163, 16);
		 pnlReservation.add(lblRoomDebt);
		 
		 JLabel lblRoomDebt_1 = new JLabel();
		 lblRoomDebt_1.setText("-");
		 lblRoomDebt_1.setHorizontalAlignment(SwingConstants.CENTER);
		 lblRoomDebt_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 lblRoomDebt_1.setEnabled(false);
		 lblRoomDebt_1.setBounds(287, 584, 89, 30);
		 pnlReservation.add(lblRoomDebt_1);
		 
		 JLabel lblServiceReservationDebt = new JLabel();
		 lblServiceReservationDebt.setText("Service Reservation Debt:");
		 lblServiceReservationDebt.setEnabled(false);
		 lblServiceReservationDebt.setBounds(60, 650, 163, 16);
		 pnlReservation.add(lblServiceReservationDebt);
		 
		 JLabel lblServiceReservationDebt_1 = new JLabel();
		 lblServiceReservationDebt_1.setText("-");
		 lblServiceReservationDebt_1.setHorizontalAlignment(SwingConstants.CENTER);
		 lblServiceReservationDebt_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 lblServiceReservationDebt_1.setEnabled(false);
		 lblServiceReservationDebt_1.setBounds(287, 642, 89, 30);
		 pnlReservation.add(lblServiceReservationDebt_1);
		 
		 JLabel currencyL_1 = new JLabel();
		 currencyL_1.setText("TL");
		 currencyL_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 currencyL_1.setEnabled(false);
		 currencyL_1.setBounds(388, 584, 27, 34);
		 pnlReservation.add(currencyL_1);
		 
		 JLabel currencyL_1_1 = new JLabel();
		 currencyL_1_1.setText("TL");
		 currencyL_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 currencyL_1_1.setEnabled(false);
		 currencyL_1_1.setBounds(388, 642, 27, 34);
		 pnlReservation.add(currencyL_1_1);
		 
		 JSeparator separator_1_1 = new JSeparator();
		 separator_1_1.setBounds(22, 692, 603, 45);
		 pnlReservation.add(separator_1_1);
		 
		 JSeparator separator_1_1_1 = new JSeparator();
		 separator_1_1_1.setBounds(12, 563, 603, 45);
		 pnlReservation.add(separator_1_1_1);
		 

		 
		 JCheckBox chckbxNewCheckBox = new JCheckBox("User lost the entry card.");
		 chckbxNewCheckBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		if(chckbxNewCheckBox.isSelected())
		 			totalDebt = totalDebt + 100; 
		 		else
		 			totalDebt = totalDebt - 100;
		 		
		 		lblTotalDebt.setText(String.valueOf(totalDebt));
		 		
		 	}
		 });
		 chckbxNewCheckBox.setBounds(236, 451, 174, 25);
		 pnlReservation.add(chckbxNewCheckBox);
		 		 
		 //***
		 
		 
		 
		 JButton btnPay = new JButton("PAY");
		 btnPay.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		hotel.payCashForRoomReservation((int) jtGuestList.getModel().getValueAt(jtGuestList.getSelectedRow(),0), selectedRoom);
		 		hotel.payCashForServiceReservation((int) jtGuestList.getModel().getValueAt(jtGuestList.getSelectedRow(),0), selectedRoom);
		 		
		 		dispose();
		 	}
		 });
		 btnPay.setEnabled(false);
		 btnPay.setBounds(328, 822, 187, 25);
		 pnlReservation.add(btnPay);
		 
		 //***
		 
		 JComboBox cmbRooms = new JComboBox();
		 cmbRooms.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent arg0) {
		 		btnCalculate.setEnabled(true);

		 		lblRoomDebt_1.setText("");
		 		lblServiceReservationDebt_1.setText("");
		 		lblTotalDebt.setText("");
		 	}
		 });
		 cmbRooms.setBounds(264, 402, 117, 22);
		 pnlReservation.add(cmbRooms);
		 
		 //***
		 
		 
		 btnCalculate.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		roomFee = 0;
		 		serviceFee = 0;
		 		lblRoomDebt_1.setText("");
		 		lblServiceReservationDebt_1.setText("");
		 		lblTotalDebt.setText("");
		 		selectedRoom = (int)cmbRooms.getSelectedItem();
		 		
		 		for( int i = 0; i<roomReservationList.size();i++ )
		 		{
		 			if(roomReservationList.get(i).getOccupiedDate()<today && roomReservationList.get(i).getOccupiedRoom() == selectedRoom ){
		 				roomFee += hotel.getRoomFee((int)cmbRooms.getSelectedItem());
		 			}
		 		}
		 		
		 		for( int i = 0; i<serviceReservationList.size();i++ )
		 		{
		 			if(serviceReservationList.get(i).getOccupiedDate()<today && serviceReservationList.get(i).getOccupiedRoom() == (int)cmbRooms.getSelectedItem() ){
		 				serviceFee += hotel.getServiceFee("Cleaning");
		 			}
		 		}
		 		
		 		totalDebt = roomFee + serviceFee;
 		
		 		btnCalculate.setEnabled(false);
		 		
		 		lblRoomDebt_1.setText(String.valueOf(roomFee));
		 		lblServiceReservationDebt_1.setText(String.valueOf(serviceFee));
		 		lblTotalDebt.setText(String.valueOf(totalDebt));
		 		
		 		btnPay.setEnabled(true);
		 		lblRoomDebt_1.setEnabled(true);
		 		lblServiceReservationDebt_1.setEnabled(true);
		 		currencyL.setEnabled(true);
		 		currencyL_1.setEnabled(true);
		 		currencyL_1_1.setEnabled(true);
		 		lblTotalDebt.setEnabled(true);
		 	}
		 });
		 btnCalculate.setEnabled(false);
		 btnCalculate.setBounds(179, 509, 276, 25);
		 pnlReservation.add(btnCalculate);
		 

		 
		 //***
		 
		 String columnGuests[]={"ID","Guest Name"};
		 DefaultTableModel tableModelGuests = new DefaultTableModel(columnGuests, 0);
		 jtGuestList = new JTable(tableModelGuests);
		 jtGuestList.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		cmbRooms.removeAllItems();
		 		lblRoomDebt_1.setText("");
		 		lblServiceReservationDebt_1.setText("");
		 		lblTotalDebt.setText("");
		 		btnCalculate.setEnabled(false);
		 		btnPay.setEnabled(false);
		 		btnPay.setEnabled(false);
		 		lblRoomDebt_1.setEnabled(false);
		 		lblServiceReservationDebt_1.setEnabled(false);
		 		currencyL.setEnabled(false);
		 		currencyL_1.setEnabled(false);
		 		currencyL_1_1.setEnabled(false);
		 		lblTotalDebt.setEnabled(false);
		 		
		 		roomReservationList = new ArrayList<Reservation>();
		 		roomReservationList = hotel.GetUserNotCanceledRoomReservations((int) jtGuestList.getModel().getValueAt(jtGuestList.getSelectedRow(), 0));
		 		ArrayList<Integer> rooms = new ArrayList<>();
		 		
		 		for( int i = 0; i<roomReservationList.size();i++ )
		 		{
		 			rooms.add(roomReservationList.get(i).getOccupiedRoom());
		 		}
		 		
		 		//just for rooms...
		 		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(rooms);
		 		ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(hashSet);
		 		for(int i = 0;i<listWithoutDuplicates.size(); i++){
		 			cmbRooms.addItem(listWithoutDuplicates.get(i));
		 		}
		 		
		 		serviceReservationList = new ArrayList<domain.ReservationForServices>();
		 		serviceReservationList = hotel.GetUserNotCanceledServiceReservations((int) jtGuestList.getModel().getValueAt(jtGuestList.getSelectedRow(), 0));
		 		ArrayList<Integer> reservedtimeSlots = new ArrayList<>();
		 		
		 		for( int i = 0; i<serviceReservationList.size();i++ )
		 		{
		 			reservedtimeSlots.add(serviceReservationList.get(i).getTimeSlotID());
		 		}
		 		
		 		
		 		if(cmbRooms.getItemCount()>0){
		 			btnCalculate.setEnabled(true);
		 		}
		 	}
		 });
		 
		 
		 jtGuestList.setShowGrid(false);
		 jtGuestList.setBorder(new LineBorder(new Color(0, 0, 0)));
		 jtGuestList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 jtGuestList.setBounds(462,95,295,300);
		 jtGuestList.removeColumn(jtGuestList.getColumnModel().getColumn(0)); // to hide ID in the table.
		 
		 Object[] rowGuestData;
		 ArrayList<User> users = null;
		 try {
			users = new ArrayList<User>();
			rowGuestData = new Object[4];
			users = hotel.retrieveUsersWithRole("Guest");
			for(int i = 0; i< users.size();i++){
				
				rowGuestData[0] = users.get(i).getIDNumber();
				rowGuestData[1] = users.get(i).getFullName();
				tableModelGuests.addRow(rowGuestData);
			}		
		
		}finally{
			if(tableModelGuests.getRowCount() == 0)
				lblNoDataAvailableGuest.setVisible(true);
			else 
			users.clear();
		}
		 
		 JScrollPane spGuestList = new JScrollPane(jtGuestList);
	
		 spGuestList.setLocation(115, 103);
		 spGuestList.setSize(121, 215);
		 spGuestList.setVisible(true);
		 spGuestList.setBounds(60,148,520,215);
		 pnlReservation.add(spGuestList);
		 
		 JLabel lblchooseGuest = new JLabel();
		 lblchooseGuest.setEnabled(false);
		 lblchooseGuest.setText("Select the guest to check out:");
		 lblchooseGuest.setBounds(60, 119, 247, 16);
		 pnlReservation.add(lblchooseGuest);
		 

	
		 //***
		 
		 JButton btnBack = new JButton("Close");
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 		
		 	}
		 });
		 btnBack.setBounds(527, 822, 98, 25);
		 pnlReservation.add(btnBack);
		 
		 JSeparator separator_1 = new JSeparator();
		 separator_1.setBounds(22, 802, 603, 45);
		 pnlReservation.add(separator_1);
		 
		 
		 

	}
}

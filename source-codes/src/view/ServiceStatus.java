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

public class ServiceStatus extends JFrame {


	/**
	 * 
	 */
	
	public ServiceStatus(Hotel hotel, domain.ReservationForServices reservation) {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 650);
		JPanel pnlReservation = new JPanel();
		pnlReservation.setForeground(Color.RED);
		pnlReservation.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlReservation.setBackground(new Color(240, 240, 240));
		setContentPane(pnlReservation);
		pnlReservation.setLayout(null);
		JLabel lblGuest = new JLabel();
		
 		JSeparator separator = new JSeparator();
 		separator.setBounds(12, 65, 546, 8);
 		pnlReservation.add(separator);
 		
 		JLabel lblGuest_1 = new JLabel();
 		lblGuest_1.setText(hotel.retrieveUserWithID(reservation.getOccupiedBy()).getFullName());
 		lblGuest_1.setFont(new Font("Tahoma", Font.BOLD, 15));
 		lblGuest_1.setEnabled(false);
 		lblGuest_1.setBounds(283, 279, 247, 30);
 		pnlReservation.add(lblGuest_1);
 		
 		JLabel lblDate_1 = new JLabel();
 		lblDate_1.setText(String.valueOf(reservation.getOccupiedDate()));
 		lblDate_1.setFont(new Font("Tahoma", Font.BOLD, 15));
 		lblDate_1.setEnabled(false);
 		lblDate_1.setBounds(283, 174, 247, 30);
 		pnlReservation.add(lblDate_1);
 		
 		JLabel lblServiceType_1 =new JLabel();
 		lblServiceType_1.setText("Cleaning");
 		lblServiceType_1.setFont(new Font("Tahoma", Font.BOLD, 15));
 		lblServiceType_1.setEnabled(false);
 		lblServiceType_1.setBounds(283, 120, 247, 30);
 		pnlReservation.add(lblServiceType_1);
 		
 		JSeparator separator_1 = new JSeparator();
 		separator_1.setBounds(12, 537, 546, 8);
 		pnlReservation.add(separator_1);
 		
 		//***
 		
		 
		 lblGuest.setText("Guest:");
		 lblGuest.setBounds(64, 287, 191, 16);
		 pnlReservation.add(lblGuest);
		
		 JButton btnBack = new JButton("Close");
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 	}
		 });
		 btnBack.setBounds(460, 558, 98, 25);
		 pnlReservation.add(btnBack);
		 
		 JLabel lblHeading = new JLabel("Service Status");
		 lblHeading.setForeground(SystemColor.textInactiveText);
		 lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		 lblHeading.setFont(new Font("Serif", Font.PLAIN, 20));
		 lblHeading.setBounds(12, 24, 546, 16);
		 pnlReservation.add(lblHeading);
		 
		 JLabel lblDate = new JLabel();
		 lblDate.setText("Date:");
		 lblDate.setBounds(64, 182, 191, 16);
		 pnlReservation.add(lblDate);
		 
		 JLabel lblServiceType = new JLabel();
		 lblServiceType.setText("Service Type:");
		 lblServiceType.setBounds(64, 128, 191, 16);
		 pnlReservation.add(lblServiceType);
		 
		 //***
			
			JLabel lblTimeSlot = new JLabel();
			lblTimeSlot.setText("Time Slot:");
			lblTimeSlot.setBounds(64, 232, 191, 16);
			pnlReservation.add(lblTimeSlot);
			
			JLabel lblTimeSlot_1 = new JLabel();
			lblTimeSlot_1.setText(hotel.getTimeSlot(reservation.getTimeSlotID()).getTimeSlot());
			lblTimeSlot_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTimeSlot_1.setEnabled(false);
			lblTimeSlot_1.setBounds(283, 224, 247, 30);
			pnlReservation.add(lblTimeSlot_1);
			
			JLabel lblReservedRoom = new JLabel();
			lblReservedRoom.setText("Ordered Room:");
			lblReservedRoom.setBounds(64, 344, 191, 16);
			pnlReservation.add(lblReservedRoom);
			
			JLabel lblReservedRoom_1 = new JLabel();
			lblReservedRoom_1.setText(String.valueOf(reservation.getOccupiedRoom()));
			lblReservedRoom_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblReservedRoom_1.setEnabled(false);
			lblReservedRoom_1.setBounds(283, 336, 247, 30);
			pnlReservation.add(lblReservedRoom_1);
			
			JLabel lblServiceFee = new JLabel();
			lblServiceFee.setText("Service Fee");
			lblServiceFee.setBounds(63, 396, 191, 16);
			pnlReservation.add(lblServiceFee);
			
			JLabel lblServiceFee_1 = new JLabel();
			lblServiceFee_1.setText("100");
			lblServiceFee_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblServiceFee_1.setEnabled(false);
			lblServiceFee_1.setBounds(283, 388, 38, 30);
			pnlReservation.add(lblServiceFee_1);
			
			JLabel currencyL_1 = new JLabel();
			currencyL_1.setText("TL");
			currencyL_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			currencyL_1.setEnabled(false);
			currencyL_1.setBounds(333, 386, 27, 34);
			pnlReservation.add(currencyL_1);
	 	
	 		
	 		
	}
}

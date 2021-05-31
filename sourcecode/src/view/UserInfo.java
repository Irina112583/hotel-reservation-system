package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import domain.Hotel;
import domain.LoginSingleton;
import domain.User;

public class UserInfo extends JFrame {

	/**
	 * 
	 */

	
	public UserInfo(Hotel hotel) {

		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1047, 403);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JPanel pnlRegister = new JPanel();
		pnlRegister.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlRegister.setBackground(Color.WHITE);
		setContentPane(pnlRegister);
		pnlRegister.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBackground(new Color(192, 192, 192));
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Calibri", Font.BOLD, 15));
		lblName.setBounds(22, 162, 150, 24);
		pnlRegister.add(lblName);
		
		JTextArea txtName = new JTextArea();
		txtName.setEnabled(false);
		txtName.setBounds(184, 158, 300, 33);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtName.setBorder(BorderFactory.createCompoundBorder(border, 
		      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setVisible(false);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPassword.setBackground(Color.LIGHT_GRAY);
		lblPassword.setBounds(546, 109, 150, 24);
		pnlRegister.add(lblPassword);
		
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setEnabled(false);
		txtPassword.setVisible(false);
		txtPassword.setBounds(708, 103, 300, 33);
		txtPassword.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtPassword);
		
	
		JButton btnStartReservation = new JButton("Start Reservation");
		btnStartReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hotel.getRole().equals("Receptionist")){
					ReservationWithReceptionist res = new ReservationWithReceptionist(hotel);
					res.setVisible(true);	
				} else {
					Reservation res = new Reservation(hotel);
					res.setVisible(true);
				}
			}
		});

		JButton btnEditReservation = new JButton("Edit Reservation");
		
		btnEditReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hotel.getRole().equals("Receptionist")){
					UpdateReservations res = new UpdateReservations(hotel);
					res.setVisible(true);	
				}
			}
		});
		
		JButton btnOrderCleaningReservation = new JButton("Order Additional Cleaning Service");
		
		btnOrderCleaningReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hotel.currentUser.getEntryCard().getCardNumber()==0) {
					JOptionPane.showMessageDialog(null, "Make reservaion of the room first");
				} else {
					CleaningServiceReservation res = new CleaningServiceReservation(hotel);
					res.setVisible(true);
				}
			}
		});
		
		JButton btnOrderedCleaningReservations = new JButton("Handle Additional Cleaning Service");
		
		btnOrderedCleaningReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hotel.currentUser.getEntryCard().getCardNumber()==0) {
					JOptionPane.showMessageDialog(null, "Make reservaion of the room first");
				} else {
					UpdateOrderedCleaningServices handleCS = new UpdateOrderedCleaningServices(hotel);
					handleCS.setVisible(true);
				}	
			}
		});
		
		JButton btnHandleCashPayment = new JButton("Handle Cash Payment");
		
		btnHandleCashPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CashPayment handlePayment = new CashPayment(hotel);
				handlePayment.setVisible(true);	
			}
		});
		
		JButton btnMonitorReservations = new JButton("Monitor Reservations");
		
		btnMonitorReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonitorReservations monitorReservations = new MonitorReservations(hotel);
				monitorReservations.setVisible(true);	
			}
		});
		
		btnStartReservation.setBounds(861, 247, 147, 25);
		pnlRegister.add(btnStartReservation);
		
		btnEditReservation.setBounds(861, 287, 147, 25);
		pnlRegister.add(btnEditReservation);
		
		btnOrderCleaningReservation.setBounds(551, 247, 247, 25);
		pnlRegister.add(btnOrderCleaningReservation);
		
		btnOrderedCleaningReservations.setBounds(551, 287, 247, 25);
		pnlRegister.add(btnOrderedCleaningReservations);
		
		btnHandleCashPayment.setBounds(551, 247, 247, 25);
		pnlRegister.add(btnHandleCashPayment);
		
		btnMonitorReservations.setBounds(661, 327, 247, 25);
		pnlRegister.add(btnMonitorReservations);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		pnlRegister.add(panel);
		
		JLabel lblRetypePassword = new JLabel("Repeat Password:");
		lblRetypePassword.setVisible(false);
		lblRetypePassword.setForeground(Color.BLACK);
		lblRetypePassword.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRetypePassword.setBackground(Color.LIGHT_GRAY);
		lblRetypePassword.setBounds(546, 173, 150, 24);
		pnlRegister.add(lblRetypePassword);
		
		JPasswordField txtRetypePassword = new JPasswordField();
		txtRetypePassword.setVisible(false);
		txtRetypePassword.setEnabled(false);
		txtRetypePassword.setBounds(708, 167, 300, 33);
		txtRetypePassword.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtRetypePassword);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setForeground(Color.BLACK);
		lblEmailAddress.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEmailAddress.setBackground(Color.LIGHT_GRAY);
		lblEmailAddress.setBounds(22, 284, 150, 24);
		pnlRegister.add(lblEmailAddress);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 15));
		lblUsername.setBackground(Color.LIGHT_GRAY);
		lblUsername.setBounds(22, 222, 150, 24);
		pnlRegister.add(lblUsername);
		
		JTextArea txtUsername = new JTextArea();
		txtUsername.setEnabled(false);
		txtUsername.setBounds(184, 218, 300, 33);
		txtUsername.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtUsername);
		
		JTextArea txtEmailAddress = new JTextArea();
		txtEmailAddress.setEnabled(false);
		txtEmailAddress.setBounds(184, 280, 300, 33);
		txtEmailAddress.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtEmailAddress);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Calibri", Font.BOLD, 15));
		lblID.setBackground(Color.LIGHT_GRAY);
		lblID.setBounds(22, 103, 150, 24);
		pnlRegister.add(lblID);
		
		JTextArea txtID = new JTextArea();
		txtID.setEnabled(false);
		txtID.setBounds(184, 99, 300, 33);
		txtID.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtID);
		
		JLabel lblWelcome = new JLabel("Welcome Username!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(139, 0, 0));
		lblWelcome.setFont(new Font("Georgia", Font.BOLD, 30));
		lblWelcome.setBackground(Color.PINK);
		lblWelcome.setBounds(22, 13, 1007, 46);
		pnlRegister.add(lblWelcome);
		
		JLabel lblRole_1 = new JLabel("...");
		lblRole_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRole_1.setEnabled(false);
		lblRole_1.setForeground(Color.BLACK);
		lblRole_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRole_1.setBackground(Color.LIGHT_GRAY);
		lblRole_1.setBounds(22, 62, 1017, 24);
		pnlRegister.add(lblRole_1);
		
		JButton btnApprovals = new JButton("Approvals");
		btnApprovals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This part will be implemented later.");
			}
		});
		btnApprovals.setBounds(691, 247, 147, 25);
		btnApprovals.setVisible(false);
		pnlRegister.add(btnApprovals);
		
		JButton btnMonitorSystem = new JButton("Monitor the System");
		btnMonitorSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This part will be implemented later.");
			}
		});
		btnMonitorSystem.setBounds(691, 292, 147, 25);
		btnMonitorSystem.setVisible(false);
		pnlRegister.add(btnMonitorSystem);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotel.updateUser(hotel.getIDNumber(), txtName.getText(), txtUsername.getText(), txtPassword.getText(), txtEmailAddress.getText(), hotel.getRole());
				txtID.setText(String.valueOf(hotel.getIDNumber()));
				lblWelcome.setText("Welcome " + hotel.getFullName());
				txtName.setText(hotel.getFullName());
				txtUsername.setText(hotel.getUsername());
				txtEmailAddress.setText(hotel.getEmailAddress());
				lblRole_1.setText(hotel.getRole());
				
				btnSave.setVisible(false);
				txtPassword.setVisible(false);
				txtPassword.setEnabled(false);
				lblPassword.setVisible(false);
				txtRetypePassword.setVisible(false);
				txtRetypePassword.setEnabled(false);
				lblRetypePassword.setVisible(false);
				txtName.setEnabled(false);
				txtUsername.setEnabled(false);
				txtEmailAddress.setEnabled(false);
				if(hotel.getIDNumber() == 1)
				{
					btnApprovals.setVisible(true);
					btnMonitorSystem.setVisible(true);
					btnMonitorReservations.setVisible(true);
				}
				if(hotel.getRole().equals("Receptionist")) {
					btnStartReservation.setVisible(true);
					btnHandleCashPayment.setVisible(true);
					btnEditReservation.setVisible(true);
					btnMonitorReservations.setVisible(true);
				}
				if(hotel.getRole().equals("Guest")) {
					btnStartReservation.setVisible(true);
					btnOrderedCleaningReservations.setVisible(true);
					btnOrderCleaningReservation.setVisible(true);
				}
			}
		});
		btnSave.setBounds(861, 292, 147, 25);
		pnlRegister.add(btnSave);
		
		
		
		
		JMenuItem updateOptionMenu = new JMenuItem("Update Account");
		updateOptionMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnStartReservation.setVisible(false);
				btnEditReservation.setVisible(false);
				btnOrderedCleaningReservations.setVisible(false);
				btnOrderCleaningReservation.setVisible(false);
				btnHandleCashPayment.setVisible(false);
				btnMonitorReservations.setVisible(false);
				btnSave.setVisible(true);
				txtPassword.setVisible(true);
				txtPassword.setEnabled(true);
				lblPassword.setVisible(true);
				txtRetypePassword.setVisible(true);
				txtRetypePassword.setEnabled(true);
				lblRetypePassword.setVisible(true);
				txtName.setEnabled(true);
				txtEmailAddress.setEnabled(true);
				btnMonitorSystem.setVisible(false);
				btnApprovals.setVisible(false);
			}
		});
		updateOptionMenu.setVisible(true);
		JMenuItem deleteOptionMenu = new JMenuItem("Delete Account");
		deleteOptionMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hotel.deleteUser(hotel.getIDNumber());
				JOptionPane.showMessageDialog(null, "Thank you for using HRS!");
				System.exit(ABORT);
			}
		});
		deleteOptionMenu.setVisible(true);
		JMenuItem exitOptionMenu = new JMenuItem("Sign Out");
		exitOptionMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Goodbye!");
				view.UserInfo.this.setVisible(false);
				LoginSingleton.getInstance();
			}
		});
		exitOptionMenu.setVisible(true);
		
		txtID.setText(String.valueOf(hotel.getIDNumber()));
		lblWelcome.setText("Welcome " + hotel.getFullName());
		txtName.setText(hotel.getFullName());
		txtUsername.setText(hotel.getUsername());
		txtEmailAddress.setText(hotel.getEmailAddress());
		lblRole_1.setText(hotel.getRole());
		

		if(hotel.getIDNumber() == 1)
		{
			btnMonitorSystem.setVisible(true);
			btnApprovals.setVisible(true);
			btnStartReservation.setVisible(false);
			btnEditReservation.setVisible(false);
			btnOrderCleaningReservation.setVisible(false);
			btnOrderedCleaningReservations.setVisible(false);
			btnHandleCashPayment.setVisible(false);
			btnMonitorReservations.setVisible(true);
		}
		
		if(hotel.getRole().equals("Guest"))
		{
			btnEditReservation.setVisible(false);
			btnOrderCleaningReservation.setVisible(true);
			btnOrderedCleaningReservations.setVisible(true);
			btnHandleCashPayment.setVisible(false);
			btnMonitorReservations.setVisible(false);
		}
		
		if(hotel.getRole().equals("Receptionist"))
		{
			btnOrderCleaningReservation.setVisible(false);
			btnOrderedCleaningReservations.setVisible(false);
			btnHandleCashPayment.setVisible(true);
			btnMonitorReservations.setVisible(true);
		}
		
		JMenu mnOptions = new JMenu("More Options...");
		mnOptions.add(updateOptionMenu);
		mnOptions.add(deleteOptionMenu);
		mnOptions.add(exitOptionMenu);
		mnOptions.setBounds(867, 26, 123, 24);
		
		menuBar.add(mnOptions);		
	

		
	}
}

package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import domain.Hotel;
import domain.User;
import java.awt.SystemColor;

public class UserInfo extends JFrame {

	/**
	 * 
	 */

	
	public UserInfo(Hotel hotel) {

		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 574);
		
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
		lblName.setBounds(22, 258, 150, 24);
		pnlRegister.add(lblName);
		
		JTextArea txtName = new JTextArea();
		txtName.setEnabled(false);
		txtName.setBounds(184, 254, 300, 33);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtName.setBorder(BorderFactory.createCompoundBorder(border, 
		      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setVisible(false);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPassword.setBackground(Color.LIGHT_GRAY);
		lblPassword.setBounds(22, 321, 150, 24);
		pnlRegister.add(lblPassword);
		
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setEnabled(false);
		txtPassword.setVisible(false);
		txtPassword.setBounds(184, 315, 300, 33);
		txtPassword.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtPassword);
		
	
		JButton btnStartReservation = new JButton("Start Reservation");
		btnStartReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hotel.getCurrentUser().getRole().equals("Receptionist")){
					ReservationWithRec res = new ReservationWithRec(hotel);
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
				if(hotel.getCurrentUser().getRole().equals("Receptionist")){
					ReservationEditor res = new ReservationEditor(hotel);
					res.setVisible(true);	
				}
			}
		});
		
		JButton btnOrderCleaningReservation = new JButton("Order Cleaning Service");
		
		btnOrderCleaningReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					ReservationForServices rfs = new ReservationForServices(hotel);
					rfs.setVisible(true);
			}
		});
		
		JButton btnEditCleaningReservations = new JButton("Edit Cleaning Service");
		
		btnEditCleaningReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationForServicesEditor rfse = new ReservationForServicesEditor(hotel);
				rfse.setVisible(true);
			}
		});
		
		JButton btnHandleCashPayment = new JButton("Handle Cash Payment");
		
		btnHandleCashPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NetCashPayment netCashPayment = new NetCashPayment(hotel);
				netCashPayment.setVisible(true);
			}
		});
		
		JButton btnMonitorReservations = new JButton("Monitor Reservations");
		
		btnMonitorReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationMonitoring resMon = new ReservationMonitoring(hotel);
				resMon.setVisible(true);
				
			}
		});
		
		btnStartReservation.setBounds(805, 462, 224, 25);
		pnlRegister.add(btnStartReservation);
		
		btnEditReservation.setBounds(287, 462, 247, 25);
		pnlRegister.add(btnEditReservation);
		
		btnOrderCleaningReservation.setBounds(546, 462, 247, 25);
		pnlRegister.add(btnOrderCleaningReservation);
		
		btnEditCleaningReservations.setBounds(287, 462, 247, 25);
		pnlRegister.add(btnEditCleaningReservations);
		
		btnHandleCashPayment.setBounds(22, 462, 247, 25);
		pnlRegister.add(btnHandleCashPayment);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 441, 1007, 2);
		pnlRegister.add(separator);
		
		btnMonitorReservations.setBounds(546, 462, 247, 25);
		pnlRegister.add(btnMonitorReservations);
		
		JLabel lblRetypePassword = new JLabel("Repeat Password:");
		lblRetypePassword.setVisible(false);
		lblRetypePassword.setForeground(Color.BLACK);
		lblRetypePassword.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRetypePassword.setBackground(Color.LIGHT_GRAY);
		lblRetypePassword.setBounds(546, 318, 150, 24);
		pnlRegister.add(lblRetypePassword);
		
		JPasswordField txtRetypePassword = new JPasswordField();
		txtRetypePassword.setVisible(false);
		txtRetypePassword.setEnabled(false);
		txtRetypePassword.setBounds(708, 312, 300, 33);
		txtRetypePassword.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtRetypePassword);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setForeground(Color.BLACK);
		lblEmailAddress.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEmailAddress.setBackground(Color.LIGHT_GRAY);
		lblEmailAddress.setBounds(546, 253, 150, 24);
		pnlRegister.add(lblEmailAddress);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 15));
		lblUsername.setBackground(Color.LIGHT_GRAY);
		lblUsername.setBounds(546, 194, 150, 24);
		pnlRegister.add(lblUsername);
		
		JTextArea txtUsername = new JTextArea();
		txtUsername.setEnabled(false);
		txtUsername.setBounds(708, 190, 300, 33);
		txtUsername.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtUsername);
		
		JTextArea txtEmailAddress = new JTextArea();
		txtEmailAddress.setEnabled(false);
		txtEmailAddress.setBounds(708, 249, 300, 33);
		txtEmailAddress.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtEmailAddress);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Calibri", Font.BOLD, 15));
		lblID.setBackground(Color.LIGHT_GRAY);
		lblID.setBounds(22, 199, 150, 24);
		pnlRegister.add(lblID);
		
		JTextArea txtID = new JTextArea();
		txtID.setEnabled(false);
		txtID.setBounds(184, 195, 300, 33);
		txtID.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtID);
		
		JLabel lblWelcome = new JLabel("Username");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(SystemColor.textHighlight);
		lblWelcome.setFont(new Font("Georgia", Font.BOLD, 30));
		lblWelcome.setBackground(Color.PINK);
		lblWelcome.setBounds(22, 46, 1007, 46);
		pnlRegister.add(lblWelcome);
		
		JLabel lblRole_1 = new JLabel("...");
		lblRole_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRole_1.setEnabled(false);
		lblRole_1.setForeground(SystemColor.textInactiveText);
		lblRole_1.setFont(new Font("Serif", Font.BOLD, 20));
		lblRole_1.setBackground(Color.LIGHT_GRAY);
		lblRole_1.setBounds(22, 105, 1009, 24);
		pnlRegister.add(lblRole_1);
		
		JButton btnApprovals = new JButton("Approvals");
		btnApprovals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserApprovals userApprovals = new UserApprovals(hotel);
 				userApprovals.setVisible(true);
			}
		});
		btnApprovals.setBounds(805, 462, 226, 25);
		btnApprovals.setVisible(false);
		pnlRegister.add(btnApprovals);
		
		JButton btnMonitorSystem = new JButton("Monitor the System");
		btnMonitorSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This part will be implemented later.");
			}
		});
		btnMonitorSystem.setBounds(287, 462, 247, 25);
		btnMonitorSystem.setVisible(false);
		pnlRegister.add(btnMonitorSystem);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!txtPassword.getText().equals(txtRetypePassword.getText())){
					JOptionPane.showMessageDialog(null, "Password fields are not matching.", "Warning", JOptionPane.WARNING_MESSAGE);
					txtPassword.setText("");
					txtRetypePassword.setText("");
					return;
				}
						
				hotel.updateUser(hotel.getCurrentUser().getIDNumber(), txtName.getText(), txtUsername.getText(), txtPassword.getText(), txtEmailAddress.getText(), hotel.getCurrentUser().getRole());
				txtID.setText(String.valueOf(hotel.getCurrentUser().getIDNumber()));
				lblWelcome.setText(hotel.getCurrentUser().getFullName());
				txtName.setText(hotel.getCurrentUser().getFullName());
				txtUsername.setText(hotel.getCurrentUser().getUsername());
				txtEmailAddress.setText(hotel.getCurrentUser().getEmailAddress());
				lblRole_1.setText(hotel.getCurrentUser().getRole());
				
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
				if(hotel.getCurrentUser().getRole().equals("Manager"))
				{
					btnApprovals.setVisible(true);
					btnMonitorSystem.setVisible(true);
					btnMonitorReservations.setVisible(true);
				}
				if(hotel.getCurrentUser().getRole().equals("Receptionist")) {
					btnStartReservation.setVisible(true);
					btnHandleCashPayment.setVisible(true);
					btnEditReservation.setVisible(true);
					btnMonitorReservations.setVisible(true);
				}
				if(hotel.getCurrentUser().getRole().equals("Guest")) {
					btnStartReservation.setVisible(true);
					btnEditCleaningReservations.setVisible(true);
					btnOrderCleaningReservation.setVisible(true);
				}
			}
		});
		btnSave.setBounds(805, 403, 224, 25);
		pnlRegister.add(btnSave);
		
		
		
		
		JMenuItem updateOptionMenu = new JMenuItem("Update Account");
		updateOptionMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnStartReservation.setVisible(false);
				btnEditReservation.setVisible(false);
				btnEditCleaningReservations.setVisible(false);
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
				if(JOptionPane.showConfirmDialog(null, "Are you sure to delete your account and exit the system?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
 				{
				hotel.deleteUser(hotel.getCurrentUser().getIDNumber());
				System.exit(ABORT);
 				}
			}
		});
		deleteOptionMenu.setVisible(true);
		JMenuItem exitOptionMenu = new JMenuItem("Sign Out");
		exitOptionMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Goodbye!");
				view.UserInfo.this.setVisible(false);
				Login loginPage = new Login();
				loginPage.setVisible(true);
			}
		});
		exitOptionMenu.setVisible(true);
		
		txtID.setText(String.valueOf(hotel.getCurrentUser().getIDNumber()));
		lblWelcome.setText(hotel.getCurrentUser().getFullName());
		txtName.setText(hotel.getCurrentUser().getFullName());
		txtUsername.setText(hotel.getCurrentUser().getUsername());
		txtEmailAddress.setText(hotel.getCurrentUser().getEmailAddress());
		lblRole_1.setText(hotel.getCurrentUser().getRole());
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 142, 1007, 2);
		pnlRegister.add(separator_1);
		
		JLabel lblWelcome_1 = new JLabel("Welcome!");
		lblWelcome_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome_1.setForeground(SystemColor.textHighlight);
		lblWelcome_1.setFont(new Font("Georgia", Font.BOLD, 25));
		lblWelcome_1.setBackground(Color.PINK);
		lblWelcome_1.setBounds(22, 0, 1007, 46);
		pnlRegister.add(lblWelcome_1);
		
		
		JMenu mnOptions = new JMenu("More Options...");
		mnOptions.add(updateOptionMenu);
		mnOptions.add(deleteOptionMenu);
		mnOptions.add(exitOptionMenu);
		mnOptions.setBounds(867, 26, 123, 24);
		
		menuBar.add(mnOptions);		


		if(hotel.getCurrentUser().getRole().equals("Manager"))
		{
			btnMonitorSystem.setVisible(true);
			btnApprovals.setVisible(true);
			btnStartReservation.setVisible(false);
			btnEditReservation.setVisible(false);
			btnOrderCleaningReservation.setVisible(false);
			btnEditCleaningReservations.setVisible(false);
			btnHandleCashPayment.setVisible(false);
			btnMonitorReservations.setVisible(true);
			mnOptions.remove(deleteOptionMenu);
		}
		
		if(hotel.getCurrentUser().getRole().equals("Guest"))
		{
			btnEditReservation.setVisible(false);
			btnOrderCleaningReservation.setVisible(true);
			btnEditCleaningReservations.setVisible(true);
			btnHandleCashPayment.setVisible(false);
			btnMonitorReservations.setVisible(false);
		}
		
		if(hotel.getCurrentUser().getRole().equals("Receptionist"))
		{
			btnOrderCleaningReservation.setVisible(false);
			btnEditCleaningReservations.setVisible(false);
			btnHandleCashPayment.setVisible(true);
			btnMonitorReservations.setVisible(true);
		}

	}
}

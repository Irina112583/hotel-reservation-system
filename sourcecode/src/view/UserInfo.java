package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import domain.DB;



public class UserInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	public UserInfo() {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1047, 466);
		JPanel pnlRegister = new JPanel();
		pnlRegister.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlRegister.setBackground(Color.WHITE);
		setContentPane(pnlRegister);
		pnlRegister.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBackground(new Color(192, 192, 192));
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Calibri", Font.BOLD, 15));
		lblName.setBounds(22, 247, 150, 24);
		pnlRegister.add(lblName);
		
		JTextArea txtName = new JTextArea();
		txtName.setEnabled(false);
		txtName.setBounds(184, 243, 300, 33);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtName.setBorder(BorderFactory.createCompoundBorder(border, 
		      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setVisible(false);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPassword.setBackground(Color.LIGHT_GRAY);
		lblPassword.setBounds(546, 313, 150, 24);
		pnlRegister.add(lblPassword);
		
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setEnabled(false);
		txtPassword.setVisible(false);
		txtPassword.setBounds(708, 307, 300, 33);
		txtPassword.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtPassword);
		
		JButton btnDone = new JButton("Skip To Reservation Page");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnDone.setBounds(708, 217, 300, 25);
		pnlRegister.add(btnDone);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		pnlRegister.add(panel);
		
		JLabel lblRetypePassword = new JLabel("Retype Password:");
		lblRetypePassword.setVisible(false);
		lblRetypePassword.setForeground(Color.BLACK);
		lblRetypePassword.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRetypePassword.setBackground(Color.LIGHT_GRAY);
		lblRetypePassword.setBounds(546, 371, 150, 24);
		pnlRegister.add(lblRetypePassword);
		
		JPasswordField txtRetypePassword = new JPasswordField();
		txtRetypePassword.setVisible(false);
		txtRetypePassword.setEnabled(false);
		txtRetypePassword.setBounds(708, 365, 300, 33);
		txtRetypePassword.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtRetypePassword);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setForeground(Color.BLACK);
		lblEmailAddress.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEmailAddress.setBackground(Color.LIGHT_GRAY);
		lblEmailAddress.setBounds(22, 369, 150, 24);
		pnlRegister.add(lblEmailAddress);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 15));
		lblUsername.setBackground(Color.LIGHT_GRAY);
		lblUsername.setBounds(22, 307, 150, 24);
		pnlRegister.add(lblUsername);
		
		JTextArea txtUsername = new JTextArea();
		txtUsername.setEnabled(false);
		txtUsername.setBounds(184, 303, 300, 33);
		txtUsername.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtUsername);
		
		JTextArea txtEmailAddress = new JTextArea();
		txtEmailAddress.setEnabled(false);
		txtEmailAddress.setBounds(184, 365, 300, 33);
		txtEmailAddress.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtEmailAddress);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Calibri", Font.BOLD, 15));
		lblID.setBackground(Color.LIGHT_GRAY);
		lblID.setBounds(22, 188, 150, 24);
		pnlRegister.add(lblID);
		
		JTextArea txtID = new JTextArea();
		txtID.setEnabled(false);
		txtID.setBounds(184, 184, 300, 33);
		txtID.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtID);
		
		JLabel lblRole = new JLabel("Role:");
		lblRole.setForeground(Color.BLACK);
		lblRole.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRole.setBackground(Color.LIGHT_GRAY);
		lblRole.setBounds(22, 132, 150, 24);
		pnlRegister.add(lblRole);
		
		JLabel lblWelcome = new JLabel("Welcome Username!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(139, 0, 0));
		lblWelcome.setFont(new Font("Georgia", Font.BOLD, 30));
		lblWelcome.setBackground(Color.PINK);
		lblWelcome.setBounds(22, 0, 1007, 104);
		pnlRegister.add(lblWelcome);
		
		JButton btnUpdateAccount = new JButton("Update Account");
		btnUpdateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateAccount.setText("Save");
				txtID.setEnabled(true);
				txtName.setEnabled(true);
				txtUsername.setEnabled(true);
				txtEmailAddress.setEnabled(true);
				txtPassword.setEnabled(true);
				txtPassword.setVisible(true);
				txtRetypePassword.setEnabled(true);
				txtRetypePassword.setVisible(true);
				lblPassword.setVisible(true);
				lblRetypePassword.setVisible(true);
				
			}
		});
		btnUpdateAccount.setBounds(708, 117, 300, 25);
		pnlRegister.add(btnUpdateAccount);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteAccount.setBounds(708, 167, 300, 25);
		pnlRegister.add(btnDeleteAccount);
		
		JLabel lblRole_1 = new JLabel("...");
		lblRole_1.setEnabled(false);
		lblRole_1.setForeground(Color.BLACK);
		lblRole_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRole_1.setBackground(Color.LIGHT_GRAY);
		lblRole_1.setBounds(184, 132, 300, 24);
		pnlRegister.add(lblRole_1);
		
		//txtID.setText(u.getID());
		
		lblWelcome.setText("Welcome " + DB.getDataInstance().getFullName());
		txtName.setText(DB.getDataInstance().getFullName());
		txtUsername.setText(DB.getDataInstance().getUsername());
		txtEmailAddress.setText(DB.getDataInstance().getEmailAddress());
		lblRole_1.setText(DB.getDataInstance().getRole());

	}
}

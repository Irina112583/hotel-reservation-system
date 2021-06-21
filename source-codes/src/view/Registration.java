package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.MaskFormatter;

import domain.Hotel;
import javax.swing.JFormattedTextField;

public class Registration extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	public Registration(Hotel hotel) {

		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 923);
		JPanel pnlRegister = new JPanel();
		pnlRegister.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlRegister.setBackground(Color.WHITE);
		setContentPane(pnlRegister);
		pnlRegister.setLayout(null);
		
		JLabel lblID = new JLabel("ID Number:");
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Calibri", Font.BOLD, 15));
		lblID.setBackground(Color.LIGHT_GRAY);
		lblID.setBounds(62, 356, 150, 24);
		pnlRegister.add(lblID);
		
		JLabel lblJustDigit = new JLabel("Just 7 digit allowed.");
		lblJustDigit.setForeground(Color.RED);
		lblJustDigit.setFont(new Font("Calibri", Font.ITALIC, 12));
		lblJustDigit.setBackground(Color.LIGHT_GRAY);
		lblJustDigit.setBounds(62, 371, 150, 24);
		pnlRegister.add(lblJustDigit);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBackground(new Color(192, 192, 192));
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Calibri", Font.BOLD, 15));
		lblName.setBounds(62, 415, 150, 24);
		pnlRegister.add(lblName);
		
		JTextArea txtName = new JTextArea();
		txtName.setBounds(224, 411, 300, 33);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtName.setBorder(BorderFactory.createCompoundBorder(border, 
		      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		pnlRegister.add(txtName);
		
		JLabel lblimg = new JLabel("");
		lblimg.setHorizontalAlignment(SwingConstants.CENTER);
		lblimg.setIcon(new ImageIcon(Login.class.getResource("/img/Register.jpg")));
		lblimg.setBounds(0, 0, 674, 313);
		pnlRegister.add(lblimg);
		
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("*******");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		formatter.setValidCharacters("0123456789");
		

		JFormattedTextField txtID = new JFormattedTextField(formatter);
		txtID.setBounds(224, 351, 300, 33);
		pnlRegister.add(txtID);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPassword.setBackground(Color.LIGHT_GRAY);
		lblPassword.setBounds(62, 537, 150, 24);
		pnlRegister.add(lblPassword);
		
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(224, 531, 300, 33);
		txtPassword.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtPassword);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login loginPage = new Login();
				loginPage.setVisible(true);
			}
		});

		btnExit.setBounds(224, 825, 300, 25);
		pnlRegister.add(btnExit);
		
		JLabel lblRetypePassword = new JLabel("Repeat Password:");
		lblRetypePassword.setForeground(Color.BLACK);
		lblRetypePassword.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRetypePassword.setBackground(Color.LIGHT_GRAY);
		lblRetypePassword.setBounds(62, 595, 150, 24);
		pnlRegister.add(lblRetypePassword);
		
		JPasswordField txtRetypePassword = new JPasswordField();
		txtRetypePassword.setBounds(224, 589, 300, 33);
		txtRetypePassword.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtRetypePassword);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setForeground(Color.BLACK);
		lblEmailAddress.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEmailAddress.setBackground(Color.LIGHT_GRAY);
		lblEmailAddress.setBounds(62, 656, 150, 24);
		pnlRegister.add(lblEmailAddress);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 15));
		lblUsername.setBackground(Color.LIGHT_GRAY);
		lblUsername.setBounds(62, 475, 150, 24);
		pnlRegister.add(lblUsername);
		
		JTextArea txtUsername = new JTextArea();
		txtUsername.setBounds(224, 471, 300, 33);
		txtUsername.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtUsername);
		
		JTextArea txtEmailAddress = new JTextArea();
		txtEmailAddress.setBounds(224, 652, 300, 33);
		txtEmailAddress.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlRegister.add(txtEmailAddress);
		
		JLabel lblRole = new JLabel("Request Type:");
		lblRole.setForeground(Color.BLACK);
		lblRole.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRole.setBackground(Color.LIGHT_GRAY);
		lblRole.setBounds(62, 718, 150, 24);
		pnlRegister.add(lblRole);
		
		JComboBox<String> cmbRole = new JComboBox<String>();
		cmbRole.setBounds(224, 718, 300, 22);
		pnlRegister.add(cmbRole);
		cmbRole.addItem("Receptionist");
		cmbRole.addItem("Guest");
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!txtPassword.getText().equals(txtRetypePassword.getText())){
					JOptionPane.showMessageDialog(null, "Password fields are not matching.", "Warning!", JOptionPane.WARNING_MESSAGE);
					txtPassword.setText("");
					txtRetypePassword.setText("");
					return;
				}
				
				if(String.valueOf(txtID.getText().trim()).isEmpty() || txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty() || txtRetypePassword.getText().isEmpty() || txtEmailAddress.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Please fill in all required fields!", "Warning!", JOptionPane.WARNING_MESSAGE);
				else{
				boolean isInserted = hotel.insertNewUser(Integer.parseInt(txtID.getText()), txtName.getText(),txtUsername.getText(),txtPassword.getText(),txtEmailAddress.getText(), cmbRole.getSelectedItem().toString(), cmbRole.getSelectedIndex());
				if(isInserted)
					{
						dispose();
						Login login = new Login();
						login.setVisible(true);
					}
				}
			}
		});
		btnSignUp.setBounds(224, 787, 300, 25);
		pnlRegister.add(btnSignUp);
		

		
	}
}

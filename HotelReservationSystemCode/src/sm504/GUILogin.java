package sm504;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUILogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlLogin;
	private JPasswordField txtPassword;


	public GUILogin() {
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 750);
		pnlLogin = new JPanel();
		pnlLogin.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlLogin.setBackground(Color.WHITE);
		setContentPane(pnlLogin);
		pnlLogin.setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(224, 567, 300, 25);
		pnlLogin.add(btnLogin);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setBackground(new Color(192, 192, 192));
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 15));
		lblUsername.setBounds(62, 346, 150, 24);
		pnlLogin.add(lblUsername);
		
		JTextArea txtUsername = new JTextArea();
		txtUsername.setBounds(224, 342, 300, 33);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtUsername.setBorder(BorderFactory.createCompoundBorder(border, 
		      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		pnlLogin.add(txtUsername);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(GUILogin.class.getResource("/img/hrs.jpg")));
		lblNewLabel.setBounds(0, 0, 674, 313);
		pnlLogin.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPassword.setBackground(Color.LIGHT_GRAY);
		lblPassword.setBounds(62, 405, 150, 24);
		pnlLogin.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(224, 399, 300, 33);
		txtPassword.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlLogin.add(txtPassword);
		
		JComboBox<String> cmbRole = new JComboBox<String>();
		cmbRole.setBounds(224, 459, 300, 22);
		cmbRole.addItem("Receptionist");
		cmbRole.addItem("Guest");
		cmbRole.addItem("Manager");
		pnlLogin.add(cmbRole);
		
		JLabel lblLoginAs = new JLabel("Login As:");
		lblLoginAs.setForeground(Color.BLACK);
		lblLoginAs.setFont(new Font("Calibri", Font.BOLD, 15));
		lblLoginAs.setBackground(Color.LIGHT_GRAY);
		lblLoginAs.setBounds(62, 462, 150, 24);
		pnlLogin.add(lblLoginAs);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Goodbye!");
				System.exit(ABORT);
			}
		});
		btnExit.setBounds(224, 643, 300, 25);
		pnlLogin.add(btnExit);
		
		JButton btnSignUpAs = new JButton("Sign Up as a New User");
		btnSignUpAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					GUIRegistration register = new GUIRegistration();
					register.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSignUpAs.setBounds(224, 605, 300, 25);
		pnlLogin.add(btnSignUpAs);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		pnlLogin.add(panel);
		
}
}

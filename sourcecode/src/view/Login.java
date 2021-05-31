package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import domain.Hotel;
import domain.HotelGuest;
import domain.HotelManager;
import domain.LoginSingleton;
import domain.Receptionist;
import domain.RegisterSingleton;
import domain.User;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Hotel h = new Hotel();
	//User u = new User(h);

	public Login() {
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 660);
		JPanel pnlLogin = new JPanel();
		pnlLogin.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlLogin.setBackground(Color.WHITE);
		setContentPane(pnlLogin);
		pnlLogin.setLayout(null);
		
		
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
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/hrs.jpg")));
		lblNewLabel.setBounds(0, 0, 674, 313);
		pnlLogin.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPassword.setBackground(Color.LIGHT_GRAY);
		lblPassword.setBounds(62, 405, 150, 24);
		pnlLogin.add(lblPassword);
		
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(224, 399, 300, 33);
		txtPassword.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnlLogin.add(txtPassword);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Goodbye!");
				System.exit(ABORT);
			}
		});
		btnExit.setBounds(224, 566, 300, 25);
		pnlLogin.add(btnExit);
		
		JButton btnSignUpAs = new JButton("Sign Up");
		btnSignUpAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    LoginSingleton.disposeInstance();
			    RegisterSingleton.getInstance();
			}
		});
		btnSignUpAs.setBounds(224, 523, 300, 25);
		pnlLogin.add(btnSignUpAs);
		
		JButton btnLogin = new JButton("LOG IN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try {
				if(h.verifyAccount(txtUsername.getText(), txtPassword.getText()) == true){
					
					LoginSingleton.disposeInstance();
					
						UserInfo userFrame = new UserInfo(h);
						userFrame.setVisible(true);

				}

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			}
		});
		btnLogin.setBounds(224, 485, 300, 25);
		pnlLogin.add(btnLogin);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		pnlLogin.add(panel);
		
		
}

}


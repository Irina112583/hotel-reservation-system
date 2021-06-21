package domain;

import java.awt.EventQueue;

import view.Login;
public class Main {

	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Login loginPage = new Login();
				loginPage.setVisible(true);
				
			}
		});
		

	}
	
}

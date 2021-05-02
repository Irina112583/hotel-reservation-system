package domain;

import javax.swing.JOptionPane;

import view.UserInfo;

public class User {
	String fullName;
	int ID;
	String password;
	String username;
	
	public void LoginToSystem(String username, String password){

			
		if (DB.getDataInstance().getUsername().equals(username) && DB.getDataInstance().getPassword().equals(password))
		{
			LoginSingleton.disposeInstance();
			UserInfo userFrame = new UserInfo();
			userFrame.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Permission Denied!");

		}
	}
	
	
}

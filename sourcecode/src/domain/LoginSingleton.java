package domain;

import view.Login;

public class LoginSingleton {
	
	private static Login uniqueInstance; 
	
	private LoginSingleton()
	{
		
	}
	
	public static synchronized Login getInstance()
	{
		if (uniqueInstance == null)
		{

			
			try {
				uniqueInstance = new Login();
				uniqueInstance.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return uniqueInstance;
				
	}
	
	public static void disposeInstance()
	{
		if (uniqueInstance != null){
			uniqueInstance.dispose();
			uniqueInstance = null;
		}
	}
}
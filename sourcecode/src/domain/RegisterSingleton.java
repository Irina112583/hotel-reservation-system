package domain;

import view.Registration;

public class RegisterSingleton {
	
	private static Registration uniqueInstance; 
	
	private RegisterSingleton()
	{
		
	}
	
	public static synchronized Registration getInstance()
	{
		if (uniqueInstance == null)
		{
			
			try {
				uniqueInstance = new Registration();
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
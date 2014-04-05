package com.example.alergant.other;

public abstract class Bundle {

	private static String user = null;
	private static String pass = null;
	
	/***** Setters *****/
	
	public static void setUser (String user){
		
		Bundle.user = user;
		
	}
	
	public void setPass (String pass){
		
		Bundle.pass = pass;
		
	}
	
	/***** Getters *****/
	
	public String getUser (){
		
		return Bundle.user;
		
	}
	
	public String getPass (){
		
		return Bundle.pass;
		
	}
	
}

/**
 * 
 */
package com.revature.application;

/**
 * @author Bryon Connolly
 *
 */
public abstract class User {

	public static int last_user = 1;
	
	public static Admin getAdminInstance() {
		User user = new User();//TODO make an Admin
		return user;
	}
	
	public static Other getOtherInstance() {
		
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) { // FOR TESTING ONLY
		// TODO Auto-generated method stub

	}

}

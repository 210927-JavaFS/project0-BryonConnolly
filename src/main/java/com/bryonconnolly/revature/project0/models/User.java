/**
 * 
 */
package com.bryonconnolly.revature.project0.models;

/**
 * @author Bryon Connolly
 *
 */
public abstract class User {

	public static int last_user = 1;
	
	public static Admin getAdminInstance() {
//		User user = new User();//TODO make an Admin
//		return user;
		return null;
	}
	
	public static Other getOtherInstance() {
	//TODO	
		return null;
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) { // FOR TESTING ONLY
		// TODO Auto-generated method stub

	}

}

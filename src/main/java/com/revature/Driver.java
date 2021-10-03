/**
 * 
 */
package com.revature;

import static java.lang.System.out;
import static java.lang.System.err;

import java.io.Console;



/**
 * @author Bryon Connolly <bryon.connolly@revature.net>
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.println("hi");

		
		/*******
		 * 
		 * Security note: If an application needs to read a password or other secure data, it should use 
		 * readPassword() or readPassword(String, Object...) and manually zero the returned 
		 * character array after processing to minimize the lifetime of sensitive data in memory.
		 * 
		 */
		
		/**
		 *Returns:
		 *	A character array containing the password or passphrase read from the console, not including any line-termination characters, or null if an end of stream has been reached.
		 * TODO learn how to do these docs properly
		 */
		Console console;
		char[] password;
		if( (console = System.console()) != null && (password = console.readPassword("[%s]","Password: ")) != null ) {
			//...
			java.util.Arrays.fill(password,' ');
		}
		
		
	}

}

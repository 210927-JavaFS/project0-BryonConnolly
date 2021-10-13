
package com.bryonconnolly.revature.project0;

import static java.lang.System.out;
import static java.lang.System.err;

import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
//import java.util.logging.FileHandler;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.bryonconnolly.revature.project0.controllers.ArcadeController;
import com.bryonconnolly.revature.project0.controllers.MenuController;
import com.bryonconnolly.revature.project0.utils.ConnectionUtil;
import com.bryonconnolly.revature.project0.utils.ANSI_Escape_Sequence;

/*****
class Constants	{

	final static String LOG_FILE_NAME = "logs.txt";//handle this on other const in a better way

}
********************/

/**
 * @author Bryon Connolly <bryon.connolly@revature.net>
 *
 */
public class Driver {

	//this constant was used for setting up logging (but doesn't really need to be abstracted out)
//	private static final String CLASS_NAME = Driver.class.getName();
	
//	private static final String CLASS_SIMPLE_NAME = Driver.class.getSimpleName();
	private static final String CLASS = Driver.class.getSimpleName();// for neater debugging messages

	
	//private static final Logger logger = Logger.getLogger(CLASS_NAME);//NTS: Loggers have hierarchy and inherit from parents
	//private static Logger log = LoggerFactory.getLogger(Driver.class);
//	private static Logger log = LoggerFactory.getLogger(CLASS_NAME);
	private static Logger log = LoggerFactory.getLogger(Driver.class.getName());
	static {
		
		// Was originally using built in logger as seen in all commented out lines referencing "logger"
	//	Logger.getGlobal().info("Driver loaded into memory");
	//	logger.info("Class "+CLASS_SIMPLE_NAME+" loaded into memory");
//		logger.warning("WARNING"); //NTS by default this is showing
//		logger.fine("FINE");		//NTS by default this is NOT showing
		
		log.info(CLASS+" loaded into memory");
		
//		log.error("ERROR LOGGING TEST - ERR CONSOLE + FILE");
		
		MDC.put("key","value");//just a reminder about MDC
		
	}//end static block
	

	

	
	
	
	/**
	 * @param args
	 */
		
		
		private static MenuController menuController = new MenuController();
		
		public static void main(String[] args) {
			

			
			
	//		System.out.println("foo");
			
	//		System.out.flush();  
			
	//		System.out.print(ANSI_Escape_Sequence.GREEN.code);
			
			
			try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			menuController.welcomeMenu();
		
		//TODO Clean below, keep the usuable, trash the rest ************
		
		
		/************TEMP***********************
		System.out.println("Welcome to the Arcade.");
		
		MenuController menuController = new MenuController();

		Player player = menuController.getPlayer();
		
		
		ArcadeController arcadeController = new ArcadeController();
		ArcadeController.enterArcade(player);
		
		System.out.println("Now leaving the gaming area. Saving your winnings.");
		
		menuController.savePlayer(player);
		System.out.println("Saving complete. See you again soon.");
		
		**********************TEMP************************/
		
				
		//TODO enable, disable, and change level of logging via args flags... UPDATE NOTE: may be intended to leave config and use lower than info to debug
/*		Logger.getGlobal().setLevel(Level.ALL);
		Logger.getGlobal().setLevel((Level.FINEST);
		Logger.getGlobal().setLevel((Level.FINER);
		Logger.getGlobal().setLevel((Level.FINE);
		Logger.getGlobal().setLevel((Level.CONFIG);
		Logger.getGlobal().setLevel((Level.INFO); //NOTE the default logging config logs records of INFO and higher, i.e. use lower levels for debug diagnostics meaningless to user
		Logger.getGlobal().setLevel((Level.WARNING);
		Logger.getGlobal().setLevel((Level.SEVERE);
		Logger.getGlobal().setLevel((Level.OFF);
*/
			/*************************************
		logger.setLevel(Level.ALL);
		
		FileHandler handler = null;
		try {
			handler = new FileHandler();
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.addHandler(handler);
		
		logger.entering(CLASS_SIMPLE_NAME, "main", args);
//		logger.entering("class name", "method name", new Object[] { arg1, arg2 });// use this form for methods with multiple params	
		*************************************/

		
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
		/**************************************************************
		Console console;
		char[] password;
		if( (console = System.console()) != null && (password = console.readPassword("[%s]","Password: ")) != null ) {
			//...
			java.util.Arrays.fill(password,' ');
		}
		
		logger.exiting(CLASS_SIMPLE_NAME, "main");
//		logger.exiting(String className, String methodName, Object result);//use this form for a method with a return		
****************************************/
	
		
		
		
		
		
	}//end main

}

package com.bryonconnolly.revature.project0.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.Console;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bryonconnolly.revature.project0.models.Element;
import com.bryonconnolly.revature.project0.Driver;
import com.bryonconnolly.revature.project0.daos.AccountDAO;
import com.bryonconnolly.revature.project0.daos.AccountDAOImplementation;
import com.bryonconnolly.revature.project0.models.Account;
import com.bryonconnolly.revature.project0.services.AccountService;
import com.bryonconnolly.revature.project0.utils.ConnectionUtil;

public class MenuController {

	private static Scanner scanner = new Scanner(System.in);
	private AccountService accountService = new AccountService();
	private AccountDAO accountDAO = new AccountDAOImplementation();
	private Account account = null;
	
	
	
	// Setup and begin Logging
	private static final String CLASS_NAME 			= MenuController.class.getName();
	private static final String CLASS_SIMPLE_NAME	= MenuController.class.getSimpleName();	
	private static Logger log = LoggerFactory.getLogger(CLASS_NAME);//NTS: Loggers have hierarchy and inherit from parents
	static {
		log.debug("Class "+CLASS_SIMPLE_NAME+" loaded into memory");
		//MDC.put("key","value");//just a reminder about MDC
	}//end static block
	
	
	private static enum WelcomeMenuOption {
		LOG_IN("i", "Log in to an existing account"), 
		CREATE_USER("c", "Create a new user"),
		EXIT("x", "Exit the program");

		private String abbreviation;
		private String description;
		private final int index;
		
		private static Map map = new HashMap<>();
		
		
		WelcomeMenuOption(String abbreviation, String description) {
			this.abbreviation = abbreviation;
			this.description = description;
			index = ordinal();
		}// end constructor

		static {
			for(WelcomeMenuOption welcomeMenuOption : WelcomeMenuOption.values()) {
				map.put(welcomeMenuOption.index, welcomeMenuOption);
			}
		}
		
		private static WelcomeMenuOption valueOf(int index) {
			return(WelcomeMenuOption) map.get(index);
		}
		
		private String getAbbreviation() {
			return abbreviation;
		}

		private String getDescription() {
			return description;
		}
		
		private int getIndex() {
			return index;
		}

	}// end enum

	public void welcomeMenu() {
		System.out.println("Welcome to the Arcade!");

		System.out.println("What would you like to do?");

		
		//TODO JAVA API seems to imply ordinal not being used as intended
		
		
		for (WelcomeMenuOption welcomeMenuOption : WelcomeMenuOption.values()) {
			System.out.print(welcomeMenuOption.ordinal() + ") ");
			System.out.println(welcomeMenuOption);
		}

		
		
		// String response = scanner.nextLine();
		WelcomeMenuOption response = null;
		loop:while (response != WelcomeMenuOption.EXIT){
			response = WelcomeMenuOption.valueOf(scanner.nextInt());
			scanner.nextLine();//consume the extra new line
			
			String username;
			String password;
			
			switch (response) {
				case LOG_IN:
					System.out.println("username: ");
					username = scanner.nextLine();
					System.out.println("password: ");
					password = scanner.nextLine();
					
					
	//				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
	//				String encoded_password = encoder.encode(password);
	//				assertTrue(encoder.matches(password, encoded_password));

					
					
					
					account = accountService.logIn(username,password);
					
				
					// TODO not complete


				// Security note: If an application needs to read a password or other secure
				// data, it should use readPassword() or readPassword(String, Object...) and
				// manually zero the returned character array after processing to minimize the
				// lifetime of sensitive data in memory.

				/***************
				 * 
 Console cons;
 char[] passwd;
 if ((cons = System.console()) != null &&
     (passwd = cons.readPassword("[%s]", "Password:")) != null) {
     ...
     java.util.Arrays.fill(passwd, ' ');
 }
				 */
				
				
				
				break;
				
				
			case CREATE_USER:
				System.err.println("NOT COMPLETE");// TODO
				
				System.out.println("username: ");
				username = scanner.nextLine();
				System.out.println("password: ");
				password = scanner.nextLine();

				
				
				
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
				String encoded_password = encoder.encode(password);
//				assertTrue(encoder.matches(password, encoded_password));

				
				account = accountService.createNewAccount(username, encoded_password, null);//TODO add set preferred name to future menu
				
				break;
			case EXIT:
				System.out.println("Goodbye.");
				break loop;
			default:
					System.out.println("That option is not recognized");
			}//switch
		} //end while

	}// end welcome menu



}

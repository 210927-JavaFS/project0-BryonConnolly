package com.bryonconnolly.revature.project0.controllers;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bryonconnolly.revature.project0.models.Account;
import com.bryonconnolly.revature.project0.services.AccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MenuController {

	private static Scanner scanner = new Scanner(System.in);
	private AccountService accountService = new AccountService();
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
		
		private static Map<Integer, WelcomeMenuOption> map = new HashMap<>();
		
		
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
/*			char[] password;
			Console console = System.console();
			if(console == null) {
				log.error("no console available");
				return;
			}
*/			
			switch (response) {
			
				case LOG_IN:
					System.out.println("username: ");
					username = scanner.nextLine();
					System.out.println("password: ");
					password = scanner.nextLine();
/*					 if ((password = console.readPassword("[%s]", "Password:")) != null) {
							account = accountService.logIn(username,new String(password));
							java.util.Arrays.fill(password, ' ');
*/
					account = accountService.logIn(username,password);
//					 }
				break;
				
			case CREATE_USER:
				System.out.println("username: ");
				username = scanner.nextLine();
				System.out.println("password: ");
				password = scanner.nextLine();
				System.out.println("Ok. Please hold on while I work on that...");
//				 if ((password = console.readPassword("[%s]", "Password:")) != null) {
						BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//						String encoded_password = encoder.encode(new String(password));
						String encoded_password = encoder.encode(password);
//						assertTrue(encoder.matches(password, encoded_password));
						account = accountService.createNewAccount(username, encoded_password, null);//TODO add set preferred name to future menu
//						java.util.Arrays.fill(password, ' ');
//				 }
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

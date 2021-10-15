package com.bryonconnolly.revature.project0.controllers;

import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bryonconnolly.revature.project0.models.Account;
import com.bryonconnolly.revature.project0.services.AccountService;
import com.bryonconnolly.revature.project0.utils.ANSI_Escape_Sequence;

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
		
		// String response = scanner.nextLine();
		WelcomeMenuOption response = null;
		welcome_menu:while (response != WelcomeMenuOption.EXIT){
			
			System.out.println("Welcome to the Arcade!");
			System.out.println("What would you like to do?");

			for (WelcomeMenuOption welcomeMenuOption : WelcomeMenuOption.values()) {
				System.out.print(welcomeMenuOption.ordinal() + ") ");		//TODO JAVA API seems to imply ordinal not being used as intended
				System.out.println(welcomeMenuOption);
			}
			
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
					if(account.is_admin())
						adminMenu();
					else
						playerMenu();

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
				account = accountService.logIn(username,password);
				if(account.is_admin())
					adminMenu();
				else
					playerMenu();
										
				break;
				
			case EXIT:
				System.out.println("Goodbye.");
				break welcome_menu;
				
			default:
					System.out.println("That option is not recognized");
			}//switch
		} //end while

	}// end welcome menu


	public void adminMenu() {
		
		final String EXIT = "4";
		String response = null;
		
		menu:while (response != EXIT){
			
			System.out.println("What would you like to do now?");

//			System.out.println("0) Check Stock");
//			System.out.println("1) Add tickets to a user's account");	
			System.out.println("1) Take tickets from user");	
			System.out.println("2) Promote a user to an administrator");	
			System.out.println("3) Remove a user's admin privilages");
			System.out.println(EXIT+") Return to log in screen");		
			
			response = scanner.nextLine();
			switch (response) {
			
	//			case "0":
	//				System.err.println("This function is incomplete but will be used to check how many tickets are left in the machine");
	//				break;
				case "1":
					System.out.println("username<enter> quantity<enter>");
					String tickets = scanner.nextLine();
					int quantity = scanner.nextInt();
					accountService.takeTickets(tickets, quantity);
					System.out.println("it is done.");
					break;
				case "2":
					System.out.println("username:");
					String promoteusername = scanner.nextLine();
					accountService.promote(promoteusername);
					System.out.println("it is done.");
					break;
					
				case "3":
					System.out.println("username:");
					String demoteusername = scanner.nextLine();
					accountService.demote(demoteusername);
					System.out.println("it is done.");
					break;				
					
				case EXIT:
					System.out.println("Goodbye.");
					break menu;
				
			default:
					System.out.println("That option is not recognized");
			}//switch
		} //end while
		
		
	}
	
	public void playerMenu() {
		
		final String EXIT = "4";
		String response = null;
		
		menu:while (response != EXIT){
			
			System.out.println("What would you like to do?");

			System.out.println("1) Play");
			System.out.println("2) Change my preferred name");
			System.out.println("3) Change my password");
		//	System.out.println("3) Redeem your tickets for prizes");
			System.out.println(EXIT+") Return to the log in screen");			
			
			response = scanner.nextLine();
			switch (response) {
			
				case "1":
					System.out.println("game not connected, simulating a result...");
					Random random = new Random();
					int tickets_won = random.nextInt(10);
					for(int i=0;i<tickets_won;i++) {
						System.out.print(ANSI_Escape_Sequence.YELLOW_BACKGROUND.code);
						System.out.print(ANSI_Escape_Sequence.YELLOW_BOLD_BRIGHT.code);
						System.out.print("[ONE TICKET]");
						System.out.print(ANSI_Escape_Sequence.RESET.code);
						System.out.println();
					}
					accountService.addTickets(account, tickets_won);
					break;
				
				case "2":
					System.out.println("What is your preferred name?");
					account.setPreferredName(scanner.nextLine());			
					accountService.save(account);
					System.out.println("it is done.");
					break;

				case "3":
					System.out.println("What would you like your password to be?");
					accountService.setPassword(account,scanner.nextLine());
					System.out.println("it is done.");
					break;
					
	//			case "3":

					
					
	//				break;
								
					
				case EXIT:
					System.out.println("Goodbye.");
					break menu;
				
			default:
					System.out.println("That option is not recognized");
			}//switch
		} //end while
		
	}
	
	public void prizeMenu() {
		
	}
	
	
}//end MenuController class

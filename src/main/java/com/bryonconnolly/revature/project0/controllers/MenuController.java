package com.bryonconnolly.revature.project0.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.Console;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.models.Element;
import com.bryonconnolly.revature.project0.models.Account;
import com.bryonconnolly.revature.project0.services.AccountService;

public class MenuController {

	private static Scanner scanner = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(MenuController.class);
	private AccountService playerService = new AccountService();

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
			switch (response) {
				case LOG_IN:
					System.out.println("username: ");
					String username = scanner.nextLine();
					System.err.println("username is : "+username);
					System.out.println("password: ");
					String password = scanner.nextLine();
					System.err.println("password is : "+password);
					logInUser(username, password);
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
				System.err.println("NOT IMPLEMENTED");// TODO
				break;
			case EXIT:
				System.out.println("Goodbye.");
				break loop;
			default:
					System.out.println("That option is not recognized");
			}//switch
		} //end while

	}// end welcome menu

	public void logInUser(String username, String password) {
		// TODO this may be better if just kept in the switch

	}

	public void createUser() {

	}

	public void playerMenu() {

	}

	public void adminMenu() {

	}

}

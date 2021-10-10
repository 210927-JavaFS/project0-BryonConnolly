package com.bryonconnolly.revature.project0.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.Console;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.models.Element;
import com.bryonconnolly.revature.project0.models.Player;
import com.bryonconnolly.revature.project0.services.PlayerService;

public class MenuController {

	private static Scanner scanner = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(MenuController.class);
	private PlayerService playerService = new PlayerService();

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
			switch (response) {
				case LOG_IN:
					// TODO clear screen or other styling
					System.out.print("username: ");
					String username = scanner.nextLine();
					System.out.print("password: ");
					String password = scanner.nextLine();
					logInUser(username, password);
					// TODO not complete
					System.err.println("NOT IMPLEMENTED");// TODO

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
		// TODO

	}

	public void createUser() {

	}

	public void playerMenu() {

	}

	public void adminMenu() {

	}

	/*******
	 * TEMP***************************** public Player getPlayer() {
	 * System.out.println("Are you a returning hero? Type yes/no."); String response
	 * = scan.nextLine(); if (response.toLowerCase().equals("yes")) {
	 * ArrayList<Player> alivePlayers = playerService.getPreviousPlayers();
	 * System.out.println("What player would you like to play as?"); int counter=1;
	 * for(Player savePlayer:alivePlayers) { System.out.println(counter+")
	 * "+savePlayer); ++counter; } String choice = scan.nextLine(); try { int
	 * choiceInt = Integer.valueOf(choice); Player player =
	 * alivePlayers.get(choiceInt-1); System.out.println("Welcome back
	 * "+player.getName()+" we are glad you are ready to continue your adventure.");
	 * return player; }catch(NumberFormatException e) { log.warn("User tried to
	 * select player that does not exist. "+e.getMessage() );
	 * System.out.println("That is not a valid input, please try again."); return
	 * getPlayer(); }
	 * 
	 * } else if (response.toLowerCase().equals("no")) { Player player =
	 * newPlayerBuilder(); return player; } System.out.println("That is not a valid
	 * choice. Please try again."); return getPlayer(); }
	 * 
	 * private Player newPlayerBuilder() { Player player = null;
	 * System.out.println("What is your player's name?"); String name =
	 * scan.nextLine(); System.out.println("What is your starting weapon type? \n" +
	 * "These are your options: \n" + "ARCANE,\r\n" + "HOLY,\r\n" + "FIRE,\r\n" +
	 * "ICE,\r\n" + "THUNDER,\r\n" + "LIGHT,\r\n" + "DARK,\r\n" + "POISON,\r\n" +
	 * "ACID,\r\n" + "WATER,\r\n" + "NORMAL"); String type =
	 * scan.nextLine().toUpperCase(); Element element = null; try { element =
	 * Element.valueOf(type); player=playerService.createNewPlayer(name, element); }
	 * catch (IllegalArgumentException e) { log.warn("User attempted to create
	 * weapon of element that does not exist"); log.warn(e.getMessage());
	 * System.out.println("That type of weapon does not exist. Please try again.");
	 * player = newPlayerBuilder(); }
	 * 
	 * return player; }
	 * 
	 * public void savePlayer(Player player) { playerService.save(player);
	 * 
	 * }
	 ****************************** 
	 * TEMP
	 *******************/

}

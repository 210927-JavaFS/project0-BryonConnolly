package com.bryonconnolly.revature.project0.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.models.Element;
import com.bryonconnolly.revature.project0.models.Player;
import com.bryonconnolly.revature.project0.services.PlayerService;
import com.bryonconnolly.revature.project0.services.WeaponService;

public class ArcadeController {

	private static Scanner scan = new Scanner(System.in);
	private static GameController dungeonController = new GameController();
	private static PlayerService playerService = new PlayerService();
	private static Logger log = LoggerFactory.getLogger(ArcadeController.class);
	private static WeaponService weaponService = new WeaponService();

	public void enterArcade(Player player) {
		boolean inArcade = true;
		while (inArcade) {
			System.out.println("Welcome " + player.getName() + " to the Arcade. What would you like to do?");
			System.out.println("You can: \n" + "1) Buy some drinks. \n" + "2) Shop withshop tickets. \n"
					+ "3) Delve into Java Dungeon. \n" + "4) Leave the arcade. (Exit the game.)");
			String choice = scan.nextLine();
			switch (choice) {
			case "1":
	//			buyPotions(player);
				break;
			case "2":
				shop(player);
				break;
			case "3":
				boolean stay = dungeonController.enterDungeon(player);
				if (stay) {
					break;
				} else {
					inArcade = false;
				}
			case "4":
				return;
			default:
				System.out.println("That is not a valid entry, please try again.");
				break;
			}
		}
	}

	private void shop(Player player) {
		
		//TODO handle these prices better, maybe an enum of prices and item names
		final int SMALL_AMOUNT_OF_TICKETS = 10;
		final int LARGE_AMOUNT_OF_TICKETS = 20;		
		//TODO actuall handle this whole method better to handle a collection of prizes
		
		
		System.out.println("You enter the shop. Would you like to: \n"
				+ "1) Enchant your weapon to be stronger. ("+LARGE_AMOUNT_OF_TICKETS+" tickets) \n"
				+ "2) Change the element your weapon uses. ("+SMALL_AMOUNT_OF_TICKETS+" tickets) \n"
				+ "3) Exit the shop.");
		String response = scan.nextLine();
		switch (response) {
		case "1":
			if (player.getTickets() >= LARGE_AMOUNT_OF_TICKETS) {
				weaponService.upgrade(player.getWeapon());
				player.setTickets(player.getTickets() - LARGE_AMOUNT_OF_TICKETS);
			} else {
				System.out.println("You do not have the money to upgrade at this time.");
				log.warn(player.getName() + " tried to upgrade a weapon without enough gold.");
				shop(player);
			}
			break;
		case "2":
			if (player.getTickets() >= SMALL_AMOUNT_OF_TICKETS) {
				System.out.println(
						"What would you like to change the weapon damage type to?" + "These are your options: \n"
								+ "ARCANE,\r\n" + "HOLY,\r\n" + "FIRE,\r\n" + "ICE,\r\n" + "THUNDER,\r\n" + "LIGHT,\r\n"
								+ "DARK,\r\n" + "POISON,\r\n" + "ACID,\r\n" + "WATER,\r\n" + "NORMAL");
				String type = scan.nextLine().toUpperCase();
				Element element = null;
				try {
					element = Element.valueOf(type);
					weaponService.changeElement(player.getWeapon(), element);
					player.setTickets(player.getTickets() - SMALL_AMOUNT_OF_TICKETS);
				} catch (IllegalArgumentException e) {
					log.warn("User attempted to change weapon to element that does not exist");
					log.warn(e.getMessage());
					System.out.println("That type of weapon does not exist. Please try again.");
					shop(player);
				}

			} else {
				System.out.println("You do not have the money to change your weapon at this time.");
				log.warn(player.getName() + " tried to change element on a weapon without enough gold.");
				shop(player);
			}
			break;
		case "3":
			System.out.println("You leave the shop");
			break;
		default:
			System.out.println("You did not enter a valid input. Please try again.");
			shop(player);
		}

	}

	private void buyDrinks(Player player) {
		final int DRINK_PRICE = 5;
		System.out.println("You enter a small shop that smells of odd chemical. How many "
				+ "drinks would you like to buy? "+DRINK_PRICE+" tickets per drink. Enter 0 to leave.");

		try {
			int purchase = Integer.parseInt(scan.nextLine());
			if (((purchase * DRINK_PRICE) <= player.getTickets()) && (purchase > 0)) {
				System.out.println("You are buying " + purchase + " drinks");
				playerService.buyDrinks(player, purchase);
				System.out.println("Thank you for your purchase, you have " + player.getTickets() + " tickets remaining.");
			} else if (purchase > 0) {
				System.out.println("You do not have enough tickets for that purchase. You " + "currently have "
						+ player.getTickets() + " tickets.");
				buyDrinks(player);
			} else {
				System.out.println("You decide to buy nothing and leave the shop.");
			}
		} catch (NumberFormatException e) {
			log.warn(player.getName() + " tried to buy drinks with an invalid input.");
			System.out.println("You have entered an invalid input, please try again.");
			buyDrinks(player);
		}
	}

}

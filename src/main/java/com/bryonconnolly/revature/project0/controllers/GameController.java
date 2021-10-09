package com.bryonconnolly.revature.project0.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.models.Monster;
import com.bryonconnolly.revature.project0.models.Player;
import com.bryonconnolly.revature.project0.services.MonsterService;
import com.bryonconnolly.revature.project0.services.PlayerService;

public class GameController {

	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(GameController.class);
	private PlayerService playerService = new PlayerService();
	private MonsterService monsterService = new MonsterService();

	public boolean enterDungeon(Player player) {
		boolean inDungeon = true;
		while (inDungeon) {
			System.out.println("Welcome to strict and strong Java Dungeon. What would you like to do? \n"
					+ "1) Search for a monster to fight. \n" + "2) Drink some healing potions. \n"
					+ "3) Return to town. \n" + "4) Go to the inn and sleep. (Exit the game)");

			String response = scan.nextLine();

			switch (response) {
				case "1":
					searchForMonster(player);
					if(!(player.getCurrentHealth()>0)) {
						return false;
					}
					break;
				case "2":
					drinkPotion(player);
					break;
				case "3":
					System.out.println("You survive the dungeon and return to town.");
					return true;
				case "4":
					System.out.println("You survived the dungeon and are looking for a good nights sleep.");
					return false;
				default:
					System.out.println("That was not a valid entry, please try again.");
					break;
			}
		}
		return false;
	}

	private void drinkPotion(Player player) {
//		System.out.println("You have "+player.getPotions()+" potions remaining. How many would "
//				+ "you like to drink? You have "+player.getCurrentHealth()+" health remaining out"
//						+ " of a total of "+player.getMaxHealth());
		String response = scan.nextLine();
		try {
			int potions = Integer.parseInt(response);
			playerService.drinkPotions(player, potions);
		}catch (NumberFormatException e) {
			log.warn("Player entered invalid selection for number of potions.");
			log.warn(e.getMessage());
			System.out.println("That is not a valid input, please try again.");
			drinkPotion(player);
		}
		

	}

	private void searchForMonster(Player player) {
		System.out.println("You search for a monster to debug...");
		Monster monster = monsterService.findMonster();
		System.out.println("You stubble upon a "+monster.getName()+" that looks angry!");
		monsterService.fight(monster, player);
		
	}

}

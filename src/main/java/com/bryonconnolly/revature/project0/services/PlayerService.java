package com.bryonconnolly.revature.project0.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.MDC;

import com.bryonconnolly.revature.project0.daos.PlayerDAO;
import com.bryonconnolly.revature.project0.models.Element;
import com.bryonconnolly.revature.project0.models.Player;
import com.bryonconnolly.revature.project0.models.Weapon;

public class PlayerService {
	
	private static Logger log = LoggerFactory.getLogger(PlayerService.class);
	private static PlayerDAO playerDAO = new PlayerDAO();

	public Player createNewPlayer(String name, Element element) {
		Weapon weapon = new Weapon();
		weapon.setElement(element);
		weapon.setBaseDamage(8);
		weapon.setCritMultiplier(2);
		switch(element) {
			case NORMAL:
				weapon.setName("Longsword");
				break;
			case ARCANE:
				weapon.setName("Arcane bolt");
				break;
			case HOLY:
				weapon.setName("Holy Word");
				break;
			case FIRE:
				weapon.setName("Flaming Dagger");
				break;
			case ICE:
				weapon.setName("Icicle");
				break;
			case THUNDER:
				weapon.setName("Lightning Rod");
				break;
			case LIGHT:
				weapon.setName("Light Sabre");
				break;
			case DARK:
				weapon.setName("Void Blade");
				break;
			case POISON:
				weapon.setName("Poisoned Dart");
				break;
			case ACID:
				weapon.setName("Acid Vial");
				break;
			case WATER:
				weapon.setName("Bucket");
				break;
			default:
				weapon.setName("Longsword");
				break;
			
		}
		return new Player(name, weapon, 10, 10, 1, 100);
	}

	//TODO change drinks to drink coupons
	public void buyDrinks(Player player, int purchase) {
		player.setTickets(player.getTickets()-(purchase*25));//TODO fix this to Constant for Drinks prices
		player.setDrinks(player.getDrinks()+purchase);
		log.info(player.getName()+" bought "+purchase+" drinks.");
	}

	public void drinkPotions(Player player, int potions) {//TODO change to use drink coupon
		for(int i =0; i<potions; ++i) {
			System.out.println("You quaff a potion");
	//		player.setPotions(player.getPotions()-1);
			player.setCurrentHealth((int) (player.getCurrentHealth()+((Math.random()*player.getMaxHealth())/3)+1));
			System.out.println("Your current health is now "+player.getCurrentHealth()+" of a "
					+ "maximum of "+player.getMaxHealth());
		}
	}

	public void save(Player player) {
		playerDAO.writePlayer(player);
		
	}

	public ArrayList<Player> getPreviousPlayers() {
		ArrayList<Player> allPlayers = playerDAO.findAllPlayers();
	/*	for(int i =0; i<allPlayers.size(); ++i) {
			if(allPlayers.get(i).getCurrentTickets)<=0) {
				allPlayers.remove(i);
			}
		}
		*/
		return allPlayers;
	}

}

package com.bryonconnolly.revature.project0.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.daos.MonsterDAO;
import com.bryonconnolly.revature.project0.models.Element;
import com.bryonconnolly.revature.project0.models.Monster;
import com.bryonconnolly.revature.project0.models.Player;
import com.bryonconnolly.revature.project0.models.Weapon;

public class MonsterService {

	private static Logger log = LoggerFactory.getLogger(MonsterService.class);
	
	private MonsterDAO monsterDao = new MonsterDAO();
	
	public Monster findMonster() {
		ArrayList<Monster> monsters = monsterDao.findAllMonsters();
		int monsterIndex = (int) (Math.random()*monsters.size());
		log.debug(((Integer)monsterIndex).toString());
		Monster monster = monsters.get(monsterIndex);
		return monster;
	}

	public void fight(Monster monster, Player player) {
		while(player.getCurrentHealth()>0&&monster.getCurrentHealth()>0) {
			System.out.println("You attack the "+monster.getName()+" with your "+player.getWeapon().getName());
			int playerDamage = (int) (Math.random()*player.getWeapon().getBaseDamage()+1);
			if(playerDamage >= player.getWeapon().getBaseDamage()) {
				playerDamage *= player.getWeapon().getCritMultiplier();
			}
			monster.setCurrentHealth(monster.getCurrentHealth()-playerDamage);
			System.out.println("You did "+playerDamage+" to the "+monster.getName()+" it has "
					+ monster.getCurrentHealth()+" health remaining");
			if(monster.getCurrentHealth()>0) {
				int monsterDamage = (int) (Math.random()*monster.getWeapon().getBaseDamage()+1);
				if(monsterDamage >= monster.getWeapon().getBaseDamage()) {
					monsterDamage *= monster.getWeapon().getCritMultiplier();
				}
				player.setCurrentHealth(player.getCurrentHealth()-monsterDamage);
				System.out.println("The monster did "+monsterDamage+" to you. you have "
						+ player.getCurrentHealth()+" health remaining");
			}
		}
		if(player.getCurrentHealth()>0) {
			System.out.println("You successfully debugged the problem.");
			int treasure =(int) (Math.random()*monster.getMaxTreasure())+1;
			System.out.println("You recover "+treasure+" gold from the "+monster.getName()+".");
			player.setTickets(player.getTickets()+treasure);
		} else {
			System.out.println("The moster has defeated you. You adventure ends here.");
		}
	}

}

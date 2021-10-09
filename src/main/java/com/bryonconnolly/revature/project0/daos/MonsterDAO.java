package com.bryonconnolly.revature.project0.daos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.models.Element;
import com.bryonconnolly.revature.project0.models.Monster;
import com.bryonconnolly.revature.project0.models.Weapon;

public class MonsterDAO {
	
	private static Logger log = LoggerFactory.getLogger(MonsterDAO.class);
	
	public ArrayList<Monster> findAllMonsters(){
		ArrayList<Monster> allMonsters = new ArrayList<>();
		try(Scanner scan = new Scanner(new File("//home//ec2-user//adventure//demos//Week1//RevatureAdventures//src//main//resources//monsters.txt"))){
			while(scan.hasNextLine()) {
				String monsterString = scan.nextLine();
				String[] monsterArray = monsterString.split(",");
				allMonsters.add(new Monster(monsterArray[0], new Weapon(monsterArray[1], 
						Integer.valueOf(monsterArray[2]), Integer.valueOf(monsterArray[3]), 
						Element.valueOf(monsterArray[4])), Integer.valueOf(monsterArray[5]),
						Integer.valueOf(monsterArray[6]), Integer.valueOf(monsterArray[7])));
			}
		}catch(IOException e) {
			log.error("Could not access monsters file. "+e.getMessage());
		}catch(NumberFormatException e) {
			log.error("monster in monster list is not properly formated "+e.getMessage());
		}
		log.debug(allMonsters.toString());
		return allMonsters;
	}

}

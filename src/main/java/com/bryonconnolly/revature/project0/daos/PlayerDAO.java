package com.bryonconnolly.revature.project0.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.models.Element;
import com.bryonconnolly.revature.project0.models.Player;
import com.bryonconnolly.revature.project0.models.Weapon;

public class PlayerDAO {
	
	private static Logger log = LoggerFactory.getLogger(PlayerDAO.class);

	public void writePlayer(Player player) {
		File players = new File("//home//&///Revature Workspace//project0-BryonConnolly//src//main//resources//players.txt");
		
		try {
			if(players.createNewFile()) {
				log.info("Created new players file");
			}else {
				log.info("players file already exists");
			}
		}catch(IOException e) {
			log.error("Something went wrong trying to access players file: "+e.getMessage());
		}
		
		try(FileWriter writer = new FileWriter("//home//ec2-user//adventure//demos//Week1//RevatureAdventures//src//main//resources//players.txt", true)){
			StringBuilder builder = new StringBuilder(player.getName());
			builder.append(","+player.getWeapon().getName());
			builder.append(","+player.getWeapon().getBaseDamage());
			builder.append(","+player.getWeapon().getCritMultiplier());
			builder.append(","+player.getWeapon().getElement());
			builder.append(","+player.getMaxHealth());
			builder.append(","+player.getCurrentHealth());
//			builder.append(","+player.getPotions());
			builder.append(","+player.getTickets()+"\n");
			String playerString = new String(builder);
			writer.write(playerString);
		}catch(IOException e) {
			log.error("Could not write to file: "+e.getMessage());
		}
		
		
	}

	public ArrayList<Player> findAllPlayers() {
		ArrayList<Player> allPlayers = new ArrayList<>();
		try(Scanner scan = new Scanner(new File("src//main//resources//players.txt"))) {
			while(scan.hasNextLine()) {
				String playerString = scan.nextLine();
				String[] playerParts = playerString.split(",");
				allPlayers.add(new Player(playerParts[0], new Weapon(playerParts[1],
						Integer.valueOf(playerParts[2]), Integer.valueOf(playerParts[3]), 
						Element.valueOf(playerParts[4])), Integer.valueOf(playerParts[5]), Integer.valueOf(playerParts[6]),
						Integer.valueOf(playerParts[7]), Integer.valueOf(playerParts[8])));
			}
		}catch(IOException e) {
			log.error("Something went wrong retieving players: "+e.getMessage());
		}
		return allPlayers;
	}
	
	

}

package com.bryonconnolly.revature.project0.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player extends Creature{

	
	private int drinks;
	private int tickets;

	private static Logger log = LoggerFactory.getLogger(Player.class);
	
	public Player(String name, Weapon weapon, int maxHealth, int currentHealth, int drinks, int tickets) {
		super(name, weapon, maxHealth, currentHealth);

		if (drinks >= 0) {
			this.drinks = drinks;
		}else {
			log.warn(this.getName() + " tried to set the drinks less than 0 at construction.");
		}
		this.tickets = tickets;
	}

	public Player() {
		super();
	}

	public int getDrinks() {
		return drinks;
	}

	public void setDrinks(int drinks) {
		if (drinks >= 0) {
			this.drinks = drinks;
		}else {
			log.warn(this.getName() + " tried to set the potions less than 0 with Setter.");
		}
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + tickets;
		result = prime * result + drinks;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (tickets != other.tickets)
			return false;
		if (drinks != other.drinks)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [drinks=" + drinks + ", tickets=" + tickets + ", toString()=" + super.toString() + "]";
	}





	
}

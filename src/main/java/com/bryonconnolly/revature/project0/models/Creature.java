package com.bryonconnolly.revature.project0.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Creature {
	
	private static Logger log = LoggerFactory.getLogger(Creature.class);
	
	private String name;
	private int maxHealth;
	private int currentHealth;
	
	public Creature(String name, int maxHealth, int currentHealth) {
		super();
		this.name = name;
		if (maxHealth >= 1) {
			this.maxHealth = maxHealth;
		} else {
			this.maxHealth = 1;
			log.warn(this.name + " tried to set the maxHealth less than 1 at construction.");
		}
		this.currentHealth = currentHealth;
	}

	public Creature() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		if (maxHealth >= 1) {
			this.maxHealth = maxHealth;
		}else {
			log.warn(this.name + " tried to set the maxHealth less than 1 with setter.");
		}
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		if(currentHealth<=this.maxHealth) {
			this.currentHealth = currentHealth;
		}else {
			this.currentHealth= this.maxHealth;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentHealth;
		result = prime * result + maxHealth;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((weapon == null) ? 0 : weapon.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Creature other = (Creature) obj;
		if (currentHealth != other.currentHealth)
			return false;
		if (maxHealth != other.maxHealth)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
/*		if (weapon == null) {
			if (other.weapon != null)
				return false;
		} else if (!weapon.equals(other.weapon))
			return false; */
		return true;
	}

	@Override
	public String toString() {
		return "Creature [name=" + name + ", maxHealth=" + maxHealth + ", currentHealth="
				+ currentHealth + "]";
	}
	
	

}

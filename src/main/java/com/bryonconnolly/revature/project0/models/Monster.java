package com.bryonconnolly.revature.project0.models;

public class Monster extends Creature{
	
	private int maxTreasure;

	public Monster(String name, Weapon weapon, int maxHealth, int currentHealth, int maxTreasure) {
		super(name, weapon, maxHealth, currentHealth);
		this.maxTreasure = maxTreasure;
	}

	public Monster() {
		super();
	}

	public int getMaxTreasure() {
		return maxTreasure;
	}

	public void setMaxTreasure(int maxTreasure) {
		this.maxTreasure = maxTreasure;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + maxTreasure;
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
		Monster other = (Monster) obj;
		if (maxTreasure != other.maxTreasure)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Monster [maxTreasure=" + maxTreasure + ", toString()=" + super.toString() + "]";
	}
	
}

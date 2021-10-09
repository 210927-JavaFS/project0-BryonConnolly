package com.bryonconnolly.revature.project0.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Weapon {

	private String name;
	private int baseDamage;
	private int critMultiplier;
	private Element element;

	private static Logger log = LoggerFactory.getLogger(Weapon.class);

	public Weapon(String name, int baseDamage, int critMultiplier, Element element) {
		super();
		this.name = name;
		if (baseDamage >= 1) {
			this.baseDamage = baseDamage;
		} else {
			log.warn(this.name + " attempted to set base damage less than 1 at construction.");
			this.baseDamage = 1;
		}
		this.critMultiplier = critMultiplier;
		this.element = element;
	}

	public Weapon() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		if (baseDamage >= 1) {
			this.baseDamage = baseDamage;
		}else {
			log.warn(this.name + " attempted to set base damage less than 1 at construction.");
		}
	}

	public int getCritMultiplier() {
		return critMultiplier;
	}

	public void setCritMultiplier(int critMultiplier) {
		this.critMultiplier = critMultiplier;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

}

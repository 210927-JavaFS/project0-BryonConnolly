package com.bryonconnolly.revature.project0.services;

import com.bryonconnolly.revature.project0.models.Element;
import com.bryonconnolly.revature.project0.models.Weapon;

public class WeaponService {

	public void upgrade(Weapon weapon) {
		weapon.setBaseDamage(weapon.getBaseDamage()+2);
	}

	public void changeElement(Weapon weapon, Element element) {
		weapon.setElement(element);
	}

}

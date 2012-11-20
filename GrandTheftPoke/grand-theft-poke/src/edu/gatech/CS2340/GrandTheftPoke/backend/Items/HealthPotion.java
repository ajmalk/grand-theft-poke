package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a HealthPotion
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class HealthPotion extends Item implements Usable {
	@Override
	public void use(Person person) {
		final int health = person.getHealth();
		final int maxHealth = person.getMaxHealth();
		if (health <= (maxHealth - 20)) {
			person.setHealth(health + 20);
		} else {
			person.setHealth(maxHealth);
		}
	}

	@Override
	public void unUse(Person person) {
	}

	@Override
	public String toString() {
		return "Health Potion";
	}

	@Override
	public String getDescription() {
		return "Health Potion restores your health to "
				+ "to the maximum. This is allows you "
				+ "stay alive longer.\n" + "Health = max";

	}

	@Override
	public String getFileName() {
		return "potion1";
	}
}

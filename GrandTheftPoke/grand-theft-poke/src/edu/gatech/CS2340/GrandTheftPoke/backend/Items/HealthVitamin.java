package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a HealthVitamin
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class HealthVitamin extends Item implements Usable {

	@Override
	public void use(Person person) {
		final int maxHealth = person.getMaxHealth();
		person.setMaxHealth(maxHealth + 25);
	}

	@Override
	public void unUse(Person person) {
		final int maxHealth = person.getMaxHealth();
		person.setMaxHealth(maxHealth - 25);
		if (person.getMaxHealth() > person.getHealth()) {
			person.setHealth(maxHealth);
		}
	}

	@Override
	public String toString() {
		return "Health Vitamin";
	}

	@Override
	public String getDescription() {
		return "Health Vitamin restores health to max.";
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "vitamin2";
	}
}

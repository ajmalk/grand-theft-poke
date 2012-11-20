/**
 * HealthPotion.java
 * @version 1.0
 */

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
	/**
	 * Method use.
	 * @param person Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#use(Person)
	 */
	@Override
	public void use(Person person) {
		final int health = person.getHealth();
		final int maxHealth = person.getMaxHealth();
		if (health <= (maxHealth - 20)) {//checks health
			person.setHealth(health + 20);//adds health back
		} else {
			person.setHealth(maxHealth);
		}
	}

	/**
	 * Method unUse.
	 * @param person Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#unUse(Person)
	 */
	@Override
	public void unUse(Person person) {
		//
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Health Potion";
	}

	/**
	 * Method getDescription.
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "Health Potion restores your health to "
				+ "to the maximum. This is allows you "
				+ "stay alive longer.\n" + "Health = max";

	}

	/**
	 * Method getFileName.
	 * @return String
	 */
	@Override
	public String getFileName() {
		return "potion1";
	}
}

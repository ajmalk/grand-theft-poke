/**
 * HealthVitamin.java
 * @version 1.0
 */

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

	/**
	 * Method use.
	 * @param person Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#use(Person)
	 */
	@Override
	public void use(Person person) {
		final int maxHealth = person.getMaxHealth();
		person.setMaxHealth(maxHealth + 25);//adds 25 health points
	}

	/**
	 * Method unUse.
	 * @param person Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#unUse(Person)
	 */
	@Override
	public void unUse(Person person) {
		final int maxHealth = person.getMaxHealth();
		person.setMaxHealth(maxHealth - 25);//subtracts 25 health points
		if (person.getMaxHealth() > person.getHealth()) {
			person.setHealth(maxHealth);
		}
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Health Vitamin";
	}

	/**
	 * Method getDescription.
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "Health Vitamin restores health to max.";
	}

	/**
	 * Method getFileName.
	 * @return String
	 */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "vitamin2";
	}
}

/**
 * AgilityVitamin.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents Agility Vitamin
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class AgilityVitamin extends Item implements Usable {

	/**
	 * Method use.
	 * 
	 * @param person
	 *            Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#use(Person)
	 */
	@Override
	public void use(Person person) {
		person.setAgility(1);
	}

	/**
	 * Method unUse.
	 * 
	 * @param person
	 *            Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#unUse(Person)
	 */
	@Override
	public void unUse(Person person) {
		person.setAgility(-1);
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Agility Vitamin";
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "The Agiliy Vitamin permanently adds  "
				+ "1 agility point to your current standings. "
				+ "This is useful because you can move further "
				+ "distances in 1 turn.\n" + "+1 Agility Point";
	}

	/**
	 * Method getFileName.
	 * 
	 * @return String
	 */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "vitamin1";
	}
}
/**
 * StaminaRoid.java
 * @version 1.0
 */
package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a StaminaRoid
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class StaminaRoid extends Item implements Usable {

	/**
	 * Method use.
	 * 
	 * @param person
	 *            Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#use(Person)
	 */
	@Override
	public void use(Person person) {
		person.setStamina(2);// adds two to stamina
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
		person.setStamina(-2);// subtracts two from stamina
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Stamina Steroid";
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "The Stamina Steroid permanently adds \n "
				+ "2 stamina points to your current standings.\n"
				+ "Increasing stamina allows you to move more\n"
				+ "more efficiently from town to town, therefore "
				+ "conserving health! \n" + "+2 Stamina Point";
	}

	/**
	 * Method getFileName.
	 * 
	 * @return String
	 */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "steroid3";
	}
}
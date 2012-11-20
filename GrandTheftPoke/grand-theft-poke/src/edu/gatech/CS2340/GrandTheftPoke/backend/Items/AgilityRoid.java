package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents an AgilitySteroid
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class AgilityRoid extends Item implements Usable {

	/**
	 * Method use.
	 * @param person Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#use(Person)
	 */
	@Override
	public void use(Person person) {
		person.setAgility(2);
	}

	/**
	 * Method unUse.
	 * @param person Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#unUse(Person)
	 */
	@Override
	public void unUse(Person person) {
		person.setAgility(-2);
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Agility Steroid";
	}

	/**
	 * Method getDescription.
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "The Agility Steroid permanently adds  "
				+ "2 agility points to your current standings. "
				+ "This is useful because you can move further "
				+ "distances in 1 turn.\n" + "+2 Agility Point";
	}

	/**
	 * Method getFileName.
	 * @return String
	 */
	@Override
	public String getFileName() {
		return "steroid1";
	}
}
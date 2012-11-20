/**
 * StrengthVitamin.java
 * @version 1.0
 */
package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a StrengthVitamin
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class StrengthVitamin extends Item implements Usable {
	/**
	 * Method hashCode.
	 * @return int
	 */
	@Override
	public int hashCode() {
		return 3;//hashcode for hashmap
	}

	/**
	 * Method use.
	 * @param person Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#use(Person)
	 */
	@Override
	public void use(Person person) {
		person.setStrength(2);//adds two strength points
	}

	/**
	 * Method unUse.
	 * @param person Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#unUse(Person)
	 */
	@Override
	public void unUse(Person person) {
		person.setStrength(-2);//subtracts two strength points
	}

	/**
	 * Method equals.
	 * @param obj Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(getClass().equals(obj.getClass()))) {
			return false;
		}
		return true;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Strength Vitamin";
	}

	/**
	 * Method getDescription.
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "The Strength Vitamin permanently adds "
				+ "1 strength point to your current standings. "
				+ "Increasing your strength will allow you to "
				+ "dominate your opponents! \n" + "+1 Strength Point";
	}

	/**
	 * Method getFileName.
	 * @return String
	 */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "vitamin4";
	}
}
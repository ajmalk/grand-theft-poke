/**
 * Pikachu.java
 * @version 1.0
 */
package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a Pikachu
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Pikachu extends Item {
	/**
	 * Method hashCode.
	 * @return int
	 */
	@Override
	public int hashCode() {
		return 10;//hashcode for hashmap
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
	 * Method use.
	 * @param person Person
	 * @return boolean
	 */
	public boolean use(Person person) {
		return false;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Pikachu Pokemon";
	}

	/**
	 * Method getDescription.
	 * @return String
	 */
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "I'm a Pikachu!";
	}

	/**
	 * Method getFileName.
	 * @return String
	 */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "pikachu";
	}
}
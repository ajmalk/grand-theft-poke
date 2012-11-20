/**
 * Repel.java
 * @version 1.0
 */
package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a repel
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
@XStreamAlias("Repel")
public class Repel extends Item implements Usable {
	/**
	 * Method hashCode.
	 * @return int
	 */
	@Override
	public int hashCode() {
		return 6;//hashcode for hashmap
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
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#use(Person)
	 */
	@Override
	public void use(Person person) {
		// should be done
	}

	/**
	 * Method unUse.
	 * @param person Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#unUse(Person)
	 */
	@Override
	public void unUse(Person person) {
		// should be done
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Repel";
	}

	/**
	 * Method getDescription.
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "Repel";
	}

	/**
	 * Method getFileName.
	 * @return String
	 */
	@Override
	public String getFileName() {
		return "potion2";
	}
}
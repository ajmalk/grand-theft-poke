/**
 * Pokeball.java
 * @version 1.0
 */
package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

//import edu.gatech.CS2340.grandtheftpoke.Person;
/**
 * Represents a Pokeball
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Pokeball extends Item {
	/**
	 * empty constructor
	 * 
	 * @param obj
	 *            Object
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
	 * Returns a string of the item's name
	 * 
	 * 
	 * @return string name of the item
	 */
	@Override
	public String toString() {
		return "Pokeball";
	}

	/**
	 * Method hashCode.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int hash = 5;// hashcode for hashmap
		return hash;
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "A pokeball";
	}

	/**
	 * Method getFileName.
	 * 
	 * @return String
	 */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "pokeball";
	}
}

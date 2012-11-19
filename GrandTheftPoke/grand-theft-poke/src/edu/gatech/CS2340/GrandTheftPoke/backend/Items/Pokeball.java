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
	 */

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return true;
	}

	/**
	 * Returns a string of the item's name
	 * 
	 * @return string name of the item
	 */
	@Override
	public String toString() {
		return "Pokeball";
	}

	@Override
	public int hashCode() {
		final int hash = 5;
		return hash;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "A pokeball";
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "pokeball";
	}
}

/**
 * Charizard.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents a Charmander
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Charmander extends Pokemon {

	/**
	 * Constructor for Charmander.
	 */
	public Charmander() {
		super(5, 3, 1, 1);//stats for charizard
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Charmander Pokemon";
	}

	/**
	 * Method getDescription.
	 * @return String
	 */
	@Override
	public String getDescription() {

		return "I'm a Charmander";
	}

	/**
	 * Method getFileName.
	 * @return String
	 */
	@Override
	public String getFileName() {
		return "charmander";
	}
}
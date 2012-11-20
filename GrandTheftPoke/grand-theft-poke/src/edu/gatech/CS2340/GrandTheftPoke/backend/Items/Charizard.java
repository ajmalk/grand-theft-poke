/**
 * Charizard.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents a Charizard
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Charizard extends Pokemon {

	/**
	 * Constructor for Charizard.
	 */
	public Charizard() {
		super(1, 2, 3, 4);//stats for charizard
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Charizard Pokemon";
	}

	/**
	 * Method getDescription.
	 * @return String
	 */
	@Override
	public String getDescription() {

		return "I'm a Charizard";
	}

	/**
	 * Method getFileName.
	 * @return String
	 */
	@Override
	public String getFileName() {
		return "charizard";
	}
}
/**
 * Charizard.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents a Bulbasaur
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Bulbasaur extends Pokemon {

	/**
	 * Constructor for Bulbasaur.
	 */
	public Bulbasaur() {
		super(1, 1, 4, 4);// stats for bulbasaur
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Bulbasaur Pokemon";
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	@Override
	public String getDescription() {

		return "I'm a Bulbasaur";
	}

	/**
	 * Method getFileName.
	 * 
	 * @return String
	 */
	@Override
	public String getFileName() {
		return "bulbasaur";
	}
}

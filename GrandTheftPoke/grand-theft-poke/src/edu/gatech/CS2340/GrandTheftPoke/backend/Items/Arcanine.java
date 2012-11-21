/**
 * Arcanine.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents an arcanine
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Arcanine extends Pokemon {

	/**
	 * Arcanine Constructor
	 */
	public Arcanine() {
		super(3, 0, 2, 1);// stats for arcanine
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Arcanine Pokemon";
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "I'm an Arcanine!";
	}

	/**
	 * Method getFileName.
	 * 
	 * @return String
	 */
	@Override
	public String getFileName() {
		return "arcanine";
	}

}
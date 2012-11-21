/**
 * Squirtle.java
 * @version 1.0
 */
package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents a Squirtle
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Squirtle extends Pokemon {

	/**
	 * Squirtle Constructor
	 */
	public Squirtle() {
		super(3, 2, 2, 3);//stats for squirtle
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Squirtle";
	}

	/**
	 * Method getDescription.
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "I'm a Squirtle!";
	}

	/**
	 * Method getFileName.
	 * @return String
	 */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "squirtle";
	}
}
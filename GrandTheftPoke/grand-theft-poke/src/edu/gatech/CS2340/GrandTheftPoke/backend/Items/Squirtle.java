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
		super(3, 3, 2, 2);
	}

	@Override
	public String toString() {
		return "Squirtle";
	}

	@Override
	public String getDescription() {
		return "I'm a Squirtle!";
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "squirtle";
	}
}
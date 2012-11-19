package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents a Charizard
 * 
 * @author Team Rocket
 * 
 */
public class Charizard extends Pokemon {

	public Charizard() {
		super(1, 2, 3, 4);
	}

	@Override
	public String toString() {
		return "Charizard Pokemon";
	}

	@Override
	public String getDescription() {

		return "I'm a Charizard";
	}

	@Override
	public String getFileName() {
		return "charizard";
	}
}
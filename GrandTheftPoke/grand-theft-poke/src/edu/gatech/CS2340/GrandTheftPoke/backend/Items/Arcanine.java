package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents an arcanine
 * 
 * @author Team Rocket
 * 
 */
public class Arcanine extends Pokemon {

	/**
	 * Arcanine Constructor
	 */
	public Arcanine() {
		super(1, 2, 3, 4);
	}

	@Override
	public String toString() {
		return "Arcanine Pokemon";
	}

	@Override
	public String getDescription() {
		return "I'm an Arcanine!";
	}

	@Override
	public String getFileName() {
		return "arcanine";
	}

}
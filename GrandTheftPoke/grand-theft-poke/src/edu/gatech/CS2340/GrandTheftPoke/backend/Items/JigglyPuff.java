package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents a JigglyPuff
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class JigglyPuff extends Pokemon {

	/**
	 * JigglyPuff Constructor
	 */
	public JigglyPuff() {
		super(1, 2, 3, 4);
	}

	@Override
	public String toString() {
		return "Jiggly Puff Pokemon";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "I'm a Jigglypuff!";
	}

	@Override
	public String getFileName() {
		return "jigglypuff";
	}
}
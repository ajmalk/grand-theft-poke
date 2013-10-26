/**
 * JigglyPuff.java
 * @version 1.0
 */
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
		super(0, 3, 1, 0);// stats for jigglypuff
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Jiggly Puff Pokemon";
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "I'm a Jigglypuff!";
	}

	/**
	 * Method getFileName.
	 * 
	 * @return String
	 */
	@Override
	public String getFileName() {
		return "jigglypuff";
	}
}
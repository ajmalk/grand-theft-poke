package edu.gatech.CS2340.GrandTheftPoke.backend;

import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;

/**
 * The path
 * 
 * @author Team Rocket
 * @version 1.0
 */
public class Path {

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Path [target=" + target + ", weight=" + weight + "]";
	}

	/**
	 * Field target.
	 */
	private final Town target;
	
	/**
	 * Field weight.
	 */
	private final int weight;

	/**
	 * Checks for efficiency
	 * 
	 * @param argTarget
	 *            town that is the target
	 * @param argWeight
	 *            target weight
	 */
	public Path(Town argTarget, int argWeight) {
		target = argTarget;
		weight = argWeight;
	}

	/**
	 * returns the target
	 * 
	
	 * @return target the target */
	public Town getTarget() {
		return target;
	}

	/**
	 * returns the weight
	 * 
	
	 * @return weight the weight */
	public int getWeight() {
		return weight;
	}
}

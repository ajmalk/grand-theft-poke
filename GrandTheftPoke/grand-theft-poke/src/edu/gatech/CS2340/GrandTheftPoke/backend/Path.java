package edu.gatech.CS2340.GrandTheftPoke.backend;

import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;

/**
 * 
 * @author Team Rocket
 */
public class Path {

	private final Town target;
	private final int weight;

	/**
	 * 
	 * @param argTarget
	 * @param argWeight
	 */
	public Path(Town argTarget, int argWeight) {
		target = argTarget;
		weight = argWeight;
	}

	/**
	 * 
	 * @return
	 */
	public Town getTarget() {
		return target;
	}

	/**
	 * 
	 * @return
	 */
	public int getWeight() {
		return weight;
	}
}

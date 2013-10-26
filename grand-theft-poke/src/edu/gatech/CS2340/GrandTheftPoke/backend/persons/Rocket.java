/**
 * Rocket.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.backend.persons;

import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;

/**
 * Represents a member of Team Rocket
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Rocket extends Person {

	/**
	 * @param name
	 * @param strength
	 * @param agility
	 * @param trade
	 * @param stamina
	 * @param health
	 * @param range
	 * @param capacity
	 * @param money
	 * @param theMap
	 */
	public Rocket(String name, int strength, int agility, int trade,
			int stamina, int health, int range, int capacity, Float money,
			GameMap theMap) {
		super(name, strength, agility, trade, stamina, health, range, capacity,
				money, theMap);

		super.setCurrent(theMap.getRandomTown());
	}

}

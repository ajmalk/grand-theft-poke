/**
 * TradeRoid.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a TradeRoid
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class TradeRoid extends Item implements Usable {
	/**
	 * Method hashCode.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		return 17;// hashcode for hashmap
	}

	/**
	 * Method use.
	 * 
	 * @param person
	 *            Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#use(Person)
	 */
	@Override
	public void use(Person person) {
		person.setTrade(2);// adds two points to trade
	}

	/**
	 * Method unUse.
	 * 
	 * @param person
	 *            Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#unUse(Person)
	 */
	@Override
	public void unUse(Person person) {
		person.setTrade(-2);// subtracts two points from trade
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(getClass().equals(obj.getClass()))) {
			return false;
		}
		return true;
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Trade Steriod";
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "The Trade Steroid permanently adds "
				+ "2 trade points to your current standings. "
				+ "Increasing trade ability allows you to become "
				+ "a master trader, thus allowing you to negotiate the "
				+ "the most competive pricing!\n" + "+2 Trade Point";
	}

	/**
	 * Method getFileName.
	 * 
	 * @return String
	 */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "steroid5";
	}
}
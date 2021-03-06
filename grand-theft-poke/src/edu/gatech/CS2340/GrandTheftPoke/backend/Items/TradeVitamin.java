/**
 * TradeVitamin.java
 * @version 1.0
 */
package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a TradeVitamin
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class TradeVitamin extends Item implements Usable {

	/**
	 * Method use.
	 * 
	 * @param person
	 *            Person
	 * @see edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable#use(Person)
	 */
	@Override
	public void use(Person person) {
		person.setTrade(1);// adds one point to trade
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
		person.setTrade(-1);// subtracts one point from trade
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Trade Vitamin";
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "Temporarily adds "
				+ "2 trade points to your current standings. "
				+ "Increasing trade ability allows you to negotiate the "
				+ "the best pricing!\n" + "+2 Trade Point";
	}

	/**
	 * Method getFileName.
	 * 
	 * @return String
	 */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "vitamin5";
	}
}
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
	@Override
	public int hashCode() {
		return 17;
	}

	@Override
	public void use(Person person) {
		person.setTrade(2);
	}

	@Override
	public void unUse(Person person) {
		person.setTrade(-2);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Trade Steriod";
	}

	@Override
	public String getDescription() {
		return "The Trade Steroid permanently adds "
				+ "2 trade points to your current standings. "
				+ "Increasing trade ability allows you to become "
				+ "a master trader, thus allowing you to negotiate the "
				+ "the most competive pricing!\n" + "+2 Trade Point";
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "steroid5";
	}
}
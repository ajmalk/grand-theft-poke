package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a StrengthRoid
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class StrengthRoid extends Item implements Usable {
	@Override
	public int hashCode() {
		return 15;
	}

	@Override
	public void use(Person person) {
		person.setStrength(2);
	}

	@Override
	public void unUse(Person person) {
		person.setStrength(-2);
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
		return "Strength Steroid";
	}

	@Override
	public String getDescription() {
		return "The Strength Steroid permanently adds "
				+ "2 strength points to your current standings. "
				+ "Increasing your strength will allow you to "
				+ "dominate your opponents! \n" + "+2 Strength Point";
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "steroid4";
	}
}
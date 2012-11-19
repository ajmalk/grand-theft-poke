package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a StrengthVitamin
 * @author Team Rocket
 *
 */
public class StrengthVitamin extends Item implements Usable {
	@Override
	public int hashCode() {
		return 3;
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
		final StrengthVitamin other = (StrengthVitamin) obj;
		return true;
	}

	@Override
	public String toString() {
		return "Strength Vitamin";
	}

	@Override
	public String getDescription() {
		return "The Strength Vitamin permanently adds \n "
				+ "1 strength point to your current standings.\n"
				+ "Increasing your strength will allow you to\n"
				+ "dominate your opponents! " + "+1 Strength Point";
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "vitamin4";
	}
}
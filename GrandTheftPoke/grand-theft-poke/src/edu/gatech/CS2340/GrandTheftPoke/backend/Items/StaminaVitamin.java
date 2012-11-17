package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

public class StaminaVitamin extends Item implements Usable {
	@Override
	public int hashCode() {
		return 4;
	}

	@Override
	public void use(Person person) {
		person.setStamina(1);
	}

	@Override
	public void unUse(Person person) {
		person.setStamina(-1);
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
		return "Stamina Vitamin";
	}

	@Override
	public String getDescription() {
		return "The Stamina Steriod permently adds \n "
				+ "1 stamina points to your current standings.\n"
				+ "Increasing stamina allows you to move more\n"
				+ "more efficiently from town to town, therefore "
				+ "conserving health! \n" + "+1 Stamina Point";
	}
}
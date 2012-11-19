package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a StaminaVitamin
 * 
 * @author Team Rocket
 * 
 */
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
		return "The Stamina Vitamin permanently adds "
				+ "1 stamina point to your current standings. "
				+ "Increasing stamina allows you to move more "
				+ "more efficiently from town to town, therefore "
				+ "conserving health! \n" + "+1 Stamina Point";
	}

	@Override
	public String getFileName() {
		return "vitamin3";
	}
}
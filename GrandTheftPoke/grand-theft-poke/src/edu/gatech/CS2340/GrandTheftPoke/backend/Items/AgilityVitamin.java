package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents Agility Vitamin
 * 
 * @author Team Rocket
 * 
 */
public class AgilityVitamin extends Item implements Usable {

	@Override
	public void use(Person person) {
		person.setAgility(1);
	}

	@Override
	public void unUse(Person person) {
		person.setAgility(-1);
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
		return "Agility Vitamin";
	}

	@Override
	public String getDescription() {
		return "The Agiliy Vitamin permanently adds \n "
				+ "1 agility point to your current standings.\n"
				+ "This is useful because you can move further \n"
				+ "distances in 1 turn.\n" + "+1 Agility Point";
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "vitamin1";
	}
}
package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

public class AgilityRoid extends Item implements Usable {

	
	@Override
	public void use(Person person) {
		person.setAgility(2);
	}

	@Override
	public void unUse(Person person) {
		person.setAgility(-2);
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
		return "Agility Steroid";
	}

	@Override
	public String getDescription() {
		return "The Agility Steroid permanently adds \n "
				+ "2 agility points to your current standings.\n"
				+ "This is useful because you can move further \n"
				+ "distances in 1 turn.\n" + "+2 Agility Point";
	}

	@Override
	public String getFileName() {
		return "steroid1";
	}
}
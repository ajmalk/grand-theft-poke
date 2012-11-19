package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

public class HealthRoid extends Item implements Usable {

	@Override
	public void use(Person person) {
		int maxHealth = person.getMaxHealth();
		person.setMaxHealth(maxHealth + 25);
		person.setHealth(maxHealth);
	}

	@Override
	public void unUse(Person person) {
		int maxHealth = person.getMaxHealth();
		person.setMaxHealth(maxHealth - 25);
		if (person.getMaxHealth() > person.getHealth()) {
			person.setHealth(maxHealth);
		}
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
		return "Health Steroid";
	}

	@Override
	public String getDescription() {
		return "Health Steroids add 25 to your\n"
				+ "max health, then sets your current\n" + "to the new max.\n"
				+ "Max Health + 25\n" + "Restores health to new max.";
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "steroid2";
	}
}
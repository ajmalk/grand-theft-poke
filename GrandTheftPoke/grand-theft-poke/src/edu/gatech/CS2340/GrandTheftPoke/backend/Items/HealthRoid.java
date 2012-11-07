package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable;
import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class HealthRoid extends Item implements Usable{
    @Override
	public int hashCode() {
		return 13;
	}
	
    @Override
	public boolean Use(Person person) {
		int maxHealth = person.getMaxHealth();
		int health = person.getHealth();
		person.setMaxHealth(maxHealth +25);
		person.setHealth(maxHealth-health);
		return false;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HealthRoid other = (HealthRoid) obj;
        return true;
    }

	@Override
	public String toString() {
		return "Health Steriod";
	}

	@Override
	public String getDescription() {
		return "Health Steriods add 25 to your\n"+
				"max health, then sets your current\n"+
				"to the new max.\n"+
				"Max Health + 25\n"+
				"Restores health to new max.";
	}
}
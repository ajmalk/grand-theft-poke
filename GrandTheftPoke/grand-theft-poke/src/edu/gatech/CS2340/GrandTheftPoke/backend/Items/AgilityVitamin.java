package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class AgilityVitamin extends Item implements Usable {
	public int hashCode() {
		return 2;
	}
	
	public boolean Use(Person person) {
		person.setAgility(1);
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
        final AgilityVitamin other = (AgilityVitamin) obj;
        return true;
    }

	@Override
	public String toString() {
		return "Agility Vitamin";
	}

	@Override
	public String getDescription() {
		return "The Agiliy Steriod permently adds \n " +
				"1 agility points to your current standings.\n" +
				"This is useful because you can move further \n"+
				"distances in 1 turn.\n"+
				"+1 Agility Point";
	}
}
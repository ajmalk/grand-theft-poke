package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;


public class StaminaRoid extends Item implements Usable{
	public int hashCode() {
		return 16;
	}
	
    @Override
	public boolean Use(Person person) {
		person.setStamina(2);
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
        final StaminaRoid other = (StaminaRoid) obj;
        return true;
    }

	@Override
	public String toString() {
		return "Stamina Steriod";
	}

	@Override
	public String getDescription() {
		return "The Stamina Steriod permently adds \n " +
				"2 stamina points to your current standings.\n" +
				"Increasing stamina allows you to move more\n"+
				"more efficiently from town to town, therefore "+
				"conserving health! \n"+
				"+2 Stamina Point";
	}
}
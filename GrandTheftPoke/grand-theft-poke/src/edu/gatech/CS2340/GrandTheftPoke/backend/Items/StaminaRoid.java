package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;


public class StaminaRoid extends Item implements Usable{
	public int hashCode() {
		return 16;
	}
	
    @Override
	public boolean Use(Person person) {
		person.setStamina(1);
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
}
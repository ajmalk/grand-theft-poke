package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable;
import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class StaminaVitamin extends Item implements Usable {
    @Override
	public int hashCode() {
		return 4;
	}
	
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
        final StaminaVitamin other = (StaminaVitamin) obj;
        return true;
    }
}
package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class StrengthVitamin extends Item implements Usable {
    @Override
	public int hashCode() {
		return 3;
	}
	
	public boolean Use(Person person) {
		person.setStrength(2);
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
        final StrengthVitamin other = (StrengthVitamin) obj;
        return true;
    }
}
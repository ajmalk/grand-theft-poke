package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable;
import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class StrengthRoid extends Item implements Usable{
    @Override
	public int hashCode() {
		return 15;
	}
	
    @Override
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
        final StrengthRoid other = (StrengthRoid) obj;
        return true;
    }
}
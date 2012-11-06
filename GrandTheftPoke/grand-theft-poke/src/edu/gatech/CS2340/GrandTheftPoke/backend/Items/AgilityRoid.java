package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable;
import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class AgilityRoid extends Item implements Usable{
    @Override
	public int hashCode() {
		return 14;
	}
	
	public boolean Use(Person person) {
		person.setAgility(2);
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
        final AgilityRoid other = (AgilityRoid) obj;
        return true;
    }
}
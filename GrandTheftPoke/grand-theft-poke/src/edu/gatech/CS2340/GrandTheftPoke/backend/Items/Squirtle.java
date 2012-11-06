package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class Squirtle extends Item {
    @Override
	public int hashCode() {
		return 8;
	}


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Squirtle other = (Squirtle) obj;
        return true;
    }
	public boolean Use(Person person){
		return false;
	}
}
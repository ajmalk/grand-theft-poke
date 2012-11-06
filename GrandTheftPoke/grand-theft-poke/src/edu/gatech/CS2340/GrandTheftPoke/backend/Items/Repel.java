package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class Repel extends Item implements Usable {
	public int hashCode() {
		return 6;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Repel other = (Repel) obj;
        return true;
    }

    @Override
    public boolean Use(Person person) {
        return false;
    }
}
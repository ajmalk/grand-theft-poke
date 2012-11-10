package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class Repel extends Item implements Usable {
	@Override
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
        return true;
    }

    @Override
    public void use(Person person) {
       //should be done
    }
    
    @Override
	public void unUse(Person person) {
		//should be done
	}

	@Override
	public String toString() {
		return "Repel";
	}

	@Override
	public String getDescription() {
		return null;
	}
}
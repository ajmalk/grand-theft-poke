package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class Arcanine extends Item {
    @Override
	public int hashCode() {
		return 12;
	}
	public boolean Use(Person person){
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
        final Arcanine other = (Arcanine) obj;
        return true;
    }
	@Override
	public String toString() {
		return "Arcanine Pokemon";
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
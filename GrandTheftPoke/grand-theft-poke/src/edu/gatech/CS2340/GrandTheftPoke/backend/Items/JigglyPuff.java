package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class JigglyPuff extends Item {
	public int hashCode() {
		return 11;
	}
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JigglyPuff other = (JigglyPuff) obj;
        return true;
    }

	public boolean Use(Person person){
		return false;
	}
	@Override
	public String toString() {
		return "Jiggly Puff Pokemon";
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
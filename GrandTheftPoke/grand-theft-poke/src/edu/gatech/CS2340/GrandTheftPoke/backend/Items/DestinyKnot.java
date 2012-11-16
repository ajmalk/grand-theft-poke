package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable;
import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class DestinyKnot extends Item implements Usable{
	 @Override
		public int hashCode() {
			return 18;
		}

		public boolean Use(Person person) {
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
	        final HealthRoid other = (HealthRoid) obj;
	        return true;
	    }
		@Override
		public String toString() {
			return "Destiny Knot";
		}
		@Override
		public String getDescription() {
			return "The Destiny Knot is an amulet commonly \n"+
					"found in large cities but covetted by the \n"+
					"small villages.";
		}
}


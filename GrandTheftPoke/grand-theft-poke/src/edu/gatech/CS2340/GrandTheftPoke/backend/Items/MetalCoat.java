package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable;
import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class MetalCoat extends Item implements Usable{
	 @Override
		public int hashCode() {
			return 20;
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
			return "Metal Jacket";
		}
		//TODO finish the description
		@Override
		public String getDescription() {
			return "The Metal Jacket is an amulet commonly \n"+
					"found luxary areas but covetted by the \n"+
					"everyone else.";
		}
}



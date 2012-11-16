package edu.gatech.CS2340.GrandTheftPoke.backend.Items;


public class FlameOrb extends Item{
	 @Override
		public int hashCode() {
			return 19;
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
			return "Flame Orb";
		}
		@Override
		public String getDescription() {
			return "The Flame Orb is an amulet commonly \n"+
					"found luxary areas but covetted by the \n"+
					"everyone else.";
		}
}


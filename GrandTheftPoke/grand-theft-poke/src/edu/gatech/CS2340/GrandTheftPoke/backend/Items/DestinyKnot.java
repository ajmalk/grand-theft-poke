package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents a DestinyKnot
 * 
 * @author Team Rocket
 * 
 */
public class DestinyKnot extends Item {
	@Override
	public int hashCode() {
		return 18;
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
		return "The Destiny Knot is an amulet commonly "
				+ "found in large cities but covetted by the "
				+ "small villages.";
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "destinyknot";
	}

}

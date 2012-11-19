package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents a FlameOrb
 * 
 * @author Team Rocket
 * 
 */
public class FlameOrb extends Item {
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
		return true;
	}

	@Override
	public String toString() {
		return "Flame Orb";
	}

	@Override
	public String getDescription() {
		return "The Flame Orb is an amulet commonly "
				+ "found luxary areas but covetted by the " + "everyone else.";
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "flameorb";
	}
}

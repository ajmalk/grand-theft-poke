package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents a FlameOrb
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class FlameOrb extends Item {
	/**
	 * Method hashCode.
	 * @return int
	 */
	@Override
	public int hashCode() {
		return 19;
	}

	/**
	 * Method equals.
	 * @param obj Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(getClass().equals(obj.getClass()))) {
			return false;
		}
		return true;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Flame Orb";
	}

	/**
	 * Method getDescription.
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "The Flame Orb is an amulet commonly "
				+ "found luxary areas but covetted by the " + "everyone else.";
	}

	/**
	 * Method getFileName.
	 * @return String
	 */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "flameorb";
	}
}

/**
 * MetalCoat.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents a MetalCoat
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class MetalCoat extends Item {
	/**
	 * Method hashCode.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		return 20;// hashcode for hashmap
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            Object
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
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Metal Jacket";
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	@Override
	public String getDescription() {
		return "The Metal Jacket is an amulet commonly \n"
				+ "found luxary areas but covetted by the \n"
				+ "everyone else.";
	}

	/**
	 * Method getFileName.
	 * 
	 * @return String
	 */
	@Override
	public String getFileName() {
		return "metalcoat";
	}
}

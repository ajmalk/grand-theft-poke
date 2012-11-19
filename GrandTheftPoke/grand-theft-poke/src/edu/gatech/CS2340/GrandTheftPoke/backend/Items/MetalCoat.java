package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * Represents a MetalCoat
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class MetalCoat extends Item {
	@Override
	public int hashCode() {
		return 20;
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
		return "Metal Jacket";
	}

	@Override
	public String getDescription() {
		return "The Metal Jacket is an amulet commonly \n"
				+ "found luxary areas but covetted by the \n"
				+ "everyone else.";
	}

	@Override
	public String getFileName() {
		return "metalcoat";
	}
}

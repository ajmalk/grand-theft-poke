package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a Pikachu
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Pikachu extends Item {
	@Override
	public int hashCode() {
		return 10;
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

	public boolean use(Person person) {
		return false;
	}

	@Override
	public String toString() {
		return "Pikachu Pokemon";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "I'm a Pikachu!";
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "pikachu";
	}
}
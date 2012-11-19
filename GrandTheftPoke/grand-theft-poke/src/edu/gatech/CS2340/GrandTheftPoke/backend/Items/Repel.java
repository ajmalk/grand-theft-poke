package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;
/**
 * Represents a repel
 * @author Team Rocket
 *
 */
@XStreamAlias("Repel")
public class Repel extends Item implements Usable {
	@Override
	public int hashCode() {
		return 6;
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
	public void use(Person person) {
		// should be done
	}

	@Override
	public void unUse(Person person) {
		// should be done
	}

	@Override
	public String toString() {
		return "Repel";
	}

	@Override
	public String getDescription() {
		return "Repel";
	}

	@Override
	public String getFileName() {
		return "potion2";
	}
}
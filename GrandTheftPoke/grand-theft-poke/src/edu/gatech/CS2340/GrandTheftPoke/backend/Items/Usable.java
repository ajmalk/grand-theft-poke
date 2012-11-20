/**
 * Usable.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Represents a Usable Item
 * 
 * @author Team Rocket
 * @version 1.0
 */
public interface Usable {
	/**
	 * represents an item being used
	 * 
	 * @param person
	 *            the person to use it on
	 */
	void use(Person person);

	/**
	 * unuse an item
	 * 
	 * @param person
	 *            the person to unuse on
	 */
	void unUse(Person person);
	// public boolean checkForUsage();
	// public void stageForUsage();
	// public int getTimer();

}

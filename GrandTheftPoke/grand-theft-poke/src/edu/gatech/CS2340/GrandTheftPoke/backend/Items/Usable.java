package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * 
 * @author Ben_2
 */
public interface Usable {
    /**
     * 
     * @param person
     */
    public void use(Person person);
    public void unUse(Person person);
    //public boolean checkForUsage();
    //public void stageForUsage();
	//public int getTimer();

}

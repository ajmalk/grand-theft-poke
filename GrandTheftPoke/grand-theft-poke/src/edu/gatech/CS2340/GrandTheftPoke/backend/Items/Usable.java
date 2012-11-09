package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

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

}


package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public abstract class Potion extends Item implements Usable{
    @Override
	public abstract void use(Person person);
    public abstract void unUse(Person person);
}

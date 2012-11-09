package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public abstract class Steroids extends Item implements Usable{
	public abstract void use(Person person);
    public abstract void unUse(Person person);
}

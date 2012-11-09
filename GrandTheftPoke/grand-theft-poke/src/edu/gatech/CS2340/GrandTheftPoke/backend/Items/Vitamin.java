package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public abstract class Vitamin extends Item implements Usable{
    @Override
	public abstract void use(Person person);
    @Override
    public abstract void unUse(Person person);
}

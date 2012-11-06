package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public abstract class Vitamin extends Item implements Usable{
    @Override
	public boolean Use(Person person){
		return false;
	}
}

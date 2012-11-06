package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable;
import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public abstract class Pokemon extends Item implements Usable{
    @Override
	public boolean Use(Person person){
		return false;
	}
}

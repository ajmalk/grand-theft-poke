package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

public class DistancePack extends Item implements Usable{
	
	private static final int BOOST = 100;
	private static final int PENALTY = 10;

	@Override
	public String getFileName() {
		return "distancePack";
	}

	@Override
	public String getDescription() {
		return "Increases the distance you can travel but has less space";
	}
	
	@Override
	public String toString() {
		return "Distance Pack";
	}

	@Override
	public void use(Person person) {
		person.getBackpack().setMaxRange(person.getBackpack().getMaxRange() + BOOST);
		person.getBackpack().setCapacity(person.getBackpack().getCapacity() - PENALTY);
		
	}

	@Override
	public void unUse(Person person) {
		person.getBackpack().setMaxRange(person.getBackpack().getMaxRange() - BOOST);
		person.getBackpack().setCapacity(person.getBackpack().getCapacity() + PENALTY);
	}

}

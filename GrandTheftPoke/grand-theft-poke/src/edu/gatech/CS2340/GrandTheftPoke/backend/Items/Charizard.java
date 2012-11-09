package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class Charizard extends Pokemon implements Usable {

	public Charizard() {
		super(1,2,3,4);
	}
	public void use(Person person) {
		super.use(person);
	}
	
	public void unUse(Person person) {
		super.unUse(person);
	}
	@Override
	public String toString() {
		return "Charizard Pokemon";
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
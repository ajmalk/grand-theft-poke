package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class Charizard extends Item {
	public int hashCode() {
		return 9;
	}
	public boolean Use(Person person){
		return false;
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
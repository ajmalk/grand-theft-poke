package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

public class Squirtle extends Pokemon {
	public Squirtle() {
		super(3, 3, 2, 2);
	}

	@Override
	public String toString() {
		return "Squirtle";
	}

	@Override
	public String getDescription() {
		return "I'm a Squirtle!";
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "squirtle";
	}
}
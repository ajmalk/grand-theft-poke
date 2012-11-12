package edu.gatech.CS2340.GrandTheftPoke.backend;

public class GymLeader extends Person {
	
	public GymLeader(String name, int strength, int agility, int trade, int stamina, int health, int range, int capacity, int money, GameMap theMap) {
		super(name, strength, agility, trade, stamina, health, range, capacity, money, theMap);
	}

	@Override
	public void postBattle(Person other) {
		// TODO Auto-generated method stub

	}

}

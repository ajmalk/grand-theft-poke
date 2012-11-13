package edu.gatech.CS2340.GrandTheftPoke.backend;

public class Rocket extends Person {
	
	public Rocket(String name, int strength, int agility, int trade, int stamina, int health, int range, int capacity, int money, GameMap theMap) {
		super(name, strength, agility, trade,
				stamina, health, range, capacity, money,
				theMap);
		
		super.setCurrent(theMap.getRandomTown());
	}

}

package edu.gatech.CS2340.GrandTheftPoke.backend.persons;

import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;

public class Rocket extends Person {
	
	public Rocket(String name, int strength, int agility, int trade, int stamina, int health, int range, int capacity, Float money, GameMap theMap) {
		super(name, strength, agility, trade,
				stamina, health, range, capacity, money,
				theMap);
		
		super.setCurrent(theMap.getRandomTown());
	}

}

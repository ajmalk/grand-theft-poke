package edu.gatech.CS2340.GrandTheftPoke.backend;

import java.util.ArrayList;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * TODO implement this class
 * @author Team Rocket
 */
public class Turn {
	private GameMap theMap;
	private ArrayList<Person> gameActors;
	public Turn(GameMap theMap, ArrayList<Person> gameActors) {
		this.theMap = theMap;
		this.gameActors = gameActors;
	}
	
	public void useAll() {
		/*for(Person individual : gameActors) {
			Set<Item> myStuff = individual.getBackpack().getContents().keySet();
			for(Item theItem : myStuff) {
				if(theItem instanceof Usable) {
					if(((Usable) theItem).checkForUsage()) {
						((Usable) theItem).use(individual);
					} else if(((Usable) theItem).getTimer() <= 0) {
						((Usable)theItem).unUse(individual);
					}
				}
			}
		}*/
	}
}

package edu.gatech.CS2340.GrandTheftPoke.backend;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Rocket;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Trader;

/**
 * TODO implement this class
 * @author Team Rocket
 */
public class Turn {
	private GameMap theMap;
	private ArrayList<Person> gameActors;
	private Player thePlayer;
	private Random rand;
	public Turn(GameMap theMap, ArrayList<Person> gameActors, Player thePlayer) {
		this.theMap = theMap;
		this.gameActors = gameActors;
		this.thePlayer = thePlayer;
		rand = new Random();
	}
	public void takeATurn() {
		useAll();
		moveAll();
		trade();
		encounter(thePlayer);
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
	
	public void moveAll() {
		for(Person individual : gameActors) {
			individual.move(theMap.getRandomTown());
		}
	}
	
	public void trade() {
		MarketPlace currentMarket;
		Set<Item> currentStock;
		Item[] possibleItems = new Item[17];
		for(Person individual : gameActors) {
			if(individual instanceof Trader) {
				if(rand.nextBoolean()) {
					currentMarket = individual.getCurrent().getMarket(); //BUY SOMETHING RANDOM
					currentStock = currentMarket.getStock().keySet();
					currentStock.toArray(possibleItems);
					individual.buy(currentMarket, possibleItems[rand.nextInt(possibleItems.length)], rand.nextInt(10));
				} else {
					currentMarket = individual.getCurrent().getMarket(); //SELL SOMETHING RANDOM
					currentStock = individual.getBackpack().getContents().keySet();
					currentStock.toArray(possibleItems);
					Item toBeSold =  possibleItems[rand.nextInt(possibleItems.length)];
					individual.sell(currentMarket,toBeSold, rand.nextInt(individual.getBackpack().getContents().get(toBeSold)));
				}
				
			}
		}
	}
	
	public void encounter(Player thePlayer) {
		for(Person individual : gameActors) {
			if(individual.getCurrent().toString().equals(thePlayer.getCurrent().toString())) {
				if(individual instanceof Trader && rand.nextDouble() <= thePlayer.getAgility()/100) {
					//FIRE SIGNAL TO GUI TO HANDLE ENCOUNTER HERE
					System.out.println("ENCOUNTER A TRADER" + individual.toString());
				} else if(individual instanceof Rocket && rand.nextDouble() >= thePlayer.getAgility()/100) {
					//FIRE SIGNAL TO GUI TO HANDLE ENCOUNTER HERE
					System.out.println("ENCOUNTER A ROCKET" + individual.toString());
				}
			}
		}
	}
}

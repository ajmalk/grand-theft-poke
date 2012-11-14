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
 * 
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

	public Person takeATurn() {
		useAll();
		moveAll();
		trade();
		 return encounter(thePlayer);
	}

	public void useAll() {
		/*
		 * for(Person individual : gameActors) { Set<Item> myStuff =
		 * individual.getBackpack().getContents().keySet(); for(Item theItem :
		 * myStuff) { if(theItem instanceof Usable) { if(((Usable)
		 * theItem).checkForUsage()) { ((Usable) theItem).use(individual); }
		 * else if(((Usable) theItem).getTimer() <= 0) {
		 * ((Usable)theItem).unUse(individual); } } } }
		 */
	}

	public void moveAll() {
		for (Person individual : gameActors) {
			individual.move(theMap.getRandomTown());
		}
	}

	public void trade() {
		MarketPlace currentMarket;
		Set<Item> currentStock;
		Item[] possibleItems = new Item[17];
		for (Person individual : gameActors) {
			if (individual instanceof Trader) {
				
				if (rand.nextBoolean()) {
					currentMarket = individual.getCurrent().getMarket(); // BUY
																			// SOMETHING
																			// RANDOM
					currentStock = currentMarket.getStock().keySet();
					currentStock.toArray(possibleItems);
					int randomIndex = rand.nextInt(possibleItems.length);
					int randomNum = rand.nextInt(10);

					if (((MarketPlaceItem) (currentMarket.getStock()
							.get(possibleItems[randomNum]))).getStock() != 0 && randomNum != 0) {
						individual.buy(currentMarket,
								possibleItems[randomIndex], randomNum);
						System.out.println(individual + " bought " + randomNum
								+ " " + possibleItems[randomIndex] + " in "
								+ individual.getCurrent());
						System.out.println(individual.getBackpack());
					}

				} else {
					currentMarket = individual.getCurrent().getMarket(); // SELL
																			// SOMETHING
																			// RANDOM
					currentStock = individual.getBackpack().getContents()
							.keySet();
					currentStock.toArray(possibleItems);
					Item toBeSold = possibleItems[rand
							.nextInt(possibleItems.length)];
					if (individual.getBackpack().checkContents(toBeSold, 1)) {

						int quantity = rand.nextInt(individual.getBackpack()
								.getContents().get(toBeSold));
						if (individual.getBackpack().checkContents(toBeSold,
								quantity)) {
							individual.sell(currentMarket, toBeSold, quantity);
							System.out.println(individual + " sold " + quantity + " " + toBeSold
									+ " in " + individual.getCurrent());
							
							System.out.println(individual.getBackpack());
						}
					}
				}

			}
		}
	}

	public Person encounter(Player thePlayer) {
		for (Person individual : gameActors) {
			if (individual.getCurrent().toString()
					.equals(thePlayer.getCurrent().toString())) {
				if (individual instanceof Trader) {
						//&& rand.nextDouble() <= thePlayer.getAgility() / 100) {
					System.out.println("ENCOUNTER A TRADER"
							+ individual.toString());
					return individual;
				} else if (individual instanceof Rocket) {
						//&& rand.nextDouble() >= thePlayer.getAgility() / 100) {
					
					System.out.println("ENCOUNTER A ROCKET"
							+ individual.toString());
					return individual;
				}
			}
		}
		return null;
	}
}

package edu.gatech.CS2340.GrandTheftPoke.backend;

import java.util.Iterator;
import java.util.Set;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.GymLeader;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;

/**
 * represents the Main class
 * 
 * @author Team Rocket
 * 
 */
public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final GlobalItemReference theReference = new GlobalItemReference();
		final GameMap testMap = Main.makeMap(theReference);
		// testMap.Dijkstras();
		// testMarketPlace(testMap, theReference);
		testMovement(testMap);
	}

	/**
	 * creates the game map
	 * 
	 * @param theReference
	 *            the globalItemReference
	 * @return a gameMap to be used
	 */
	public static GameMap makeMap(GlobalItemReference theReference) {
		final GameMap map = new GameMap(theReference);
		return map;
	}

	/**
	 * tests marketPlace
	 * 
	 * @param map
	 *            the current gameMap
	 * @param theReference
	 *            the globalItemReference
	 */
	public static void testMarketPlace(GameMap map,
			GlobalItemReference theReference) {

		final Player testPlayer = new Player("Ben", 4, 4, 4, 4, 500, 100, 1000, map);
		final MarketPlace theMarket = testPlayer.getCurrent().getMarket();
		System.out.println(testPlayer.getBackpack());
		System.out.println(testPlayer.getWallet());
		System.out.println(testPlayer.buy(theMarket,
				theReference.getCharizard(), 1));
		System.out.println(testPlayer.getBackpack());
		System.out.println(testPlayer.getWallet());
		System.out.println(testPlayer.sell(theMarket,
				theReference.getHealthPotion(), 3));
		System.out.println(testPlayer.getBackpack());
		System.out.println(testPlayer.getWallet());
		testPlayer.buy(theMarket, theReference.getRepel(), 1);
		System.out.println(testPlayer.getBackpack());
		System.out.println(testPlayer.getWallet());
	}

	/**
	 * tests valid movement
	 * 
	 * @param map
	 *            the current gameMap
	 */
	public static void testMovement(GameMap map) {
		// Player testPlayer = new Player("Ben", 4, 4, 4, 4, 500, 120, 10, map);
		final Person testPlayer = new GymLeader("Brock", 4, 4, 4, 4, 100, 80, 20,
				50f, map);
		final Set<Town> townSet = map.getTownSet();
		for (final Iterator<Town> it = townSet.iterator(); it.hasNext();) {
			testPlayer.move(it.next());
			System.out.println(testPlayer.getCurrent());
			map.Dijkstras(testPlayer.getCurrent());
			System.out.println();
		}
	}
}

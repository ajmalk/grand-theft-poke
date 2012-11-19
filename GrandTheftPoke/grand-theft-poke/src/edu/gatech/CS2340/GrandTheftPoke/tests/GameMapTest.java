package edu.gatech.CS2340.GrandTheftPoke.tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;

/**
 * The class <code>GameMapTest</code> contains tests for the class
 * <code>{@link GameMap}</code>.
 * 
 * @generatedBy CodePro at 11/14/12 10:18 PM
 * @author Ben Nuttle
 * @version $Revision: 1.0 $
 */
public class GameMapTest extends junit.framework.TestCase {
	/**
	 * Run the GameMap() constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Test
	public void testGameMap_1() throws Exception {

		GameMap result = new GameMap();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getStartTown());
	}

	/**
	 * Run the GameMap(GlobalItemReference) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Test
	public void testGameMap_2() throws Exception {
		GlobalItemReference theReference = new GlobalItemReference();

		GameMap result = new GameMap(theReference);
		assertNotNull(result);
	}

	/**
	 * Run the void Dijkstras(Town) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Test
	public void testDijkstras() throws Exception {
		GameMap fixture = new GameMap(new GlobalItemReference());

		int distance = fixture.Dijkstras(fixture.getStartTown(), "Pallet Town");
		assertEquals(distance, 0);

		distance = fixture.Dijkstras(fixture.getStartTown(), "Cinnabar Island");
		assertEquals(distance, 100);

		distance = fixture.Dijkstras(fixture.getStartTown(), "Viridian City");
		assertEquals(distance, 10);

		distance = fixture.Dijkstras(fixture.getStartTown(), "Pewter City");
		assertEquals(distance, 30);

		distance = fixture.Dijkstras(fixture.getStartTown(), "Cerulean City");
		assertEquals(distance, 80);

		distance = fixture.Dijkstras(fixture.getStartTown(), "Power Plant");
		assertEquals(distance, 110);
	}

	/**
	 * Run the void Dijkstras(Town) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Test
	public void testDijkstras_2() throws Exception {
		GameMap fixture = new GameMap();
		fixture.addTown(new Town("", new MarketPlace(new HashMap())));
		Town source = new Town("", new MarketPlace(new HashMap()));

		fixture.Dijkstras(source);
	}

	/**
	 * Run the int Dijkstras(Town,String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Test
	public void testMovement() throws Exception {
		GameMap fixture = new GameMap(new GlobalItemReference());
		Player testPlayer = new Player("Brock", 4, 4, 4, 4, 100, 80, 20,
				fixture);
		Set<Town> townSet = fixture.getTownSet();
		for (Iterator<Town> it = townSet.iterator(); it.hasNext();) {
			testPlayer.move(it.next());
			assertNotNull(testPlayer.getCurrent());
		}

	}

	/**
	 * Run the int Dijkstras(Town,String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Test
	public void testDijkstras_3() throws Exception {
		GameMap fixture = new GameMap(new GlobalItemReference());
		Town source = new Town("", new MarketPlace(new HashMap()));
		String townName = "";

		int result = fixture.Dijkstras(source, townName);
		assertEquals(Integer.MAX_VALUE, result);
	}

	/**
	 * Run the void addTown(Town) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Test
	public void testAddTown_1() throws Exception {
		GameMap fixture = new GameMap(new GlobalItemReference());
		fixture.addTown(new Town("", new MarketPlace(new HashMap())));
		Town toBeAdded = new Town("", new MarketPlace(new HashMap()));

		fixture.addTown(toBeAdded);
	}

	/**
	 * Run the void computePaths(Town) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Test
	public void testComputePaths_1() throws Exception {
		Town source = new Town("", new MarketPlace(new HashMap()));

		GameMap.computePaths(source);
	}

	/**
	 * Run the Town getRandomTown() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Test
	public void testGetRandomTown() throws Exception {
		GameMap fixture = new GameMap(new GlobalItemReference());

		Town result = fixture.getRandomTown();
		assertNotNull(result);
	}

	/**
	 * Run the List<Town> getShortestPathTo(Town) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Test
	public void testGetShortestPathTo_1() throws Exception {
		Town target = new Town("", new MarketPlace(new HashMap()));
		target.setPrevious(new Town("", new MarketPlace(new HashMap())));

		List<Town> result = GameMap.getShortestPathTo(target);
		assertNotNull(result);
	}

	/**
	 * Run the List<Town> getShortestPathTo(Town) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Test
	public void testGetShortestPathTo_2() throws Exception {
		Town target = null;

		List<Town> result = GameMap.getShortestPathTo(target);
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Set<Town> getTownSet() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Test
	public void testGetTownSet() throws Exception {
		GameMap fixture = new GameMap(new GlobalItemReference());
		Set<Town> result = fixture.getTownSet();

		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	@Override
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 11/14/12 10:18 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GameMapTest.class);
	}
}
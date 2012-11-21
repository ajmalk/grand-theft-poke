package edu.gatech.CS2340.GrandTheftPoke.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.Turn;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;
import edu.gatech.CS2340.GrandTheftPoke.files.SaveGame;

/**
 * Tests saving and loading
 * @author Ajmal Kunnummal
 * @version 1.0
 *
 */
public class SaveLoadTest {
	GameMap map1;
	GameMap map2;
	Player player1;
	Player player2;
	Turn turn1, turn2;
	SaveGame game1, game2;
	/**
	 * toString
	 * @return String
	 */
	@Override
	public String toString() {
		return "SaveLoadTest";
	}

	
	/**
	 * Method setUp.
	 */
	@Before
	public void setUp() {
		map1 = new GameMap();
		map2 = new GameMap();
		player1 = new Player("Ajmal", 5,5,5,5,100,100,50,map1);
		player2 = new Player("Ben", 7,3,4,6,200,50,80,map2);
		GlobalItemReference ref1 = new GlobalItemReference();
		GlobalItemReference ref2 = new GlobalItemReference();
		turn1 = new Turn(map1,player1,ref1);
		turn2 = new Turn(map2,player2,ref2);
		game1 = new SaveGame(player1, map1, turn1);
		game2 = new SaveGame(player2, map2, turn2);
	}

	/**
	 * Method saveloadbasic.
	 */
	@Test
	public final void saveloadbasic() {
		GTPoke game1 = makeNewGame("Ajmal", 5, 5, 5, 5), game2 = makeNewGame(
				"Ben", 2, 7, 6, 5);
		assertFalse(game1.equals(game2));
		SaveGame save = new SaveGame(game1.getPlayer(), game1.getMap(), null);
		save.load(game2);
		assertTrue(game1.equals(game2));
	}

	/**
	 * Method saveloadserialized.
	 */
	@Test
	public final void saveloadserialized() {
		GTPoke game1 = makeNewGame("Ajmal", 5, 5, 5, 5), game2 = makeNewGame(
				"Ben", 2, 7, 6, 5);
		String gamestr1 = game1.save(), gamestr2 = game2.save();
		assertFalse(gamestr1.equals(gamestr2));
		game1.load(gamestr2);
		assertTrue(game1.equals(game2));
	}
	
	/**
	 * Run the SaveGame(Player,GameMap,Turn) constructor test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testSaveGame_1()
		throws Exception {
		
		Turn controller = new Turn(new GameMap(), new ArrayList(), new Player());

		SaveGame result = new SaveGame(player, map, controller);

		// add additional test code here
		assertNotNull(result);
		assertEquals("SaveGame [map=GameMap [townSet=[], startTown=null], player=class edu.gatech.CS2340.GrandTheftPoke.backend.persons.PlayerName:null Strength:null Agility:null Trade:null Stamina:null Health:null, controller=Turn [theMap=GameMap [townSet=[], startTown=null], gameActors=[], thePlayer=class edu.gatech.CS2340.GrandTheftPoke.backend.persons.PlayerName:null Strength:null Agility:null Trade:null Stamina:null Health:null, rand=java.util.Random@40c2bfde]]", result.toString());
	}

	/**
	 * Run the GameMap getMap() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetMap_1()
		throws Exception {
		SaveGame fixture = new SaveGame(new Player(), new GameMap(), new Turn(new GameMap(), new ArrayList(), new Player()));

		GameMap result = fixture.getMap();

		// add additional test code here
		assertNotNull(result);
		assertEquals("GameMap [townSet=[], startTown=null]", result.toString());
		assertEquals(null, result.getStartTown());
	}

	/**
	 * Run the Player getPlayer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/20/12 4:42 PM
	 */
	@Test
	public void testGetPlayer_1()
		throws Exception {
		SaveGame fixture = new SaveGame(new Player(), new GameMap(), new Turn(new GameMap(), new ArrayList(), new Player()));

		Player result = fixture.getPlayer();

		// add additional test code here
		assertNotNull(result);
		assertEquals("class edu.gatech.CS2340.GrandTheftPoke.backend.persons.PlayerName:null Strength:null Agility:null Trade:null Stamina:null Health:null", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getCurrent());
		assertEquals(true, result.flee());
		assertEquals(null, result.getAgility());
		assertEquals(null, result.getWallet());
		assertEquals(null, result.getHealth());
		assertEquals(null, result.getBackpack());
		assertEquals(null, result.getTrade());
		assertEquals(null, result.getStamina());
		assertEquals(null, result.getMaxHealth());
		assertEquals(null, result.getStrength());
	}

	/**
	 * Run the boolean load(GTPoke) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/20/12 4:42 PM
	 */
	@Test
	public void testLoad_1()
		throws Exception {
		SaveGame fixture = new SaveGame(new Player(), new GameMap(), new Turn(new GameMap(), new ArrayList(), new Player()));
		GTPoke game = new GTPoke();

		boolean result = fixture.load(game);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/20/12 4:42 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		SaveGame fixture = new SaveGame(new Player(), new GameMap(), new Turn(new GameMap(), new ArrayList(), new Player()));

		String result = fixture.toString();

		// add additional test code here
		assertEquals("SaveGame [map=GameMap [townSet=[], startTown=null], player=class edu.gatech.CS2340.GrandTheftPoke.backend.persons.PlayerName:null Strength:null Agility:null Trade:null Stamina:null Health:null, controller=Turn [theMap=GameMap [townSet=[], startTown=null], gameActors=[], thePlayer=class edu.gatech.CS2340.GrandTheftPoke.backend.persons.PlayerName:null Strength:null Agility:null Trade:null Stamina:null Health:null, rand=java.util.Random@1bd07411]]", result);
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 11/20/12 4:42 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}
}

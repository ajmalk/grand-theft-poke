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
	SaveGame save1, save2;
	GTPoke game1, game2;
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
		GlobalItemReference ref1 = new GlobalItemReference();
		GlobalItemReference ref2 = new GlobalItemReference();
		map1 = new GameMap(ref1);
		map2 = new GameMap(ref2);
		player1 = new Player("Ajmal", 5,5,5,5,100,100,50,map1);
		player2 = new Player("Ben", 7,3,4,6,200,50,80,map2);
		turn1 = new Turn(map1,player1,ref1);
		turn2 = new Turn(map2,player2,ref2);
		save1 = new SaveGame(player1, map1, turn1);
		save2 = new SaveGame(player2, map2, turn2);
		game1 = new GTPoke(map1, player1, turn1);
		game2 = new GTPoke(map2, player2, turn2);
	}

	/**
	 * Method saveloadbasic.
	 */
	@Test
	public final void saveloadbasic() {
		assertFalse(game1.isEqualto(game2));
		save1.load(game2);
		assertTrue(game1.isEqualto(game2));
	}

	/**
	 * Method saveloadserialized.
	 */
	@Test
	public final void saveserialized() {
		String gamestr1 = game1.getSaveStr(), gamestr2 = game2.getSaveStr();
		assertFalse(gamestr1.equals(gamestr2));
		save1.load(game2);
		gamestr2 = game2.getSaveStr();
		assertTrue(gamestr1.equals(gamestr2));
	}
	
	public final void saveloadserialized() {
		String gamestr1 = game1.getSaveStr(), gamestr2 = game2.getSaveStr();
		assertFalse(game1.isEqualto(game2));
		game1.load(gamestr2);
		assertTrue(game1.isEqualto(game2));
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
		assertNotNull(game1.getSaveStr());
		assertNotNull(game1.getSaveStr());
		assertNotNull(game1.getSave());
		assertNotNull(game1.getSave());
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
		boolean result = save1.load(game1);
		assertEquals(true, result);
	}
}

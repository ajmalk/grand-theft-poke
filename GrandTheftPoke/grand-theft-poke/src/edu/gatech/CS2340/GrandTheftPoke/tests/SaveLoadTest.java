package edu.gatech.CS2340.GrandTheftPoke.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.files.SaveGame;

/**
 * Tests saving and loading
 * @author Ajmal Kunnummal
 * @version 1.0
 *
 */
public class SaveLoadTest {

	@Before
	public void setUp() throws Exception {
		return;
	}

	public GTPoke makeNewGame(String name, Integer strength, Integer agility,
			Integer trade, Integer stamina) {
		GTPoke game = new GTPoke();
		game.setPlayerName(name);
		game.createPlayer(strength, agility, trade, stamina);
		return game;
	}

	@Test
	public final void saveloadbasic() {
		GTPoke game1 = makeNewGame("Ajmal", 5, 5, 5, 5), game2 = makeNewGame(
				"Ben", 2, 7, 6, 5);
		assertFalse(game1.equals(game2));
		SaveGame save = new SaveGame(game1.getPlayer(), game1.getMap(), null);
		save.load(game2);
		assertTrue(game1.equals(game2));
	}

	@Test
	public final void saveloadserialized() {
		GTPoke game1 = makeNewGame("Ajmal", 5, 5, 5, 5), game2 = makeNewGame(
				"Ben", 2, 7, 6, 5);
		String gamestr1 = game1.save(), gamestr2 = game2.save();
		assertFalse(gamestr1.equals(gamestr2));
		game1.load(gamestr2);
		assertTrue(game1.equals(game2));
	}
}

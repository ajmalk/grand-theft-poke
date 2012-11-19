package edu.gatech.CS2340.GrandTheftPoke.files;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.Turn;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;

/**
 * The game saving algorithm
 * 
 * @author Team Rocket
 * 
 */
@XStreamAlias("Game")
public class SaveGame {
	@Override
	public String toString() {
		return "SaveGame [map=" + map + ", player=" + player + ", controller="
				+ controller + "]";
	}

	private GameMap map;
	private Player player;
	@XStreamOmitField
	private Turn controller;

	/**
	 * Empty default constructor
	 */
	public SaveGame() {
	}

	/**
	 * @param player
	 *            the player in the game
	 * @param map
	 *            the map for the game
	 * @param controller
	 *            the turn controlling the game
	 */
	public SaveGame(Player player, GameMap map, Turn controller) {
		this.player = player;
		this.map = map;
		this.controller = controller;
	}

	/**
	 * @param game
	 *            the game being played
	 * @return boolean
	 */
	public boolean load(GTPoke game) {
		game.setPlayer(player);
		game.setMap(map);
		game.setController(controller);
		return true;
	}

	/**
	 * @return player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return map
	 */
	public GameMap getMap() {
		return map;
	}
}

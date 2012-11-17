package edu.gatech.CS2340.GrandTheftPoke.files;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.Turn;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;

@XStreamAlias("Game")
public class SaveGame {
	private GameMap map;
	private Player player;
	@XStreamOmitField
	private Turn controller;

	public SaveGame() {
	}

	public SaveGame(Player player, GameMap map, Turn controller) {
		this.player = player;
		this.map = map;
		this.controller = controller;
	}

	public boolean load(GTPoke game) {
		game.setPlayer(player);
		game.setMap(map);
		game.setController(controller);
		return true;
	}

	public Player getPlayer() {
		return player;
	}

	public GameMap getMap() {
		return map;
	}
}

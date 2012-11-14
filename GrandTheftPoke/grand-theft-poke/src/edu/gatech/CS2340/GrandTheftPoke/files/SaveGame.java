package edu.gatech.CS2340.GrandTheftPoke.files;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;

public class SaveGame {
	Player player;
	GameMap map;
	public SaveGame(Player player, GameMap map){
		this.player = player;
		this.map = map;
	}
	public boolean load(GTPoke game){
		game.setPlayer(player);
		game.setMap(map);
		return true;
	}
}

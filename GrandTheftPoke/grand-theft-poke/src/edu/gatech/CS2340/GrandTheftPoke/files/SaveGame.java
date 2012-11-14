package edu.gatech.CS2340.GrandTheftPoke.files;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;

@XStreamAlias("Game")
public class SaveGame {
	Player player;
	@XStreamOmitField
	GameMap map;
	public SaveGame(){}
	public SaveGame(Player player, GameMap map){
		this.player = player;
		this.map = map;
	}
	public boolean load(GTPoke game){
		game.setPlayer(player);
		game.setMap(map);
		return true;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public GameMap getMap(){
		return map;
	}
}

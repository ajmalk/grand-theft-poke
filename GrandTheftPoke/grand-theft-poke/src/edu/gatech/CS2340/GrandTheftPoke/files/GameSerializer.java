package edu.gatech.CS2340.GrandTheftPoke.files;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializer;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.Backpack;
import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;

public class GameSerializer implements Serializer<GTPoke> {
	@Override
	public void write(Json json, GTPoke game, Class knownType) {
		json.setSerializer(Player.class, new PlayerSerializer());
		json.writeValue(game.getPlayer(), knownType);
	}

	@Override
	public GTPoke read(Json json, Object jsonData, Class type) {
		json.setSerializer(Player.class, new PlayerSerializer());
		return new GTPoke(json.readValue(Player.class, jsonData));
	}

	private class PlayerSerializer implements Serializer<Player> {

		@Override
		public void write(Json json, Player player, Class knownType) {
			json.writeValue("Health", player.getHealth());
			json.writeValue(player.getName());
			json.setSerializer(Backpack.class, new BackpackSerializer());
			json.writeValue(player.getBackpack());
		}

		@Override
		public Player read(Json json, Object jsonData, Class type) {
			String name = json.readValue(String.class, jsonData);
			json.setSerializer(Backpack.class, new BackpackSerializer());
			return new Player(name,5,5,5,5,5,5,5,new GameMap());//json.readValue(type, jsonData);
		}
		
		private class BackpackSerializer implements Serializer<Backpack> {

			@Override
			public void write(Json json, Backpack backpack, Class knownType) {
				json.writeValue(backpack.getContents());
				
			}

			@Override
			public Backpack read(Json json, Object jsonData, Class type) {
				return new Backpack(100, 20);
			}
			
		}
	}
}

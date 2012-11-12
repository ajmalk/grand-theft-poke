package edu.gatech.CS2340.GrandTheftPoke.files;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializer;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.Backpack;
import edu.gatech.CS2340.GrandTheftPoke.backend.Player;

public class GameSerializer implements Serializer<GTPoke> {
	@Override
	public void write(Json json, GTPoke game, Class knownType) {
		json.setSerializer(Player.class, new PlayerSerializer());
		json.writeValue("thePlayer", game.getPlayer(), knownType);
	}

	@Override
	public GTPoke read(Json json, Object jsonData, Class type) {
		// TODO Auto-generated method stub
		return null;
	}

	private class PlayerSerializer implements Serializer<Player> {

		@Override
		public void write(Json json, Player player, Class knownType) {
			//json.writeValue("Name", player.getName());
			json.setSerializer(Backpack.class, new BackpackSerializer());
			//json.writeValue("Backpack", player.getBackpack());
		}

		@Override
		public Player read(Json json, Object jsonData, Class type) {
			// TODO Auto-generated method stub
			return null;
		}
		
		private class BackpackSerializer implements Serializer<Backpack> {

			@Override
			public void write(Json json, Backpack backpack, Class knownType) {
				json.writeValue(backpack.getContents());
				
			}

			@Override
			public Backpack read(Json json, Object jsonData, Class type) {
				// TODO Auto-generated method stub
				return null;
			}
			
		}
	}
}

package edu.gatech.CS2340.GrandTheftPoke;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.Player;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.TownFactoryImplementation;
import edu.gatech.CS2340.GrandTheftPoke.files.GameSerializer;
import edu.gatech.CS2340.GrandTheftPoke.screens.*;

public class GTPoke extends Game {
	private String playerName = "";
	private Player thePlayer;
	private GlobalItemReference items;
	private GameMap theMap;
	private static Texture ButtonSprite;
	private static final int INITIAL_RANGE = 80;
	private static final int INITIAL_CARRY = 30;
	private static final int INITIAL_HEALTH = 500;

	@Override
	public void create() {
		items = new GlobalItemReference();
		Pixmap map = new Pixmap(150, 600, Pixmap.Format.RGB565);
		map.setColor(Color.GRAY);
		map.fillRectangle(0, 0, 150, 600);
		map.setColor(Color.BLACK);
		map.fillRectangle(0, 200, 150, 200);
		map.setColor(Color.RED);
		map.fillRectangle(0, 400, 150, 200);
		ButtonSprite = new Texture(map);
		setScreen(getSplashScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		Json save = new Json(OutputType.minimal);
		save.setSerializer(GTPoke.class, new GameSerializer());
		System.out.println(save.toJson(this));
		System.out.println(save);
	}

	@Override
	public void render() {
		super.render();
		
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;

	}

	public void createPlayer(Integer strength, Integer trade, Integer agility,
			Integer stamina) {
		items = new GlobalItemReference();
		theMap = makeMap();
		thePlayer = new Player(playerName, strength, trade, agility, stamina,
				INITIAL_HEALTH, INITIAL_RANGE, INITIAL_CARRY, theMap);
		thePlayer.buy(theMap.getCurrent().getMarket(), items.getHealthPotion(), 1);
		thePlayer.buy(theMap.getCurrent().getMarket(), items.getRepel(), 1);
	}

	public GameMap makeMap() {
		return new GameMap(items);
	}

	public Town getCurrentTown() {
		return theMap.getCurrent();
	}

	public static Texture getButtonSprite() {
		return ButtonSprite;
	}

	public GlobalItemReference getItems() {
		return items;
	}

	public Screen getSplashScreen() {
		return new SplashScreen(this);
	}

	public Screen getMainMenuScreen() {
		return new MainMenu(this);
	}

	public Screen getNameScreen() {
		return new Name(this);
	}

	public Screen getMarketPlaceDemoScreen() {
		return new MarketPlaceItemDemo(this);
	}

	public Screen getMarketScreen() {
		return new Market(this);
	}

	public Screen getSkillPointsScreen() {
		return new SkillPoints(this);
	}

	public Screen getStarterPokemonScreen() {
		return new StarterPokemon(this);
	}
	
	public Screen getCurrentTownScreen() {
		return new PalletTown(this, theMap.getCurrent().getImage());
	}
	
	public Screen getMapScreen() {
		return new MapScreen(this);
	}

	public Player getPlayer() {
		return thePlayer;
	}

	public GameMap getMap() {
		return theMap;
	}
}

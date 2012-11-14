package edu.gatech.CS2340.GrandTheftPoke;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.thoughtworks.xstream.XStream;

import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.Turn;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.*;
import edu.gatech.CS2340.GrandTheftPoke.files.GameConverter;
import edu.gatech.CS2340.GrandTheftPoke.screens.MainMenu;
import edu.gatech.CS2340.GrandTheftPoke.screens.MapScreen;
import edu.gatech.CS2340.GrandTheftPoke.screens.Market;
import edu.gatech.CS2340.GrandTheftPoke.screens.MarketPlaceItemDemo;
import edu.gatech.CS2340.GrandTheftPoke.screens.Name;
import edu.gatech.CS2340.GrandTheftPoke.screens.PalletTown;
import edu.gatech.CS2340.GrandTheftPoke.screens.SkillPoints;
import edu.gatech.CS2340.GrandTheftPoke.screens.SplashScreen;
import edu.gatech.CS2340.GrandTheftPoke.screens.StarterPokemon;

import java.util.ArrayList;

public class GTPoke extends Game {
	private String playerName = "";
	private Player thePlayer;
	private GlobalItemReference items;
	private GameMap theMap;
	private Turn turnController;
	private ArrayList<Person> gameActors;
	private static Texture ButtonSprite;
	private static final int INITIAL_RANGE = 80;
	private static final int INITIAL_CARRY = 30;
	private static final int INITIAL_HEALTH = 500;
	private XStream xstream;
	
	public GTPoke(){
		System.out.println("I'm getting called");
		gameActors = new ArrayList<Person>();
		items = new GlobalItemReference();
		theMap = makeMap();
		gameActors.add(new Trader("Bob Waters", 2, 4, 6, 4, 500, 100, 20, 1000f, theMap));
		gameActors.add(new Trader("Ajmal Kunnummal", 2, 4, 6, 4, 500, 100, 20, 1000f, theMap));
		gameActors.add(new Trader("Drake Stephens", 2, 4, 6, 4, 500, 100, 20, 1000f, theMap));
		gameActors.add(new Trader("Henry Tullis", 2, 4, 6, 4, 500, 100, 20, 1000f, theMap));
		gameActors.add(new Trader("Griffin Asher", 2, 4, 6, 4, 500, 100, 20, 1000f, theMap));
		gameActors.add(new Trader("Your Mother", 2, 4, 6, 4, 500, 100, 20, 1000f, theMap));
		gameActors.add(new Trader("Rival", 2, 4, 6, 4, 500, 100, 20, 1000f, theMap));
		gameActors.add(new Trader("Ajmal's Evil Twin", 2, 4, 6, 4, 500, 100, 20, 1000f, theMap));
		gameActors.add(new Rocket("Ben Nuttle V2", 6, 4, 2, 4, 500, 100, 20, 1000f, theMap));
		gameActors.add(new Rocket("Ho Yin", 6, 4, 2, 4, 500, 100, 20, 1000f, theMap));
		gameActors.add(new Rocket("Jill Cagz", 6, 4, 2, 4, 500, 100, 20, 1000f, theMap));
		gameActors.add(new Rocket("Sagar Laud", 6, 4, 2, 4, 500, 100, 20, 1000f, theMap));
	}
	
	public GTPoke(Player player) {
		
	}

	@Override
	public void create() {
		xstream = new XStream();
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
		xstream.registerConverter(new GameConverter(xstream));
		System.out.println(xstream.toXML(this));
		//Json save = new Json(OutputType.minimal), save2 = new Json(OutputType.minimal);
		//save.setSerializer(GTPoke.class, new GameSerializer());
		//String jsonText = save.toJson(this);
		//System.out.println(jsonText);
		//save.setSerializer(GTPoke.class, new GameSerializer());
		//save.fromJson(GTPoke.class, jsonText);
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

	public void createPlayer(Integer strength, Integer agility, Integer trade,
			Integer stamina) {
		//items = new GlobalItemReference();
		//theMap = makeMap();
		thePlayer = new Player(playerName, strength, agility, trade, stamina,
				INITIAL_HEALTH, INITIAL_RANGE, INITIAL_CARRY, theMap);
		//thePlayer.buy(thePlayer.getCurrent().getMarket(), items.getHealthPotion(), 1);
		//thePlayer.buy(thePlayer.getCurrent().getMarket(), items.getRepel(), 1);
		turnController = new Turn(theMap, gameActors, thePlayer);
	}

	public GameMap makeMap() {
		return new GameMap(items);
	}

	public Town getCurrentTown() {
		return thePlayer.getCurrent();
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
		turnController.takeATurn();
		return new PalletTown(this, thePlayer.getCurrent().getImage());
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
	
	public XStream getSerializer(){
		return xstream;
	}
}

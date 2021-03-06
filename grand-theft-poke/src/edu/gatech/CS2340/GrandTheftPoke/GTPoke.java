/**
 * GTPoke.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.thoughtworks.xstream.XStream;

import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.Turn;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Trader;
import edu.gatech.CS2340.GrandTheftPoke.files.SaveGame;
import edu.gatech.CS2340.GrandTheftPoke.screens.BackpackScreen;
import edu.gatech.CS2340.GrandTheftPoke.screens.Battle;
import edu.gatech.CS2340.GrandTheftPoke.screens.EncounterScreen;
import edu.gatech.CS2340.GrandTheftPoke.screens.GameOverScreen;
import edu.gatech.CS2340.GrandTheftPoke.screens.MainMenu;
import edu.gatech.CS2340.GrandTheftPoke.screens.MapScreen;
import edu.gatech.CS2340.GrandTheftPoke.screens.Market;
import edu.gatech.CS2340.GrandTheftPoke.screens.MarketPlaceItemDemo;
import edu.gatech.CS2340.GrandTheftPoke.screens.Name;
import edu.gatech.CS2340.GrandTheftPoke.screens.SkillPoints;
import edu.gatech.CS2340.GrandTheftPoke.screens.SplashScreen;
import edu.gatech.CS2340.GrandTheftPoke.screens.StarterPokemon;
import edu.gatech.CS2340.GrandTheftPoke.screens.TownScreen;

/**
 * Controls the entire game
 * 
 * @author Team Rocket
 * 
 * @version 1.0
 */
public class GTPoke extends Game {
	/**
	 * Field INITIAL_RANGE. (value is 80)
	 */
	private static final int INITIAL_RANGE = 80;

	/**
	 * Field INITIAL_CARRY. (value is 30)
	 */
	private static final int INITIAL_CARRY = 30;

	/**
	 * Field INITIAL_HEALTH. (value is 100)
	 */
	private static final int INITIAL_HEALTH = 100;

	/**
	 * Field playerName.
	 */
	private String playerName = "";

	/**
	 * Field thePlayer.
	 */
	private Player thePlayer;

	/**
	 * Field items.
	 */
	private GlobalItemReference items;

	/**
	 * Field theMap.
	 */
	private GameMap theMap;

	/**
	 * Field controller.
	 */
	private Turn controller;

	/**
	 * Field atlas.
	 */
	private static TextureAtlas atlas;

	/**
	 * Field xstream.
	 */
	private XStream xstream;

	/**
	 * Field saveFile.
	 */
	private FileHandle saveFile;

	/**
	 * Field statusBar.
	 */
	private Table statusBar;

	/**
	 * Field saveButton.
	 */
	private Button saveButton;

	/**
	 * Field skin.
	 */
	private static Skin skin;

	/**
	 * Field buttonSprite.
	 */
	private static Texture ButtonSprite;

	/**
	 * Field nextScreen.
	 */
	private Screen nextScreen, prevScreen;

	/**
	 * Field healthBar.
	 */
	private AtlasRegion healthBar;

	/**
	 * Constructor for GTPoke.
	 */
	public GTPoke() {
		super();
		// default constructor
	}

	/**
	 * Constructor for GTPoke.
	 * 
	 * @param map
	 *            GameMap
	 * @param player
	 *            Player
	 * @param turn
	 *            Turn
	 */
	public GTPoke(GameMap map, Player player, Turn turn) {
		items = new GlobalItemReference();
		xstream = new XStream();
		this.theMap = map;
		thePlayer = player;
		this.controller = turn;
	}

	/**
	 * Method isEqualto.
	 * 
	 * @param obj
	 *            Object
	 * @return boolean
	 */
	public boolean isEqualto(Object obj) {
		if (this.equals(obj)) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GTPoke)) {
			return false;
		}
		GTPoke other = (GTPoke) obj;
		if (controller == null) {
			if (other.controller != null) {
				return false;
			}
		} else if (!controller.equals(other.controller)) {
			return false;
		}
		if (theMap == null) {
			if (other.theMap != null) {
				return false;
			}
		} else if (!theMap.equals(other.theMap)) {
			return false;
		}
		if (thePlayer == null) {
			if (other.thePlayer != null) {
				return false;
			}
		} else if (!thePlayer.equals(other.thePlayer)) {
			return false;
		}
		return true;
	}

	/**
	 * Method create.
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() {
		items = new GlobalItemReference();
		xstream = new XStream();
		saveFile = Gdx.files.local("saves//savegame.xml");
		atlas = new TextureAtlas(
				Gdx.files.internal("images//textures//packed//gtpoke.atlas"));
		final Pixmap map = new Pixmap(256, 1024, Pixmap.Format.RGB565);
		map.setColor(Color.GRAY);
		map.fillRectangle(0, 0, 256, 1024);
		map.setColor(Color.BLACK);
		map.fillRectangle(0, 200, 256, 200);
		map.setColor(Color.RED);
		map.fillRectangle(0, 400, 256, 200);
		ButtonSprite = new Texture(map);
		statusBar = new Table(skin);

		saveButton = getButton("save");
		saveButton.setPosition(920, 400);
		saveButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				save();
				clear();
				setScreen(getMainMenuScreen());
			}
		});

		theMap = makeMap();

		setScreen(getSplashScreen());
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean update() {
		statusBar.clear();
		statusBar.setSkin(skin);
		statusBar.setBackground(new TextureRegionDrawable(atlas
				.findRegion("status-bar")));
		//statusBar.setSize(678, 64);
		statusBar.pack();
		statusBar.pad(25);
		statusBar.setPosition(
				(int) (Gdx.graphics.getWidth() - statusBar.getWidth()) >> 1, 0);
		final Label health = new Label("Health: "
				+ thePlayer.getHealth().toString(), skin);
		final Label money = new Label("$" + thePlayer.getWallet().getMoney(),
				skin);
		health.setColor(Color.BLUE);
		money.setColor(Color.BLUE);
		// statusBar.add(health).left();
		statusBar.add(money).left().width(168);
		healthBar = atlas.findRegion("health-bar-full");
		// System.out.println(thePlayer.getHealth() + " " +
		// thePlayer.getMaxHealth());
		healthBar.setRegionWidth((int) (healthBar.originalWidth
				/ (float) thePlayer.getMaxHealth() * thePlayer.getHealth()));
		statusBar.add(new Image(healthBar)).expand().left().padLeft(1);
		Label strength = new Label("ST: " + thePlayer.getStrength().toString(), skin);
		Label agility = new Label("AG: " + thePlayer.getAgility().toString(), skin);
		Label trade = new Label("TR: " + thePlayer.getTrade().toString(), skin);
		Label stamina = new Label("SM: " + thePlayer.getStamina().toString(), skin);
		strength.setColor(Color.RED);
		agility.setColor(Color.BLUE);
		trade.setColor(Color.GREEN);
		stamina.setColor(Color.CYAN);
		statusBar.add(strength).width(55);
		statusBar.add(agility).width(55);
		statusBar.add(trade).width(55);
		statusBar.add(stamina).width(55).padRight(-30);
		// statusBar.pack();
		// statusBar.center();
		return true;
	}

	/**
	 * 
	 * @return statusBar
	 */
	public Table getStatusBar() {
		return statusBar;
	}

	/**
	 * 
	 * @return skin
	 */
	public static Skin getSkin() {
		if (skin == null) {
			skin = new Skin(Gdx.files.internal("skins//uiskin.json"));
		}
		return skin;
	}

	/**
	 * 
	 * @return atlas
	 */
	public static TextureAtlas getTextures() {
		return atlas;
	}

	/**
	 * 
	 * @return nextScreen
	 */
	public Screen getNextScreen() {
		return nextScreen;
	}

	/**
	 * 
	 * @return prevScreen
	 */
	public Screen getPrevScreen() {
		return prevScreen;
	}

	/**
	 * initializes variables for new game
	 */
	public void newGame() {
		theMap = makeMap();
		thePlayer = new Player();
		controller = new Turn(theMap, thePlayer, items);
		prevScreen = getMainMenuScreen();
		nextScreen = getNameScreen();
		setScreen(getNameScreen());
	}

	/**
	 * 
	 * @return savestr
	 */
	public String save() {
		final SaveGame save = new SaveGame(thePlayer, theMap, controller);
		final String savestr = xstream.toXML(save);
		saveFile.writeString(savestr, false);
		return savestr;
	}

	/**
	 * @param index
	 *            index to load
	 */
	public void load(int index) {
		final String savestr = saveFile.readString();
		// System.out.println(savestr);
		final SaveGame game = (SaveGame) xstream.fromXML(savestr);
		game.load(this);
		setScreen(getCurrentTownScreenFromEncounter());
	}

	/**
	 * Method getSaveStr.
	 * 
	 * @return String
	 */
	public String getSaveStr() {
		return xstream.toXML(new SaveGame(thePlayer, theMap, controller));
	}

	/**
	 * Method getSave.
	 * 
	 * @return SaveGame
	 */
	public SaveGame getSave() {
		return new SaveGame(thePlayer, theMap, controller);
	}

	/**
	 * @param gamestr
	 *            string used to load game
	 */
	public void load(String gamestr) {
		final SaveGame game = (SaveGame) xstream.fromXML(gamestr);
		game.load(this);
	}

	/**
	 * @param player
	 *            current player
	 */
	public void setPlayer(Player player) {
		thePlayer = player;
	}

	/**
	 * @param map
	 *            the current map
	 */
	public void setMap(GameMap map) {
		theMap = map;
	}

	/**
	 * @param controller
	 *            the turn controller
	 */
	public void setController(Turn controller) {
		this.controller = controller;
	}

	/**
	 * clears the map and player
	 */
	public void clear() {
		theMap = null;
		thePlayer = null;
	}

	/**
	 * @param playerName
	 *            name of player
	 */
	public void setPlayerName(String playerName) {
		thePlayer.setName(playerName);

	}

	/**
	 * @param strength
	 * @param agility
	 * @param trade
	 * @param stamina
	 */
	public void createPlayer(Integer strength, Integer agility, Integer trade,
			Integer stamina) {
		thePlayer = new Player(playerName, strength, agility, trade, stamina,
				INITIAL_HEALTH, INITIAL_RANGE, INITIAL_CARRY, theMap);
		controller = new Turn(theMap, thePlayer, items);
	}

	/**
	 * 
	 * @return map to play on
	 */
	public GameMap makeMap() {
		return new GameMap(items);
	}

	/**
	 * 
	 * @return current town
	 */
	public Town getCurrentTown() {
		return thePlayer.getCurrent();
	}

	/**
	 * 
	 * 
	 * @return buttonSprite
	 */
	public static Texture getButtonSprite() {
		return ButtonSprite;
	}

	/**
	 * 
	 * @return items
	 */
	public GlobalItemReference getItems() {
		return items;
	}

	/**
	 * 
	 * @return returns a splashScreen
	 */
	public Screen getSplashScreen() {
		return new SplashScreen(this);
	}

	/**
	 * 
	 * @return returns a new main menu
	 */
	public Screen getMainMenuScreen() {
		return new MainMenu(this);
	}

	/**
	 * 
	 * @return returns a new starting screen
	 */
	public Screen getNameScreen() {
		return new Name(this);
	}

	/**
	 * 
	 * @return returns a new marketPlace screen
	 */
	public Screen getMarketPlaceDemoScreen() {
		return new MarketPlaceItemDemo(this);
	}

	/**
	 * 
	 * @return returns a new market screen
	 */
	public Screen getMarketScreen() {
		return new Market(this);
	}

	/**
	 * @param theMarket
	 *            the current market
	 * 
	 * @return Market screen
	 */
	public Screen getMarketScreen(MarketPlace theMarket) {
		return new Market(this, theMarket);
	}

	/**
	 * @param theMarket
	 *            the current market
	 * @param other
	 *            the other trader
	 * 
	 * @return the market screen
	 */
	public Screen getMarketScreen(MarketPlace theMarket, Trader other) {
		return new Market(this, theMarket, other);
	}

	/**
	 * 
	 * @return Game Over Screen
	 */
	public Screen getGameOverScreen() {
		return new GameOverScreen(this);
	}

	/**
	 * 
	 * @return Backpack Screen
	 */
	public Screen getBackpackScreen() {
		return new BackpackScreen(this);
	}

	/**
	 * 
	 * 
	 * @return Screen
	 */
	public Screen getSkillPointsScreen() {
		return new SkillPoints(this);
	}

	/**
	 * 
	 * @return a skill points screen
	 */
	public Screen getStarterPokemonScreen() {
		return new StarterPokemon(this);
	}

	/**
	 * @return the current town's screen
	 */
	public Screen getCurrentTownScreen() {
		final Person potentialEncounter = controller.takeATurn();
		if (potentialEncounter != null) {
			return new EncounterScreen(this, potentialEncounter);
		} else if (thePlayer.getHealth() <= 0
				&& thePlayer.getWallet().getMoney() <= 0) {
			return getGameOverScreen();
		}
		return new TownScreen(this, thePlayer.getCurrent().getImage());
	}

	/**
	 * @param button
	 *            string to display on button
	 * 
	 * @return the button that was created
	 */
	public Button getButton(String button) {
		return new Button(new TextureRegionDrawable(atlas.findRegion(button)),
				new TextureRegionDrawable(atlas.findRegion(button + "-down")));
	}

	/**
	 * 
	 * 
	 * @return a back button
	 */
	public Button getBackButton() {
		return getButton("back-button");
	}

	/**
	 * 
	 * @return a save button
	 */
	public Button getSaveButton() {
		return saveButton;
	}

	/**
	 * 
	 * @return current townScreen
	 */
	public Screen getCurrentTownScreenFromEncounter() {
		if (thePlayer.getHealth() <= 0 && thePlayer.getWallet().getMoney() <= 0) {
			return getGameOverScreen();
		}
		return new TownScreen(this, thePlayer.getCurrent().getImage());
	}

	/**
	 * 
	 * @return mapScreen
	 */
	public Screen getMapScreen() {
		return new MapScreen(this);
	}

	/**
	 * 
	 * @return thePlayer
	 */
	public Player getPlayer() {
		return thePlayer;
	}

	/**
	 * 
	 * @return theMap
	 */
	public GameMap getMap() {
		return theMap;
	}

	/**
	 * 
	 * @return xstream
	 */
	public XStream getSerializer() {
		return xstream;
	}

	/**
	 * @param myPerson
	 *            the current person
	 * 
	 * @return a Battle
	 */
	public Screen getBattleScreen(Person myPerson) {
		return new Battle(this, myPerson);
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "GTPoke";
	}
}

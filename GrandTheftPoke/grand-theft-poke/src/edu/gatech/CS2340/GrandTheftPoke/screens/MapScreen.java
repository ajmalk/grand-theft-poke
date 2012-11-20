package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import java.util.Iterator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.GUI.TownTile;
import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;

/**
 * Map Screen
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class MapScreen extends AbstractScreen {
	/**
	 * toString
	 * @return String
	 */
	@Override
	public String toString() {
		return "MapScreen";
	}

	/**
	 * Field background.
	 */
	private Texture background;

	/**
	 * Field backgroundImage.
	 */
	private Image backgroundImage;

	/**
	 * Field theMap.
	 */
	private GameMap theMap;

	/**
	 * Field palletTownButton.
	 */
	private TownTile palletTownButton;

	/**
	 * Field viridianCityButton.
	 */
	private TownTile viridianCityButton;

	/**
	 * Field pewterCityButton.
	 */
	private TownTile pewterCityButton;

	/**
	 * Field ceruleanCityButton.
	 */
	private TownTile ceruleanCityButton;

	/**
	 * Field vermillionCityButton.
	 */
	private TownTile vermillionCityButton;

	/**
	 * Field lavenderTownButton.
	 */
	private TownTile lavenderTownButton;

	/**
	 * Field fuchsiaCityButton.
	 */
	private TownTile fuchsiaCityButton;

	/**
	 * Field saffronCityButton.
	 */
	private TownTile saffronCityButton;

	/**
	 * Field cinnabarIslandButton.
	 */
	private TownTile cinnabarIslandButton;

	/**
	 * Field powerPlantButton.
	 */
	private TownTile powerPlantButton;

	/**
	 * Field celadonCityButton.
	 */
	private TownTile celadonCityButton;

	/**
	 * Field backButton.
	 */
	private Button backButton;

	/**
	 * @param game
	 *            the game being played
	 */
	public MapScreen(GTPoke game) {
		super(game);
	}

	/**
	 * Method show.
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		super.show();

		background = new Texture("images//map.png");

		stage.clear();

		theMap = game.getMap();

		backgroundImage = new Image(background);
		backgroundImage.getColor().a = 0f;
		backgroundImage.addAction(fadeIn(0.75f));

		final Texture townTileSprite = new Texture("images//icons//newball.png");
		final ButtonStyle townTileStyle = new ButtonStyle();
		townTileStyle.up = new TextureRegionDrawable(new TextureRegion(
				townTileSprite, 0, 0, 36, 45));
		townTileStyle.down = new TextureRegionDrawable(new TextureRegion(
				townTileSprite, 0, 46, 36, 45));
		townTileStyle.disabled = new TextureRegionDrawable(new TextureRegion(
				townTileSprite, 0, 91, 36, 45));
		for(final Iterator<Town> i = game.getMap().getTownSet().iterator(); i.hasNext();) {
			Town theTown = i.next();

			if (theTown.toString().equals("Pallet Town")) {
				palletTownButton = new TownTile(theTown, townTileStyle);
			} else if (theTown.toString().equals("Viridian City")) {
				viridianCityButton = new TownTile(theTown, townTileStyle);
			} else if (theTown.toString().equals("Power Plant")) {
				powerPlantButton = new TownTile(theTown, townTileStyle);
			} else if (theTown.toString().equals("Pewter City")) {
				pewterCityButton = new TownTile(theTown, townTileStyle);
			} else if (theTown.toString().equals("Cerulean City")) {
				ceruleanCityButton = new TownTile(theTown, townTileStyle);
			} else if (theTown.toString().equals("Fuchsia City")) {
				fuchsiaCityButton = new TownTile(theTown, townTileStyle);
			} else if (theTown.toString().equals("Cinnabar Island")) {
				cinnabarIslandButton = new TownTile(theTown, townTileStyle);
			} else if (theTown.toString().equals("Saffron City")) {
				saffronCityButton = new TownTile(theTown, townTileStyle);
			} else if (theTown.toString().equals("Vermillion City")) {
				vermillionCityButton = new TownTile(theTown, townTileStyle);
			} else if (theTown.toString().equals("Lavender Town")) {
				lavenderTownButton = new TownTile(theTown, townTileStyle);
			} else if (theTown.toString().equals("Celadon City")) {
				celadonCityButton = new TownTile(theTown, townTileStyle);
			}

			int distance = theMap.dijkstras(game.getPlayer().getCurrent(),
					theTown.toString());
			int range = game.getPlayer().getBackpack().getMaxRange();
			int playerHealth = game.getPlayer().getHealth();

			if (distance > range || playerHealth < distance / 5) {
				if (theTown.toString().equals("Pallet Town")) {
					palletTownButton.setDisabled(true);
					palletTownButton.setTouchable(Touchable.disabled);
				} else if (theTown.toString().equals("Viridian City")) {
					viridianCityButton.setDisabled(true);
					viridianCityButton.setTouchable(Touchable.disabled);
				} else if (theTown.toString().equals("Power Plant")) {
					powerPlantButton.setDisabled(true);
					powerPlantButton.setTouchable(Touchable.disabled);
				} else if (theTown.toString().equals("Pewter City")) {
					pewterCityButton.setDisabled(true);
					pewterCityButton.setTouchable(Touchable.disabled);
				} else if (theTown.toString().equals("Cerulean City")) {
					ceruleanCityButton.setDisabled(true);
					ceruleanCityButton.setTouchable(Touchable.disabled);
				} else if (theTown.toString().equals("Fuchsia City")) {
					fuchsiaCityButton.setDisabled(true);
					fuchsiaCityButton.setTouchable(Touchable.disabled);
				} else if (theTown.toString().equals("Cinnabar Island")) {
					cinnabarIslandButton.setDisabled(true);
					cinnabarIslandButton.setTouchable(Touchable.disabled);
				} else if (theTown.toString().equals("Saffron City")) {
					saffronCityButton.setDisabled(true);
					saffronCityButton.setTouchable(Touchable.disabled);
				} else if (theTown.toString().equals("Vermillion City")) {
					vermillionCityButton.setDisabled(true);
					vermillionCityButton.setTouchable(Touchable.disabled);
				} else if (theTown.toString().equals("Lavender Town")) {
					lavenderTownButton.setDisabled(true);
					lavenderTownButton.setTouchable(Touchable.disabled);
				} else if (theTown.toString().equals("Celadon City")) {
					celadonCityButton.setDisabled(true);
					celadonCityButton.setTouchable(Touchable.disabled);
				}
			}
		}

		final Texture buttonSprite = new Texture("images//button-sprite.png");
		final ButtonStyle style = new ButtonStyle();
		style.up = new TextureRegionDrawable(new TextureRegion(buttonSprite, 0,
				0, 320, 70));
		style.down = new TextureRegionDrawable(new TextureRegion(buttonSprite,
				0, 69, 320, 70));
		style.disabled = new TextureRegionDrawable(new TextureRegion(
				buttonSprite, 0, 69, 320, 70));

		backButton = game.getBackButton();
		backButton.setPosition(20, 15);

		backButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.getCurrentTownScreenFromEncounter());
			}
		});
		// return true;

		viridianCityButton.setStyle(style);
		palletTownButton.setStyle(style);
		powerPlantButton.setStyle(style);
		pewterCityButton.setStyle(style);
		ceruleanCityButton.setStyle(style);
		fuchsiaCityButton.setStyle(style);
		cinnabarIslandButton.setStyle(style);
		saffronCityButton.setStyle(style);
		vermillionCityButton.setStyle(style);
		lavenderTownButton.setStyle(style);
		celadonCityButton.setStyle(style);

		viridianCityButton.setSkin(game.getSkin());
		palletTownButton.setSkin(game.getSkin());
		powerPlantButton.setSkin(game.getSkin());
		pewterCityButton.setSkin(game.getSkin());
		ceruleanCityButton.setSkin(game.getSkin());
		fuchsiaCityButton.setSkin(game.getSkin());
		cinnabarIslandButton.setSkin(game.getSkin());
		saffronCityButton.setSkin(game.getSkin());
		vermillionCityButton.setSkin(game.getSkin());
		lavenderTownButton.setSkin(game.getSkin());
		celadonCityButton.setSkin(game.getSkin());

		viridianCityButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
				// viridianCityButton.setStyle(STYLE WITH PLAYER ON IT);
			}

			private void move(Actor listenerActor) {
				final Town destination = ((TownTile) (listenerActor)).getTown();
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});

		celadonCityButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
				// viridianCityButton.setStyle(STYLE WITH PLAYER ON IT);
			}

			private void move(Actor listenerActor) {
				final Town destination = ((TownTile) (listenerActor)).getTown();
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});

		palletTownButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				final Town destination = ((TownTile) (listenerActor)).getTown();
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});

		powerPlantButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				final Town destination = ((TownTile) (listenerActor)).getTown();
				System.out.println(destination);
				game.getPlayer().move(destination);
			}

		});

		pewterCityButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				final Town destination = ((TownTile) (listenerActor)).getTown();
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});

		ceruleanCityButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				final Town destination = ((TownTile) (listenerActor)).getTown();
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});

		fuchsiaCityButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				final Town destination = ((TownTile) (listenerActor)).getTown();
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});

		cinnabarIslandButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				final Town destination = ((TownTile) (listenerActor)).getTown();
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});

		saffronCityButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				final Town destination = ((TownTile) (listenerActor)).getTown();
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});

		vermillionCityButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				final Town destination = ((TownTile) (listenerActor)).getTown();
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});

		lavenderTownButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				final Town destination = ((TownTile) (listenerActor)).getTown();
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});

		stage.addActor(backgroundImage);

		viridianCityButton.add("Viridian City");
		stage.addActor(viridianCityButton);
		viridianCityButton.setPosition(355, 391);

		palletTownButton.add("Pallet Town");
		stage.addActor(palletTownButton);
		palletTownButton.setPosition(355, 210);

		powerPlantButton.add("Power Plant");
		stage.addActor(powerPlantButton);
		powerPlantButton.setPosition(849, 693);

		pewterCityButton.add("Pewter City");
		stage.addActor(pewterCityButton);
		pewterCityButton.setPosition(375, 607);

		ceruleanCityButton.add("Cerulean City");
		stage.addActor(ceruleanCityButton);
		ceruleanCityButton.setPosition(742, 562);

		saffronCityButton.add("Saffron City");
		stage.addActor(saffronCityButton);
		saffronCityButton.setPosition(730, 418);

		celadonCityButton.add("Celadon City");
		stage.addActor(celadonCityButton);
		celadonCityButton.setPosition(610, 393);

		cinnabarIslandButton.add("Cinnabar Island");
		stage.addActor(cinnabarIslandButton);
		cinnabarIslandButton.setPosition(365, 25);

		vermillionCityButton.add("Vermillion City");
		stage.addActor(vermillionCityButton);
		vermillionCityButton.setPosition(730, 299);

		lavenderTownButton.add("Lavender Town");
		stage.addActor(lavenderTownButton);
		lavenderTownButton.setPosition(898, 408);

		fuchsiaCityButton.add("Fuchsia City");
		stage.addActor(fuchsiaCityButton);
		fuchsiaCityButton.setPosition(602, 122);

		stage.addActor(game.getSaveButton());
		stage.addActor(backButton);

		stage.addActor(game.getStatusBar());
	}

	/**
	 * Method render.
	 * @param delta float
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		super.render(delta);
		game.update();
	}


}
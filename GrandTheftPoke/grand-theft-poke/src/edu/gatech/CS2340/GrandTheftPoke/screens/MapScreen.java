package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.GUI.ItemTile;
import edu.gatech.CS2340.GrandTheftPoke.GUI.TownTile;
import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;

public class MapScreen extends AbstractScreen {

	private Table table;

	private Texture background;
	private Image backgroundImage;
	private Town current;
	private GameMap theMap;

	private TownTile palletTownButton;
	private TownTile viridianCityButton;
	private TownTile pewterCityButton;
	private TownTile ceruleanCityButton;
	private TownTile vermillionCityButton;
	private TownTile lavenderTownButton;
	private TownTile celadonCityButton;
	private TownTile fuchsiaCityButton;
	private TownTile saffronCityButton;
	private TownTile cinnabarIslandButton;
	private TownTile powerPlantButton;

	private HashSet<TownTile> buttonSet;

	public MapScreen(GTPoke game) {
		super(game);
		buttonSet = new HashSet<TownTile>();
		table = new Table(getSkin());
	}

	@Override
	public void show() {
		super.show();
		//table.setFillParent(true);

		//table = new Table(getSkin());
		//table.setFillParent(true);

		background = new Texture("images//map.png");

		stage.clear();
		
		theMap = game.getMap();
		System.out.println(theMap.getCurrent());
		theMap.Dijkstras();

		backgroundImage = new Image(background);
		backgroundImage.getColor().a = 0f;
		backgroundImage.addAction(fadeIn(0.75f));

		Iterator<Town> i = game.getMap().getTownSet().iterator();
		while (i.hasNext()) {
			Town theTown = i.next();

			if (theTown.toString() == "Pallet Town") {
				palletTownButton = new TownTile(theTown);
			} else if (theTown.toString() == "Viridian City") {
				viridianCityButton = new TownTile(theTown);
			} else if (theTown.toString() == "Power Plant") {
				powerPlantButton = new TownTile(theTown);
			} else if (theTown.toString() == "Pewter City") {
				pewterCityButton = new TownTile(theTown);
			} else if (theTown.toString() == "Cerulean City") {
				ceruleanCityButton = new TownTile(theTown);
			} else if (theTown.toString() == "Fuchsia City") {
				fuchsiaCityButton = new TownTile(theTown);
			} else if (theTown.toString() == "Cinnabar Island") {
				cinnabarIslandButton = new TownTile(theTown);
			} else if (theTown.toString() == "Saffron City") {
				saffronCityButton = new TownTile(theTown);
			} else if (theTown.toString() == "Vermillion City") {
				vermillionCityButton = new TownTile(theTown);
			} else {
				lavenderTownButton = new TownTile(theTown);
			}

			int distance = theMap.Dijkstras(theTown.toString());
			int range = game.getPlayer().getBackpack().getMaxRange();

			if (distance > range) {
				//System.out.println("disabling " + theTown);
				//setDisabled(theTown);
			}
		}

		buttonSet.add(celadonCityButton);
		buttonSet.add(palletTownButton);
		buttonSet.add(viridianCityButton);
		buttonSet.add(powerPlantButton);
		buttonSet.add(pewterCityButton);
		buttonSet.add(ceruleanCityButton);
		buttonSet.add(fuchsiaCityButton);
		buttonSet.add(cinnabarIslandButton);
		buttonSet.add(saffronCityButton);
		buttonSet.add(vermillionCityButton);
		buttonSet.add(lavenderTownButton);
		
		table.add(palletTownButton);
		table.add(viridianCityButton);
		table.add(powerPlantButton);
		table.add(pewterCityButton);
		table.add(ceruleanCityButton);
		table.add(fuchsiaCityButton);
		table.add(cinnabarIslandButton);
		table.add(saffronCityButton);
		table.add(vermillionCityButton);
		table.add(lavenderTownButton);

		/*for (Iterator<TownTile> it = buttonSet.iterator(); i.hasNext();) {
			TownTile localButton = it.next();
			System.out.println(localButton);
			localButton.addListener(new ClickListener() {
				public void clicked(InputEvent event, float x, float y) {
					move(event.getListenerActor());
				}

				private void move(Actor listenerActor) {
					Town destination = ((TownTile)(listenerActor)).getTown();
					System.out.println(destination);
					game.getPlayer().move(destination);
				}

			});
		}*/
		Texture ButtonSprite = new Texture("images//button-sprite.png");
		ButtonStyle style = new ButtonStyle();
		style.up = new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0, 0, 320, 70));
		style.down = new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0, 69, 320, 70));
		style.disabled = new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0, 69, 320, 70)); 
		
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
		viridianCityButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});
		
		palletTownButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				System.out.println(destination);
				game.getPlayer().move(destination);
			}

		});
		
		powerPlantButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				System.out.println(destination);
				game.getPlayer().move(destination);
			}

		});
		
		pewterCityButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				System.out.println(destination);
				game.getPlayer().move(destination);
			}

		});
		
		ceruleanCityButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				System.out.println(destination);
				game.getPlayer().move(destination);
			}

		});
		
		fuchsiaCityButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				System.out.println(destination);
				game.getPlayer().move(destination);
			}

		});
		
		cinnabarIslandButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				System.out.println(destination);
				game.getPlayer().move(destination);
			}

		});
		
		saffronCityButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				System.out.println(destination);
				game.getPlayer().move(destination);
			}

		});
		
		vermillionCityButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				System.out.println(destination);
				game.getPlayer().move(destination);
			}

		});
		
		lavenderTownButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				System.out.println(destination);
				game.getPlayer().move(destination);
			}

		});

		stage.addActor(backgroundImage);
		 stage.addActor(viridianCityButton);
		 //stage.addActor(palletTownButton);
		 //stage.addActor(powerPlantButton);
		 //stage.addActor(pewterCityButton);
		 //stage.addActor(ceruleanCityButton);
		 //stage.addActor(saffronCityButton);
		 //stage.addActor(cinnabarIslandButton);
		 //stage.addActor(vermillionCityButton);
		 //stage.addActor(lavenderTownButton);
		 //stage.addActor(fuchsiaCityButton);
		// remVal.setText(remainder.toString());

		// table.debug();
		// table.drawDebug(stage);

	}

	public void setDisabled(Town theTown) {
		for (Iterator<TownTile> i = buttonSet.iterator(); i.hasNext();) {
			TownTile localButton = i.next();
			if (localButton.getTown().toString() == theTown.toString()) {
				localButton.setDisabled(true);
				localButton.setTouchable(Touchable.disabled);
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void dispose() {
		super.dispose();
	}

}

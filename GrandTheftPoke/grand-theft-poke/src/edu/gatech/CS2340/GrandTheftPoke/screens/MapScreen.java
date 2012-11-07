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
	private Button backButton;

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
		theMap.Dijkstras();
		System.out.println(theMap.getCurrent());

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
				setDisabled(theTown);
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
		
		backButton = new Button(style);
		
		backButton.setSkin(getSkin());
		backButton.add("Back");
		backButton.setPosition(10, 10);
		
		backButton.addListener(new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				game.setScreen(game.getCurrentTownScreen());
			}
		});
		
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
		
		viridianCityButton.setSkin(getSkin());
		palletTownButton.setSkin(getSkin());
		powerPlantButton.setSkin(getSkin());
		pewterCityButton.setSkin(getSkin());
		ceruleanCityButton.setSkin(getSkin());
		fuchsiaCityButton.setSkin(getSkin());
		cinnabarIslandButton.setSkin(getSkin());
		saffronCityButton.setSkin(getSkin());
		vermillionCityButton.setSkin(getSkin());
		lavenderTownButton.setSkin(getSkin());
		
		
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
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
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
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});
		
		ceruleanCityButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				game.getPlayer().move(destination);
				game.setScreen(game.getCurrentTownScreen());
			}

		});
		
		fuchsiaCityButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				game.getPlayer().move(destination);
			}

		});
		
		cinnabarIslandButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				game.getPlayer().move(destination);
			}

		});
		
		saffronCityButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				game.getPlayer().move(destination);
			}

		});
		
		vermillionCityButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				game.getPlayer().move(destination);
			}

		});
		
		lavenderTownButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				move(event.getListenerActor());
			}

			private void move(Actor listenerActor) {
				Town destination = ((TownTile)(listenerActor)).getTown();
				game.getPlayer().move(destination);
			}

		});

		stage.addActor(backgroundImage);
		viridianCityButton.add("Viridian City");
		 stage.addActor(viridianCityButton);
		 viridianCityButton.setPosition(334, 391);
		 palletTownButton.add("Pallet Town");
		 stage.addActor(palletTownButton);
		 palletTownButton.setPosition(337, 180);
		 powerPlantButton.add("Power Plant");
		 stage.addActor(powerPlantButton);
		 powerPlantButton.setPosition(849, 693);
		 pewterCityButton.add("Pewter City");
		 stage.addActor(pewterCityButton);
		 pewterCityButton.setPosition(346, 627);
		 ceruleanCityButton.add("Cerulean City");
		 stage.addActor(ceruleanCityButton);
		 ceruleanCityButton.setPosition(732,582);
		 saffronCityButton.add("Saffron City");
		 stage.addActor(saffronCityButton);
		 saffronCityButton.setPosition(720,438);
		 cinnabarIslandButton.add("Cinnabar Island");
		 stage.addActor(cinnabarIslandButton);
		 cinnabarIslandButton.setPosition(334,35);
		 vermillionCityButton.add("Vermillion City");
		 stage.addActor(vermillionCityButton);
		 vermillionCityButton.setPosition(220, 309);
		 lavenderTownButton.add("Lavender Town");
		 stage.addActor(lavenderTownButton);
		 lavenderTownButton.setPosition(888, 418);
		 fuchsiaCityButton.add("Fuchsia City");
		 stage.addActor(fuchsiaCityButton);
		 fuchsiaCityButton.setPosition(582, 132);
		 
		 stage.addActor(backButton);
//remVal.setText(remainder.toString());

		// table.debug();
		// table.drawDebug(stage);

	}

	public void setDisabled(Town toBeDisabled) {
		//Iterator<TownTile> i = buttonSet.iterator();
		for(TownTile localButton : buttonSet) {
			
				//TownTile localButton = i.next();
				//System.out.println(localButton);
				if(localButton.getTown().toString().equals(toBeDisabled.toString())) {
					System.out.println("Disabling" + toBeDisabled);
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

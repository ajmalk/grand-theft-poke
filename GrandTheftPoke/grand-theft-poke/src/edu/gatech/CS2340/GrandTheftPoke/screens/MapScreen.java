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

	private	Table table;
	
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
	
	public MapScreen(GTPoke game){
		super(game);
		buttonSet = new HashSet<TownTile>();
	}
	@Override
	public void show(){
		super.show();
		
		table = new Table(getSkin());
		table.setFillParent(true);
		
		background = new Texture("images//map.png");
		
		stage.clear();
	
		//backgroundImage = new Image(background);
		//backgroundImage.getColor().a = 0f;
		//backgroundImage.addAction(fadeIn(0.75f));
	

				for(Iterator<Town> i =  game.getMap().getTownSet().iterator(); i.hasNext(); ){
					Town theTown = i.next();
					
					if(theTown.toString() == "Pallet Town") {
						palletTownButton = new TownTile(theTown);
					} else if(theTown.toString() == "Viridian City") {
						viridianCityButton = new TownTile(theTown);
					} else if(theTown.toString() == "Power Plant") {
						powerPlantButton = new TownTile(theTown);
					} else if(theTown.toString() == "Pewter City") {
						pewterCityButton = new TownTile(theTown);
					} else if(theTown.toString() == "Cerulean City") {
						ceruleanCityButton = new TownTile(theTown);
					} else if(theTown.toString() == "Fuchsia City") {
						fuchsiaCityButton = new TownTile(theTown);
					} else if(theTown.toString() == "Cinnabar Island") {
						cinnabarIslandButton = new TownTile(theTown);
					} else if(theTown.toString() == "Saffron City") {
						saffronCityButton = new TownTile(theTown);
					} else if(theTown.toString() == "Vermillion City"){
						vermillionCityButton = new TownTile(theTown);
					} else {
						lavenderTownButton = new TownTile(theTown);
					}
					
					int distance = theMap.Dijkstras(theTown.toString());
					int range = game.getPlayer().getBackpack().getMaxRange();
					
					if(distance > range) {
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
		
		
		
		
		//stage.addActor(backgroundImage);
		//stage.addActor(table);

		//remVal.setText(remainder.toString());
		
		//table.debug();
		//table.drawDebug(stage);
		
		
	}
	
	public void setDisabled(Town theTown) {
		for(Iterator<TownTile> i = buttonSet.iterator(); i.hasNext(); ) {
			TownTile localButton = i.next();
			if(localButton.getTown().toString() == theTown.toString()) {
				localButton.setDisabled(true);
				localButton.setTouchable(Touchable.disabled);
			}
		}
	}

	@Override
	public void resize(int width, int height){
		super.resize(width, height);
	}

	@Override
	public void dispose(){
		super.dispose();
	}
	
}


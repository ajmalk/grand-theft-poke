package edu.gatech.CS2340.GrandTheftPoke.screens;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import java.util.Iterator;
import java.util.Map.Entry;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
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
	private Button mapButton;
	private Button pokeCenterButton;
	private Button marketPlaceButton;
	private Button gymLeaderButton;
	
	public MapScreen(GTPoke game){
		super(game);
	}
	@Override
	public void show(){
		super.show();
		
		table = new Table(getSkin());
		table.setFillParent(true);
		
		background = new Texture("images//map.png");
		
		Texture ButtonSprite = new Texture("images//icons//PalletTown.png");
		stage.clear();
	
		backgroundImage = new Image(background);
		//backgroundImage.setFillParent(true);
		backgroundImage.getColor().a = 0f;
		backgroundImage.addAction(fadeIn(0.75f));
	
	
		mapButton = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0, 380, 265, 378)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0, 1154, 265, 378)));
		mapButton.addListener(new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				//game.setScreen(game.getNameScreen());
			}
		});
		pokeCenterButton = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 265, 380, 260, 378)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 265, 1154, 260, 378)));
		pokeCenterButton.addListener(new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				//game.setScreen(game.getNameScreen());
			}
		});
		marketPlaceButton = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 527, 380, 250, 378)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 527, 1154, 250, 378)));
		marketPlaceButton.addListener(new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				//game.setScreen(game.getNameScreen());
			}
		});
		gymLeaderButton = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 775, 380, 258, 378)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 775, 1154, 258, 378)));
		gymLeaderButton.addListener(new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				//game.setScreen(game.getNameScreen());
			}
		});
	
	
	
	}
	@Override
	public void render(float delta){
		super.render(delta);
		
		table.clear();
		table.setPosition(0, -188);
		table.add(mapButton);
		table.add(pokeCenterButton);
		table.add(marketPlaceButton);
		table.add(gymLeaderButton);
		
		for(Iterator<Town> i =  theMap.getTownSet().iterator(); i.hasNext(); ){
			Town toBeChecked = i.next();
			int distance = theMap.Dijkstras(toBeChecked.toString());
		}
		
		
		
		stage.addActor(backgroundImage);
		//stage.addActor(table);

		//remVal.setText(remainder.toString());
		
		//table.debug();
		//table.drawDebug(stage);
		
		
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


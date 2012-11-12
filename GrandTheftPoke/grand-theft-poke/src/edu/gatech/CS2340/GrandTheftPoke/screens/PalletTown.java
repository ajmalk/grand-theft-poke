package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
//import com.badlogic.gdx.scenes.scene2d.ui.Label;
//import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
//import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
//import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;

//check imports



public class PalletTown extends AbstractScreen {

	private	Table table;
	private	Table bp;
	private Texture background;
	private Image backgroundImage;
	private Button mapButton;
	private Button pokeCenterButton;
	private Button marketPlaceButton;
	private Button gymLeaderButton;
	private Button backPackButton;
	private String strTown;
	
	public PalletTown(GTPoke game, String str){
		super(game);
		strTown = str;
	}
	@Override
	public void show(){
		super.show();
		
		table = new Table(getSkin());
		bp = new Table(getSkin());
		
		table.setFillParent(true);
		bp.setFillParent(true);
		
		background = new Texture(strTown);
		
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
			@Override
			public void clicked (InputEvent event, float x, float y) {
				game.setScreen(game.getMapScreen());
			}
		});
		pokeCenterButton = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 265, 380, 260, 378)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 265, 1154, 260, 378)));
		pokeCenterButton.addListener(new ClickListener() {
			@Override
			public void clicked (InputEvent event, float x, float y) {
				//game.setScreen(game.getNameScreen());
			}
		});
		marketPlaceButton = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 527, 380, 250, 378)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 527, 1154, 250, 378)));
		marketPlaceButton.addListener(new ClickListener() {
			@Override
			public void clicked (InputEvent event, float x, float y) {
				game.setScreen(game.getMarketScreen());
			}
		});
		backPackButton = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 25, 267,88, 108)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 25, 1040, 88, 108)));
		backPackButton.addListener(new ClickListener() {
			@Override
			public void clicked (InputEvent event, float x, float y) {
				//game.setScreen(game.getNameScreen());
			}
		});
		gymLeaderButton = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 775, 380, 258, 378)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 775, 1154, 258, 378)));
		gymLeaderButton.addListener(new ClickListener() {
			@Override
			public void clicked (InputEvent event, float x, float y) {
				//game.setScreen(game.getNameScreen());
			}
		});
	
	
	
	}
	@Override
	public void render(float delta){
		super.render(delta);
		
		table.clear();
		bp.clear();
		table.setPosition(0, -188);
		table.add(mapButton);
		table.add(pokeCenterButton);
		table.add(marketPlaceButton);
		table.add(gymLeaderButton);
		
		
		
		stage.addActor(backgroundImage);
		stage.addActor(table);
		
		bp.setPosition(-450, 60);
		bp.add(backPackButton);
		
		
		stage.addActor(bp);
		
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

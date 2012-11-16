package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
//import com.badlogic.gdx.scenes.scene2d.Actor;
//import com.badlogic.gdx.scenes.scene2d.ui.Label;
//import com.badlogic.gdx.scenes.scene2d.ui.Slider;
//import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
//import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

//check imports



public class PalletTown extends AbstractScreen {

	private	Table table;
	private Table healthTable;
	private	Table bp;
	private Texture background;
	private Image backgroundImage;
	private Image healthImage;
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
		healthTable = new Table(getSkin());
		bp = new Table(getSkin());
		
		table.setFillParent(true);
		healthTable.setFillParent(true);
		bp.setFillParent(true);
		
		background = new Texture(strTown);
		
		Texture ButtonSprite = new Texture("images//icons//PalletTown.png");
		Texture BackpackSprite = new Texture("images//icons//backpackIcon.png");
		stage.clear();
	
		backgroundImage = new Image(background);
		healthImage = new Image(new TextureRegionDrawable(new TextureRegion(ButtonSprite, 177, 701, 667, 63)));
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
				new TextureRegionDrawable(new TextureRegion(BackpackSprite, 408, 270,99,117 )),
				new TextureRegionDrawable(new TextureRegion(BackpackSprite, 638, 418, 142, 163)));
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
		
		healthTable.add(healthImage);
		
		
		
		stage.addActor(backgroundImage);
		//stage.addActor(table);
		stage.addActor(healthTable);
		
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

package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

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

public class StarterPokemon extends AbstractScreen {
	private Texture background;
	private Image backgroundImage;
	
	private Button bulbasaur;
	private Button charmander;
	private Button squirtle;
	
	private Texture title;
	
	private	Table table;
	
	public StarterPokemon(GTPoke game){
		super(game);
	}
	@Override
	public void show(){
		super.show();
		
		table = new Table(getSkin());
		table.setFillParent(true);
		
		background = new Texture("images//icons//chooseStarterTitle.png");
		
		Texture ButtonSprite = new Texture("images//icons//starterbuttons.png");
		stage.clear();

		backgroundImage = new Image(background);
		//backgroundImage.setFillParent(true);
		backgroundImage.getColor().a = 0f;
		backgroundImage.setPosition(60, 600);
		backgroundImage.addAction(fadeIn(0.75f));
		


		bulbasaur = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0, 0, 335, 768)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0, 769, 335, 768)));
		bulbasaur.addListener(new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				game.setScreen(game.getNameScreen());
			}
		});
		
		charmander = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 335, 0, 338, 768)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 335, 768, 338, 768)));
		charmander.addListener(new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				//game.setScreen(game.getNameScreen());
			}
		});
		
		squirtle = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 674, 0, 349, 768)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 674, 768, 349, 768)));
		squirtle.addListener(new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				//game.setScreen(game.getNameScreen());
			}
		});
	}
	
	@Override
	public void render(float delta){
		super.render(delta);

		//remVal.setText(remainder.toString());
		
		table.clear();
		
		table.add(bulbasaur);
		table.add(charmander);
		table.add(squirtle);
		
		stage.addActor(table);
		stage.addActor(backgroundImage);
		
		
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
		background.dispose();
	}
}

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



public class PalletTown extends AbstractScreen {

	private	Table table;
	
	private Texture background;
	private Image backgroundImage;
	private Button mapButton;
	
	public PalletTown(GTPoke game){
		super(game);
	}
	@Override
	public void show(){
		super.show();
		
		table = new Table(getSkin());
		table.setFillParent(true);
		
		background = new Texture("images//icons//PalletTown.png");
		
		Texture ButtonSprite = new Texture("images//icons//PalletTown.png");
		stage.clear();
	
		backgroundImage = new Image(background);
		//backgroundImage.setFillParent(true);
		backgroundImage.getColor().a = 0f;
		backgroundImage.addAction(fadeIn(0.75f));
	
	
		mapButton = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0, 510, 258, 380)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0, 510, 258, 380)));
		mapButton.addListener(new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				//game.setScreen(game.getNameScreen());
			}
		});
	
	
	
	}
	@Override
	public void render(float delta){
		super.render(delta);
		
		table.clear();
		table.add(mapButton);
		
		
		stage.addActor(backgroundImage);
		stage.addActor(table);

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

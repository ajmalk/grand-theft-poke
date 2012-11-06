package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;

public class Market extends AbstractScreen {
	private Texture background;
	private Image backgroundImage;
	private	Table table;
	private MarketPlace market;
	private Group
	public Market(GTPoke game){
		super(game);
	}
	
	@Override
	public void show(){
		super.show();
		
		background = new Texture("images//icons//chooseStarterTitle.png");
		backgroundImage = new Image(background);
		backgroundImage.setFillParent(true);
		backgroundImage.getColor().a = 0f;
		backgroundImage.addAction(fadeIn(0.75f));
		
		market = game.getCurrentTown().getMarket();
		
		
	}

	@Override
	public void render(float delta){
		super.render(delta);
		
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

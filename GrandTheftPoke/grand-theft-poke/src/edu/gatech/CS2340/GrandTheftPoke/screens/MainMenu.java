/**
 * MainMenu.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.screens;

//import com.badlogic.gdx.graphics.Color;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
//import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
//import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton.ImageTextButtonStyle;
//same story with imports here

/**
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class MainMenu extends AbstractScreen {
	/**
	 * toString
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "MainMenu";
	}

	/**
	 * Field background.
	 */
	private Image background;

	/**
	 * @param game
	 *            the game being played
	 */
	public MainMenu(GTPoke game) {
		super(game);
	}

	/**
	 * Method show.
	 * 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		super.show();
		final AtlasRegion buttonSprite = GTPoke.getTextures().findRegion(
				"button-sprite");
		stage.clear();

		background = new Image(GTPoke.getTextures().findRegion(
				"intro/main-menu"));
		background.setFillParent(true);
		background.getColor().a = 0f;
		background.addAction(fadeIn(0.75f));
		stage.addActor(background);

		final Button gameButton = new Button(new TextureRegionDrawable(
				new TextureRegion(buttonSprite, 0, 0, 320, 70)),
				new TextureRegionDrawable(new TextureRegion(buttonSprite, 0,
						69, 320, 70)));
		gameButton.setSkin(GTPoke.getSkin());
		gameButton.add("New Game");

		final Button loadButton = new Button(new TextureRegionDrawable(
				new TextureRegion(buttonSprite, 0, 0, 320, 70)),
				new TextureRegionDrawable(new TextureRegion(buttonSprite, 0,
						69, 320, 70)));
		loadButton.setSkin(GTPoke.getSkin());
		loadButton.add("Continue Game");

		gameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.newGame();

			}
		});
		loadButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.load(0);
			}
		});

		final Button debugButton = new Button(new TextureRegionDrawable(
				new TextureRegion(buttonSprite, 0, 0, 320, 70)),
				new TextureRegionDrawable(new TextureRegion(buttonSprite, 0,
						69, 320, 70)));
		debugButton.setSkin(GTPoke.getSkin());
		debugButton.add("Debug Game");

		debugButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new MarketPlaceItemDemo(game));
			}
		});

		final Table table = new Table(GTPoke.getSkin());
		table.setFillParent(true);
		stage.addActor(table);
		table.add(gameButton);
		table.row();
		table.add(loadButton);
		table.row();
		table.add(debugButton);

	}

}

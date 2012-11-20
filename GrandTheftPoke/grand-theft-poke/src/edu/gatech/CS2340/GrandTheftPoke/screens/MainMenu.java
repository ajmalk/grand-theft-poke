package edu.gatech.CS2340.GrandTheftPoke.screens;

//import com.badlogic.gdx.graphics.Color;
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
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		super.show();
		Texture buttonSprite = new Texture("images//button-sprite.png");
		stage.clear();

		// Image backgroundImage = new Image(background);
		background = new Image(game.getTextures().findRegion("intro/main-menu"));
		background.setFillParent(true);
		background.getColor().a = 0f;
		background.addAction(fadeIn(0.75f));
		stage.addActor(background);

		Button gameButton = new Button(new TextureRegionDrawable(
				new TextureRegion(buttonSprite, 0, 0, 320, 70)),
				new TextureRegionDrawable(new TextureRegion(buttonSprite, 0,
						69, 320, 70)));
		gameButton.setSkin(game.getSkin());
		gameButton.add("New Game");

		Button loadButton = new Button(new TextureRegionDrawable(
				new TextureRegion(buttonSprite, 0, 0, 320, 70)),
				new TextureRegionDrawable(new TextureRegion(buttonSprite, 0,
						69, 320, 70)));
		loadButton.setSkin(game.getSkin());
		loadButton.add("Load Game");

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

		Button debugButton = new Button(new TextureRegionDrawable(
				new TextureRegion(buttonSprite, 0, 0, 320, 70)),
				new TextureRegionDrawable(new TextureRegion(buttonSprite, 0,
						69, 320, 70)));
		debugButton.setSkin(game.getSkin());
		debugButton.add("Debug Game");

		debugButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new MarketPlaceItemDemo(game));
			}
		});

		Table table = new Table(game.getSkin());
		table.setFillParent(true);
		stage.addActor(table);
		table.add(gameButton);
		table.row();
		table.add(loadButton);
		table.row();
		table.add(debugButton);

	}

	/**
	 * Method render.
	 * @param delta float
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		super.render(delta);
	}

	/**
	 * Method resize.
	 * @param width int
	 * @param height int
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	/**
	 * Method dispose.
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
	}
}

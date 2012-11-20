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

/**
 * Load/Save feature
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class LoadSave extends AbstractScreen {
	/**
	 * Field background.
	 */
	private Texture background;

	/**
	 * @param game
	 *            the game being played
	 */
	public LoadSave(GTPoke game) {
		super(game);
	}

	/**
	 * Method show.
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		super.show();

		background = new Texture("images//main-menu.png");
		final Texture buttonSprite = new Texture("images//button-sprite.png");
		stage.clear();

		final Image backgroundImage = new Image(background);
		backgroundImage.setFillParent(true);
		backgroundImage.getColor().a = 0f;
		backgroundImage.addAction(fadeIn(0.75f));
		stage.addActor(backgroundImage);

		final Button gameButton = new Button(new TextureRegionDrawable(
				new TextureRegion(buttonSprite, 0, 0, 320, 70)),
				new TextureRegionDrawable(new TextureRegion(buttonSprite, 0,
						69, 320, 70)));
		gameButton.setSkin(game.getSkin());
		gameButton.add("New Game");

		final Button loadButton = new Button(new TextureRegionDrawable(
				new TextureRegion(buttonSprite, 0, 0, 320, 70)),
				new TextureRegionDrawable(new TextureRegion(buttonSprite, 0,
						69, 320, 70)));
		loadButton.setSkin(game.getSkin());
		loadButton.add("Load Game");

		gameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.getNameScreen());
			}
		});
		loadButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.getMarketScreen());
			}
		});

		final Table table = new Table(game.getSkin());
		table.setFillParent(true);
		stage.addActor(table);
		table.add(gameButton);
		table.row();
		table.add(loadButton);

	}

	/**
	 * Method dispose.
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		background.dispose();
	}
}

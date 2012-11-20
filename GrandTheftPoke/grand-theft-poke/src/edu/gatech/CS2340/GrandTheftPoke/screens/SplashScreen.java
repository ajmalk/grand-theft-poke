package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;

//import com.badlogic.gdx.math.Rectangle;

/**
 * The initial splash screen
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class SplashScreen extends AbstractScreen {
	/**
	 * Field splashTexture.
	 */
	private Texture splashTexture;

	/**
	 * @param game
	 *            the game being played
	 */
	public SplashScreen(GTPoke game) {
		super(game);
	}

	/**
	 * Method show.
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		super.show();

		splashTexture = new Texture("images//splash.png");
		stage.clear();
		final Image splashImage = new Image(splashTexture);
		splashImage.setFillParent(true);

		splashImage.getColor().a = 0f;

		splashImage.addAction(sequence(fadeIn(1f), delay(1f), fadeOut(.2f),
				new Action() {
					@Override
					public boolean act(float delta) {
						game.setScreen(game.getMainMenuScreen());
						return true;
					}
				}));

		stage.addActor(splashImage);
		// stage.addActor(new Rectangle(0, 0, 200, 200));
	}

	/**
	 * Method render.
	 * @param delta float
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}

	/**
	 * Method dispose.
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		splashTexture.dispose();
	}
}

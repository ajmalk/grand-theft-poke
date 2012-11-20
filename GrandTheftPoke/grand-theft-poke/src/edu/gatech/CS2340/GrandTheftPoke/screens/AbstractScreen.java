package edu.gatech.CS2340.GrandTheftPoke.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;

/**
 * An Abstract Screen
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public abstract class AbstractScreen implements Screen {
	/**
	 * Field game.
	 */
	protected final GTPoke game;

	/**
	 * Field stage.
	 */
	protected final Stage stage;

	/**
	 * Field batch.
	 */
	private final SpriteBatch batch;

	/**
	 * @param game
	 *            the game being played
	 */
	public AbstractScreen(GTPoke game) {
		this.game = game;
		this.batch = new SpriteBatch();
		this.stage = new Stage(0, 0, true);
		Gdx.input.setInputProcessor(stage);
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
	 * Method resize.
	 * @param width int
	 * @param height int
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
	}

	/**
	 * Method show.
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		return;
	}

	/**
	 * Method hide.
	 * @see com.badlogic.gdx.Screen#hide()
	 */
	@Override
	public void hide() {
		return;
	}

	/**
	 * Method pause.
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override
	public void pause() {
		return;
	}

	/**
	 * Method resume.
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override
	public void resume() {
		return;
	}

	/**
	 * Method dispose.
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {
		stage.dispose();
		batch.dispose();
	}

}

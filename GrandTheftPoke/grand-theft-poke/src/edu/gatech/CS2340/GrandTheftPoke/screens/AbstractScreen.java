package edu.gatech.CS2340.GrandTheftPoke.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;

public abstract class AbstractScreen implements Screen {
	protected final GTPoke game;
	protected final Stage stage;
	private final SpriteBatch batch;
	protected Skin skin;

	public AbstractScreen(GTPoke game) {
		this.game = game;
		this.batch = new SpriteBatch();
		this.stage = new Stage(0, 0, true);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		stage.dispose();
		batch.dispose();
	}

	protected Skin getSkin() {
		if (skin == null) {
			skin = new Skin(Gdx.files.internal("skins//uiskin.json"));
		}
		return skin;
	}
}

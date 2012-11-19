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
 * @author Team Rocket
 *
 */
public class LoadSave extends AbstractScreen {
	private Texture background;

	/**
	 * @param game the game being played
	 */
	public LoadSave(GTPoke game) {
		super(game);
	}


	@Override
	public void show() {
		super.show();

		background = new Texture("images//main-menu.png");
		Texture ButtonSprite = new Texture("images//button-sprite.png");
		stage.clear();

		Image backgroundImage = new Image(background);
		backgroundImage.setFillParent(true);
		backgroundImage.getColor().a = 0f;
		backgroundImage.addAction(fadeIn(0.75f));
		stage.addActor(backgroundImage);

		Button GameButton = new Button(new TextureRegionDrawable(
				new TextureRegion(ButtonSprite, 0, 0, 320, 70)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0,
						69, 320, 70)));
		GameButton.setSkin(game.getSkin());
		GameButton.add("New Game");

		Button LoadButton = new Button(new TextureRegionDrawable(
				new TextureRegion(ButtonSprite, 0, 0, 320, 70)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0,
						69, 320, 70)));
		LoadButton.setSkin(game.getSkin());
		LoadButton.add("Load Game");

		GameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.getNameScreen());
			}
		});
		LoadButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.getMarketScreen());
			}
		});

		Table table = new Table(game.getSkin());
		table.setFillParent(true);
		stage.addActor(table);
		table.add(GameButton);
		table.row();
		table.add(LoadButton);

	}


	@Override
	public void render(float delta) {
		super.render(delta);
	}


	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}


	@Override
	public void dispose() {
		super.dispose();
		background.dispose();
	}
}
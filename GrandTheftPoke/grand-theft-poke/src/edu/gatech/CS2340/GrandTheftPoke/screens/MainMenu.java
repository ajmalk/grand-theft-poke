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
import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
//import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
//import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton.ImageTextButtonStyle;
//same story with imports here
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;

/**
 * @author Team Rocket
 *
 */
public class MainMenu extends AbstractScreen {
	private Image background;

	/**
	 * @param game the game being played
	 */
	public MainMenu(GTPoke game) {
		super(game);
	}

	@Override
	public void show() {
		super.show();
		Texture ButtonSprite = new Texture("images//button-sprite.png");
		stage.clear();

		//Image backgroundImage = new Image(background);
		background = new Image(game.getTextures().findRegion("intro/main-menu"));
		background.setFillParent(true);
		background.getColor().a = 0f;
		background.addAction(fadeIn(0.75f));
		stage.addActor(background);

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
				game.newGame();
				
			}
		});
		LoadButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.load(0);
			}
		});
		
		Button DebugButton = new Button(new TextureRegionDrawable(
				new TextureRegion(ButtonSprite, 0, 0, 320, 70)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0,
						69, 320, 70)));
		DebugButton.setSkin(game.getSkin());
		DebugButton.add("Debug Game");

		DebugButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new MarketPlaceItemDemo(game));
			}
		});
		
		
		Table table = new Table(game.getSkin());
		table.setFillParent(true);
		stage.addActor(table);
		table.add(GameButton);
		table.row();
		table.add(LoadButton);
		table.row();
		table.add(DebugButton);

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
	}
}

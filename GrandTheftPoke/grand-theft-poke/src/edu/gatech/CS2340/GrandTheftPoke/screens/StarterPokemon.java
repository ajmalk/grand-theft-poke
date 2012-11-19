package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;

/**
 * Starter screen
 * @author Team Rocket
 *
 */
public class StarterPokemon extends AbstractScreen {
	private Image title;
	private Button bulbasaur;
	private Button charmander;
	private Button squirtle;
	private Button ConfirmButton;
	private int confirmX = 356;
	private int confirmY = 10;
	private Table table;

	/**
	 * @param game the game being played
	 */
	public StarterPokemon(GTPoke game) {
		super(game);
	}


	@Override
	public void show() {
		super.show();

		table = new Table();
		table.setFillParent(true);

		title = new Image(game.getTextures().findRegion("intro/starter-title"));
		title.getColor().a = 0f;
		title.setPosition(60, 600);
		title.addAction(fadeIn(0.75f));

		bulbasaur = new Button(new TextureRegionDrawable(game.getTextures().findRegion("intro/starter-1"))
				, new TextureRegionDrawable(game.getTextures().findRegion("intro/starter-1-down")));
		
		bulbasaur.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// game.setScreen(game.getNameScreen());
				confirmX = 25;
				ConfirmButton.setDisabled(false);
				ConfirmButton.setTouchable(Touchable.enabled);
			}
		});

		charmander = new Button(new TextureRegionDrawable(game.getTextures().findRegion("intro/starter-2"))
		, new TextureRegionDrawable(game.getTextures().findRegion("intro/starter-2-down")));
		charmander.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// game.setScreen(game.getNameScreen());
				confirmX = 356;
				ConfirmButton.setDisabled(false);
				ConfirmButton.setTouchable(Touchable.enabled);
			}
		});

		squirtle = new Button(new TextureRegionDrawable(game.getTextures().findRegion("intro/starter-3"))
		, new TextureRegionDrawable(game.getTextures().findRegion("intro/starter-3-down")));
		squirtle.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// game.setScreen(game.getNameScreen());
				confirmX = 675;
				ConfirmButton.setDisabled(false);
				ConfirmButton.setTouchable(Touchable.enabled);
			}
		});

		Texture confirmButtonSprite = new Texture("images//button-sprite.png");
		ButtonStyle style = new ButtonStyle();
		style.up = new TextureRegionDrawable(new TextureRegion(
				confirmButtonSprite, 0, 0, 320, 70));
		style.down = new TextureRegionDrawable(new TextureRegion(
				confirmButtonSprite, 0, 69, 320, 70));
		style.disabled = new TextureRegionDrawable(new TextureRegion(
				confirmButtonSprite, 0, 69, 320, 70));

		ConfirmButton = new Button(style);
		ConfirmButton.setSkin(game.getSkin());
		ConfirmButton.add("Confirm");
		ConfirmButton.setPosition(confirmX, confirmY);
		ConfirmButton.setDisabled(true);
		ConfirmButton.setTouchable(Touchable.disabled);

		ConfirmButton.setStyle(style);

		ConfirmButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.getCurrentTownScreenFromEncounter());
			}
		});
	}


	@Override
	public void render(float delta) {
		super.render(delta);

		table.clear();

		table.add(bulbasaur);
		table.add(charmander);
		table.add(squirtle);

		stage.addActor(table);
		stage.addActor(title);
		ConfirmButton.setPosition(confirmX, confirmY);
		stage.addActor(ConfirmButton);
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

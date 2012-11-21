/**
 * StarterPokemon.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
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
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Pokemon;

/**
 * Starter screen
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class StarterPokemon extends AbstractScreen {

	/**
	 * toString
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "StarterPokemon";
	}

	/**
	 * Field starter.
	 */
	private Pokemon starter;

	/**
	 * Field title.
	 */
	private Image title;

	/**
	 * Field bulbasaur.
	 */
	private Button bulbasaur;

	/**
	 * Field charmander.
	 */
	private Button charmander;

	/**
	 * Field squirtle.
	 */
	private Button squirtle;

	/**
	 * Field ConfirmButton.
	 */
	private Button confirmButton;

	/**
	 * Field confirmX.
	 */
	private int confirmX = 356;

	/**
	 * Field confirmY.
	 */
	private static final int COMFIRMY = 10;

	/**
	 * Field table.
	 */
	private Table table;

	/**
	 * @param game
	 *            the game being played
	 */
	public StarterPokemon(GTPoke game) {
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

		table = new Table();
		table.setFillParent(true);

		title = new Image(GTPoke.getTextures()
				.findRegion("intro/starter-title"));
		title.getColor().a = 0f;
		title.setPosition(60, 600);
		title.addAction(fadeIn(0.75f));

		bulbasaur = new Button(new TextureRegionDrawable(GTPoke.getTextures()
				.findRegion("intro/starter-1")), new TextureRegionDrawable(
				GTPoke.getTextures().findRegion("intro/starter-1-down")));

		bulbasaur.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				starter = (Pokemon) game.getItems().getBulbasaur();
				confirmX = 25;
				confirmButton.setDisabled(false);
				confirmButton.setTouchable(Touchable.enabled);
			}
		});

		charmander = new Button(new TextureRegionDrawable(GTPoke.getTextures()
				.findRegion("intro/starter-2")), new TextureRegionDrawable(
				GTPoke.getTextures().findRegion("intro/starter-2-down")));
		charmander.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				starter = (Pokemon) game.getItems().getCharmander();
				confirmX = 356;
				confirmButton.setDisabled(false);
				confirmButton.setTouchable(Touchable.enabled);
			}
		});

		squirtle = new Button(new TextureRegionDrawable(GTPoke.getTextures()
				.findRegion("intro/starter-3")), new TextureRegionDrawable(
				GTPoke.getTextures().findRegion("intro/starter-3-down")));
		squirtle.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				starter = (Pokemon) game.getItems().getSquirtle();
				confirmX = 675;
				confirmButton.setDisabled(false);
				confirmButton.setTouchable(Touchable.enabled);
			}
		});

		final AtlasRegion buttonSprite = GTPoke.getTextures().findRegion(
				"button-sprite");
		final ButtonStyle style = new ButtonStyle();
		style.up = new TextureRegionDrawable(new TextureRegion(buttonSprite, 0,
				0, 320, 70));
		style.down = new TextureRegionDrawable(new TextureRegion(buttonSprite,
				0, 69, 320, 70));
		style.disabled = new TextureRegionDrawable(new TextureRegion(
				buttonSprite, 0, 69, 320, 70));

		confirmButton = new Button(style);
		confirmButton.setSkin(GTPoke.getSkin());
		confirmButton.add("Confirm");
		confirmButton.setPosition(confirmX, COMFIRMY);
		confirmButton.setDisabled(true);
		confirmButton.setTouchable(Touchable.disabled);

		confirmButton.setStyle(style);

		confirmButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.getPlayer().getBackpack().place(starter, 1);
				starter.use(game.getPlayer());
				System.out.println(game.getPlayer());
				game.setScreen(game.getCurrentTownScreenFromEncounter());
			}
		});
	}

	/**
	 * Method render.
	 * 
	 * @param delta
	 *            float
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		super.render(delta);

		table.clear();

		table.add(bulbasaur);
		table.add(charmander);
		table.add(squirtle);

		stage.addActor(table);
		stage.addActor(title);
		confirmButton.setPosition(confirmX, COMFIRMY);
		stage.addActor(confirmButton);
	}

}

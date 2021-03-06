/**
 * Name.java
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
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;

/**
 * Initial input screen
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Name extends AbstractScreen {
	/**
	 * toString
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Name";
	}

	/**
	 * Field background.
	 */
	private Image background;

	/**
	 * Field ConfirmButton.
	 */
	private Button confirmButton;

	/**
	 * Field myName.
	 */
	private TextField myName;

	/**
	 * Field playerName.
	 */
	private String playerName = "";

	/**
	 * Field table.
	 */
	private Table table;

	/**
	 * @param game
	 *            the game being played
	 */
	public Name(GTPoke game) {
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
		// stage.clear();
		table = new Table(GTPoke.getSkin());
		table.setFillParent(true);

		background = new Image(GTPoke.getTextures().findRegion(
				"intro/main-menu"));

		final AtlasRegion buttonSprite = GTPoke.getTextures().findRegion(
				"button-sprite");

		background.setFillParent(true);
		background.getColor().a = 0f;
		background.addAction(fadeIn(0.75f));
		stage.addActor(background);

		myName = new TextField("", GTPoke.getSkin());
		myName.setTextFieldListener(new TextFieldListener() {
			@Override
			public void keyTyped(TextField name, char key) {
				if (!(key == 14 || key == 15 || key == 0)) {

					if (key == '\b' && playerName.length() != 0) {
						if (playerName.length() == 1) {
							playerName = "";
						} else {
							playerName = playerName.substring(0,
									playerName.length() - 1);
						}
					} else if (key != '\b' && key != 13) {
						playerName += key;
					}

					if (checkName(playerName)) {
						confirmButton.setDisabled(false);
						confirmButton.setTouchable(Touchable.enabled);
					} else {
						confirmButton.setDisabled(true);
						confirmButton.setTouchable(Touchable.disabled);
					}

					if (key == 13 && checkName(playerName)) {
						game.setPlayerName(playerName);
						game.setScreen(game.getSkillPointsScreen());
					}
				}
			}
		});

		final ButtonStyle style = new ButtonStyle();
		style.up = new TextureRegionDrawable(new TextureRegion(buttonSprite, 0,
				0, 320, 70));
		style.down = new TextureRegionDrawable(new TextureRegion(buttonSprite,
				0, 69, 320, 70));
		style.disabled = new TextureRegionDrawable(new TextureRegion(
				buttonSprite, 0, 69, 320, 70));

		confirmButton = new Button(style);
		confirmButton.setDisabled(true);
		confirmButton.setTouchable(Touchable.disabled);

		confirmButton.setSkin(GTPoke.getSkin());
		confirmButton.add("Confirm");
		confirmButton.setPosition(700, 10);

		confirmButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setPlayerName(playerName);
				game.setScreen(game.getSkillPointsScreen());
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

		table.add("Name:").width(100);
		table.add(myName);
		table.row();

		stage.addActor(table);
		stage.addActor(confirmButton);

	}

	/**
	 * Method checkName.
	 * 
	 * @param name
	 *            String
	 * @return boolean
	 */
	private boolean checkName(String name) {
		for (int index = 0; index < name.length(); index++) {
			if ((name.charAt(index) < 32)
					|| (name.charAt(index) > 32 && name.charAt(index) < 48)
					|| (name.charAt(index) > 57 && name.charAt(index) < 65)
					|| (name.charAt(index) > 90 && name.charAt(index) < 97)
					|| (name.charAt(index) > 122)) {
				return false;
			}
		}

		if (name.length() < 1) {
			return false;
		}
		return true;
	}
}

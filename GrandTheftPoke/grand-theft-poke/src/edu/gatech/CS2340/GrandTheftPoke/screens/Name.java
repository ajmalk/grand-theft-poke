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
	private Image background;
	private Button ConfirmButton;
	private TextField myName;
	private String playerName = "";
	private Table table;

	/**
	 * @param game
	 *            the game being played
	 */
	public Name(GTPoke game) {
		super(game);
	}

	@Override
	public void show() {
		super.show();
		// stage.clear();
		table = new Table(game.getSkin());
		table.setFillParent(true);

		background = new Image(game.getTextures().findRegion("intro/main-menu"));

		Texture ButtonSprite = new Texture("images//button-sprite.png");

		background.setFillParent(true);
		background.getColor().a = 0f;
		background.addAction(fadeIn(0.75f));
		stage.addActor(background);

		myName = new TextField("", game.getSkin());
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
						ConfirmButton.setDisabled(false);
						ConfirmButton.setTouchable(Touchable.enabled);
					} else {
						ConfirmButton.setDisabled(true);
						ConfirmButton.setTouchable(Touchable.disabled);
					}

					if (key == 13 && checkName(playerName)) {
						game.setPlayerName(playerName);
						game.setScreen(game.getSkillPointsScreen());
					}
				}
			}
		});

		ButtonStyle style = new ButtonStyle();
		style.up = new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0,
				0, 320, 70));
		style.down = new TextureRegionDrawable(new TextureRegion(ButtonSprite,
				0, 69, 320, 70));
		style.disabled = new TextureRegionDrawable(new TextureRegion(
				ButtonSprite, 0, 69, 320, 70));

		ConfirmButton = new Button(style);
		ConfirmButton.setDisabled(true);
		ConfirmButton.setTouchable(Touchable.disabled);

		ConfirmButton.setSkin(game.getSkin());
		ConfirmButton.add("Confirm");
		ConfirmButton.setPosition(700, 10);

		ConfirmButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setPlayerName(playerName);
				game.setScreen(game.getSkillPointsScreen());
			}
		});

	}

	@Override
	public void render(float delta) {
		super.render(delta);

		table.clear();

		table.add("Name:").width(100);
		table.add(myName);
		table.row();

		stage.addActor(table);
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

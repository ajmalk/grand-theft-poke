package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;

public class Name extends AbstractScreen {
	private Texture background;

	private Button ConfirmButton;

	TextField name;
	private String playerName = "";

	private Table table;

	public Name(GTPoke game) {
		super(game);
	}

	@Override
	public void show() {
		super.show();

		table = new Table(getSkin());
		table.setFillParent(true);

		background = new Texture("images//main-menu.png");

		Texture ButtonSprite = new Texture("images//button-sprite.png");
		stage.clear();

		Image backgroundImage = new Image(background);
		backgroundImage.setFillParent(true);
		backgroundImage.getColor().a = 0f;
		backgroundImage.addAction(fadeIn(0.75f));
		stage.addActor(backgroundImage);

		name = new TextField("", getSkin());
		name.setTextFieldListener(new TextFieldListener() {
			@Override
			public void keyTyped(TextField name, char key) {
				if (!(key == 14 || key == 15 || key == 0)) {

					if (key == '\b' && playerName.length() != 0) {
						if (playerName.length() == 1) {
							playerName = "";
						}
						else {
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

		ConfirmButton.setSkin(getSkin());
		ConfirmButton.add("Confirm");
		ConfirmButton.setPosition(700, 10);

		ConfirmButton.addListener(new ClickListener() {
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
		table.add(name);
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
		background.dispose();
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

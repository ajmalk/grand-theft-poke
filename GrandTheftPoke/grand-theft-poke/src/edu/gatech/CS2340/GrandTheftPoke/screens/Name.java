package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.Main;

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
				System.out.print(key);
				if(key == '\b' && playerName.length() != 0) {
					playerName = playerName.substring(0, playerName.length()- 1);
				}
				else if(key != '\b'){
					playerName += key;
				}
				
				if (playerName.length() != 0) {
					ConfirmButton.setDisabled(false);
					ConfirmButton.setTouchable(Touchable.enabled);
				}
				else {
					ConfirmButton.setDisabled(true);
					ConfirmButton.setTouchable(Touchable.disabled);
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
		// ConfirmButton.setDisabled(true);
		// ConfirmButton.setTouchable(Touchable.disabled);

		ConfirmButton.setStyle(style);

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

		// remVal.setText(remainder.toString());

		table.clear();

		table.add("Name:").width(100);
		table.add(name);
		table.row();

		stage.addActor(table);
		stage.addActor(ConfirmButton);
		// table.debug();
		// table.drawDebug(stage);

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

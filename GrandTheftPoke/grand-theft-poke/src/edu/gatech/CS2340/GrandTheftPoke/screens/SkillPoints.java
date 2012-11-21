/**
 * SkillPoints.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.screens;

//package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;

//import com.badlogic.gdx.scenes.scene2d.ui.Window;

/**
 * The skill point allocation screen
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class SkillPoints extends AbstractScreen {
	/**
	 * toString
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "SkillPoints";
	}

	/**
	 * Field background.
	 */
	private AtlasRegion background;

	/**
	 * Field max.
	 */
	/**
	 * Field stamina.
	 */
	/**
	 * Field trade.
	 */
	/**
	 * Field agility.
	 */
	/**
	 * Field strength.
	 */
	/**
	 * Field remainder.
	 */
	private Integer remainder, strength, agility, trade, stamina, max;

	/**
	 * Field remVal.
	 */
	/**
	 * Field staminaVal.
	 */
	/**
	 * Field tradeVal.
	 */
	/**
	 * Field agilityVal.
	 */
	/**
	 * Field strengthVal.
	 */
	private Label strengthVal, agilityVal, tradeVal, staminaVal, remVal;

	/**
	 * Field tradeSlider.
	 */
	/**
	 * Field agilitySlider.
	 */
	/**
	 * Field staminaSlider.
	 */
	/**
	 * Field strengthSlider.
	 */
	private Slider strengthSlider, staminaSlider, agilitySlider, tradeSlider;

	/**
	 * Field ConfirmButton.
	 */
	private Button confirmButton;

	/**
	 * Field table.
	 */
	private Table table;

	/**
	 * @param game
	 *            the game being played
	 */
	public SkillPoints(GTPoke game) {
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
		table = new Table(GTPoke.getSkin());
		table.setFillParent(true);
		strength = 0;
		stamina = 0;
		agility = 0;
		trade = 0;

		remainder = 20;
		max = 20;
		strengthVal = new Label(strength.toString(), GTPoke.getSkin());
		agilityVal = new Label(agility.toString(), GTPoke.getSkin());
		tradeVal = new Label(agility.toString(), GTPoke.getSkin());
		staminaVal = new Label(agility.toString(), GTPoke.getSkin());
		remVal = new Label(agility.toString(), GTPoke.getSkin());
		background = GTPoke.getTextures().findRegion("skillpoint");

		final AtlasRegion buttonSprite = GTPoke.getTextures().findRegion(
				"button-sprite");
		stage.clear();

		final Image backgroundImage = new Image(background);
		backgroundImage.setFillParent(true);
		backgroundImage.getColor().a = 0f;
		backgroundImage.addAction(fadeIn(0.75f));
		stage.addActor(backgroundImage);

		strengthSlider = new Slider(0, 10, 1, false, GTPoke.getSkin());
		staminaSlider = new Slider(0, 10, 1, false, GTPoke.getSkin());
		agilitySlider = new Slider(0, 10, 1, false, GTPoke.getSkin());
		tradeSlider = new Slider(0, 10, 1, false, GTPoke.getSkin());

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
		confirmButton.setPosition(700, 10);
		confirmButton.setDisabled(true);
		confirmButton.setTouchable(Touchable.disabled);

		confirmButton.setStyle(style);

		confirmButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.createPlayer(strength, agility, trade, stamina);
				game.setScreen(game.getStarterPokemonScreen());
			}
		});

		remVal.setText(remainder.toString());

		strengthSlider.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				strength = (int) ((Slider) actor).getValue();
				updateRemainder((Slider) actor, strength);
				strengthVal.setText(strength.toString());
			}
		});

		staminaSlider.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				stamina = (int) ((Slider) actor).getValue();
				updateRemainder((Slider) actor, stamina);
				staminaVal.setText(stamina.toString());
			}
		});

		agilitySlider.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				agility = (int) ((Slider) actor).getValue();
				updateRemainder((Slider) actor, agility);
				agilityVal.setText(agility.toString());
			}
		});

		tradeSlider.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				trade = (int) ((Slider) actor).getValue();
				updateRemainder((Slider) actor, trade);
				tradeVal.setText(trade.toString());
			}
		});

		// nameWindow = new Window("Enter Your Name: ", skin);
		// name = new TextField("", getSkin());
		// nameWindow.add(name);

	}

	/**
	 * Method updateRemainder.
	 * 
	 * @param slider
	 *            Slider
	 * @param value
	 *            Integer
	 */
	private void updateRemainder(Slider slider, Integer value) {
		confirmButton.setDisabled(true);
		confirmButton.setTouchable(Touchable.disabled);
		remainder = max - strength - stamina - agility - trade;
		remVal.setText(remainder.toString());
		if (remainder <= 0) {
			value += remainder;
			confirmButton.setDisabled(false);
			confirmButton.setTouchable(Touchable.enabled);
		}
		slider.setValue(value);
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

		// remVal.setText(remainder.toString());

		trade = (int) tradeSlider.getValue();
		tradeVal.setText(trade.toString());

		table.clear();

		table.defaults().height(115);
		table.columnDefaults(0).width(40);
		table.columnDefaults(1).width(500).spaceLeft(250).top().height(30);
		table.setPosition(130, 35);
		table.bottom().left();
		table.add(remVal);
		table.row();
		table.add(strengthVal);
		table.add(strengthSlider).height(30).top();
		table.row();
		table.add(agilityVal);
		table.add(agilitySlider);
		table.row();
		table.add(tradeVal);
		table.add(tradeSlider);
		table.row();
		table.add(staminaVal);
		table.add(staminaSlider);

		// table.debug();
		// table.drawDebug(stage);

		stage.addActor(table);
		// stage.addActor(nameWindow);

		// stage.addActor(table);
		stage.addActor(confirmButton);

	}

	/**
	 * Method dispose.
	 * 
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
	}
}

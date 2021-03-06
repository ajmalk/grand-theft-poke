/**
 * Battle.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * Battle class
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Battle extends AbstractScreen {

	/**
	 * the game
	 */
	private final GTPoke myGame;

	/**
	 * the background
	 */
	private AtlasRegion background;

	/**
	 * the backgroundImage
	 */
	private Image backgroundImage;

	/**
	 * myPerson
	 */
	private final Person myPerson;
	
	private AtlasRegion healthBar;

	/**
	 * rand
	 */
	private final Random rand;

	/**
	 * attack button
	 */
	private Button attack;

	/**
	 * flee button
	 */
	private Button flee;

	/**
	 * turnCount
	 */
	private int turnCount;

	/**
	 * table
	 */
	private Table table;
	
	private Table statusBar;

	/**
	 * @param game
	 *            the game being played
	 * @param opponent
	 *            the opponent
	 */
	public Battle(GTPoke game, Person opponent) {
		super(game);
		this.myGame = game;
		myPerson = opponent;
		rand = new Random();
		turnCount = 1;
	}

	/**
	 * toString method
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Battle";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.gatech.CS2340.GrandTheftPoke.screens.AbstractScreen#show()
	 */
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
		
		statusBar = new Table(GTPoke.getSkin());

		final AtlasRegion buttonSprite = GTPoke.getTextures().findRegion(
				"button-sprite");

		background = GTPoke.getTextures().findRegion("battle");

		// Texture ButtonSprite = new Texture("images//icons//encounter.png");
		stage.clear();

		backgroundImage = new Image(background);
		backgroundImage.getColor().a = 0f;
		backgroundImage.setPosition(0, 0);
		backgroundImage.addAction(fadeIn(0.75f));

		flee = new Button(new TextureRegionDrawable(new TextureRegion(
				buttonSprite, 480, 586, 179, 44)), new TextureRegionDrawable(
				new TextureRegion(buttonSprite, 480, 585, 179, 44)));
		flee.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(myGame.getPlayer().getHealth() <= 0) {
					myGame.getPlayer().setHealth(
							-1 * myGame.getPlayer().getHealth());
					myPerson.win(myGame.getPlayer());
					myGame.setScreen(myGame.getCurrentTownScreenFromEncounter());
				}
				if (myGame.getPlayer().flee(myPerson)) {
					myGame.setScreen(myGame.getCurrentTownScreenFromEncounter());
				}
			}
		});

		attack = new Button(new TextureRegionDrawable(new TextureRegion(
				buttonSprite, 480, 512, 179, 44)), new TextureRegionDrawable(
				new TextureRegion(buttonSprite, 480, 511, 179, 44)));
		attack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

				final int speed = myGame.getPlayer().getAgility();
				final int otherSpeed = myPerson.getAgility();
				final int damage = myGame.getPlayer().attack(turnCount);
				final int otherDamage = myPerson.attack(turnCount);

				if (speed > otherSpeed) {
					myPerson.defend(damage);
					myGame.getPlayer().defend(otherDamage);
				} else if (speed < otherSpeed) {
					myGame.getPlayer().defend(otherDamage);
					myPerson.defend(damage);
				} else if (rand.nextBoolean()) {
					myPerson.defend(damage);
					myGame.getPlayer().defend(otherDamage);

				} else {
					myGame.getPlayer().defend(otherDamage);
					myPerson.defend(damage);
				}
				turnCount++;
				if (myPerson.getHealth() <= 0) {
					myPerson.setHealth(-1 * myPerson.getHealth());
					myGame.getPlayer().win(myPerson);
					myGame.setScreen(myGame.getCurrentTownScreenFromEncounter());
					return;
				}
				if (myGame.getPlayer().getHealth() <= 0) {
					myGame.getPlayer().setHealth(
							-1 * myGame.getPlayer().getHealth());
					myPerson.win(myGame.getPlayer());
					myGame.setScreen(myGame.getCurrentTownScreenFromEncounter());
					return;
				}
			}
		});

		stage.addActor(backgroundImage);
		flee.setPosition(480, 138);
		stage.addActor(flee);

		attack.setPosition(480, 212);
		stage.addActor(attack);
		stage.addActor(myGame.getStatusBar());
		//statusBar.pack();
		//statusBar.setPosition((int) (Gdx.graphics.getWidth() - statusBar.getWidth()) >> 1, 700);
		stage.addActor(statusBar);

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
		myGame.update();
		update();
	}
	
	public boolean update() {
		statusBar.clear();
		statusBar.setSkin(GTPoke.getSkin());
		statusBar.setBackground(new TextureRegionDrawable(GTPoke.getTextures()
				.findRegion("status-bar")));
		//statusBar.setSize(678, 64);
		statusBar.pack();
		statusBar.setPosition((int) (Gdx.graphics.getWidth() - statusBar.getWidth()) >> 1, 700);

		statusBar.pad(25);
		final Label health = new Label("Health: "
				+ myPerson.getHealth().toString(), GTPoke.getSkin());
		final Label money = new Label("$" + myPerson.getWallet().getMoney(),
				GTPoke.getSkin());
		health.setColor(Color.BLUE);
		money.setColor(Color.BLUE);
		statusBar.add(money).left().width(168);
		healthBar = GTPoke.getTextures().findRegion("health-bar-full");
		TextureRegion temp = new TextureRegion(healthBar, 0, 0, (int) (healthBar.originalWidth
				/ (float) myPerson.getMaxHealth() * myPerson.getHealth()), healthBar.getRegionHeight());
		statusBar.add(new Image(temp)).expand().left().padLeft(1);
		Label strength = new Label("ST: " + myPerson.getStrength().toString(), GTPoke.getSkin());
		Label agility = new Label("AG: " + myPerson.getAgility().toString(), GTPoke.getSkin());
		Label trade = new Label("TR: " + myPerson.getTrade().toString(), GTPoke.getSkin());
		Label stamina = new Label("SM: " + myPerson.getStamina().toString(), GTPoke.getSkin());
		strength.setColor(Color.RED);
		agility.setColor(Color.BLUE);
		trade.setColor(Color.GREEN);
		stamina.setColor(Color.CYAN);
		statusBar.add(strength).width(55);
		statusBar.add(agility).width(55);
		statusBar.add(trade).width(55);
		statusBar.add(stamina).width(55).padRight(-30);
		return true;
	}
}

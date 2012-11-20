package edu.gatech.CS2340.GrandTheftPoke.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.GymLeader;

/**
 * Town/Navigation screen
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class TownScreen extends AbstractScreen {

	private Table table;
	private Table healthTable;
	private Table bp;
	private Image townImage;
	private Image healthImage;
	private Button mapButton;
	private Button pokeCenterButton;
	private Button marketPlaceButton;
	private Button gymLeaderButton;
	private Button backPackButton;
	private String town;

	/**
	 * @param game
	 *            the game being played
	 * @param town
	 *            the town one is in
	 */
	public TownScreen(GTPoke game, String town) {
		super(game);
		this.town = town;
	}

	@Override
	public void show() {
		super.show();

		table = new Table(game.getSkin());
		healthTable = new Table(game.getSkin());
		bp = new Table(game.getSkin());

		table.setFillParent(true);
		healthTable.setFillParent(true);
		bp.setFillParent(true);

		townImage = new Image(game.getTextures().findRegion("town/" + town));

		Texture ButtonSprite = new Texture("images//icons//PalletTown.png");
		Texture BackpackSprite = new Texture("images//icons//backpackIcon.png");
		stage.clear();

		healthImage = new Image(new TextureRegionDrawable(new TextureRegion(
				ButtonSprite, 183, 707, 667, 63)));

		mapButton = game.getButton("town/map");

		mapButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.getMapScreen());
			}
		});
		pokeCenterButton = game.getButton("town/pokecenter");
		pokeCenterButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// game.setScreen(game.getNameScreen());
				// System.out.println("health is: "+game.getPlayer().getHealth());
				// System.out.println("money is: "+game.getPlayer().getWallet().getMoney());
				if (game.getPlayer().getHealth() != game.getPlayer()
						.getMaxHealth()
						&& game.getPlayer().getWallet().getMoney() >= 300) {
					game.getPlayer().setHealth(
							game.getPlayer().getMaxHealth()
									- game.getPlayer().getHealth());
					game.getPlayer().getWallet().updateMoney(-300);
				}
				// System.out.println("health is now: "+game.getPlayer().getHealth());
				// System.out.println("money is now: "+game.getPlayer().getWallet().getMoney());

			}
		});
		marketPlaceButton = game.getButton("town/marketplace");
		marketPlaceButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.getMarketScreen());
			}
		});
		backPackButton = game.getButton("town/backpack");
		backPackButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// game.setScreen(game.getNameScreen());
			}
		});
		gymLeaderButton = game.getButton("town/gymleader");
		gymLeaderButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.getBattleScreen(new GymLeader("Brock", 8,
						8, 0, 8, 200, 0, 0, 1000f, game.getMap())));
			}
		});

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		game.update();
		table.clear();
		bp.clear();
		healthTable.clear();
		table.add(townImage).colspan(4);
		table.row();
		table.add(mapButton);
		table.add(pokeCenterButton);
		table.add(marketPlaceButton);
		table.add(gymLeaderButton);

		// healthTable.setPosition(0, -350);
		// healthTable.add(healthImage);

		// stage.addActor(backgroundImage);
		stage.addActor(table);

		bp.setPosition(-450, 60);
		bp.add(backPackButton);

		stage.addActor(bp);
		stage.addActor(game.getStatusBar());
		// game.getStatusBar().debug().drawDebug(stage);
		// remVal.setText(remainder.toString());

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
	}
}

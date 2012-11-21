/**
 * Market.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.GUI.ItemTile;
import edu.gatech.CS2340.GrandTheftPoke.backend.Backpack;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Pokemon;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable;

/**
 * The Market
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class BackpackScreen extends AbstractScreen {
	/**
	 * toString
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Market";
	}

	/**
	 * Field myMarket.
	 */
	private MarketPlace myMarket;

	/**
	 * Field playerPack.
	 */
	private Backpack playerPack;

	/**
	 * Field markettable.
	 */
	private Table backpacktable, table;

	/**
	 * Field marketItemGroup.
	 */
	private ButtonGroup marketItemGroup;

	/**
	 * Field marketStock.
	 */
	private ScrollPane backpackStock;

	/**
	 * Field backButton.
	 */
	private Button backButton;

	/**
	 * Field backpack.
	 */
	private Map<Item, ItemTile> backpack;

	/**
	 * Field background.
	 */
	private Image background;

	/**
	 * Field confirmButton.
	 */
	private Button confirmButton;

	/**
	 * @param game
	 *            the game being played
	 * @param market
	 *            the market being traded within
	 */
	public BackpackScreen(GTPoke game) {
		super(game);
		background = new Image(GTPoke.getTextures().findRegion("backpackUI"));
		background.setFillParent(true);
		background.getColor().a = 0f;
		background.addAction(fadeIn(0.75f));
		playerPack = game.getPlayer().getBackpack();
		table = new Table();
		// markettable = new Table();
		backpacktable = new Table();
		marketItemGroup = new ButtonGroup();
		// marketStock = new ScrollPane(markettable);
		backpackStock = new ScrollPane(backpacktable);
		backpack = new HashMap<Item, ItemTile>();
		// marketplace = new HashMap<Item, ItemTile>();
		myMarket = game.getCurrentTown().getMarket();
	}

	/**
	 * Method show.
	 * 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		stage.addActor(background);

		updatetables();

		addItems();

		marketItemGroup.setMaxCheckCount(1);
		marketItemGroup.setMinCheckCount(1);

		backpacktable.top().left();

		backpackStock.setScrollingDisabled(true, false);

		/*
		 * description = new ItemDescTile( ((ItemTile)
		 * marketItemGroup.getChecked()).getItem(), ((ItemTile)
		 * (marketItemGroup.getChecked())).getStockInfo(), game.getPlayer(),
		 * myMarket, (Market)game.getMarketScreen(), (ItemTile)
		 * marketItemGroup.getChecked(), otherTrader);
		 */

		final AtlasRegion buttonSprite = GTPoke.getTextures().findRegion(
				"button-sprite");
		final ButtonStyle style = new ButtonStyle();
		style.up = new TextureRegionDrawable(new TextureRegion(buttonSprite, 0,
				0, 320, 70));
		style.down = new TextureRegionDrawable(new TextureRegion(buttonSprite,
				0, 69, 320, 70));
		style.disabled = new TextureRegionDrawable(new TextureRegion(
				buttonSprite, 0, 69, 320, 70));
		backButton = game.getBackButton();
		backButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.getCurrentTownScreenFromEncounter());
			}
		});

		table.add(backpackStock).top();
		table.left().setPosition(33, 90);

		confirmButton = new Button(style);
		confirmButton.setSkin(GTPoke.getSkin());
		confirmButton.add("Confirm");
		confirmButton.setPosition(685, 75);
		// confirmButton.setDisabled(true);
		// confirmButton.setTouchable(Touchable.disabled);

		confirmButton.setStyle(style);

		confirmButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ItemTile currentChecked = (ItemTile) marketItemGroup
						.getChecked();
				if (currentChecked.getItem() instanceof Usable
						&& (!((Usable) currentChecked.getItem() instanceof Pokemon))) {
					((Usable) currentChecked.getItem()).use(game.getPlayer());
					game.getPlayer().getBackpack()
							.remove(currentChecked.getItem(), 1);
				}
			}
		});
	}

	/**
	 * adds items to the market
	 */
	public void addItems() {
		int col = 2;
		backpacktable.clear();

		for (final Iterator<java.util.Map.Entry<Item, ItemTile>> i = backpack
				.entrySet().iterator(); i.hasNext();) {
			final Entry<Item, ItemTile> item = i.next();
			if (item.getValue().getStock() != null) {
				backpacktable.add(item.getValue()).top();
				marketItemGroup.add(item.getValue());
				if (col++ % 6 == 1) {
					backpacktable.row();
				}
			}
		}
	}

	/**
	 * updates items in the market
	 */
	private void updatetables() {
		for (final Iterator<java.util.Map.Entry<Item, Integer>> i = playerPack
				.getContents().entrySet().iterator(); i.hasNext();) {
			final java.util.Map.Entry<Item, Integer> item = i.next();
			ItemTile tile = new ItemTile(myMarket, item.getKey(),
					item.getValue(), playerPack);
			backpack.put(item.getKey(), tile);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.gatech.CS2340.GrandTheftPoke.screens.AbstractScreen#render(float)
	 */
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
		game.update();

		for (final Iterator<Entry<Item, ItemTile>> iter = backpack.entrySet()
				.iterator(); iter.hasNext();) {
			Entry<Item, ItemTile> item = iter.next();
			item.getValue().update();
			addItems();
		}

		backButton.setPosition(20, 15);
		table.top();
		table.setSize(907, 440);
		table.setPosition(55, 117);
		stage.addActor(table);
		stage.addActor(game.getStatusBar());
		stage.addActor(backButton);
		stage.addActor(confirmButton);

		// backpacktable.setSize(500, 500);
		// backpacktable.pack();
		// backpacktable.debug().drawDebug(stage);
		// backpackStock.setSize(937, 440);
		// table.debug().drawDebug(stage);
	}
}

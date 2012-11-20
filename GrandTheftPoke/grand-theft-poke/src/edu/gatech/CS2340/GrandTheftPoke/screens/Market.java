package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.graphics.Texture;
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
import edu.gatech.CS2340.GrandTheftPoke.GUI.ItemDescTile;
import edu.gatech.CS2340.GrandTheftPoke.GUI.ItemTile;
import edu.gatech.CS2340.GrandTheftPoke.backend.Backpack;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Trader;

/**
 * The Market
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Market extends AbstractScreen {
	private MarketPlace myMarket;
	private Backpack playerPack;
	private Table markettable, backpacktable, table;
	private ButtonGroup marketItemGroup;
	private ScrollPane marketStock, backpackStock;
	private ItemDescTile description;
	private Button backButton;
	private Map<Item, ItemTile> backpack, marketplace;
	private Image background;
	private Trader otherTrader;

	/**
	 * @param game
	 *            the game being played
	 * @param market
	 *            the market being traded within
	 */
	public Market(GTPoke game, MarketPlace market) {
		super(game);
		background = new Image(game.getTextures().findRegion("market-place"));
		background.setFillParent(true);
		background.getColor().a = 0f;
		background.addAction(fadeIn(0.75f));
		this.myMarket = market;
		playerPack = game.getPlayer().getBackpack();
		table = new Table();
		markettable = new Table();
		backpacktable = new Table();
		marketItemGroup = new ButtonGroup();
		marketStock = new ScrollPane(markettable);
		backpackStock = new ScrollPane(backpacktable);
		backpack = new HashMap<Item, ItemTile>();
		marketplace = new HashMap<Item, ItemTile>();
	}

	/**
	 * @param game
	 *            the game being played
	 */
	public Market(GTPoke game) {
		this(game, game.getCurrentTown().getMarket());
	}

	/**
	 * @param game
	 *            the game being played
	 * @param market
	 *            the market being traded in
	 * @param other
	 *            the other trader
	 */
	public Market(GTPoke game, MarketPlace market, Trader other) {
		super(game);
		background = new Image(game.getTextures().findRegion("trade-screen"));
		background.setFillParent(true);
		background.getColor().a = 0f;
		background.addAction(fadeIn(0.75f));
		this.myMarket = market;
		playerPack = game.getPlayer().getBackpack();
		table = new Table();
		markettable = new Table();
		backpacktable = new Table();
		marketItemGroup = new ButtonGroup();
		marketStock = new ScrollPane(markettable);
		backpackStock = new ScrollPane(backpacktable);
		backpack = new HashMap<Item, ItemTile>();
		marketplace = new HashMap<Item, ItemTile>();
		otherTrader = other;
	}

	@Override
	public void show() {
		// background = new
		// Image(game.getTextures().findRegion("market-place"));
		// background.setFillParent(true);
		// background.getColor().a = 0f;
		// background.addAction(fadeIn(0.75f));
		stage.addActor(background);

		updatetables();

		addItems();

		marketItemGroup.setMaxCheckCount(1);
		marketItemGroup.setMinCheckCount(1);

		markettable.top().left();
		backpacktable.top().left();

		marketStock.setScrollingDisabled(true, false);
		backpackStock.setScrollingDisabled(true, false);

		backpackStock.setWidth(backpacktable.getWidth());
		backpackStock.setHeight(stage.getHeight() - 200);
		marketStock.setWidth(markettable.getWidth());
		marketStock.setHeight(stage.getHeight() - 200);

		description = new ItemDescTile(
				((ItemTile) marketItemGroup.getChecked()).getItem(),
				((ItemTile) (marketItemGroup.getChecked())).getStockInfo(),
				game.getPlayer(), myMarket, this,
				(ItemTile) marketItemGroup.getChecked(), otherTrader);

		Texture ButtonSprite = new Texture("images//button-sprite.png");
		ButtonStyle style = new ButtonStyle();
		style.up = new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0,
				0, 320, 70));
		style.down = new TextureRegionDrawable(new TextureRegion(ButtonSprite,
				0, 69, 320, 70));
		style.disabled = new TextureRegionDrawable(new TextureRegion(
				ButtonSprite, 0, 69, 320, 70));
		backButton = game.getBackButton();
		backButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.getCurrentTownScreenFromEncounter());
			}
		});

		table.add(marketStock).top().width(300);
		table.add(backpackStock).top().padLeft(25).width(300);
		table.add(description).padLeft(33).width(300);
		table.left().setPosition(33, 90);
	}

	/**
	 * adds items to the market
	 */
	public void addItems() {
		int col = 0;
		markettable.clear();
		marketItemGroup = new ButtonGroup();
		for (Iterator<Map.Entry<Item, ItemTile>> i = marketplace.entrySet()
				.iterator(); i.hasNext();) {
			final Map.Entry<Item, ItemTile> item = i.next();
			if (item.getValue().getStock() != 0) {
				markettable.add(item.getValue());
				marketItemGroup.add(item.getValue());
				if (col++ % 2 == 1) {
					markettable.row();
				}
			}
		}

		col = 0;
		backpacktable.clear();

		for (Iterator<java.util.Map.Entry<Item, ItemTile>> i = backpack
				.entrySet().iterator(); i.hasNext();) {
			final Entry<Item, ItemTile> item = i.next();
			if (item.getValue().getStock() != null) {
				backpacktable.add(item.getValue());
				marketItemGroup.add(item.getValue());
				if (col++ % 2 == 1) {
					backpacktable.row();
				}
			}
		}
	}

	/**
	 * updates items in the market
	 */
	private void updatetables() {
		for (Iterator<Map.Entry<Item, MarketPlaceItem>> i = myMarket.iterator(); i
				.hasNext();) {
			final Map.Entry<Item, MarketPlaceItem> item = i.next();
			final ItemTile markettile = new ItemTile(item.getKey(),
					item.getValue());
			Integer pack = playerPack.getContents().get(item.getKey());
			ItemTile backpacktile;
			backpacktile = new ItemTile(myMarket, item.getKey(), pack,
					playerPack);
			marketplace.put(item.getKey(), markettile);
		}
		for (Iterator<java.util.Map.Entry<Item, Integer>> i = playerPack
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
	@Override
	public void render(float delta) {
		super.render(delta);
		game.update();
		for (Iterator<Entry<Item, ItemTile>> iter = marketplace.entrySet()
				.iterator(); iter.hasNext();) {
			Entry<Item, ItemTile> item = iter.next();
			item.getValue().update();
			if (playerPack.getContents().containsKey(item.getKey())
					&& !backpack.containsKey(item.getKey())) {
				backpack.put(item.getKey(),
						new ItemTile(myMarket, item.getKey(), playerPack
								.getContents().get(item.getKey()), playerPack));
				addItems();
			}
			if (item.getValue().getStock() == 0) {
				iter.remove();
				addItems();
			}
		}

		for (Iterator<Entry<Item, ItemTile>> iter = backpack.entrySet()
				.iterator(); iter.hasNext();) {
			Entry<Item, ItemTile> item = iter.next();
			item.getValue().update();
			if (((MarketPlaceItem) myMarket.getStock().get(item.getKey()))
					.getStock() != 0 && !marketplace.containsKey(item.getKey())) {
				marketplace.put(item.getKey(), new ItemTile(item.getKey(), item
						.getValue().getStockInfo()));
				addItems();
			}
			if (item.getValue().getStock() == null) {
				iter.remove();
				addItems();
			}
		}
		backButton.setPosition(20, 15);
		description.update(((ItemTile) marketItemGroup.getChecked()),
				game.getPlayer());
		table.setSize(1024, 525);
		stage.addActor(table);
		stage.addActor(game.getStatusBar());
		stage.addActor(backButton);
	}
}

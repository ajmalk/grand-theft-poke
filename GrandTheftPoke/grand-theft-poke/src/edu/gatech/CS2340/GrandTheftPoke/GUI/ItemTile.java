/**
 * ItemTile.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.Backpack;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;

/**
 * an item tile
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class ItemTile extends Button {
	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "ItemTile [item=" + item + ", stock=" + stock
				+ ", backpackStock=" + backpackStock + ", icon=" + icon
				+ ", stockLabel=" + stockLabel + ", price=" + price + ", pack="
				+ pack + "]";
	}

	/**
	 * Field item.
	 */
	private final Item item;

	/**
	 * Field stock.
	 */
	private MarketPlaceItem stock;

	/**
	 * Field backpackStock.
	 */
	private final Integer backpackStock;

	/**
	 * Field icon.
	 */
	private final Image icon;

	/**
	 * Field price.
	 */
	/**
	 * Field stockLabel.
	 */
	private final Label stockLabel, price;

	/**
	 * Field pack.
	 */
	private Backpack pack;

	/**
	
	 * @return item */
	public Item getItem() {
		return item;
	}

	// private Table tile;
	/**
	 * @param item
	 *            the item to put in the tile
	 * @param stock
	 *            the stock of the item in the marketplace
	 */
	public ItemTile(Item item, MarketPlaceItem stock) {
		super(new TextureRegionDrawable(new TextureRegion(
				GTPoke.getButtonSprite(), 0, 0, 150, 175)),
				new TextureRegionDrawable(new TextureRegion(
						GTPoke.getButtonSprite(), 0, 200, 150, 175)),
				new TextureRegionDrawable(new TextureRegion(
						GTPoke.getButtonSprite(), 0, 400, 150, 175)));
		this.item = item;
		this.stock = stock;
		final Pixmap map = new Pixmap(50, 50, Pixmap.Format.RGB565);
		map.setColor(Color.BLUE);
		map.fillRectangle(0, 0, 50, 50);
		backpackStock = -1;
		stockLabel = new Label("", new Skin(
				Gdx.files.internal("skins//uiskin.json")));
		price = new Label("",
				new Skin(Gdx.files.internal("skins//uiskin.json")));
		icon = new Image(new Texture(map));
		setSkin(new Skin(Gdx.files.internal("skins//uiskin.json")));

		add(stockLabel).right();
		row();
		add(icon).expandX();
		row();
		final Label name = new Label(item.toString(), new Skin(
				Gdx.files.internal("skins//uiskin.json")));
		name.setWrap(true);
		name.setAlignment(Align.center);
		add(name).width(130).padTop(5);
		row();
		add(price).expandY().bottom();
		pad(10);
		top();
		update();
	}

	/**
	 * @param theMarket
	 *            the current market
	 * @param item
	 *            the item being referred to
	 * @param stock
	 *            the stock of the item
	 * @param pack
	 *            the player's backpack
	 */
	public ItemTile(MarketPlace theMarket, Item item, Integer stock,
			Backpack pack) {
		super(new TextureRegionDrawable(new TextureRegion(
				GTPoke.getButtonSprite(), 0, 0, 150, 170)),
				new TextureRegionDrawable(new TextureRegion(
						GTPoke.getButtonSprite(), 0, 200, 150, 170)),
				new TextureRegionDrawable(new TextureRegion(
						GTPoke.getButtonSprite(), 0, 400, 150, 170)));
		this.item = item;
		if (theMarket.getStock().containsKey(item)) {
			this.stock = (MarketPlaceItem) theMarket.getStock().get(item);
		} else {
			this.stock = new MarketPlaceItem((float) stock, 1000f);
		}
		backpackStock = stock;
		this.pack = pack;
		final Pixmap map = new Pixmap(50, 50, Pixmap.Format.RGB565);
		stockLabel = new Label("", new Skin(
				Gdx.files.internal("skins//uiskin.json")));
		price = new Label("",
				new Skin(Gdx.files.internal("skins//uiskin.json")));
		map.setColor(Color.RED);
		map.fillRectangle(0, 0, 50, 50);
		icon = new Image(new Texture(map));
		setSkin(new Skin(Gdx.files.internal("skins//uiskin.json")));

		add(stockLabel).right();
		row();
		add(icon).expandX();
		row();
		final Label name = new Label(item.toString(), new Skin(
				Gdx.files.internal("skins//uiskin.json")));
		name.setWrap(true);
		name.setAlignment(Align.center);
		add(name).width(130).padTop(5);
		row();
		add(price).expandY().bottom();
		pad(10);
		top();
		update();
	}

	/**
	
	 * @return stock */
	public MarketPlaceItem getStockInfo() {
		return stock;
	}

	/**
	
	 * @return boolean */
	public boolean isMarketItem() {
		return backpackStock == -1;
	}

	/**
	
	 * @return stock of item */
	public Integer getStock() {
		if (backpackStock != null && backpackStock == -1) {
			return stock.getStock();
		}
		return pack.getContents().get(item);
	}

	/**
	*/
	public void update() {
		if (backpackStock != null && backpackStock == -1) {
			stockLabel.setText(stock.getStock().toString());
			price.setText("$" + ((Float) (1.1f * stock.getPrice())).toString());
		} else if (pack.getContents().get(item) != null) {
			stockLabel.setText(pack.getContents().get(item).toString());
			price.setText("$" + ((Float) (0.9f * stock.getPrice())).toString());
		}
	}
}

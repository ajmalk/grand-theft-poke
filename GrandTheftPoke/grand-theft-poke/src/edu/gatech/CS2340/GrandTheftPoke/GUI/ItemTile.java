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
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.Backpack;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;

public class ItemTile extends Button {
	private Item item;
	private MarketPlaceItem stock;
	private Integer backpackStock;
	private Image icon;
	private Label stockLabel, price;
	private Backpack pack;
	public Item getItem() {
		return item;
	}

	// private Table tile;
	public ItemTile(Item item, MarketPlaceItem stock) {
		super(	new TextureRegionDrawable(new TextureRegion(
						GTPoke.getButtonSprite(), 0, 0, 150, 150)),
				new TextureRegionDrawable(new TextureRegion(
						GTPoke.getButtonSprite(), 0, 200, 150, 150)),
				new TextureRegionDrawable(new TextureRegion(
						GTPoke.getButtonSprite(), 0, 400, 150, 150)));
		this.item = item;
		this.stock = stock;
		Pixmap map = new Pixmap(50, 50, Pixmap.Format.RGB565);
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
		add(icon).expand();
		row();
		add(item.toString());
		row();
		add(price);
		update();
		setSize(150, 150);
		pad(12);

	}

	public boolean update() {
		if (backpackStock == -1) {
			stockLabel.setText(stock.getStock().toString());
			price.setText("$" + ((Float) (1.1f * stock.getPrice())).toString());
		} else {
			stockLabel.setText(pack.getContents().get(item).toString());
			price.setText("$" + ((Float) (0.9f * stock.getPrice())).toString());
		}
		return true;
	}

	public ItemTile(MarketPlace theMarket, Item item, int stock, Backpack pack) {
		super(new TextureRegionDrawable(new TextureRegion(
				GTPoke.getButtonSprite(), 0, 0, 200, 200)),
				new TextureRegionDrawable(new TextureRegion(
						GTPoke.getButtonSprite(), 0, 200, 200, 200)),
				new TextureRegionDrawable(new TextureRegion(
						GTPoke.getButtonSprite(), 0, 400, 200, 200)));
		this.item = item;
		if (theMarket.getStock().containsKey(item)) {
			this.stock = (MarketPlaceItem) theMarket.getStock().get(item);
		} else {
			this.stock = new MarketPlaceItem((float) stock, 1000f);
		}
		backpackStock = stock;
		this.pack = pack;
		Pixmap map = new Pixmap(50, 50, Pixmap.Format.RGB565);
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
		add(icon).expand();
		row();
		add(item.toString());
		row();
		add(price);
		setSize(400, 200);
		pad(12);
		update();
	}

}

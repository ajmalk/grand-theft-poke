package edu.gatech.CS2340.GrandTheftPoke.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;

public class ItemTile extends Button{
	private Item item;
	private MarketPlaceItem stock;
	private Image icon;
	
	//private Table tile;
	public ItemTile(Item item, MarketPlaceItem stock){
		super(	new TextureRegionDrawable(new TextureRegion(GTPoke.getButtonSprite(), 0, 0, 150, 200)),
				new TextureRegionDrawable(new TextureRegion(GTPoke.getButtonSprite(), 0, 0, 150, 200)));
		this.item = item;
		this.stock = stock;
		Pixmap map = new Pixmap(50, 50, Pixmap.Format.RGB565);
		map.setColor(Color.BLUE);
		map.fillRectangle(0, 0, 50, 50);
		icon = new Image(new Texture(map));
		setSkin(new Skin(Gdx.files.internal( "skins//uiskin.json" )));
		add(stock.getStock().toString()).right();
		row();
		add(icon).expand();
		row();
		add(item.toString());
		row();
		add("$" + stock.getPrice().toString());
		setSize(150, 200);
		pad(12);
	}
	
	public ItemTile(MarketPlace theMarket, Item item, int stock) {
		super(	new TextureRegionDrawable(new TextureRegion(GTPoke.getButtonSprite(), 0, 0, 150, 200)),
				new TextureRegionDrawable(new TextureRegion(GTPoke.getButtonSprite(), 0, 0, 150, 200)));
		this.item = item;
		this.stock = (MarketPlaceItem) theMarket.getStock().get(item);
		Pixmap map = new Pixmap(50, 50, Pixmap.Format.RGB565);
		map.setColor(Color.RED);
		map.fillRectangle(0, 0, 50, 50);
		icon = new Image(new Texture(map));
		setSkin(new Skin(Gdx.files.internal( "skins//uiskin.json" )));
		add(((Integer)stock).toString()).right();
		row();
		add(icon).expand();
		row();
		add(item.toString());
		row();
		add("$" + this.stock.getStock().toString());
		setSize(150, 200);
		pad(12);
	}
	
}

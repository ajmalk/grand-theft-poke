package edu.gatech.CS2340.GrandTheftPoke.screens;

import java.util.Iterator;
import java.util.Map;

import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.GUI.ItemTile;
import edu.gatech.CS2340.GrandTheftPoke.backend.Backpack;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;

public class Market extends AbstractScreen {
	private MarketPlace market;
	private Backpack playerPack;
	private Table markettable, backpacktable, table;
	private ButtonGroup marketItemGroup, backPackItemGroup;
	private ScrollPane marketStock, backpackStock;

	public Market(GTPoke game, MarketPlace market) {
		super(game);
		this.market = market;
		playerPack = game.getPlayer().getBackpack();
		table = new Table();
		markettable = new Table();
		backpacktable = new Table();
		marketItemGroup = new ButtonGroup();
		backPackItemGroup = new ButtonGroup();
		marketStock = new ScrollPane(markettable);
		backpackStock = new ScrollPane(backpacktable);
	}
	
	public Market(GTPoke game) {
		this(game, game.getCurrentTown().getMarket());
	}
	
	@Override
	public void show() {
		int col = 0;
		for (Iterator<Map.Entry<Item, MarketPlaceItem>> i = market.iterator(); i.hasNext();) {
			Map.Entry<Item, MarketPlaceItem> item = i.next();
			if (item.getValue().getStock() != 0) {
				ItemTile tile = new ItemTile(item.getKey(), item.getValue());
				markettable.add(tile);
				marketItemGroup.add(tile);
				if (col++ % 2 == 1)
					markettable.row();
			}
		}
		
		col = 0;
		for (Iterator<java.util.Map.Entry<Item, Integer>> i = playerPack
				.getContents().entrySet().iterator(); i.hasNext();) {
			java.util.Map.Entry<Item, Integer> item = i.next();
			ItemTile tile = new ItemTile(market, item.getKey(),
					item.getValue(), playerPack);
			backpacktable.add(tile);
			marketItemGroup.add(tile);
			if (col++ % 2 == 1)
				backpacktable.row();
		}
		
		markettable.setWidth(markettable.getPrefWidth());
		markettable.setHeight(markettable.getPrefWidth());
		backpacktable.setWidth(markettable.getPrefWidth());
		backpacktable.setHeight(markettable.getPrefWidth());
		
		markettable.top();
		backpacktable.top();
		
		marketStock.setScrollingDisabled(true, false);
		marketStock.setPosition(25, 50);
		backpackStock.setScrollingDisabled(true, false);
		backpackStock.setPosition(450, 50);
		
		backpackStock.setWidth(backpacktable.getWidth());
		backpackStock.setHeight(stage.getHeight() - 200);
		marketStock.setWidth(markettable.getWidth());
		marketStock.setHeight(stage.getHeight() - 200);
		
		table.add(marketStock).top();
		table.add(backpackStock).top().padLeft(25);
		table.left().setPosition(25, 100);
	}
	
	public void render(float delta) {
		super.render(delta);

//		for(int i= 0; i< marketItemGroup.getButtons().size; i++)
//			marketItemGroup.getButtons().get(i).debug().drawDebug(stage);
		
		
		
		
		table.setSize(1024, 525);
		
		//stage.addActor(marketStock);
		//stage.addActor(backpackStock);
		stage.addActor(table);
		//stage.addActor(backpacktable);
	}
}

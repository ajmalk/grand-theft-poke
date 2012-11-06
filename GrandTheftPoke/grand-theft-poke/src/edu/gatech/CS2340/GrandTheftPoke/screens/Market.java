package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.GUI.ItemTile;
import edu.gatech.CS2340.GrandTheftPoke.backend.Backpack;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;

public class Market extends AbstractScreen {
	private Texture background;
	private Image backgroundImage;
	private	Table table;
	private MarketPlace market;
	private Backpack playerPack;
	public Market(GTPoke game){
		super(game);
	}
	
	@Override
	public void show(){
		super.show();
		
		background = new Texture("images//icons//chooseStarterTitle.png");
		backgroundImage = new Image(background);
		backgroundImage.setFillParent(true);
		backgroundImage.getColor().a = 0f;
		backgroundImage.addAction(fadeIn(0.75f));
		
		market = game.getCurrentTown().getMarket();
		playerPack = game.getPlayer().getBackpack();
		table = new Table();
		//ItemTile tile = new ItemTile(game.getItems().getAgilityRoid(), new MarketPlaceItem(500, 500));
		
		//stage.addActor(tile);
	}

	@Override
	public void render(float delta){
		super.render(delta);
		table.clear();
		int col = 0;
		for(Iterator<Entry> i =  market.getStock().entrySet().iterator(); i.hasNext(); ){
			Entry item = i.next();
			table.add(new ItemTile((Item)item.getKey(), (MarketPlaceItem) item.getValue()));
			if(col++ % 3 == 0)
				table.row();
		}
		for(Iterator<Entry<Item, Integer>> i =  playerPack.getContents().entrySet().iterator(); i.hasNext(); ){
			Entry item = i.next();
			table.add(new ItemTile(market, (Item)item.getKey(), (Integer)item.getValue()));
			if(col++ % 3 == 0)
				table.row();
		}
		table.debug();
		table.drawDebug(stage);
		table.setPosition(500, 200);
		stage.addActor(table);
	}

	@Override
	public void resize(int width, int height){
		super.resize(width, height);
	}

	@Override
	public void dispose(){
		super.dispose();
		background.dispose();
	}
}

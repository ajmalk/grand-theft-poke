package edu.gatech.CS2340.GrandTheftPoke.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

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
	private ButtonGroup marketItemGroup;
	private ScrollPane 	marketStock,
						backpackStock;
	Button buy;
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
		Entry item2 = (Entry) market.getStock().entrySet().toArray()[0];

		Button tile2 = new ItemTile((Item)item2.getKey(), (MarketPlaceItem) item2.getValue());
		
		Texture ButtonSprite = new Texture("images//button-sprite.png");
		tile2.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y) {
				System.out.print("CLicked");
			}
		});
		
		
		
		
		//playerPack = game.getPlayer().getBackpack();
		table = new Table();
		marketItemGroup = new ButtonGroup();
		marketStock = new ScrollPane(table);
		//ItemTile tile = new ItemTile(game.getItems().getAgilityRoid(), new MarketPlaceItem(500, 500));
		marketStock.setPosition(0, 150);
		marketStock.setSize(150	, 150);
		//marketStock.setTouchable(Touchable.childrenOnly);
		//marketStock.setScrollingDisabled(true, true);
		marketItemGroup.setMaxCheckCount(1);
		
		
		int col = 0;
		for(Iterator<Entry> i =  market.getStock().entrySet().iterator(); i.hasNext(); ){
			Entry item = i.next();
			ItemTile tile = new ItemTile((Item)item.getKey(), (MarketPlaceItem) item.getValue());
			table.add(tile);
			marketItemGroup.add(tile);
			if(col++ % 3 == 0)
				table.row();
		}
		
		buy = new Button(
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0, 0, 320, 70)),
				new TextureRegionDrawable(new TextureRegion(ButtonSprite, 0, 69, 320, 70)));
		buy.setSkin(getSkin());
		buy.add("Buy");
		buy.setPosition(1024 - 400, 50);
		
		buy.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				System.out.print(((ItemTile) (marketItemGroup.getChecked())).getItem());
				System.out.print(market);
				game.getPlayer().buy(market, ((ItemTile) (marketItemGroup.getChecked())).getItem(), 100);
			}
		});
//		for(Iterator<Entry<Item, Integer>> i =  playerPack.getContents().entrySet().iterator(); i.hasNext(); ){
//			Entry item = i.next();
//			table.add(new ItemTile(market, (Item)item.getKey(), (Integer)item.getValue()));
//			if(col++ % 3 == 0)
//				table.row();
//		}
		
		//stage.addActor(tile2);

		
		
		//stage.addActor(tile);
	}

	@Override
	public void render(float delta){
		super.render(delta);
		table.debug();
		//table.drawDebug(stage);
		table.setPosition(500, 200);
		//stage.addActor(marketStock);
		stage.addActor(table);
		stage.addActor(buy);
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
